package com.whty;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpContentCompressor;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.util.concurrent.DefaultEventExecutor;
import net.javaforge.netty.servlet.bridge.ServletBridgeHandler;
import net.javaforge.netty.servlet.bridge.config.ServletConfiguration;
import net.javaforge.netty.servlet.bridge.config.WebappConfiguration;
import net.javaforge.netty.servlet.bridge.impl.ServletBridgeWebapp;
import net.javaforge.netty.servlet.bridge.interceptor.ChannelInterceptor;
import net.javaforge.netty.servlet.bridge.interceptor.HttpSessionInterceptor;
import netty.NettyHttpServerInboundHandler;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.mock.web.MockServletConfig;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.whty.netty.Main;

public class NettyTest {

	public static void main(String[] args) throws InterruptedException,
			IOException {

		Properties properties = new Properties();
		properties.load(Main.class.getClass().getResourceAsStream(
				"/env.properties"));
		Integer port = Integer.parseInt(properties.get("port").toString());
		String charset = properties.get("charset").toString();
		String env = properties.get("env").toString();
		String configLocation = properties.get("contextConfigLocation")
				.toString();

		// Configure the server.
		final ServerBootstrap bootstrap = new ServerBootstrap();

		WebappConfiguration webappConf = new WebappConfiguration()
				.addContextParameter("contextConfigLocation", "classpath*:/spring.xml")
				.addServletContextListener(ContextLoaderListener.class)
				.addServletConfigurations(
						new ServletConfiguration(TestServlet.class,
								"/servlet2/").addInitParameter("initpram1",
								"value1"),
						new ServletConfiguration(CXFServlet.class, "/webservice/*"),
						new ServletConfiguration(DispatcherServlet.class, "/*")
								.addInitParameter("contextConfigLocation",
										"classpath*:/spring/spring-mvc.xml")
				);

		DefaultEventExecutor eventExecutor = new DefaultEventExecutor();

		ChannelGroup allChannels = new DefaultChannelGroup(eventExecutor);

		ServletBridgeWebapp.get().init(webappConf, allChannels);
		NioEventLoopGroup group = new NioEventLoopGroup();
		NioEventLoopGroup childgroup = new NioEventLoopGroup();
		
		bootstrap
				.group(group, childgroup)
				.channel(NioServerSocketChannel.class)
				.childHandler(new ChannelInitializer<SocketChannel>() {
					@Override
					public void initChannel(SocketChannel ch) throws Exception {
						ch.pipeline().addLast(new HttpResponseEncoder());
						ch.pipeline().addLast(new HttpRequestDecoder());
//						ch.pipeline().addLast("deflater",
//								new HttpContentCompressor());
						ch.pipeline().addLast(
								new NettyHttpServerInboundHandler().addInterceptor(new ChannelInterceptor()));
					}
				}).option(ChannelOption.SO_BACKLOG, 1024)
				.childOption(ChannelOption.SO_KEEPALIVE, true);
		System.out.println("server started at " + port + " ....");
		bootstrap.bind(port).sync().channel().closeFuture().sync();
	}
	
	// public static void main(String[] args) {
	// WebappConfiguration webapp = new WebappConfiguration()
	// .addContextParameter("name1", "value1")
	// .addContextParameter("name2", "value2")
	// .addServletConfigurations(
	// new ServletConfiguration(TestServlet.class, "/servlet2")
	// .addInitParameter("initpram1", "value1")
	// .addInitParameter("initpram2", "value2")
	// );
	//
	// final ServerBootstrap bootstrap = new ServerBootstrap(
	// new NioServerSocketChannelFactory(
	// Executors.newCachedThreadPool(), Executors.newCachedThreadPool()
	// )
	// );
	//
	// // ServletBridgeWebapp.get().init(webapp, sharedChannelGroup);
	//
	// // .addFilterConfigurations (
	// // new FilterConfiguration(MyServletFilter.class, "/*"),
	// // );
	// }
}
