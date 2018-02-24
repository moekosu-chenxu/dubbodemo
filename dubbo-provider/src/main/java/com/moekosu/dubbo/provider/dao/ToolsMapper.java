package com.moekosu.dubbo.provider.dao;

import com.moekosu.dubbo.api.bean.Tools;

/**
 * @author chenxu
 * @date 2018/02
 */
@Mapper
public interface ToolsMapper {

    List<Tools> getToolsList(Tools tools);

}
