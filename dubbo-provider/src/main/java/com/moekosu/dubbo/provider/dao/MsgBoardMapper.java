package com.moekosu.dubbo.provider.dao;

import com.moekosu.dubbo.api.bean.MessageBoard;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author chenxu
 * @date 2018/03
 */
@Mapper
public interface MsgBoardMapper {

    List<MessageBoard> getBoardList();

    void addMessage(MessageBoard message);

}
