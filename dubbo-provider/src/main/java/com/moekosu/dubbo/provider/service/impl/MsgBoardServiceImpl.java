package com.moekosu.dubbo.provider.service.impl;

import com.moekosu.dubbo.api.bean.MessageBoard;
import com.moekosu.dubbo.provider.dao.MsgBoardMapper;
import com.moekosu.dubbo.provider.service.MsgBoardService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author chenxu
 * @date 2018/03
 */
public class MsgBoardServiceImpl implements MsgBoardService {

    @Autowired
    private MsgBoardMapper msgBoardMapper;

    public List<MessageBoard> getBoardList() {
        return msgBoardMapper.getBoardList();
    }

    public void addMessage(MessageBoard message) {
        msgBoardMapper.addMessage(message);
    }
}
