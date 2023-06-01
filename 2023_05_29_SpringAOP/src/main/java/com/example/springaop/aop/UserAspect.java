package com.example.springaop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: cbiltps
 * Date: 2023-05-29
 * Time: 16:57
 */
@Aspect // 定义当前类是一个切面
@Component
public class UserAspect {

    // 定义一个切点（设置拦截规则）
    @Pointcut("execution(* com.example.springaop.controller.UserController.*(..))")
    public void userPointcut() {

    }

    /**
     * 实现 userPointcut 切点的前置通知,
     * 在执行目标方法之前执行的方法就叫做前置通知.
     */
    @Before("userPointcut()")
    public void doBefore() {
        System.out.println("前置通知: 被执行了.");
    }

    /**
     * 针对 userPointcut 切点的后置通知.
     */
    @After("userPointcut()")
    public void doAfter() {
        System.out.println("后置通知: 被执行了.");
    }

    @AfterReturning("userPointcut()")
    public void doAfterReturning() {
        System.out.println("执行了 AfterReturning 方法");
    }

    @AfterThrowing("userPointcut()")
    public void doAfterThrowing() {
        System.out.println("执行了 AfterThrowing 方法");
    }

    /**
     * 针对 userPointcut 切点的环绕通知(计算方法的执行时间---旧的写法).
     * @param joinPoint
     * @return
     */
//    @Around("userPointcut()")
//    public Object doAround(ProceedingJoinPoint joinPoint) {
//        Object result = null;
//        long start = System.currentTimeMillis();
//        try {
//
//            // 执行目标方法, 以及目标方法所对应的相应的通知
//            result = joinPoint.proceed();
//
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
//        long end = System.currentTimeMillis();
//        System.out.println(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName()
//                + " 方法执行时间: " + (end - start) + "ms");
//        return result;
//    }

    /**
     * 针对 userPointcut 切点的环绕通知(Spring中的时间统计).
     *
     * @param joinPoint
     * @return
     */
    @Around("userPointcut()")
    public Object doAround(ProceedingJoinPoint joinPoint) {
        // Spring中的时间统计对象
        StopWatch stopWatch = new StopWatch();
        Object result = null;
        try {
            stopWatch.start(); // 开始计时
            // 执行目标方法, 以及目标方法所对应的相应的通知等
            result = joinPoint.proceed();
            stopWatch.stop(); // 停止计时
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName()
                + " 方法执行花费的时间: " + stopWatch.getTotalTimeMillis() + "ms");
        return result;
    }
}
