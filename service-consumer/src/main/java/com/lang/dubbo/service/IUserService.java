package com.lang.dubbo.service;

import com.lang.dubbo.model.User;

import java.util.List;

public interface IUserService {
    //登录
    boolean login(String username, String password);

    //注册
    boolean register(User user);
    //批量注册
    boolean resgisterBatch(List<User> users);
}
