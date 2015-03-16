package com.whty.tathing.enterfront.webservice.impl;

import java.io.StringReader;

import javax.jws.HandlerChain;
import javax.jws.WebService;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.whty.framework.spring.SpringPropertyPlaceholderConfigurer;
import com.whty.tathing.enterfront.web.common.Constant;
import com.whty.tathing.enterfront.web.entity.AppActiveBody;
import com.whty.tathing.enterfront.web.entity.AppActiveResp;
import com.whty.tathing.enterfront.web.entity.AppDeleteBody;
import com.whty.tathing.enterfront.web.entity.AppDeleteResp;
import com.whty.tathing.enterfront.web.entity.AppDeleteResultNotifyBody;
import com.whty.tathing.enterfront.web.entity.AppDeleteResultNotifyResp;
import com.whty.tathing.enterfront.web.entity.AppDownloadBody;
import com.whty.tathing.enterfront.web.entity.AppDownloadResp;
import com.whty.tathing.enterfront.web.entity.AppDownloadResultNotifyBody;
import com.whty.tathing.enterfront.web.entity.AppDownloadResultNotifyResp;
import com.whty.tathing.enterfront.web.entity.AppPersonialBody;
import com.whty.tathing.enterfront.web.entity.AppPersonialResp;
import com.whty.tathing.enterfront.web.entity.AppPushBody;
import com.whty.tathing.enterfront.web.entity.AppPushResp;
import com.whty.tathing.enterfront.web.entity.AppStatusNotifyResp;
import com.whty.tathing.enterfront.web.entity.AppStatusNotityBody;
import com.whty.tathing.enterfront.web.entity.CreatSSDBody;
import com.whty.tathing.enterfront.web.entity.CreatSSDResp;
import com.whty.tathing.enterfront.web.entity.Header;
import com.whty.tathing.enterfront.web.entity.OrderSaveBody;
import com.whty.tathing.enterfront.web.entity.OrderSaveResp;
import com.whty.tathing.enterfront.web.entity.PublicKeyBody;
import com.whty.tathing.enterfront.web.entity.PublicKeyResp;
import com.whty.tathing.enterfront.web.entity.SSDInfoBody;
import com.whty.tathing.enterfront.web.entity.SSDInfoResp;
import com.whty.tathing.enterfront.web.entity.TokenSignBody;
import com.whty.tathing.enterfront.web.entity.TokenSignResp;
import com.whty.tathing.enterfront.web.entity.TsmEntity;
import com.whty.tathing.enterfront.webservice.AppActiveRequest;
import com.whty.tathing.enterfront.webservice.AppActiveResponse;
import com.whty.tathing.enterfront.webservice.AppDeleteRequest;
import com.whty.tathing.enterfront.webservice.AppDeleteResponse;
import com.whty.tathing.enterfront.webservice.AppDeleteResultNotifyRequest;
import com.whty.tathing.enterfront.webservice.AppDeleteResultNotifyResponse;
import com.whty.tathing.enterfront.webservice.AppDownloadRequest;
import com.whty.tathing.enterfront.webservice.AppDownloadResponse;
import com.whty.tathing.enterfront.webservice.AppDownloadResultNotifyRequest;
import com.whty.tathing.enterfront.webservice.AppDownloadResultNotifyResponse;
import com.whty.tathing.enterfront.webservice.AppPersonialRequest;
import com.whty.tathing.enterfront.webservice.AppPersonialResponse;
import com.whty.tathing.enterfront.webservice.AppPushRequest;
import com.whty.tathing.enterfront.webservice.AppPushResponse;
import com.whty.tathing.enterfront.webservice.AppStatusNotifyRequest;
import com.whty.tathing.enterfront.webservice.AppStatusNotifyResponse;
import com.whty.tathing.enterfront.webservice.CreatSSDRequest;
import com.whty.tathing.enterfront.webservice.CreatSSDResponse;
import com.whty.tathing.enterfront.webservice.IEnterFrontService;
import com.whty.tathing.enterfront.webservice.OrderSaveRequest;
import com.whty.tathing.enterfront.webservice.OrderSaveResponse;
import com.whty.tathing.enterfront.webservice.PublicKeyRequest;
import com.whty.tathing.enterfront.webservice.PublicKeyResponse;
import com.whty.tathing.enterfront.webservice.RspnMsg;
import com.whty.tathing.enterfront.webservice.SSDInfoRequest;
import com.whty.tathing.enterfront.webservice.SSDInfoResponse;
import com.whty.tathing.enterfront.webservice.TokenSignRequest;
import com.whty.tathing.enterfront.webservice.TokenSignResponse;
import com.whty.tathing.enterfront.webservice.util.HeaderManager;
import com.whty.util.Encryptor;

/**
 * webservice服务实现
 * @since 1.0.0
 */
@WebService(endpointInterface="com.whty.tathing.enterfront.webservice.IEnterFrontService",
		targetNamespace="http://www.tathing.com",
		portName="EnterFrontServicePort",
		wsdlLocation="ws/enterfront.wsdl",
		serviceName="EnterFrontService")
@HandlerChain(file="/ws/chain/handler-chain.xml")
@Component
public class EnterFrontServiceImpl implements IEnterFrontService{
	
	protected static final Gson gson = new Gson();
	
	private final static String ENCODE = Constant.UTF_8_ENCODING;

	@Override
	public AppPushResponse appPush(AppPushRequest appPushRequest) {
		AppPushResponse responese = new AppPushResponse();
		TsmEntity<AppPushBody> tsm  = new TsmEntity<AppPushBody>();
		AppPushBody body = new AppPushBody();
		RspnMsg msg = new RspnMsg();
		// 获取加密因子
		String secureFactor = SpringPropertyPlaceholderConfigurer.getStringProperty("secureFactor");
		try {
			// 获取报文头
			Header header = HeaderManager.getHeader();
			if(null == header){
				responese.setRspnMsg(getMsg());
				return responese;
			}
			tsm.setHeader(header);
			// 将报文体转换为我们的bean
			//BeanUtils.copyProperties(body, appPushRequest);
			String reqJson = gson.toJson(appPushRequest);
			body = gson.fromJson(reqJson, AppPushBody.class);
			tsm.setBody(body);
			// 交由service转发到tathing tsm
			byte[] returnStr = "".getBytes();//appPushService.AppPushRequest(tsm,secureFactor,Constant.THIRD_2_TATHING);
			byte[] enData = Encryptor.decrypt(secureFactor.getBytes(), returnStr);
			// 解密json
			JsonReader reader = new JsonReader(new StringReader(new String( enData, ENCODE)));
			reader.setLenient(true);
			// 将返回json反序列化为业务实体
			TsmEntity<AppPushResp> tsm1  =  gson.fromJson(reader,new TypeToken<TsmEntity<AppPushResp>>() {}.getType());
			// 使用json复制属性，不使用BeanUtils.copyProperties
			String tsmJson = gson.toJson((AppPushResp)tsm1.getBody());
			responese = gson.fromJson(tsmJson, AppPushResponse.class);
			//BeanUtils.copyProperties(responese, (AppPushResp)tsm1.getBody());
		} catch (Exception e) {
			e.printStackTrace();
			msg.setSts("0001");
			msg.setRjctCd("B0001");
			msg.setRjctInfo("appPush数据出错");
			msg.setEndFlag("01");
			responese.setRspnMsg(msg);
		}
		return responese;
	}
	
	@Override
	public AppStatusNotifyResponse appStatusNotify(
			AppStatusNotifyRequest appStatusNotifyRequest) {
		AppStatusNotifyResponse responese = new AppStatusNotifyResponse();
		TsmEntity<AppStatusNotityBody> tsm  = new TsmEntity<AppStatusNotityBody>();
		AppStatusNotityBody body = new AppStatusNotityBody();
		RspnMsg msg = new RspnMsg();
		// 获取加密因子
		String secureFactor = SpringPropertyPlaceholderConfigurer.getStringProperty("secureFactor");
		try {
			// 获取报文头
			Header header = HeaderManager.getHeader();
			if(null == header){
				responese.setRspnMsg(getMsg());
				return responese;
			}
			tsm.setHeader(header);
			// 将报文体转换为我们的bean
			BeanUtils.copyProperties(body, appStatusNotifyRequest);
			tsm.setBody(body);
			// 交由service转发到tathing tsm
			byte[] returnStr = "".getBytes();;
			byte[] enData = Encryptor.decrypt(secureFactor.getBytes(), returnStr);
			// 解密json
			JsonReader reader = new JsonReader(new StringReader(new String( enData, ENCODE)));
			reader.setLenient(true);
			// 将返回json反序列化为业务实体
			TsmEntity<AppStatusNotifyResp> tsm1  =  gson.fromJson(reader,new TypeToken<TsmEntity<AppStatusNotifyResp>>() {}.getType());
			// 使用json复制属性，不使用BeanUtils.copyProperties
			String tsmJson = gson.toJson((AppStatusNotifyResp)tsm1.getBody());
			responese = gson.fromJson(tsmJson, AppStatusNotifyResponse.class);
			//BeanUtils.copyProperties(responese, (AppStatusNotifyResp)tsm1.getBody());
		} catch (Exception e) {
			e.printStackTrace();
			msg.setSts("0001");
			msg.setRjctCd("B0001");
			msg.setRjctInfo("appStatusNofity数据出错");
			msg.setEndFlag("01");
			responese.setRspnMsg(msg);
		}
		return responese;
	}

/*	@Override
	public AppSeCheckResponse appSeCheck(AppSeCheckRequest appSeCheckRequest) {
		AppSeCheckResponse responese = new AppSeCheckResponse();
		TsmEntity<AppSeCheckBody> tsm  = new TsmEntity<AppSeCheckBody>();
		AppSeCheckBody body = new AppSeCheckBody();
		RspnMsg msg = new RspnMsg();
		// 获取加密因子
		String secureFactor = SpringPropertyPlaceholderConfigurer.getStringProperty("secureFactor");
		try {
			// 获取报文头
			Header header = HeaderManager.getHeader();
			if(null == header){
				responese.setRspnMsg(getMsg());
				return responese;
			}
			tsm.setHeader(header);
			// 将报文体转换为我们的bean
			BeanUtils.copyProperties(body, appSeCheckRequest);
			tsm.setBody(body);
			// 交由service转发到tathing tsm
			byte[] returnStr = appSeCheckService.AppSeCheckRequest(tsm,secureFactor,Constant.TATHING_2_THIRD);
			// 解密json
			byte[] enData = Encryptor.decrypt(secureFactor.getBytes(), returnStr);
			reader.setLenient(true);
			// 将返回json反序列化为业务实体
			TsmEntity<AppSeCheckResp> tsm1  =  gson.fromJson(reader,new TypeToken<TsmEntity<AppSeCheckResp>>() {}.getType());
			// 使用json复制属性，不使用BeanUtils.copyProperties
			String tsmJson = gson.toJson((AppSeCheckResp)tsm1.getBody());
			//responese = gson.fromJson(tsmJson, AppSeCheckResponse.class);
			BeanUtils.copyProperties(responese, (AppSeCheckResp)tsm1.getBody());
		} catch (Exception e) {
			e.printStackTrace();
			msg.setSts("0001");
			msg.setRjctCd("B0001");
			msg.setEndFlag("01");
			msg.setRjctInfo("appSeCheck数据出错");
			responese.setRspnMsg(msg);
		}
		return responese;
	}*/

	@Override
	public AppDeleteResultNotifyResponse appDeleteResultNotify(
			AppDeleteResultNotifyRequest appDeleteResultNotifyRequest) {
		AppDeleteResultNotifyResponse responese = new AppDeleteResultNotifyResponse();
		TsmEntity<AppDeleteResultNotifyBody> tsm  = new TsmEntity<AppDeleteResultNotifyBody>();
		AppDeleteResultNotifyBody body = new AppDeleteResultNotifyBody();
		RspnMsg msg = new RspnMsg();
		// 获取加密因子
		String secureFactor = SpringPropertyPlaceholderConfigurer.getStringProperty("secureFactor");
		try {
			// 获取报文头
			Header header = HeaderManager.getHeader();
			if(null == header){
				responese.setRspnMsg(getMsg());
				return responese;
			}
			tsm.setHeader(header);
			// 将报文体转换为我们的bean
			BeanUtils.copyProperties(body, appDeleteResultNotifyRequest);
			tsm.setBody(body);
			// 交由service转发到tathing tsm
			byte[] returnStr ="".getBytes();;
			byte[] enData = Encryptor.decrypt(secureFactor.getBytes(), returnStr);
			// 解密json
			JsonReader reader = new JsonReader(new StringReader(new String( enData, ENCODE)));
			reader.setLenient(true);
			// 将返回json反序列化为业务实体
			TsmEntity<AppDeleteResultNotifyResp> tsm1  =  gson.fromJson(reader,new TypeToken<TsmEntity<AppDeleteResultNotifyResp>>() {}.getType());
			// 使用json复制属性，不使用BeanUtils.copyProperties
			String tsmJson = gson.toJson((AppDeleteResultNotifyResp)tsm1.getBody());
			responese = gson.fromJson(tsmJson, AppDeleteResultNotifyResponse.class);
			//BeanUtils.copyProperties(responese, (AppDeleteResultNotifyResp)tsm1.getBody());
		} catch (Exception e) {
			e.printStackTrace();
			msg.setSts("0001");
			msg.setRjctCd("B0001");
			msg.setRjctInfo("appDeleteResultNotify数据出错");
			msg.setEndFlag("01");
			responese.setRspnMsg(msg);
		}
		return responese;
	}

/*	@Override
	public AppQueryResponse appQuery(AppQueryRequest appQueryRequest) {
		AppQueryResponse responese = new AppQueryResponse();
		TsmEntity<AppQueryBody> tsm  = new TsmEntity<AppQueryBody>();
		AppQueryBody body = new AppQueryBody();
		RspnMsg msg = new RspnMsg();
		// 获取加密因子
		String secureFactor = SpringPropertyPlaceholderConfigurer.getStringProperty("secureFactor");
		try {
			// 获取报文头
			Header header = HeaderManager.getHeader();
			if(null == header){
				responese.setRspnMsg(getMsg());
				return responese;
			}
			tsm.setHeader(header);
			// 将报文体转换为我们的bean
			BeanUtils.copyProperties(body, appQueryRequest);
			tsm.setBody(body);
			// 交由service转发到tathing tsm
			byte[] returnStr = appQueryService.AppQueryRequest(tsm,2);
			byte[] enData = Encryptor.decrypt(secureFactor.getBytes(), returnStr);
			// 解密json
			JsonReader reader = new JsonReader(new StringReader(new String( enData, ENCODE)));
			reader.setLenient(true);
			// 将返回json反序列化为业务实体
			TsmEntity<AppQueryResp> tsm1  =  gson.fromJson(reader,new TypeToken<TsmEntity<AppQueryResp>>() {}.getType());
			// 使用json复制属性，不使用BeanUtils.copyProperties
			String tsmJson = gson.toJson((AppQueryResp)tsm1.getBody());
			responese = gson.fromJson(tsmJson, AppQueryResponse.class);
			//BeanUtils.copyProperties(responese, (AppQueryResp)tsm1.getBody());
		} catch (Exception e) {
			e.printStackTrace();
			msg.setSts("0001");
			msg.setRjctCd("B0001");
			msg.setRjctInfo("appQuery数据出错");
			msg.setEndFlag("01");
			responese.setRspnMsg(msg);
		}
		return responese;
	}*/

	@Override
	public AppDeleteResponse appDelete(AppDeleteRequest appDeleteRequest) {
		AppDeleteResponse responese = new AppDeleteResponse();
		TsmEntity<AppDeleteBody> tsm  = new TsmEntity<AppDeleteBody>();
		AppDeleteBody body = new AppDeleteBody();
		RspnMsg msg = new RspnMsg();
		// 获取加密因子
		String secureFactor = SpringPropertyPlaceholderConfigurer.getStringProperty("secureFactor");
		try {
			// 获取报文头
			Header header = HeaderManager.getHeader();
			if(null == header){
				responese.setRspnMsg(getMsg());
				return responese;
			}
			tsm.setHeader(header);
			// 将报文体转换为我们的bean
			BeanUtils.copyProperties(body, appDeleteRequest);
			tsm.setBody(body);
			// 交由service转发到tathing tsm
			byte[] returnStr = "".getBytes();;
			byte[] enData = Encryptor.decrypt(secureFactor.getBytes(), returnStr);
			// 解密json
			JsonReader reader = new JsonReader(new StringReader(new String( enData, ENCODE)));
			reader.setLenient(true);
			// 将返回json反序列化为业务实体
			TsmEntity<AppDeleteResp> tsm1  =  gson.fromJson(reader,new TypeToken<TsmEntity<AppDeleteResp>>() {}.getType());
			// 使用json复制属性，不使用BeanUtils.copyProperties
			String tsmJson = gson.toJson((AppDeleteResp)tsm1.getBody());
			responese = gson.fromJson(tsmJson, AppDeleteResponse.class);
			//BeanUtils.copyProperties(responese, (AppDeleteResp)tsm1.getBody());
		} catch (Exception e) {
			e.printStackTrace();
			msg.setSts("0001");
			msg.setRjctCd("B0001");
			msg.setRjctInfo("appDelete数据出错");
			msg.setEndFlag("01");
			responese.setRspnMsg(msg);
		}
		return responese;
	}

	@Override
	public TokenSignResponse tokenSign(TokenSignRequest tokenSignRequest) {
		TokenSignResponse responese = new TokenSignResponse();
		TsmEntity<TokenSignBody> tsm  = new TsmEntity<TokenSignBody>();
		TokenSignBody body = new TokenSignBody();
		RspnMsg msg = new RspnMsg();
		// 获取加密因子
		String secureFactor = SpringPropertyPlaceholderConfigurer.getStringProperty("secureFactor");
		try {
			// 获取报文头
			Header header = HeaderManager.getHeader();
			if(null == header){
				responese.setRspnMsg(getMsg());
				return responese;
			}
			tsm.setHeader(header);
			// 将报文体转换为我们的bean
			BeanUtils.copyProperties(body, tokenSignRequest);
			tsm.setBody(body);
			// 交由service转发到tathing tsm
			byte[] returnStr = "".getBytes();;
			byte[] enData = Encryptor.decrypt(secureFactor.getBytes(), returnStr);
			// 解密json
			JsonReader reader = new JsonReader(new StringReader(new String( enData, ENCODE)));
			reader.setLenient(true);
			// 将返回json反序列化为业务实体
			TsmEntity<TokenSignResp> tsm1  =  gson.fromJson(reader,new TypeToken<TsmEntity<TokenSignResp>>() {}.getType());
			// 使用json复制属性，不使用BeanUtils.copyProperties
			String tsmJson = gson.toJson((TokenSignResp)tsm1.getBody());
			responese = gson.fromJson(tsmJson, TokenSignResponse.class);
			//BeanUtils.copyProperties(responese, (TokenSignResp)tsm1.getBody());
		} catch (Exception e) {
			e.printStackTrace();
			msg.setSts("0001");
			msg.setRjctCd("B0001");
			msg.setRjctInfo("tokenSign数据出错");
			msg.setEndFlag("01");
			responese.setRspnMsg(msg);
		}
		return responese;
	}

	@Override
	public AppPersonialResponse appPersonial(
			AppPersonialRequest appPersonialRequest) {
		AppPersonialResponse responese = new AppPersonialResponse();
		TsmEntity<AppPersonialBody> tsm  = new TsmEntity<AppPersonialBody>();
		AppPersonialBody body = new AppPersonialBody();
		RspnMsg msg = new RspnMsg();
		// 获取加密因子
		String secureFactor = SpringPropertyPlaceholderConfigurer.getStringProperty("secureFactor");
		try {
			// 获取报文头
			Header header = HeaderManager.getHeader();
			if(null == header){
				responese.setRspnMsg(getMsg());
				return responese;
			}
			tsm.setHeader(header);
			// 将报文体转换为我们的bean
			String tsmJson1 = gson.toJson(appPersonialRequest);
			body = gson.fromJson(tsmJson1, AppPersonialBody.class);
			tsm.setBody(body);
			// 交由service转发到tathing tsm
			byte[] returnStr ="".getBytes();;
			byte[] enData = Encryptor.decrypt(secureFactor.getBytes(), returnStr);
			// 解密json
			JsonReader reader = new JsonReader(new StringReader(new String( enData, ENCODE)));
			reader.setLenient(true);
			// 将返回json反序列化为业务实体
			TsmEntity<AppPersonialResp> tsm1  =  gson.fromJson(reader,new TypeToken<TsmEntity<AppPersonialResp>>() {}.getType());
			// 使用json复制属性，不使用BeanUtils.copyProperties
			String tsmJson = gson.toJson((AppPersonialResp)tsm1.getBody());
			responese = gson.fromJson(tsmJson, AppPersonialResponse.class);
			//BeanUtils.copyProperties(responese, (AppPersonialResp)tsm1.getBody());
		} catch (Exception e) {
			e.printStackTrace();
			msg.setSts("0001");
			msg.setRjctCd("B0001");
			msg.setRjctInfo("appPersonial数据出错");
			msg.setEndFlag("01");
			responese.setRspnMsg(msg);
		}
		return responese;
	}

	@Override
	public AppDownloadResultNotifyResponse appDownloadResultNotify(
			AppDownloadResultNotifyRequest appDownloadResultNotifyRequest) {
		AppDownloadResultNotifyResponse responese = new AppDownloadResultNotifyResponse();
		TsmEntity<AppDownloadResultNotifyBody> tsm  = new TsmEntity<AppDownloadResultNotifyBody>();
		AppDownloadResultNotifyBody body = new AppDownloadResultNotifyBody();
		RspnMsg msg = new RspnMsg();
		// 获取加密因子
		String secureFactor = SpringPropertyPlaceholderConfigurer.getStringProperty("secureFactor");
		try {
			// 获取报文头
			Header header = HeaderManager.getHeader();
			if(null == header){
				responese.setRspnMsg(getMsg());
				return responese;
			}
			tsm.setHeader(header);
			// 将报文体转换为我们的bean
			String tsmJson1 = gson.toJson(appDownloadResultNotifyRequest);
			body = gson.fromJson(tsmJson1, AppDownloadResultNotifyBody.class);
			tsm.setBody(body);
			// 交由service转发到tathing tsm
			byte[] returnStr = "".getBytes();
			byte[] enData = Encryptor.decrypt(secureFactor.getBytes(), returnStr);
			// 解密json
			JsonReader reader = new JsonReader(new StringReader(new String( enData, ENCODE)));
			reader.setLenient(true);
			// 将返回json反序列化为业务实体
			TsmEntity<AppDownloadResultNotifyResp> tsm1  =  gson.fromJson(reader,new TypeToken<TsmEntity<AppDownloadResultNotifyResp>>() {}.getType());
			// 使用json复制属性，不使用BeanUtils.copyProperties
			String tsmJson = gson.toJson((AppDownloadResultNotifyResp)tsm1.getBody());
			responese = gson.fromJson(tsmJson, AppDownloadResultNotifyResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
			msg.setSts("0001");
			msg.setRjctCd("B0001");
			msg.setRjctInfo("appDownloadResultNotify数据出错");
			msg.setEndFlag("01");
			responese.setRspnMsg(msg);
		}
		return responese;
	}

	@Override
	public AppActiveResponse appActive(AppActiveRequest appActiveRequest) {
		AppActiveResponse responese = new AppActiveResponse();
		TsmEntity<AppActiveBody> tsm  = new TsmEntity<AppActiveBody>();
		AppActiveBody body = new AppActiveBody();
		RspnMsg msg = new RspnMsg();
		// 获取加密因子
		String secureFactor = SpringPropertyPlaceholderConfigurer.getStringProperty("secureFactor");
		try {
			// 获取报文头
			Header header = HeaderManager.getHeader();
			if(null == header){
				responese.setRspnMsg(getMsg());
				return responese;
			}
			tsm.setHeader(header);
			// 将报文体转换为我们的bean
			BeanUtils.copyProperties(body, appActiveRequest);
			tsm.setBody(body);
			// 交由service转发到tathing tsm
			byte[] returnStr ="".getBytes();;
			byte[] enData = Encryptor.decrypt(secureFactor.getBytes(), returnStr);
			// 解密json
			JsonReader reader = new JsonReader(new StringReader(new String( enData, ENCODE)));
			reader.setLenient(true);
			// 将返回json反序列化为业务实体
			TsmEntity<AppActiveResp> tsm1  =  gson.fromJson(reader,new TypeToken<TsmEntity<AppActiveResp>>() {}.getType());
			// 使用json复制属性，不使用BeanUtils.copyProperties
			String tsmJson = gson.toJson((AppActiveResp)tsm1.getBody());
			responese = gson.fromJson(tsmJson, AppActiveResponse.class);
			//BeanUtils.copyProperties(responese, (AppActiveResp)tsm1.getBody());
		} catch (Exception e) {
			e.printStackTrace();
			msg.setSts("0001");
			msg.setRjctCd("B0001");
			msg.setRjctInfo("appActive数据出错");
			msg.setEndFlag("01");
			responese.setRspnMsg(msg);
		}
		return responese;
	}

	@Override
	public PublicKeyResponse publicKey(PublicKeyRequest publicKeyRequest) {
		PublicKeyResponse responese = new PublicKeyResponse();
		TsmEntity<PublicKeyBody> tsm  = new TsmEntity<PublicKeyBody>();
		PublicKeyBody body = new PublicKeyBody();
		RspnMsg msg = new RspnMsg();
		// 获取加密因子
		String secureFactor = SpringPropertyPlaceholderConfigurer.getStringProperty("secureFactor");
		try {
			// 获取报文头
			Header header = HeaderManager.getHeader();
			if(null == header){
				responese.setRspnMsg(getMsg());
				return responese;
			}
			tsm.setHeader(header);
			// 将报文体转换为我们的bean
			BeanUtils.copyProperties(body, publicKeyRequest);
			tsm.setBody(body);
			// 交由service转发到tathing tsm
			byte[] returnStr ="".getBytes();;
			byte[] enData = Encryptor.decrypt(secureFactor.getBytes(), returnStr);
			// 解密json
			JsonReader reader = new JsonReader(new StringReader(new String( enData, ENCODE)));
			reader.setLenient(true);
			// 将返回json反序列化为业务实体
			TsmEntity<PublicKeyResp> tsm1  =  gson.fromJson(reader,new TypeToken<TsmEntity<PublicKeyResp>>() {}.getType());
			// 使用json复制属性，不使用BeanUtils.copyProperties
			String tsmJson = gson.toJson((PublicKeyResp)tsm1.getBody());
			responese = gson.fromJson(tsmJson, PublicKeyResponse.class);
			//BeanUtils.copyProperties(responese, (PublicKeyResp)tsm1.getBody());
		} catch (Exception e) {
			e.printStackTrace();
			msg.setSts("0001");
			msg.setRjctCd("B0001");
			msg.setRjctInfo("publicKey数据出错");
			msg.setEndFlag("01");
			responese.setRspnMsg(msg);
		}
		return responese;
	}

	@Override
	public SSDInfoResponse ssdInfo(SSDInfoRequest ssdInfoRequest) {
		SSDInfoResponse responese = new SSDInfoResponse();
		TsmEntity<SSDInfoBody> tsm  = new TsmEntity<SSDInfoBody>();
		SSDInfoBody body = new SSDInfoBody();
		RspnMsg msg = new RspnMsg();
		// 获取加密因子
		String secureFactor = SpringPropertyPlaceholderConfigurer.getStringProperty("secureFactor");
		try {
			// 获取报文头
			Header header = HeaderManager.getHeader();
			if(null == header){
				responese.setRspnMsg(getMsg());
				return responese;
			}
			tsm.setHeader(header);
			// 将报文体转换为我们的bean
			BeanUtils.copyProperties(body, ssdInfoRequest);
			tsm.setBody(body);
			// 交由service转发到tathing tsm
			byte[] returnStr = "".getBytes();;
			byte[] enData = Encryptor.decrypt(secureFactor.getBytes(), returnStr);
			// 解密json
			JsonReader reader = new JsonReader(new StringReader(new String( enData, ENCODE)));
			reader.setLenient(true);
			// 将返回json反序列化为业务实体
			TsmEntity<SSDInfoResp> tsm1  =  gson.fromJson(reader,new TypeToken<TsmEntity<SSDInfoResp>>() {}.getType());
			// 使用json复制属性，不使用BeanUtils.copyProperties
			String tsmJson = gson.toJson((SSDInfoResp)tsm1.getBody());
			responese = gson.fromJson(tsmJson, SSDInfoResponse.class);
			//BeanUtils.copyProperties(responese, (SSDInfoResp)tsm1.getBody());
		} catch (Exception e) {
			e.printStackTrace();
			msg.setSts("0001");
			msg.setRjctCd("B0001");
			msg.setRjctInfo("ssdInfo数据出错");
			msg.setEndFlag("01");
			responese.setRspnMsg(msg);
		}
		return responese;
	}

	@Override
	public AppDownloadResponse appDownload(AppDownloadRequest appDownloadRequest) {
		AppDownloadResponse responese = new AppDownloadResponse();
		TsmEntity<AppDownloadBody> tsm  = new TsmEntity<AppDownloadBody>();
		AppDownloadBody body = new AppDownloadBody();
		RspnMsg msg = new RspnMsg();
		// 获取加密因子
		String secureFactor = SpringPropertyPlaceholderConfigurer.getStringProperty("secureFactor");
		try {
			// 获取报文头
			Header header = HeaderManager.getHeader();
			if(null == header){
				responese.setRspnMsg(getMsg());
				return responese;
			}
			tsm.setHeader(header);
			// 将报文体转换为我们的bean
			String tsmJson1 = gson.toJson(appDownloadRequest);
			body = gson.fromJson(tsmJson1, AppDownloadBody.class);
			tsm.setBody(body);
			// 交由service转发到tathing tsm
			byte[] returnStr = "".getBytes();;
			byte[] enData = Encryptor.decrypt(secureFactor.getBytes(), returnStr);
			// 解密json
			JsonReader reader = new JsonReader(new StringReader(new String( enData, ENCODE)));
			reader.setLenient(true);
			// 将返回json反序列化为业务实体
			TsmEntity<AppDownloadResp> tsm1  =  gson.fromJson(reader,new TypeToken<TsmEntity<AppDownloadResp>>() {}.getType());
			// 使用json复制属性，不使用BeanUtils.copyProperties
			String tsmJson = gson.toJson((AppDownloadResp)tsm1.getBody());
			responese = gson.fromJson(tsmJson, AppDownloadResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
			msg.setSts("0001");
			msg.setRjctCd("B0001");
			msg.setRjctInfo("appDownload数据出错");
			msg.setEndFlag("01");
			responese.setRspnMsg(msg);
		}
		return responese;
	}

	@Override
	public CreatSSDResponse creatSSD(CreatSSDRequest creatSSDRequest) {
		CreatSSDResponse responese = new CreatSSDResponse();
		TsmEntity<CreatSSDBody> tsm  = new TsmEntity<CreatSSDBody>();
		CreatSSDBody body = new CreatSSDBody();
		RspnMsg msg = new RspnMsg();
		// 获取加密因子
		String secureFactor = SpringPropertyPlaceholderConfigurer.getStringProperty("secureFactor");
		try {
			// 获取报文头
			Header header = HeaderManager.getHeader();
			if(null == header){
				responese.setRspnMsg(getMsg());
				return responese;
			}
			tsm.setHeader(header);
			// 将报文体转换为我们的bean
			String tsmJson1 = gson.toJson(creatSSDRequest);
			body = gson.fromJson(tsmJson1, CreatSSDBody.class);
			tsm.setBody(body);
			// 交由service转发到tathing tsm
			byte[] returnStr = "".getBytes();;
			byte[] enData = Encryptor.decrypt(secureFactor.getBytes(), returnStr);
			// 解密json
			JsonReader reader = new JsonReader(new StringReader(new String( enData, ENCODE)));
			reader.setLenient(true);
			// 将返回json反序列化为业务实体
			TsmEntity<CreatSSDResp> tsm1  =  gson.fromJson(reader,new TypeToken<TsmEntity<CreatSSDResp>>() {}.getType());
			// 使用json复制属性，不使用BeanUtils.copyProperties
			String tsmJson = gson.toJson((CreatSSDResp)tsm1.getBody());
			responese = gson.fromJson(tsmJson, CreatSSDResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
			msg.setSts("0001");
			msg.setRjctCd("B0001");
			msg.setRjctInfo("creatSSD数据出错");
			msg.setEndFlag("01");
			responese.setRspnMsg(msg);
		}
		return responese;
	}
	
	/**
	 * 获取错误信息
	 * @return
	 */
	private RspnMsg getMsg(){
		RspnMsg msg = new RspnMsg();
		msg.setSts("0001");
		msg.setRjctCd("B0001");
		msg.setRjctInfo("报文头格式不正确");
		msg.setEndFlag("01");
		return msg;
	}

	@Override
	public OrderSaveResponse orderSave(OrderSaveRequest orderSaveRequest) {
		OrderSaveResponse responese = new OrderSaveResponse();
		TsmEntity<OrderSaveBody> tsm  = new TsmEntity<OrderSaveBody>();
		OrderSaveBody body = new OrderSaveBody();
		RspnMsg msg = new RspnMsg();		
		// 获取加密因子
		String secureFactor = SpringPropertyPlaceholderConfigurer.getStringProperty("secureFactor");			
		try {	
		// 获取报文头
		Header header = HeaderManager.getHeader();
		if(null == header){
				responese.setRspnMsg(getMsg());
				return responese;
		}	
		//报文头传空
		tsm.setHeader(null);
	    String reqJson = gson.toJson(orderSaveRequest);
		body = gson.fromJson(reqJson, OrderSaveBody.class);
		tsm.setBody(body);
			// 交由service转发到tathing tsm
		byte[] returnStr ="".getBytes();
		
		byte[] enData = Encryptor.decrypt(secureFactor.getBytes(), returnStr);
		// 解密json
		JsonReader reader = new JsonReader(new StringReader(new String(enData, ENCODE)));
		reader.setLenient(true);
		// 将返回json反序列化为业务实体
		TsmEntity<OrderSaveResp> tsm1  =  gson.fromJson(reader,new TypeToken<TsmEntity<OrderSaveResp>>() {}.getType());
		// 将返回json反序列化为业务实体:{"body": {"rspnMsg":{"endFlag":"01","rjctCd":"B0000","rjctInfo":"业务处理正常","sts":"0000"}}}
		
		String tsmJson = gson.toJson((OrderSaveResp)tsm1.getBody());
		System.out.println("营销平台返回的明文："+tsmJson.toString());
		responese = gson.fromJson(tsmJson, OrderSaveResponse.class);			
		} catch (Exception e) {
			e.printStackTrace();
			msg.setSts("0001");
			msg.setRjctCd("B0001");
			msg.setRjctInfo("orderSave数据出错");
			msg.setEndFlag("01");
			responese.setRspnMsg(msg);
		}
		return responese;
	
	}
}