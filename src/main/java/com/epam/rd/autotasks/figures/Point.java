package com.epam.rd.autotasks.figures;

class Point {
    private double x;
    private double y;
    private Point neighbor;

    public Point(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    public Point(double x, double y, Point neighbor) {
        this.x = x;
        this.y = y;
        this.neighbor = neighbor;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setNeighbor(Point neighbor) {
        this.neighbor = neighbor;
    }

    //
    public double calcSide() {  // вычисляем длину отрезка от этой точки до "neighbor"
        double l;
        if (neighbor != null) {  // испольсуем теорему Пифагора
            l = Math.sqrt(Math.pow(neighbor.x - x, 2) + Math.pow(neighbor.y - y, 2));
        } else
            l = 0;
        return l;
    }

}

