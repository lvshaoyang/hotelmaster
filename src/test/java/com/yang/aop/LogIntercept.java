package com.yang.aop;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class LogIntercept implements MethodInterceptor {

    @Override
    public Object intercept(Object target, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        //ִ��ԭ���߼���ע������invokeSuper

        Object rev = proxy.invokeSuper(target,args);

        if(method.getName().equals("doSomeThing2")){
            System.out.println("��¼��־");
        }

        return rev;
    }
}
