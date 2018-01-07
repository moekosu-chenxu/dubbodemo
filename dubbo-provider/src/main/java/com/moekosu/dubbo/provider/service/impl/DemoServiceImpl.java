package com.moekosu.dubbo.provider.service.impl;

import com.moekosu.dubbo.provider.service.DemoService;

public class DemoServiceImpl implements DemoService {

	public String sayHello(String name)
	{
		return "Welcome to Moekosu's Dubbo, Hello " + name;
	}

}
