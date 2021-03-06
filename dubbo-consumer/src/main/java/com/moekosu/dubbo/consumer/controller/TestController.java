package com.moekosu.dubbo.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSONObject;
import com.moekosu.dubbo.provider.service.DemoService;

import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试用的 Controller 类；
 */
@RestController
public class TestController {
	
	@Autowired
	DemoService demoService;

	/**
	 * 测试 JSON 接口；
	 * @param name 名字
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/test/{name}")
	public JSONObject testJson(@PathVariable("name") String name) {
		JSONObject jsonObject = new JSONObject();
		String testStr = demoService.sayHello(name);
		jsonObject.put("str", testStr);
		return jsonObject;
	}
}