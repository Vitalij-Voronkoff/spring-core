package com.vvoronkov.spring_core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.Locale;

@Component
public class Circle implements Shape, ApplicationEventPublisherAware {
    private Point point;
    @Autowired
    MessageSource messageSource;
    private ApplicationEventPublisher publisher;

    public Point getPoint() {
        return point;
    }

    //@Required
    /*@Autowired
    @Qualifier("circleRelated")*/
    @Resource(name = "pointC")
    public void setPoint(Point point) {
        this.point = point;
    }

    public void draw() {
        System.out.println(messageSource.getMessage("circle.draw", null, "Default circle message", Locale.ENGLISH) + point.toString());
        publisher.publishEvent(new DrawEvent(this));
    }

    @PostConstruct
    public void initializeCircle() {
        System.out.println("Circle initialized.");
    }

    @PreDestroy
    public void destroyCircle() {
        System.out.println("Circle destroyed.");
    }

    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }
}
