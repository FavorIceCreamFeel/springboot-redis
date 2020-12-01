package com.redis.service.impl;

import com.redis.pojo.User;
import com.redis.service.UserService;
import org.springframework.stereotype.Service;

import javax.naming.Name;

/**
 * @author smxr
 * @date 2020/11/23
 * @time 10:25
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Override
    public void eat() {
        System.out.println("要去吃饭了......");
    }

    @Override
    public void sleep() {
        System.out.println("终于到了放松的时候了........");
    }

    @Override
    public void corporate_slave() {
        System.out.println("要去工作了.........");
    }

    @Override
    public void speak(User user) {
        System.out.println(user.getUserName()+"说:.......");
    }
}
