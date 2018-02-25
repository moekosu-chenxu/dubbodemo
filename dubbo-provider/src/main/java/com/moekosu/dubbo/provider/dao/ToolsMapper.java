package com.moekosu.dubbo.provider.dao;

import com.moekosu.dubbo.api.bean.Tools;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author chenxu
 * @date 2018/02
 */
@Mapper
public interface ToolsMapper {

    List<Tools> getToolsList(Tools tools);

}
