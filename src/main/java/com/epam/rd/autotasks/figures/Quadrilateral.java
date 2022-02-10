package com.epam.rd.autotasks.figures;

class Quadrilateral extends Figure {
    private Point point1;
    private Point point2;
    private Point point3;
    private Point point4;

    public Quadrilateral(Point point1, Point point2, Point point3, Point point4) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        this.point4 = point4;
    }

    public double area() {
        double operation1 = this.point1.getX() * this.point2.getY() - this.point1.getY() * this.point2.getX();
        double operation2 = this.point2.getX() * this.point3.getY() - this.point2.getY() * this.point3.getX();
        double operation3 = this.point3.getX() * this.point4.getY() - this.point3.getY() * this.point4.getX();
        double operation4 = this.point4.getX() * this.point1.getY() - this.point4.getY() * this.point1.getX();
        return Math.abs((operation1 + operation2 + operation3 + operation4) / 2.0D);
    }

    public String pointsToString() {
        return String.format("%s%s%s%s", this.point1, this.point2, this.point3, this.point4);
    }

    public Point leftmostPoint() {
        double minX = Math.min(this.point1.getX(), Math.min(this.point2.getX(), Math.min(this.point3.getX(), this.point4.getX())));
        if (this.point1.getX() == minX) {
            return this.point1;
        } else if (this.point2.getX() == minX) {
            return this.point2;
        } else {
            return this.point3.getX() == minX ? this.point3 : this.point4;
        }
    }
}