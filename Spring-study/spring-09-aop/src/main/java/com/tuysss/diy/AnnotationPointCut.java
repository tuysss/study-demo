package com.tuysss.diy;
//方法三：使用注解 实现AOP
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect  //标注这个类是一个切面
public class AnnotationPointCut {

    @Before("execution(* com.tuysss.service.UserService.*(..))")
    public void before(){
        System.out.println("=======方法执行前=======");
    }

    @After("execution(* com.tuysss.service.UserService.*(..))")
    public void after(){
        System.out.println("=======方法执行后=======");
    }

    //在环绕增强中，我们可以给定一个参数，代表我们要获取处理切入的点
    @Around("execution(* com.tuysss.service.UserService.*(..))")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("环绕前");

        //签名，一般用于日志
        Signature signature = jp.getSignature();
        System.out.println("signature= "+signature);
        //执行方法
        Object proceed = jp.proceed();

        System.out.println("环绕后");
    }

}


