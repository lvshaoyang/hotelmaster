package com.yang.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/***
 * 打印日志的切面
 */
public class LogInvocationHandler implements InvocationHandler {
    private Object target;  //目标对象t

    public LogInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        /**
         * proxy既是代理类的实例？？
         * 可以看一下invoke这个方法的具体实现
         * method是怎么传过来的,调用多个方法的话,
         *
         * 生成的代理类源码会把自身传到这个方法中proxy为this
         */

        //System.out.println("method到底有几个"+method.getName());
        //执行原有逻辑
        Object rev = method.invoke(target);
        //执行织入的日志,你可以控制哪些方法执行切入逻辑
        if(method.getName().equals("doSomeThing2")){
            System.out.println("记录日志");
        }

        //System.out.println("method调用invoke方法的返回值是："+rev);

        return rev;
    }
}
