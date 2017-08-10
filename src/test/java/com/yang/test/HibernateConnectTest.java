package com.yang.test;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HibernateConnectTest {
    @Test
    public void testHibernateConnection(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        SessionFactory sf = (SessionFactory) context.getBean("sessionFactoryessionFactory");
        System.out.println(sf);



    }

    @Test
    public void testRegix(){
        Pattern pattern = Pattern.compile("a c");
        Matcher m = pattern.matcher("abc");

        boolean fit = m.matches();

        System.out.println(m.find());
    }
}
