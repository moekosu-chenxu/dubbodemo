package com.moekosu.dubbo.consumer.controller;

import com.alibaba.fastjson.JSON;
import com.moekosu.dubbo.api.bean.Tools;
import com.moekosu.dubbo.provider.service.ToolsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * 工具下载Controller
 * @author chenxu
 * @date 2018/02
 */
@RestController
public class ToolsController {

    @Autowired
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
    public String downloadTools(String pass, String fileName, String downloadUrl, HttpServletResponse response)
    {
        //
        final String msgSuccess = "成功";
        final String msgNoExist = "失败，文件不存在";
        final String msgNoAuth = "失败，您无权限下载";
        final String msgError = "失败，系统错误";
        final String CORRECT_PASS = "218";

        // 处理
        File f = new File(downloadUrl);
        if(!f.exists()){
            return msgNoExist;
        }
        // TODO 鉴权(提取密码)
        if(!CORRECT_PASS.equals(pass)){
            return msgNoAuth;
        }

        // 设置编码与文件名
        response.setCharacterEncoding("UTF-8");
        response.addHeader("Content-Disposition", "attachment; filename=" + fileName);

        // 输入输出流
        FileInputStream in = null;
        ServletOutputStream out = null;
        try {
            // 缓存区1024个字节
            byte[] buf = new byte[1024];
            int rc = 0;
            // 文件输入流
            in = new FileInputStream(f);
            // response的输出流
            out = response.getOutputStream();
            // 写入out(每次读取指定buf长度的字符，指针已走到最后位置)
            while((rc = in.read(buf, 0, buf.length)) > 0){
                out.write(buf, 0, rc);
            }
            out.flush();
        }
        catch ( Exception e )
        {
            return msgError;
        }
        finally {
            try {
                in.close();
                out.close();
            }
            catch ( IOException e ){

            }
        }

        return msgSuccess;
    }

}
