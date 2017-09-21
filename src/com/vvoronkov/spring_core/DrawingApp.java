package com.vvoronkov.spring_core;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

public class DrawingApp {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        context.registerShutdownHook();
        Shape shape = context.getBean("circle", Shape.class);
        shape.draw();
        System.out.println(context.getMessage("greeting", null, "Default greeting", Locale.ENGLISH));
    }
}
