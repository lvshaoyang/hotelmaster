package com.yang.test;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HibernateConnectTest {
    @Test
    public void testHibernateConnection(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        SessionFactory sf = (SessionFactory) context.getBean("sessionFactoryessionFactory");
        System.out.println(sf);
    }
}
