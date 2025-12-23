package ru.stqa.geometry.figures;

import java.util.Objects;

public record Triangle(double a, double b, double c){

    public Triangle{
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Стороны треугольника должны быть положительными");
        }
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("Треугольник с такими сторонами не существует");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return (Double.compare(this.a, triangle.a) == 0 && Double.compare(this.b, triangle.b) == 0 && Double.compare(this.c, triangle.c) == 0)
                || (Double.compare(this.a, triangle.b) == 0 && Double.compare(this.b, triangle.c) == 0 && Double.compare(this.c, triangle.a) == 0)
                || (Double.compare(this.a, triangle.c) == 0 && Double.compare(this.b, triangle.a) == 0 && Double.compare(this.c, triangle.b) == 0)
                || (Double.compare(this.a, triangle.a) == 0 && Double.compare(this.b, triangle.c) == 0 && Double.compare(this.c, triangle.b) == 0)
                || (Double.compare(this.a, triangle.c) == 0 && Double.compare(this.b, triangle.b) == 0 && Double.compare(this.c, triangle.a) == 0)
                || (Double.compare(this.a, triangle.b) == 0 && Double.compare(this.b, triangle.a) == 0 && Double.compare(this.c, triangle.c) == 0)
                ;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    public static void printTrianglePerimeter(Triangle r) {
        var text = String.format("Периметр треугольника со сторонами %f, %f и %f равняется %f", r.a, r.b, r.c, r.perimeter());
        System.out.println(text);

    }

    public static void printTriangleArea(Triangle t) {
        var text = String.format("Площадь треугольника со сторонами %f, %f и %f равняется %f", t.a, t.b, t.c, t.area());
        System.out.println(text);
    }


    public double perimeter() {
        return this.a + this.b + this.c;
    }
    public double halfPerimeter(){
        return perimeter() / 2;
    }

     public double area() {
        double h = halfPerimeter();
        return Math.sqrt(h * (h - a) * (h - b) * (h - c));
    }
}

