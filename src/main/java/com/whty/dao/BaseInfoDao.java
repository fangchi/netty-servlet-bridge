package com.whty.dao;

import java.util.List;

import com.whty.entities.BaseInfo;
import com.whty.entities.Criteria;


public interface BaseInfoDao {
	/**
	 * 渠道类型：厦门和洪城
	 * @param channel_code 
	 */
	public List<BaseInfo> getBaseInfos(Criteria example);
	
}
