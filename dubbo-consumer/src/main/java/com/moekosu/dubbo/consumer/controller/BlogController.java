package com.moekosu.dubbo.consumer.controller;

import com.alibaba.fastjson.JSON;
import com.moekosu.dubbo.api.bean.Essay;
import com.moekosu.dubbo.api.bean.EssayGroup;
import com.moekosu.dubbo.provider.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenxu
 * @date 2018/03
 */
@RestController
public class BlogController extends PageController {

    @Autowired
    private BlogService blogService;

    @RequestMapping("/blog/list")
    @ResponseBody
    public String getBlogList(String groupId)
    {
        List<Essay> list = blogService.getEssayList(groupId);
        return returnSuccessMap(list);
    }

    @RequestMapping("/blog/groupList")
    @ResponseBody
    public String getBlogGroupList()
    {
        List<EssayGroup> list = blogService.getEssayGroupList();
        return returnSuccessMap(list);
    }

    @RequestMapping("/blog/detail")
    @ResponseBody
    public String getBlogDetail(String id)
    {
        Essay essay = blogService.getEssayDetailById(id);
        return returnSuccessMap(essay);
    }

    @RequestMapping("/blog/add")
    @ResponseBody
    public String addEssay()
    {
        try {
            Essay essay = new Essay();
            blogService.addEssay(essay);
            return returnSuccessMap(null);
        }
        catch (Exception e){
            System.out.println(e);
            return returnFailMap("新增失败");
        }
    }

    @RequestMapping("/blog/remove")
    @ResponseBody
    public String removeEssay(String essayId)
    {
        try {
            blogService.removeEssay(essayId);
            return returnSuccessMap(null);
        }
        catch (Exception e){
            System.out.println(e);
            return returnFailMap("删除失败");
        }
    }

    @RequestMapping("/blog/update")
    @ResponseBody
    public String updateEssay(String id, String title, String content, String groupId)
    {
        try {
            Essay essay = new Essay();
            essay.setId(id);
            essay.setTitle(title);
            essay.setContent(content);
            // 缺更新时间
            essay.setGroupId(groupId);
            blogService.updateEssay(essay);
            return returnSuccessMap(null);
        }
        catch (Exception e){
            System.out.println(e);
            return returnFailMap("编辑失败");
        }
    }



}
