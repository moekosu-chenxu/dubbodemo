package com.moekosu.dubbo.provider.service.impl;

import com.moekosu.dubbo.api.bean.Tools;
import com.moekosu.dubbo.provider.dao.ToolsMapper;
import com.moekosu.dubbo.provider.service.ToolsService;

/**
 * @author chenxu
 * @date 2018/02
 */
public class ToolsServiceImpl implements ToolsService {

    @Autowire
    private ToolsMapper toolsMapper;

    @Override
    public List<Tools> getToolsList(Tools tools)
    {
        return toolsMapper.getToolsList(tools);
    }

}
