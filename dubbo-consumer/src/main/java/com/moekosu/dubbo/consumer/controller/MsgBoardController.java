package com.moekosu.dubbo.consumer.controller;

import com.moekosu.dubbo.api.bean.MessageBoard;
import com.moekosu.dubbo.provider.service.MsgBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author chenxu
 * @date 2018/03
 */
@RestController
public class MsgBoardController extends PageController {

    @Autowired
    private MsgBoardService msgBoardService;

    @RequestMapping("/board/list")
    @ResponseBody
    public String getBoardMessageList()
    {
        try {
            List<MessageBoard> list = msgBoardService.getBoardList();
            return returnSuccessMap(list);
        }
        catch (Exception e){
            System.out.println(e);
            return returnFailMap("获取失败");
        }
    }

    @RequestMapping("/board/add")
    @ResponseBody
    public String addMessage(String author, String content)
    {
        MessageBoard message = new MessageBoard();
        message.setAuthor(author);
        message.setContent(content);
        try {
            msgBoardService.addMessage(message);
            return returnSuccessMap(null);
        }
        catch (Exception e){
            System.out.println(e);
            return returnFailMap("新增失败");
        }
    }

}
