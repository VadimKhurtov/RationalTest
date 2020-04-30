

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


import static org.junit.Assert.*;

public class Tests {
    @Test
    public void testStandardConstructor() {
        Rational standard = new Rational();
        assertEquals("Standard constructor returns wrong numerator", 0, standard.getNumerator());
        assertEquals("Standard constructor returns wrong denominator", 1, standard.getDenominator());
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
    @Test
    public void testDivisionByZero() {
        exceptionRule.expect(ArithmeticException.class);
        exceptionRule.expectMessage("division by zero !");
        Rational divByZero = new Rational(3, 0);
    }

    @Test
    public void testGetNumerator() {
        Rational testGet = new Rational(0, 7);
        assertEquals("getNumerator returns wrong numerator", 0, testGet.getNumerator());
    }

    @Test
    public void testGetDenominator() {
        Rational testGet = new Rational(-2, 7);
        assertEquals("getDenominator returns wrong denominator", 7, testGet.getDenominator());
    }

    @Test
    public void testSetDenominator(){
        Rational testSet = new Rational(5,7);
        testSet.setDenominator(10);
        assertEquals("Returns wrong denominator after set",2, testSet.getDenominator());
    }

    @Test
    public void testSetNumerator(){
        Rational testSet = new Rational(3,10);
        testSet.setNumerator(5);
        assertEquals("Returns wrong numerator after set",1, testSet.getNumerator());
    }

    @Test
    public void testToString(){
        Rational toStr = new Rational(3, 7);
        assertEquals("testToString returns wrong response", "3/7", toStr.toString());
    }

    @Test
    public void testEqualsNull() {
        Rational testEq = new Rational(3, 7);
        assertFalse(testEq.equals(null));
    }

    @Test
    public void testEqualsAnotherClass() {
        Rational testEq = new Rational(3,7);
        String string = "string";
        assertFalse(testEq.equals(string));
    }

    @Test
    public void testEqualsNumerator() {
        Rational obj1 = new Rational(2, 5);
        Rational obj2 = new Rational(2, 7);
        assertFalse(obj1.equals(obj2));
    }

    @Test
    public void testEqualsDenominator() {
        Rational obj1 = new Rational(3, 5);
        Rational obj2 = new Rational(2, 5);
        assertFalse(obj1.equals(obj2));
    }

    @Test
    public void testEquals() {
        Rational obj1 = new Rational(2, 10);
        Rational obj2 = new Rational(2, 10);
        assertTrue(obj1.equals(obj2));
    }

    @Test
    public void testLessDenominatorsAreEqualTrue() {
        Rational rational1 = new Rational(1, 9);
        Rational rational2 = new Rational(5, 9);
        assertTrue("Wrong numerators comparison", rational1.less(rational2));
    }

    @Test
    public void testLessDenominatorsAreEqualFalse() {
        Rational rational1 = new Rational(1, 9);
        Rational rational2 = new Rational(5, 9);
        assertFalse("Wrong numerators comparison", rational2.less(rational1));
    }

    @Test
    public void testLessNumeratorsAreEqualTrue() {
        Rational rational1 = new Rational(5, 11);
        Rational rational2 = new Rational(5, 9);
        assertTrue("Wrong denominators comparison", rational1.less(rational2));
    }

    @Test
    public void testLessNumeratorsAreEqualFalse() {
        Rational rational1 = new Rational(5, 11);
        Rational rational2 = new Rational(5, 9);
        assertFalse("Wrong denominators comparison", rational2.less(rational1));
    }

    @Test
    public void testLessElseTrue() {
        Rational rational1 = new Rational(1, 2);
        Rational rational2 = new Rational(3, 4);
        assertTrue(rational1.less(rational2));
    }

    @Test
    public void testLessElseFalse() {
        Rational rational1 = new Rational(3, 11);
        Rational rational2 = new Rational(5, 9);
        assertFalse(rational2.less(rational1));
    }

    @Test
    public void testPlus() {
        Rational rational1 = new Rational(-1, 3);
        Rational rational2 = new Rational(2, 5);
        Rational result = rational1.plus(rational2);
        assertEquals(1, result.getNumerator());
        assertEquals(15, result.getDenominator());
    }

    @Test
    public void testMultiply() {
        Rational rational1 = new Rational(2, 5);
        Rational rational2 = new Rational(3, 4);
        Rational result = rational1.multiply(rational2);
        assertEquals(3, result.getNumerator());
        assertEquals(10, result.getDenominator());
    }

    @Test
    public void testSimplifyMinuses() {
        Rational rational = new Rational(2, -3);
        assertEquals(-2, rational.getNumerator());
        assertEquals(3, rational.getDenominator());
    }

    @Test
    public void testMinus() {
        Rational rational1 = new Rational(3,5);
        Rational rational2 = new Rational(1,6);
        Rational result = rational1.minus(rational2);
        assertEquals(13, result.getNumerator());
        assertEquals(30, result.getDenominator());
    }

    @Test
    public void testDivideNumeratorIsZero() {
        Rational rational1 = new Rational(2, 5);
        Rational rational2 = new Rational(0, 3);
        exceptionRule.expect(ArithmeticException.class);
        exceptionRule.expectMessage("division by zero !");
        rational1.divide(rational2);
    }

    @Test
    public void testDivide() {
        Rational rational1 = new Rational(2, 5);
        Rational rational2 = new Rational(4, 7);
        Rational result = rational1.divide(rational2);
        assertEquals(7, result.getNumerator());
        assertEquals(10, result.getDenominator());
    }

    @Test
    public void testBoundaries() {
        Rational rational = new Rational(Integer.MAX_VALUE + 1, Integer.MIN_VALUE - 1);
        assertEquals(-2147483648, rational.getNumerator());
        assertEquals(2147483647, rational.getDenominator());
    }
}