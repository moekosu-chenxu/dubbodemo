package com.moekosu.dubbo.provider.dao;

import com.moekosu.dubbo.api.bean.Essay;
import com.moekosu.dubbo.api.bean.EssayGroup;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chenxu
 * @date 2018/03
 */
@Mapper
public interface BlogMapper {

    List<Essay> getEssayList(@Param("groupId") String groupId);

    List<EssayGroup> getEssayGroupList();

    Essay getEssayDetailById(@Param("essayId") String essayId);

    void addEssay(Essay essay);

    void removeEssay(@Param("essayId") String essayId);

    void updateEssay(Essay essay);

}
