package com.yang.aop;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class LogIntercept implements MethodInterceptor {

    @Override
    public Object intercept(Object target, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        //执行原有逻辑，注意这是invokeSuper

        Object rev = proxy.invokeSuper(target,args);

        if(method.getName().equals("doSomeThing2")){
            System.out.println("记录日志");
        }

        return rev;
    }
}
