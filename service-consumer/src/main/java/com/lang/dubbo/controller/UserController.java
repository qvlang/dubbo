package com.lang.dubbo.controller;

import com.lang.dubbo.model.User;
import com.lang.dubbo.service.IUserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Reference
    private IUserService userService;

    @PostMapping("/login")
    public String login(String username, String password, Model model) {
        boolean success = userService.login(username, password);
        if (success) {
            model.addAttribute("username", username);
            return "success";
        } else {
            return "fail";
        }
    }

    @GetMapping("/addBatch")
    @ResponseBody
    public String addBatch() {
        //批量注册
        User user1 = new User();
        user1.setUsername("赵一");
        User user2 = new User();
        user2.setUsername("赵二");
        User user3 = new User();
        user3.setUsername("赵三");
        User user4 = new User();
        user4.setUsername("赵四");
        User user5 = new User();
        user5.setUsername("赵五");
        User user6 = new User();
        user6.setUsername("赵六");
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);
        userService.resgisterBatch(users);
        return "ok";
    }

    @GetMapping("/add")
    @ResponseBody
    public String add() {
        User user1 = new User();
        user1.setUsername("单条记录插入");
        userService.register(user1);
        return "ok";
    }
}
