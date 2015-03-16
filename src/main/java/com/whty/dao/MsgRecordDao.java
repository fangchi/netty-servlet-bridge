package com.whty.dao;

import com.whty.entities.MsgRecord;


public interface MsgRecordDao {
	/**
	 *  厦门和洪城：圈存写卡确认，支付，圈存订单创建
	 * @param msgRecord 
	 */
	public void saveMsgRecord(MsgRecord msgRecord);
	
}
