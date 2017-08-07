package com.yang.aop;

import com.sun.deploy.net.proxy.DynamicProxyManager;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

public class TestAop {
    public static void main(String[] args) {
        //��Ҫ����Ľӿ�,��������ʵ�ֵĶ���ӿڱ��������ﶨ��
        Class[] proxyInterface = new Class[]{IBusiness.class,IBusiness2.class};

        //����AOP��Advice,������Ҫ����ҵ�����ʵ��
        LogInvocationHandler handler = new LogInvocationHandler(new Business());

        //���ɴ�������ֽ��������
        ClassLoader classLoader = DynamicProxyManager.class.getClassLoader();

        IBusiness2 proxyBusiness = (IBusiness2) Proxy.newProxyInstance(classLoader,proxyInterface,handler);


        System.out.println("���ô�������"+Proxy.getInvocationHandler(proxyBusiness));
        //ʹ�ô������ʵ�������÷���
        proxyBusiness.doSomeThing2();

        ((IBusiness)proxyBusiness).doSomeThing();
    }

    /**
     * ���Ծ�̬����
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
     * ��̬�ֽ�������
     */
    @Test
    public void testByteCode(){
        byteCodege();
    }

    public static void byteCodege(){
        //����һ��֯����
        Enhancer enhancer = new Enhancer();
        //���ø���
        enhancer.setSuperclass(Business.class);

        enhancer.setCallback(new LogIntercept());

        //ʹ��֯������������
        IBusiness2 newBusiness = (IBusiness2)enhancer.create();
        newBusiness.doSomeThing2();
    }
}
