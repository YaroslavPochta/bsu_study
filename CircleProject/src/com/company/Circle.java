package com.company;

import java.awt.*;

public class Circle extends Figure implements Comparable<Circle> {
    private Point center;
    private double radius;

    public Circle( Point p1, Point p2 ) {
        super(p1, p2);
        center = centerCalc(p1, p2);
        radius = radiusCalc(p1, p2);
    }

    private double radiusCalc(Point p1, Point p2)
    {
        return (Math.abs(p1.x-p2.x)/2 < Math.abs(p1.y-p2.y)/2) ? Math.abs(p1.x-p2.x)/2 : Math.abs(p1.y-p2.y)/2;
    }

    private Point centerCalc(Point p1, Point p2)
    {
        int px;
        int py;
        px = p1.x + ((p1.x < p2.x) ? + Math.abs(p1.x-p2.x)/2 : - Math.abs(p1.x-p2.x)/2);
        py = p1.y + ((p1.y < p2.y) ? + Math.abs(p1.y-p2.y)/2 : - Math.abs(p1.y-p2.y)/2);
        return new Point(px, py);
    }

    @Override
    double square() {
        return 0;
    }

    @Override
    public int compareTo( Circle o ) {
        return 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Circle{");
        sb.append("center=").append(center);
        sb.append(", radius=").append(radius);
        sb.append('}');
        return sb.toString();
    }
}
