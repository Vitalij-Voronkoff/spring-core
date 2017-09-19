package com.vvoronkov.spring_core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Triangle triangle = context.getBean("triangle", Triangle.class);
        triangle.draw();
        triangle.getPointA().setX(15);
        triangle.getPointA().setY(25);
        triangle.draw();
        Triangle newtriangle = context.getBean("triangle", Triangle.class);
        newtriangle.draw();
    }
}
