package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {
    @Test
    void canCalculateArea() {
        var t = new Triangle(5.0, 5.0, 5.0);
        double result = t.area();
        Assertions.assertEquals(10.825, result, 1e-3);
    }
    @Test
    void canCalculatePerimeter() {
        Assertions.assertEquals(15.0, new Triangle(5.0, 5.0, 5.0).perimeter());
    }

    @Test
    void cantBeNegative() {
        try {
            new Triangle(-4.0, 2.0, 3.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            //ok
        }
    }

    @Test
    void checkSum() {
        try {
            new Triangle(2, 10, 3);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            //ok
        }
    }
    @Test
    void testEqualityFirst() {
        var t1 = new Triangle(2.0,3.0,4.0);
        var t2 = new Triangle(2.0,3.0,4.0);
        Assertions.assertEquals(t1, t2);
    }
    @Test
    void testEqualitySecond() {
        var t3 = new Triangle(2.0,3.0,4.0);
        var t4 = new Triangle(4.0,2.0,3.0);
        Assertions.assertEquals(t3, t4);
    }
}