package com.yang.aop;

/**
 * 业务类,需要代理的类
 * 被代理的类？？
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
        System.out.println("执行业务逻辑1");
        return  true;
    }

    @Override
    public boolean doSomeThing2() {
        System.out.println("执行业务逻辑2");
        return  true;
    }

    @Override
    public void test() {
        System.out.println("test");
    }
}
