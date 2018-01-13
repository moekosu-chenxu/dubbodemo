package com.moekosu.dubbo.provider.service.abstractImpl;

import com.moekosu.dubbo.provider.service.LotteryService;
import com.moekosu.dubbo.api.bean.LotteryUser;

import java.util.List;

public abstract class LotteryAbstractService implements LotteryService {

    @Override
    public String Lottery(String activityId)
    {
        return "";
    }

    @Override
    public String Lottery(List<LotteryUser> userList)
    {
        return  "";
    }

}
