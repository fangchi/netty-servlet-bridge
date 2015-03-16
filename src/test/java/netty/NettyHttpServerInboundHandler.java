package netty;

import static io.netty.handler.codec.http.HttpHeaders.setContentLength;
import static io.netty.handler.codec.http.HttpHeaders.Names.CACHE_CONTROL;
import static io.netty.handler.codec.http.HttpHeaders.Names.CONNECTION;
import static io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_LENGTH;
import static io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_TYPE;
import static io.netty.handler.codec.http.HttpHeaders.Names.PRAGMA;
import static io.netty.handler.codec.http.HttpHeaders.Names.SERVER;
import static io.netty.handler.codec.http.HttpMethod.GET;
import static io.netty.handler.codec.http.HttpResponseStatus.BAD_REQUEST;
import static io.netty.handler.codec.http.HttpResponseStatus.CONTINUE;
import static io.netty.handler.codec.http.HttpResponseStatus.FORBIDDEN;
import static io.netty.handler.codec.http.HttpResponseStatus.INTERNAL_SERVER_ERROR;
import static io.netty.handler.codec.http.HttpResponseStatus.METHOD_NOT_ALLOWED;
import static io.netty.handler.codec.http.HttpResponseStatus.NOT_FOUND;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelProgressiveFuture;
import io.netty.channel.ChannelProgressiveFutureListener;
import io.netty.channel.DefaultFileRegion;
import io.netty.channel.FileRegion;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.TooLongFrameException;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.DefaultHttpResponse;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpContentCompressor;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.codec.http.HttpHeaders.Values;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.ssl.SslHandler;
import io.netty.handler.stream.ChunkedFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.javaforge.netty.servlet.bridge.ServletBridgeHandler;
import net.javaforge.netty.servlet.bridge.ServletBridgeInterceptor;
import net.javaforge.netty.servlet.bridge.ServletBridgeRuntimeException;
import net.javaforge.netty.servlet.bridge.impl.FilterChainImpl;
import net.javaforge.netty.servlet.bridge.impl.HttpServletRequestImpl;
import net.javaforge.netty.servlet.bridge.impl.HttpServletResponseImpl;
import net.javaforge.netty.servlet.bridge.impl.ServletBridgeWebapp;
import net.javaforge.netty.servlet.bridge.util.Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NettyHttpServerInboundHandler extends ChannelInboundHandlerAdapter {

	Random random = new Random();

	private static Logger logger = LoggerFactory
			.getLogger(NettyHttpServerInboundHandler.class);
	private ByteBufToBytes reader;

	private List<ServletBridgeInterceptor> interceptors;

	/**
	 * Which uri should be passed into this servlet container
	 */
	private String uriPrefix = "/";

	public NettyHttpServerInboundHandler() {
		this("/");
	}

	public NettyHttpServerInboundHandler(String uriPrefix) {
		this.uriPrefix = uriPrefix;
	}

	public NettyHttpServerInboundHandler addInterceptor(
			ServletBridgeInterceptor interceptor) {
		if (interceptors == null)
			interceptors = new ArrayList<ServletBridgeInterceptor>();
		interceptors.add(interceptor);
		return this;
	}

//	public void initChannel(SocketChannel ch) throws Exception {
//		ch.pipeline().addLast(new HttpResponseEncoder());
//		ch.pipeline().addLast(new HttpRequestDecoder());
//		ch.pipeline().addLast("deflater", new HttpContentCompressor());
//	}
//
//	@Override
//	public final void channelRegistered(ChannelHandlerContext ctx)
//			throws Exception {
//		super.channelRegistered(ctx);
//	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object e)
			throws Exception {
//		 if (e instanceof HttpRequest) {
//		 HttpRequest request = (HttpRequest) e;
//		 if (HttpHeaders.isContentLengthSet(request)) {
//		 reader = new ByteBufToBytes(
//		 (int) HttpHeaders.getContentLength(request));
//		 }
//		 } else if (e instanceof HttpContent) {
//		 FullHttpResponse response = new DefaultFullHttpResponse(
//		 HTTP_1_1, OK, Unpooled.wrappedBuffer("123".getBytes()));
//		 response.headers().set(CONTENT_TYPE, "text/plain");
//		 response.headers().set(CONTENT_LENGTH,
//		 response.content().readableBytes());
//		 response.headers().set(CONNECTION, Values.KEEP_ALIVE);
//		 ctx.write(response);
//		 ctx.flush();
//		 } else {
//		 ctx.fireChannelRead(e);
//		 }
		if (e instanceof HttpRequest) {
			HttpRequest request = (HttpRequest) e;

			String uri = request.uri();

			if (uri.startsWith(uriPrefix)) {
				if (HttpHeaders.is100ContinueExpected(request)) {
					ctx.channel().write(
							new DefaultHttpResponse(HTTP_1_1, CONTINUE));
				}

				FilterChainImpl chain = ServletBridgeWebapp.get()
						.initializeChain(uri);

				if (chain.isValid()) {
					handleHttpServletRequest(ctx, request, chain);
				} else if (ServletBridgeWebapp.get().getStaticResourcesFolder() != null) {
					handleStaticResourceRequest(ctx, request);
				} else {
					throw new ServletBridgeRuntimeException(
							"No handler found for uri: " + request.getUri());
				}
			} else {
				ctx.fireChannelRead(e);
			}
		} else {
			ctx.fireChannelRead(e);
		}
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		logger.info("HttpServerInboundHandler.channelReadComplete");
		ctx.flush();
	}

	protected void handleHttpServletRequest(ChannelHandlerContext ctx,
			HttpRequest request, FilterChainImpl chain) throws Exception {

		interceptOnRequestReceived(ctx, request);

		DefaultFullHttpResponse response = new DefaultFullHttpResponse(
				HTTP_1_1, OK);

		HttpServletResponseImpl resp = buildHttpServletResponse(response);
		HttpServletRequestImpl req = buildHttpServletRequest(request, chain);

		chain.doFilter(req, resp);

		interceptOnRequestSuccessed(ctx, request, response);

		resp.getWriter().flush();

		boolean keepAlive = HttpHeaders.isKeepAlive(request);

		if (keepAlive) {

			// Add 'Content-Length' header only for a keep-alive connection.
			response.headers().set(CONTENT_LENGTH,
					response.content().readableBytes());
			// Add keep alive header as per:
			// -
			// http://www.w3.org/Protocols/HTTP/1.1/draft-ietf-http-v11-spec-01.html#Connection
			response.headers().set(CONNECTION, HttpHeaders.Values.KEEP_ALIVE);
		}

		// write response...
		ChannelFuture future = ctx.channel().writeAndFlush(response);

		if (!keepAlive) {
			future.addListener(ChannelFutureListener.CLOSE);
		}
	}

	protected void handleStaticResourceRequest(ChannelHandlerContext ctx,
			HttpRequest request) throws Exception {
		if (request.method() != GET) {
			sendError(ctx, METHOD_NOT_ALLOWED);
			return;
		}

		String uri = Utils.sanitizeUri(request.uri());
		final String path = (uri != null ? ServletBridgeWebapp.get()
				.getStaticResourcesFolder().getAbsolutePath()
				+ File.separator + uri : null);

		if (path == null) {
			sendError(ctx, FORBIDDEN);
			return;
		}

		File file = new File(path);
		if (file.isHidden() || !file.exists()) {
			sendError(ctx, NOT_FOUND);
			return;
		}
		if (!file.isFile()) {
			sendError(ctx, FORBIDDEN);
			return;
		}

		RandomAccessFile raf;
		try {
			raf = new RandomAccessFile(file, "r");
		} catch (FileNotFoundException fnfe) {
			sendError(ctx, NOT_FOUND);
			return;
		}

		long fileLength = raf.length();

		HttpResponse response = new DefaultHttpResponse(HTTP_1_1, OK);
		setContentLength(response, fileLength);

		Channel ch = ctx.channel();

		// Write the initial line and the header.
		ch.write(response);

		// Write the content.
		ChannelFuture writeFuture;
		if (isSslChannel(ch)) {
			// Cannot use zero-copy with HTTPS.
			writeFuture = ch.write(new ChunkedFile(raf, 0, fileLength, 8192));
		} else {
			// No encryption - use zero-copy.
			final FileRegion region = new DefaultFileRegion(raf.getChannel(),
					0, fileLength);
			writeFuture = ch.write(region);
			writeFuture.addListener(new ChannelProgressiveFutureListener() {

				@Override
				public void operationProgressed(
						ChannelProgressiveFuture channelProgressiveFuture,
						long current, long total) throws Exception {
					System.out.printf("%s: %d / %d (+%d)%n", path, current,
							total, total);
				}

				@Override
				public void operationComplete(
						ChannelProgressiveFuture channelProgressiveFuture)
						throws Exception {
					region.release();
				}
			});
		}

	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		logger.error("Unexpected exception from downstream.", cause);

		Channel ch = ctx.channel();
		if (cause instanceof IllegalArgumentException) {
			ch.close();
		} else {
			if (cause instanceof TooLongFrameException) {
				sendError(ctx, BAD_REQUEST);
				return;
			}

			if (ch.isActive()) {
				sendError(ctx, INTERNAL_SERVER_ERROR);
			}

		}

	}

	private void sendError(ChannelHandlerContext ctx, HttpResponseStatus status) {
		String text = "Failure: " + status.toString() + "\r\n";
		ByteBuf byteBuf = Unpooled.buffer();
		byte[] bytes = null;
		try {
			bytes = text.getBytes("utf-8");
			byteBuf.writeBytes(bytes);
		} catch (UnsupportedEncodingException e) {
		}

		FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1, OK,
				byteBuf);
		HttpHeaders headers = response.headers();

		headers.add(CONTENT_TYPE, "text/plain;charset=utf-8");
		headers.add(CACHE_CONTROL, "no-cache");
		headers.add(PRAGMA, "No-cache");
		headers.add(SERVER, "eBay Server");
		headers.add(CONTENT_LENGTH, byteBuf.readableBytes());
		ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
	}

	private void interceptOnRequestReceived(ChannelHandlerContext ctx,
			HttpRequest request) {
		if (interceptors != null) {
			for (ServletBridgeInterceptor interceptor : interceptors) {
				interceptor.onRequestReceived(ctx, request);
			}
		}

	}

	private void interceptOnRequestSuccessed(ChannelHandlerContext ctx,
			HttpRequest request, HttpResponse response) {
		if (interceptors != null) {
			for (ServletBridgeInterceptor interceptor : interceptors) {
				interceptor.onRequestSuccessed(ctx, request, response);
			}
		}

	}

	// private void interceptOnRequestFailed(ChannelHandlerContext ctx,
	// ExceptionEvent e, HttpResponse response) {
	// if (this.interceptors != null) {
	// for (ServletBridgeInterceptor interceptor : this.interceptors) {
	// interceptor.onRequestFailed(ctx, e, response);
	// }
	// }
	//
	// }

	protected HttpServletResponseImpl buildHttpServletResponse(
			FullHttpResponse response) {
		return new HttpServletResponseImpl(response);
	}

	protected HttpServletRequestImpl buildHttpServletRequest(
			HttpRequest request, FilterChainImpl chain) {
		return new HttpServletRequestImpl(request, chain);
	}

	private boolean isSslChannel(Channel ch) {
		return ch.pipeline().get(SslHandler.class) != null;
	}

	public String getUriPrefix() {
		return uriPrefix;
	}

	public void setUriPrefix(String uriPrefix) {
		this.uriPrefix = uriPrefix;
	}
}
