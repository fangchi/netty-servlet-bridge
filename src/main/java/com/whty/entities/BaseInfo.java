package com.whty.entities;

import java.util.Date;

public class BaseInfo {

	public String sender_name; // 渠道编码: 01厦门,02洪城
	public String is_enable; // 渠道名称
	public Date exprie_time; // 接口类型编码

	public BaseInfo() {
		super();
	}

	public String getSender_name() {
		return sender_name;
	}

	public void setSender_name(String sender_name) {
		this.sender_name = sender_name;
	}

	public String getIs_enable() {
		return is_enable;
	}

	public void setIs_enable(String is_enable) {
		this.is_enable = is_enable;
	}

	public Date getExprie_time() {
		return exprie_time;
	}

	public void setExprie_time(Date exprie_time) {
		this.exprie_time = exprie_time;
	}

}
