public class Geometry {
    public static void main(String[] args) {
        printSquareArea(7);
        printSquareArea(9);
        printRectangleArea(3.0, 5.0);
        printRectangleArea(5.0, 7.0);
     }

    private static void printRectangleArea(double a, double b) {
        System.out.println("Площадь прямоугольника со сторонами " + a + " и " + b + " равняется " + rectangleArea(a, b));
    }

    private static double rectangleArea(double a, double b) {
        return a * b;
    }

    static void printSquareArea(double side){
        System.out.println("Площадь квадрата со стороной " + side + " равняется " + squareArea(side));
    }

    private static double squareArea(double a) {
        return a * a;
    }
}

