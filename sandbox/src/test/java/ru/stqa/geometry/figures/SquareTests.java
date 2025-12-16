package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SquareTests {
    @Test
    void canCalculateArea() {
        var s = new Square(5.0);
        double result = s.area();
        Assertions.assertEquals(25.0, result);
    }
    @Test
    void canCalculatePerimeter() {
        Assertions.assertEquals(20.0, new Square(5.0).perimeter());
    }
    @Test
    void testEquality(){
        var s0 = new Square(5.0);
        var s1 = new Square(5.0);
        Assertions.assertEquals(s0, s1);
    }
    @Test
    void testPass() {
        var s2 = new Square(5.0);
        var s3 = new Square(5.0);
        Assertions.assertTrue(s2.equals(s3));
    }
}
