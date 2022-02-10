package com.epam.rd.autotasks.figures;

class Point {
    private double x;
    private double y;


    public Point(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public String toString() {
        return String.format("(%s,%s)", this.x, this.y);
    }

}

