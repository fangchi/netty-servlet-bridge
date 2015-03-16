package com.whty.tathing.enterfront.web.service;

import java.util.HashMap;

import com.whty.tathing.enterfront.web.strategy.tsmrouter.Router;

/**
 * 路由容器
 */
public class RouterContainer {

	private static HashMap<String, Router> routers = new HashMap<String, Router>();
	private static HashMap<String, Boolean> accessSender = new HashMap<String, Boolean>();

	public static void addRouter(String receiver, Router receiver_url) {
		routers.put(receiver, receiver_url);
	}
	
	public static Router getRouter(String receiver){
		if(routers.isEmpty()){
			return null;
		}
		return routers.get(receiver);
	}
	
	public static void addAccessSender(String receiver, Boolean isTrue) {
		accessSender.put(receiver, isTrue);
	}
	
	public static boolean getAccessSender(String receiver){
		return !accessSender.isEmpty() && accessSender.get(receiver);
	}
	
	public static void clearRouters(){
		routers.clear();
		accessSender.clear();
	}
}
