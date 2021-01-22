package com.company;

import java.awt.*;

abstract class Figure{
    private Point p1;
    private Point p2;

    public Figure() {
    }

    public Figure( Point p1, Point p2 ) {
        this.p1 = p1;
        this.p2 = p2;
    }

    abstract double square();
}
