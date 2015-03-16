package com.whty.tathing.enterfront.web.strategy.tsmrouter;

import com.whty.tathing.enterfront.web.entity.TsmEntity;

/**
 * 路由策略接口
 */
public interface RouterStrategy {

	public String getURL(TsmEntity  tsmEntity);
	public String getYxptUrl(TsmEntity  tsmEntity);
}
