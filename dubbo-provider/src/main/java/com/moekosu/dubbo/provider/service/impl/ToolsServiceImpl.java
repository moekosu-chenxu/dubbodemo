package com.moekosu.dubbo.provider.service.impl;

import com.moekosu.dubbo.api.bean.Tools;
import com.moekosu.dubbo.provider.dao.ToolsMapper;
import com.moekosu.dubbo.provider.service.ToolsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author chenxu
 * @date 2018/02
 */
public class ToolsServiceImpl implements ToolsService {

    @Autowired
    private ToolsMapper toolsMapper;

    @Override
    public List<Tools> getToolsList(Tools tools)
    {
        return toolsMapper.getToolsList(tools);
    }

}
