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
            near_far_points(a, b, c, d);
        } else {
            System.out.println("Quadrilateral is non-convex");
        }
    }

    public boolean getIsP4Inside() {
        return isP4Inside;
    }

    @Override
    public double area() {

        Point a1, a2, a3, a4;
        double s1, s2;
        Triangle tr;

        a1 = new Point(a.getX(), a.getY());   // p_near_1
        a2 = new Point(b.getX(), b.getY());   // p_near_2
        a3 = new Point(c.getX(), c.getY());         // p_far
        a4 = new Point(d.getX(), d.getY());

        tr = new Triangle(a1, a2, a3);
        s1 = tr.area();

        tr = new Triangle(a1, a2, a4);
        s2 = tr.area();

        if (!isP4Inside) {// НЕвыпуклый
            return s1 + s2;
        } else {             // выпуклый
            return s1 - s2;
        }
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

    private void near_far_points(Point p1, Point p2, Point p3, Point p4) { //
        double l_max;
        p4.setNeighbor(p1);
        l_max = p4.calcSide();
        c = p1;
        a = p2;
        b = p3;
        p4.setNeighbor(p2);
        if (p4.calcSide() > l_max) ;
        {
            l_max = p4.calcSide();
            c = p2;
            a = p1;
            b = p3;
        }
        p4.setNeighbor(p3);
        if (p4.calcSide() > l_max) ;
        {
            c = p3;
            a = p1;
            b = p2;
        }
        a.setNeighbor(c);
        c.setNeighbor(b);
        b.setNeighbor(d);
        d.setNeighbor(a);
    }

    public String pointsToString() {
        return "(" + a.getX() + "," + a.getY() + ")" + "(" + b.getX() + "," + b.getY() + ")" + "("
                + c.getX() + "," + c.getY() + ")" + "(" + d.getX() + "," + d.getY() + ")";
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[" + pointsToString() + "]";
    }

    @Override
    public Point leftmostPoint() {
        Point[] points = {a, b, c, d};
        Point corner = null;
        Integer d = null;
        for (Point point : points) {
            Integer diff = point.y - point.x;
            if (d == null || (diff) > d) {
                corner = point;
                d = diff;
            }
        }
        return corner;
    }
}
