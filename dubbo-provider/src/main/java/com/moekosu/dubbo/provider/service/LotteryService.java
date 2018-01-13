package com.moekosu.dubbo.provider.service;

import com.moekosu.dubbo.api.bean.LotteryUser;

import java.util.List;

public interface LotteryService {

    String Lottery(String activityId);

    String Lottery(List<LotteryUser> userList);

}
