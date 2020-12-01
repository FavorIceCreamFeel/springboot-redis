package com.redis;

import com.redis.pojo.User;
import com.redis.pojo.UserConditional;
import com.redis.pojo.UserConditional2;
import com.redis.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class SpringbootRedisApplicationTests {
    @Autowired
    StringRedisTemplate redis;
    @Autowired
    private User user;
    @Autowired
    private User user2;
    @Autowired
    UserServiceImpl userService;
    @Autowired
    UserServiceImpl userService2;
//    @Autowired
//    private ApplicationContext applicationContext;

    @Test
    void contextLoads() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
//        System.out.println(this.user.toString());
//        System.out.println(user2.toString());
    }
    @Test
    void AOPTest(){
        for (int i = 0; i < 10; i++) {
            AOPTest1();
        }
    }
    @Test
    void AOPTest3(){
        userService2.sleep();
    }
    @Test
    void AOPTest1(){
        User user3 = new User();
        user3.setUserName("马老师");
        user3.setUserAge(69);
        userService.speak(user3);
        System.out.println("----------------分界线--------------------");
        User user4 = new User();
        user4.setUserName("老马");
        user4.setUserAge(80);
        userService2.speak(user4);
    }

}
