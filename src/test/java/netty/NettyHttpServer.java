package netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpContentCompressor;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;

public class NettyHttpServer {

	public void start(int port) throws Exception {
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup)
					.channel(NioServerSocketChannel.class)
					.childHandler(new ChannelInitializer<SocketChannel>() {
						@Override
						public void initChannel(SocketChannel ch)
								throws Exception {
							ch.pipeline().addLast(new HttpResponseEncoder());
							ch.pipeline().addLast(new HttpRequestDecoder());
							ch.pipeline().addLast("deflater",
									new HttpContentCompressor());
							ch.pipeline().addLast(
									new NettyHttpServerInboundHandler());
						}
					}).option(ChannelOption.SO_BACKLOG, 1024)
					.childOption(ChannelOption.SO_KEEPALIVE, true);

			ChannelFuture f = b.bind(port).sync(); // (7)
			System.out.println("server started at " + port);
			f.channel().closeFuture().sync();
		} finally {
			workerGroup.shutdownGracefully();
			bossGroup.shutdownGracefully();
		}
	}

	public static void main(String[] args) throws Exception {
		try {
			NettyHttpServer server = new NettyHttpServer();
			server.start(8070);
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
