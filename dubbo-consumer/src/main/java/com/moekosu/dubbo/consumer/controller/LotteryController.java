package com.moekosu.dubbo.consumer.controller;

import com.moekosu.dubbo.provider.service.LotteryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import com.moekosu.dubbo.api.bean.LotteryUser;

@RestController
@RequestMapping("/lottery")
public class LotteryController {

    private static final Logger logger = LoggerFactory.getLogger(LotteryController.class);

    // 参与抽奖的用户
    private List<LotteryUser> userList = new ArrayList<LotteryUser>();
    // 抽奖序号
    private int seqNum = 1;

    @Autowired
    @Qualifier("prizeLotteryService")
    private LotteryService lotteryService1;

    @Autowired
    @Qualifier("personLotteryService")
    private LotteryService lotteryService2;

    @RequestMapping("/prize")
    @ResponseBody
    public String Lottery1()
    {
        logger.info("抽奖");
        String prize = lotteryService1.Lottery("123");
        return prize;
    }

    @RequestMapping("/person/lottery")
    @ResponseBody
    public String Lottery2()
    {
        logger.info("抽奖");
        String prize = lotteryService2.Lottery(userList);
        emptyUserList();
        return prize;
    }

    /**
     * 进入抽奖队列
     * @param userName
     */
    @RequestMapping("/person/join")
    public void joinLottery(String userName)
    {
        if(StringUtils.isEmpty(userName))
        {
            logger.info("join user: ["+userName+"] into lottery error");
        }
        LotteryUser user = new LotteryUser();
        user.setId(seqNum++);
        user.setUserName(userName);
        this.userList.add(user);
    }

    /**
     * 抽奖结束，清空队列
     */
    private void emptyUserList()
    {
        userList = new ArrayList<LotteryUser>();
        seqNum = 1;
    }

}
