package com.whty.tathing.enterfront.web.strategy.tsmrouter;


/**
 * 路由信息bean
 * @author gaofeng
 *
 */
public class Router {
	/** 转发地址*/
	private String receiver_url;
	/** 实现bean_id*/
	private String bean_id;
	public String getReceiver_url() {
		return receiver_url;
	}
	public void setReceiver_url(String receiver_url) {
		this.receiver_url = receiver_url;
	}
	public String getBean_id() {
		return bean_id;
	}
	public void setBean_id(String bean_id) {
		this.bean_id = bean_id;
	}
}
