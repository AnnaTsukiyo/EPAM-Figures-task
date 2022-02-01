package com.epam.rd.autotasks.figures;

class Quadrilateral extends Figure {

    Point a;
    Point b;
    Point c;
    Point d;
    private boolean isP4Inside;

    public Quadrilateral(Point a, Point b, Point c, Point d) {
        calcIsPointInside(a, b, c, d);

        if (!isP4Inside) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
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

        a1 = new Point(a.getX(), a.getY());
        a2 = new Point(b.getX(), b.getY());
        a3 = new Point(c.getX(), c.getY());
        a4 = new Point(d.getX(), d.getY());

        tr = new Triangle(a1, a2, a3);
        s1 = tr.area();

        tr = new Triangle(a1, a2, a4);
        s2 = tr.area();

        if (!isP4Inside) {
            return s1 + s2;
        } else {
            return s1 - s2;
        }
    }

    private void calcIsPointInside(Point a, Point b, Point c, Point d) {

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
        return Quadrilateral.this + "[" + pointsToString() + "]";
    }

    @Override
    public Point leftmostPoint() {
        if ((a.getX() < b.getX()) && (a.getX() < c.getX()) && (a.getX() < d.getX())) {
            return this.a;
        }
        if ((b.getX() < a.getX()) && (b.getX() < c.getX()) && (b.getX()) < d.getX()) {
            return this.b;
        }
        if ((c.getX() < a.getX()) && (c.getX() < b.getX()) && (c.getX() < d.getX())) {
            return this.c;
        } else {
            return this.d;
        }
    }
}
