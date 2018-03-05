package com.moekosu.dubbo.provider.dao;

import com.moekosu.dubbo.api.bean.Essay;
import com.moekosu.dubbo.api.bean.EssayGroup;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author chenxu
 * @date 2018/03
 */
@Mapper
public interface BlogMapper {

    List<Essay> getEssayList(String groupId);

    List<EssayGroup> getEssayGroupList();

    Essay getEssayDetailById(String essayId);

    void addEssay(Essay essay);

    void removeEssay(String essayId);

    void updateEssay(Essay essay);

}
