package com.moekosu.dubbo.provider.dao;

import com.moekosu.dubbo.api.bean.Modules;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2018/1/23.
 */
@Mapper
public interface ModulesMapper {

	List<Modules> getAllModulesList();

}
