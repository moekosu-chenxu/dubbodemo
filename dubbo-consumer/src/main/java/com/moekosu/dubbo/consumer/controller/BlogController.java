package com.moekosu.dubbo.consumer.controller;

import com.moekosu.dubbo.api.bean.Essay;
import com.moekosu.dubbo.api.bean.EssayGroup;
import com.moekosu.dubbo.provider.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author chenxu
 * @date 2018/03
 */
//@CrossOrigin(origins = "**", maxAge = 3600)
@RequestMapping(value = "/blog", method = RequestMethod.POST)
@RestController
public class BlogController extends PageController {

    @Autowired
    private BlogService blogService;

    @RequestMapping("/list")
    @ResponseBody
    public String getBlogList(@RequestBody Map<String, Object> reqMap)
    {
        String groupId = (String) reqMap.get("groupId");
        List<Essay> list = blogService.getEssayList(groupId);
        return returnSuccessMap(list);
    }

    @RequestMapping("/groupList")
    @ResponseBody
    public String getBlogGroupList()
    {
        List<EssayGroup> list = blogService.getEssayGroupList();
        return returnSuccessMap(list);
    }

    @RequestMapping("/detail")
    @ResponseBody
    public String getBlogDetail(@RequestBody Map<String, Object> reqMap)
    {
        String id = reqMap.get("id").toString();
        Essay essay = blogService.getEssayDetailById(id);
        return returnSuccessMap(essay);
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public String addEssay(@RequestBody Map<String, Object> reqMap)
    {
        String title = (String) reqMap.get("title");
        String content = (String) reqMap.get("content");
        String groupId = (String) reqMap.get("groupId");
        // TODO 防止注入

        Essay essay = new Essay();
        essay.setTitle(title);
        essay.setContent(content);
        essay.setGroupId(groupId == null? "0": groupId);
        try {
            blogService.addEssay(essay);
            return returnSuccessMap(null);
        }
        catch (Exception e){
            System.out.println(e);
            return returnFailMap("新增失败");
        }
    }

    @RequestMapping("/remove")
    @ResponseBody
    public String removeEssay(@RequestBody Map<String, Object> reqMap)
    {
        String essayId = reqMap.get("essayId").toString();
        try {
            blogService.removeEssay(essayId);
            return returnSuccessMap(null);
        }
        catch (Exception e){
            System.out.println(e);
            return returnFailMap("删除失败");
        }
    }

    @RequestMapping("/update")
    @ResponseBody
    public String updateEssay(@RequestBody Map<String, Object> reqMap)
    {
        String id = reqMap.get("id").toString();
        String title = reqMap.get("title").toString();
        String content = reqMap.get("content").toString();
        String groupId = reqMap.get("groupId").toString();

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
