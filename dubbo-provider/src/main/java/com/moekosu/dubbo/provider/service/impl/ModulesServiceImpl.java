package com.moekosu.dubbo.provider.service.impl;

import com.moekosu.dubbo.api.bean.Modules;
import com.moekosu.dubbo.provider.dao.ModulesMapper;
import com.moekosu.dubbo.provider.service.ModulesService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2018/1/23.
 */
public class ModulesServiceImpl implements ModulesService {

	@Autowired
	private ModulesMapper modulesMapper;

	@Override
	public List<Modules> getAllModulesList()
	{
		return modulesMapper.getAllModulesList();
	}

}
