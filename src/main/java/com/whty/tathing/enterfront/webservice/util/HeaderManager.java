package com.whty.tathing.enterfront.webservice.util;

import com.whty.tathing.enterfront.web.entity.Header;


public class HeaderManager {
	private static ThreadLocal<Header> header = new ThreadLocal<Header>();
 
    public static Header getHeader() {
        return HeaderManager.header.get();
    }
 
    public static void setHeader(Header header) {
    	HeaderManager.header.set(header);
    }
}
