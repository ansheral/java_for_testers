package ru.stqa.geometry.figures;

public class Square {
    public static void printSquareArea(double side){
        System.out.println("Площадь квадрата со стороной " + side + " равняется " + area(side));
    }

    public static double area(double a) {
        return a * a;
    }

    public static double perimeter(double a) {
        return 4 * a;
    }
}
