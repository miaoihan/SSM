package com.zh.spring;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

/**
 * @author han
 * @date 16-5-22.
 */
public class Main {

    public static void main(String[] args) {
        Resource resource = new FileSystemResource("testSpring/helloWorld.xml");
        BeanFactory beanFactory = new XmlBeanFactory(resource);
        Person p1 = (Person)beanFactory.getBean("person");
        p1.sayHello();

//        ApplicationContext context =
//                new AnnotationConfigApplicationContext(Main.class);
//        Person printer = context.getBean(Person.class);
    }
}
