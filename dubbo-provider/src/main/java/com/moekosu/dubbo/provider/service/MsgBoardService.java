package com.moekosu.dubbo.provider.service;

import com.moekosu.dubbo.api.bean.MessageBoard;

import java.util.List;

/**
 * @author chenxu
 * @date 2018/03
 */
public interface MsgBoardService {

    List<MessageBoard> getBoardList();

    void addMessage(MessageBoard message);

}
