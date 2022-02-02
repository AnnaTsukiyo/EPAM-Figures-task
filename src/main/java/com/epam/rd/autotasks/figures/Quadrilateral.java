package com.epam.rd.autotasks.figures;

class Quadrilateral extends Figure {

    Point a;
    Point b;
    Point c;
    Point d;
    private boolean isP4Inside;    // true - НЕвыпуклый . false - выпуклый private boolean  isP4Inside ;    // true - НЕвыпуклый . false - выпуклый

    public Quadrilateral(Point a, Point b, Point c, Point d) {
        if (a == null || b == null || c == null || d == null) {
            throw new IllegalArgumentException();
        }

        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public double area() {
        boolean areaIs;
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
        areaIs = Math.abs(s1 - (s2 + s3 + s4)) < delta;

        if (!areaIs) {// НЕвыпуклый
            return s1 + s3;
        } else {             // выпуклый
            return s2 + s4;
        }
    }

    public Point centroid() {
        Point gA = new Triangle(b, c, d).centroidTriangle();
        Point gB = new Triangle(a, c, d).centroidTriangle();
        Point gC = new Triangle(a, b, b).centroidTriangle();
        Point gD = new Triangle(a, b, c).centroidTriangle();
        return findIntersection(gA, gC, gB, gD);
    }

    public static Point findIntersection(Point l1s, Point l1e, Point l2s, Point l2e) {

        double a1 = l1e.getY() - l1s.getY();
        double b1 = l1s.getX() - l1e.getX();
        double c1 = a1 * l1s.getX() + b1 * l1s.getY();

        double a2 = l2e.getY() - l2s.getY();
        double b2 = l2s.getX() - l2e.getX();
        double c2 = a2 * l2s.getX() + b2 * l2s.getY();

        double delta = a1 * b2 - a2 * b1;
        if (delta == 0) {
            return null;
        }
        return new Point((b2 * c1 - b1 * c2) / delta, (a1 * c2 - a2 * c1) / delta);
    }

    public String pointsToString() {
        return "(" + a.getX() + "," + a.getY() + ")" + "(" + b.getX() + "," + b.getY() + ")" + "(" + c.getX() + "," + c.getY() + ")" + "(" + d.getX() + "," + d.getY() + ")";
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[" + pointsToString() + "]";
    }

    @Override
    public Point leftmostPoint() {
        Point mostUpperLeft = null;
        Point[] points = {a, b, c, d};
        int leftmost = 0;
        for (Point point : points) {
            for (int i = 1; i < points.length; i++) {
                points[i] = point;
                if (points[i].getX() < points[leftmost].getX()) {
                    leftmost = i;
                    mostUpperLeft = points[i];
                }
            }
        }
        return mostUpperLeft;
    }
}



