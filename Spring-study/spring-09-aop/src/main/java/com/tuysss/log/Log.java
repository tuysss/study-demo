package com.tuysss.log;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.net.SocketTimeoutException;

public class Log implements MethodBeforeAdvice {

    /**
     * @param method method being invoked要执行的方法
     * @param args
     * @param target target of the method invocation目标对象
     * @throws Throwable
     */
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println(target.getClass().getName()+"对象的"+method.getName()+"方法 被执行了");
    }
}
