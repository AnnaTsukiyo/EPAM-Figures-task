package com.epam.rd.autotasks.figures;

class Quadrilateral extends Figure {
    Point a;
    Point b;
    Point c;
    Point d;
    private boolean isP4Inside;    // true - НЕвыпуклый . false - выпуклый private boolean  isP4Inside ;    // true - НЕвыпуклый . false - выпуклый

    public Quadrilateral(Point a, Point b, Point c, Point d) {
        calcIsPointInside(a, b, c, d);

        if (!isP4Inside) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        } else {
            throw new IllegalArgumentException("Quadrilateral is non-convex");
        }
    }

    public boolean getIsP4Inside() {
        return isP4Inside;
    }

    @Override
    public double area() {
        Point[] points = {a, b, c, d};
        double sum = 0.0;
        for (int i = 0; i < points.length - 1; ++i) {
            sum += (points[i].getX() * points[i + 1].getY()) - (points[i + 1].getX() * points[i].getY());
        }
        return Math.abs(sum / 2);
    }

    private void calcIsPointInside(Point a, Point b, Point c, Point d) {  // считаем внутри ли тр-ка p1-p2-p3 точка p4

        Triangle tr;
        Double s1, s2, s3, s4, delta;

        tr = new Triangle(a, b, c);
        s1 = tr.area();

        tr = new Triangle(a, b, d);
        s2 = tr.area();
        tr = new Triangle(a, c, d);
        s3 = tr.area();
        tr = new Triangle(b, c, d);
        s4 = tr.area();

        delta = 1.0E-10;   // нужно учитывать погрешность вычисления
        isP4Inside = Math.abs(s1 - (s2 + s3 + s4)) < delta;
    }

    public String pointsToString() {
        return "(" + a.getX() + "," + a.getY() + ")" + "(" + b.getX() + "," + b.getY() + ")" + "(" + d.getX() + "," + d.getY() + ")";
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[" + pointsToString() + "]";
    }

    @Override
    public Point leftmostPoint() {
        Point mostUpperLeft = null;
        Point[] points = {a, b, c, d};
        for (Point point : points) {
            if (mostUpperLeft == null) {
                mostUpperLeft = point;
            } else {
                double diffX = mostUpperLeft.getX() - point.getX();
                double diffY = point.getY() - mostUpperLeft.getY();
                if (diffX + diffY > 0) {
                    mostUpperLeft = point;
                }
            }
        }
        return mostUpperLeft;
    }
}
