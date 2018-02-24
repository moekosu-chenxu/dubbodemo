package com.moekosu.dubbo.consumer.controller;

import com.alibaba.fastjson.JSON;
import com.moekosu.dubbo.api.bean.Tools;
import com.moekosu.dubbo.provider.service.ToolsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 工具下载Controller
 * @author chenxu
 * @date 2018/02
 */
@RestController
public class ToolsController {

    @Autowire
    private ToolsService toolsService;

    @RequestMapping("/tools/list")
    @ResponseBody
    public String getToolsList()
    {
        Tools tools = new Tools();
        List<Tools> list = toolsService.getToolsList(tools);

        return JSON.toJSONString(list);
    }

    @RequestMapping("/tools/download")
    @ResponseBody
    public String downloadTools(String id)
    {
        Integer toolsID = 0;
        try {
            toolsID = Integer.valueOf(id);
        }
        catch (Exception e)
        {
            // logging
        }
        Tools tools = new Tools();
        tools.setId(toolsID);
        List<Tools> list = toolsService.getToolsList(tools);
        Tools result = !list.isEmpty() && list.size()>0? list.get(0) : new Tools();

        return JSON.toJSONString(result);
    }

}
