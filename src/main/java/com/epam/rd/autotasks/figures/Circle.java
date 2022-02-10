package com.epam.rd.autotasks.figures;

class Circle extends Figure {
    private final Point point;
    private final double radius;

    public Circle(Point point, double radius) {
        this.point = point;
        this.radius = radius;
    }

    public double area() {
        return 3.141592653589793D * Math.pow(this.radius, 2.0D);
    }

    public String pointsToString() {
        return this.point.toString();
    }

    public Point leftmostPoint() {
        return new Point(this.point.getX() - this.radius, this.point.getY());
    }

    public String toString() {
        return String.format("Circle[%s%s]", this.pointsToString(), this.radius);
    }
}