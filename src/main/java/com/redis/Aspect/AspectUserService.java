package com.redis.Aspect;

import com.redis.pojo.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import javax.sound.midi.Soundbank;

/**
 * @author smxr
 * @date 2020/11/23
 * @time 10:33
 */
@Aspect
@Component
public class AspectUserService {
//    @Pointcut("execution( public * com.redis.service.impl.UserServiceImpl.sleep(..))")
////    private void PointCut(){}
    @Before("execution(public * com.redis.service.UserService.sleep(..))")
    public void sleepBefore(JoinPoint joinPoint){
      //  System.out.println(joinPoint.toString());//输出结果:execution(void com.redis.service.impl.UserServiceImpl.sleep())
        System.out.println("joinPoint.getSignature().getName():"+joinPoint.getSignature().getName());//sleep
        System.out.println("joinPoint.getSignature().getDeclaringTypeName():"+joinPoint.getSignature().getDeclaringTypeName());//com.redis.service.impl.UserServiceImpl
        System.out.println("joinPoint.getSignature().getModifiers():"+joinPoint.getSignature().getModifiers());//1
        System.out.println("前置拦截开始了");//2
    }
    @After("execution(public * com.redis.service.UserService.sleep(..))")
    public void sleepAfter(JoinPoint joinPoint){
        System.out.println("后置拦截开始了");//4
    }
    @AfterReturning("execution(public * com.redis.service.UserService.sleep(..))")
    public void sleepAfterReturning(JoinPoint joinPoint){
        System.out.println("完成拦截开始了");//3
    }
    @AfterThrowing("execution(public * com.redis.service.UserService.sleep(..))")
    public void sleep(JoinPoint joinPoint){
        System.out.println("异常拦截开始了");
    }
    @Around("execution(public * com.redis.service.UserService.sleep(..))")
    public void sleepAround(ProceedingJoinPoint proceedingJoinPoint){
        try {
            System.out.println("前置环绕:运行......");//1
            proceedingJoinPoint.proceed();
            System.out.println("后置环绕:运行......");//5
        } catch (Throwable throwable) {
            System.out.println("环绕:运行异常......");
        }
    }

    //不关注 参数
    @Around("execution(public * com.redis.service.UserService.speak(..))")
    public void speakAround(ProceedingJoinPoint proceedingJoinPoint){
        try {
            System.out.println("前置环绕:运行......");
            proceedingJoinPoint.proceed();
            System.out.println("后置环绕:运行......");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    //
    /*
    * 关注 参数
    * && args(user) 指定参数;要传入的参数
    * && bean(userServiceImpl) 指定要使用的容器组件名;即这个指定的(userServiceImpl)组件bean去调用,才能生效.
    */
    @Around("execution(public * com.redis.service.UserService.speak(..)) && args(user)&& bean(userService)")
    public void speakAround(ProceedingJoinPoint proceedingJoinPoint,User user){

        try {
            if (user.getUserAge()==69){
                System.out.println(user.getUserAge()+"老同志即将发言,请注意听讲!如果你大意了,就没有闪了");
            }else if (user.getUserAge()>69){
                System.out.println(user.getUserAge()+"老同志即将发言,请注意听讲!");
            }else {
                System.out.println(user.getUserName()+"的前置环绕即将说话:请注意听讲");
            }
            proceedingJoinPoint.proceed();
            if (user.getUserAge()==69){
                System.out.println(user.getUserAge()+"老同志发言完成,恭喜大家获取技能闪电五连变");
            }else {
                System.out.println(user.getUserName()+"的后置环绕完成!");
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
    @Before("execution(public * com.redis.service.UserService.speak(..))")
    public void speakBefore(JoinPoint joinPoint){
        System.out.println("前置拦截开始了");
    }
    @After("execution(public * com.redis.service.UserService.speak(..))")
    public void speakAfter(JoinPoint joinPoint){
        System.out.println("后置拦截开始了");
    }
    @AfterReturning("execution(public * com.redis.service.UserService.speak(..))")
    public void speakAfterReturning(JoinPoint joinPoint){
        System.out.println("完成拦截开始了");
    }

}
