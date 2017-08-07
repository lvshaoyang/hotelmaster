package com.yang.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/***
 * ��ӡ��־������
 */
public class LogInvocationHandler implements InvocationHandler {
    private Object target;  //Ŀ�����t

    public LogInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        /**
         * proxy���Ǵ������ʵ������
         * ���Կ�һ��invoke��������ľ���ʵ��
         * method����ô��������,���ö�������Ļ�,
         *
         * ���ɵĴ�����Դ�������������������proxyΪthis
         */

        //System.out.println("method�����м���"+method.getName());
        //ִ��ԭ���߼�
        Object rev = method.invoke(target);
        //ִ��֯�����־,����Կ�����Щ����ִ�������߼�
        if(method.getName().equals("doSomeThing2")){
            System.out.println("��¼��־");
        }

        //System.out.println("method����invoke�����ķ���ֵ�ǣ�"+rev);

        return rev;
    }
}
