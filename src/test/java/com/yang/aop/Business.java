package com.yang.aop;

/**
 * ҵ����,��Ҫ�������
 * ��������ࣿ��
 */
public class Business implements IBusiness,IBusiness2{
    private String name;

    public Business() {
    }

    public Business(String name) {
        this.name = name;
    }

    @Override
    public boolean doSomeThing() {
        System.out.println("ִ��ҵ���߼�1");
        return  true;
    }

    @Override
    public boolean doSomeThing2() {
        System.out.println("ִ��ҵ���߼�2");
        return  true;
    }

    @Override
    public void test() {
        System.out.println("test");
    }
}
