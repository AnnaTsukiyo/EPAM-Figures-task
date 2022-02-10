package com.epam.rd.autotasks.figures;

abstract class Figure {
    Figure() {
    }

    public abstract double area();

    public abstract String pointsToString();

    public abstract Point leftmostPoint();

    public String toString() {
        String var10000 = this.getClass().getSimpleName();
        return var10000 + "[" + this.pointsToString() + "]";
    }
}
