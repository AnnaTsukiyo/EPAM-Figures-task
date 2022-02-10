package com.epam.rd.autotasks.figures;

class Triangle extends Figure {
    private final Point point1;
    private final Point point2;
    private final Point point3;

    public Triangle(Point point1, Point point2, Point point3) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    public double area() {
        double operand1 = (this.point1.getX() - this.point3.getX()) * (this.point2.getY() - this.point3.getY());
        double operand2 = (this.point2.getX() - this.point3.getX()) * (this.point1.getY() - this.point3.getY());
        return Math.abs(operand1 - operand2) / 2.0D;
    }

    public String pointsToString() {
        return String.format("%s%s%s", this.point1, this.point2, this.point3);
    }

    public Point leftmostPoint() {
        double minX = Math.min(this.point1.getX(), Math.min(this.point2.getX(), this.point3.getX()));
        if (this.point1.getX() == minX) {
            return this.point1;
        } else {
            return this.point2.getX() == minX ? this.point2 : this.point3;
        }
    }
}
