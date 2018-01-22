package com.moekosu.dubbo.provider.dao;

import com.moekosu.dubbo.api.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> getUserList();

}
