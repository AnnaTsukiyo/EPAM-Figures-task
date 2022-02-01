package com.epam.rd.autotasks.figures;

class Triangle extends Figure {

    Point a;
    Point b;
    Point c;

    public Triangle(Point a, Point b, Point c) throws IllegalArgumentException {
        if ((length1(a, b) >= length2(a, c) + length3(c, b)) || (length2(a, c) >= (length1(a, b) + length3(c, b))) || (length3(c, b)) >= length2(a, c) + (length1(a, b))) {
            throw new IllegalArgumentException();
        } else {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    double length1(Point a, Point b) {
        double xDistanceSquare = Math.pow(a.getX() - b.getX(), 2);
        double yDistanceSquare = Math.pow(a.getY() - b.getY(), 2);
        return Math.sqrt(xDistanceSquare + yDistanceSquare);
    }

    double length2(Point a, Point c) {
        double xDistanceSquare = Math.pow(a.getX() - c.getX(), 2);
        double yDistanceSquare = Math.pow(a.getY() - c.getY(), 2);
        return Math.sqrt(xDistanceSquare + yDistanceSquare);
    }

    double length3(Point c, Point b) {
        double xDistanceSquare = Math.pow(c.getX() - b.getX(), 2);
        double yDistanceSquare = Math.pow(c.getY() - b.getY(), 2);
        return Math.sqrt(xDistanceSquare + yDistanceSquare);
    }

    @Override
    public double area() {
        return Math.abs((b.getX() - a.getX()) * (c.getY() - a.getY()) - (c.getX() - a.getX()) * (b.getY() - a.getY())) / 2;
    }


    public String pointsToString() {
        return "(" + a.getX() + "," + a.getY() + ")" + "(" + b.getX() + "," + b.getY() + ")" + "(" + c.getX() + "," + c.getY() + ")";

    }

    @Override
    public String toString() {
        return Triangle.this + "[" + pointsToString() + "]";
    }

    @Override
    public Point leftmostPoint() {
        if ((a.getX() < b.getX()) && (a.getX()) < (c.getX())) {
            return this.a;
        }
        if ((b.getX() < a.getX()) && (b.getX() < c.getX())) {
            return this.b;
        } else {
            return this.c;
        }
    }
}

