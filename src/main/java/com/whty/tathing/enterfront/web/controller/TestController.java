package com.whty.tathing.enterfront.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whty.entities.BaseInfo;
import com.whty.entities.Criteria;
import com.whty.tathing.enterfront.web.service.BaseInfoService;

@Controller
@RequestMapping("/tsmnetty")
public class TestController extends BaseController{
	@Autowired
	@Qualifier("baseInfoService")
	BaseInfoService baseInfoService;


	@ResponseBody
	@RequestMapping("/test")
	public Object test(HttpServletRequest req)throws Exception{
		try {
			List<BaseInfo> li = baseInfoService.getBaseInfo(new Criteria());
			return li;
		}catch(Exception e){
			e.printStackTrace();
		}
		return "error";
	}
}
