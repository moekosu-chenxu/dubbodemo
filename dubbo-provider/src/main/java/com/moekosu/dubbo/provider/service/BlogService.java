package com.moekosu.dubbo.provider.service;

import com.moekosu.dubbo.api.bean.Essay;
import com.moekosu.dubbo.api.bean.EssayGroup;

import java.util.List;

/**
 * @author chenxu
 * @date 2018/03
 */
public interface BlogService {

    List<Essay> getEssayList(String groupId);

    List<EssayGroup> getEssayGroupList();

    Essay getEssayDetailById(String essayId);

    void addEssay(Essay essay);

    void removeEssay(String essayId);

    void updateEssay(Essay essay);

}
