package com.yang.aop;

import com.sun.deploy.net.proxy.DynamicProxyManager;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

public class TestAop {
    public static void main(String[] args) {
        //需要代理的接口,被代理类实现的多个接口必须在这里定义
        Class[] proxyInterface = new Class[]{IBusiness.class,IBusiness2.class};

        //构建AOP的Advice,这里需要传入业务类的实例
        LogInvocationHandler handler = new LogInvocationHandler(new Business());

        //生成代理类的字节码加载器
        ClassLoader classLoader = DynamicProxyManager.class.getClassLoader();

        IBusiness2 proxyBusiness = (IBusiness2) Proxy.newProxyInstance(classLoader,proxyInterface,handler);


        System.out.println("调用处理器："+Proxy.getInvocationHandler(proxyBusiness));
        //使用代理类的实例来调用方法
        proxyBusiness.doSomeThing2();

        ((IBusiness)proxyBusiness).doSomeThing();
    }

    /**
     * 测试静态代理
     */
    @Test
    public void testProxy(){
        Business business = new Business();
        business.doSomeThing();
        business.doSomeThing2();
    }

    @Test
    public void testReflect(){
        try {
            Constructor con = Business.class.getConstructor(String.class);
            //con.newInstance(new String[]{"lucy"});
            //Object ob = con.newInstance();// wrong number of arguments
            Object ob = con.newInstance("lucy");
            System.out.println(ob);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 动态字节码生成
     */
    @Test
    public void testByteCode(){
        byteCodege();
    }

    public static void byteCodege(){
        //创建一个织入器
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(Business.class);

        enhancer.setCallback(new LogIntercept());

        //使用织入器创建子类
        IBusiness2 newBusiness = (IBusiness2)enhancer.create();
        newBusiness.doSomeThing2();
    }
}
