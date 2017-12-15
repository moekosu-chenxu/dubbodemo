package com.moekosu.dubboprovider.service.impl;

import com.moekosu.dubboprovider.service.TestService;

public class TestServiceImpl implements TestService {

    @Override
    public String sayHello(String name)
    {
        return "Hello: " + name;
    }

}
