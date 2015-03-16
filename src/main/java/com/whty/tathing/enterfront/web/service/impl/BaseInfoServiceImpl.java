package com.whty.tathing.enterfront.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whty.dao.BaseInfoDao;
import com.whty.entities.BaseInfo;
import com.whty.entities.Criteria;
import com.whty.tathing.enterfront.web.service.BaseInfoService;

@Service("baseInfoService")
public class BaseInfoServiceImpl implements BaseInfoService{

	@Autowired
	private BaseInfoDao baseInfoDao;

	@Override
	public List<BaseInfo> getBaseInfo(Criteria criteria) {
		return baseInfoDao.getBaseInfos(criteria);
	}
	
	
}
