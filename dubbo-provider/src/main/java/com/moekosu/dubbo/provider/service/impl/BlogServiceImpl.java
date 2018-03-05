package com.moekosu.dubbo.provider.service.impl;

import com.moekosu.dubbo.api.bean.Essay;
import com.moekosu.dubbo.api.bean.EssayGroup;
import com.moekosu.dubbo.provider.dao.BlogMapper;
import com.moekosu.dubbo.provider.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author chenxu
 * @date 2018/03
 */
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    public List<Essay> getEssayList(String groupId) {
        return blogMapper.getEssayList(groupId);
    }

    public List<EssayGroup> getEssayGroupList() {
        return blogMapper.getEssayGroupList();
    }

    public Essay getEssayDetailById(String essayId) {
        return blogMapper.getEssayDetailById(essayId);
    }

    public void addEssay(Essay essay) {
        blogMapper.addEssay(essay);
    }

    public void removeEssay(String essayId) {
        blogMapper.removeEssay(essayId);
    }

    public void updateEssay(Essay essay) {
        blogMapper.updateEssay(essay);
    }
}
