package com.epam.rd.autotasks.figures;

class Circle extends Figure {
    static final double PI = Math.PI;
    Point centr;
    double radius;

    public Circle(Point centr, double radius) {
        if (centr == null) {
            throw new IllegalArgumentException();
        }
            this.centr = centr;
            this.radius = radius;
        if (radius<=0){
            throw new IllegalArgumentException();
    }
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(radius,2);
    }

    @Override
    public String pointsToString() {
        return "(" + centr.getX() + "," + centr.getY() + ")";
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[" + pointsToString() + "," + radius + "]";
    }

    @Override
    public Point leftmostPoint() {
        return new Point(centr.getX() - radius, centr.getY());
    }
}

