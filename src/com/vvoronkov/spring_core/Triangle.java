package com.vvoronkov.spring_core;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle implements Shape, ApplicationContextAware, BeanNameAware, InitializingBean, DisposableBean {
    private Point pointA;
    private Point pointB;
    private Point pointC;
    private ApplicationContext applicationContext;

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }

    public Point getPointC() {
        return pointC;
    }

    public void setPointC(Point pointC) {
        this.pointC = pointC;
    }

    public void draw() {
        System.out.println("PonitA " + pointA.toString() + "PointB " + pointB.toString() + "PointC " + pointC.toString());

    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void setBeanName(String beanName) {
        System.out.println("Bean name is " + beanName);
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("Triangle bean was initialized");
    }

    public void destroy() throws Exception {
        System.out.println("Triangle bean was destroyed.");
    }

    public void myInit() {
        System.out.println("myInit() called.");
    }

    public void myDestroy() {
        System.out.println("myDestroy method called.");
    }
}
