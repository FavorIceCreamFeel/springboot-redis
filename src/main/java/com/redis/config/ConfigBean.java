package com.redis.config;

import com.redis.pojo.User;
import com.redis.pojo.UserConditional;
import com.redis.pojo.UserConditional2;
import com.redis.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author smxr
 * @date 2020/11/19
 * @time 11:11
 * EnableAspectJAutoProxy(proxyTargetClass = true)
 * 这个为true时,则会使用 cglib 的动态代理方式;缺点:拓展类的实例用final修饰时,则无法进行织入
 * 默认使用的是jdk动态代理; 缺点:会有一点影响性能
 */
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ConfigBean {

    @Conditional(UserConditional.class)
    @Bean
    public User user(){
        System.out.println("张三加载中...........");
        User user = new User();
        user.setUserName("张三");
        return user;
    }
    @Conditional(UserConditional2.class)
    @Bean
    public User user2(){
        System.out.println("李四加载中...........");
        User user = new User();
        user.setUserName("李四");
        return user;
    }
    @Bean
    public UserServiceImpl userService2(){
        UserServiceImpl userService2 = new UserServiceImpl();
        return userService2;
    }
}
