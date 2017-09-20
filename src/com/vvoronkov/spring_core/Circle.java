package com.vvoronkov.spring_core;

public class Circle implements Shape {
    private Point point;

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public void draw() {
        System.out.println("Circle point is " + point.toString());
    }
}
