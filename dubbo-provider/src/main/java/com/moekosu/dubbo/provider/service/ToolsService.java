package com.moekosu.dubbo.provider.service;

import com.moekosu.dubbo.api.bean.Tools;

import java.util.List;

/**
 * @author chenxu
 * @date 2018/02
 */
public interface ToolsService {

    List<Tools> getToolsList(Tools tools);

}
