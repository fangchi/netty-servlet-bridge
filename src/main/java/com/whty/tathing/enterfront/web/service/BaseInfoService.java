package com.whty.tathing.enterfront.web.service;

import java.util.List;

import com.whty.entities.BaseInfo;
import com.whty.entities.Criteria;

public interface BaseInfoService {

	public List<BaseInfo> getBaseInfo(Criteria criteria);
}
