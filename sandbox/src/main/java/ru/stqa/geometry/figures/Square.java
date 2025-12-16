package ru.stqa.geometry.figures;

public record Square (double side) {

    public static void printSquareArea(Square s){
        System.out.println("Площадь квадрата со стороной " + s.side + " равняется " + s.area());
    }

    public double area() {
        return this.side * this.side;
    }

    public double perimeter() {
        return this.side * 4;
    }
}
