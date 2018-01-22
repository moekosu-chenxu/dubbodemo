package com.moekosu.dubbo.consumer.controller;

import com.alibaba.fastjson.JSON;
import com.moekosu.dubbo.api.bean.Modules;
import com.moekosu.dubbo.provider.service.ModulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Created by Administrator on 2018/1/21.
 */
@RestController
public class ModulesController {

	@Autowired
	private ModulesService modulesService;

	@RequestMapping("/modules/list")
	@ResponseBody
	public String getModules()
	{
		List<Modules> list = modulesService.getAllModulesList();

		return JSON.toJSONString(list);
	}

}
