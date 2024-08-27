package devs.fmm.mathematics.hugeandveryprecisenumbers;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.List;

public class Fraction extends Number implements Comparable<Fraction> {
    public final int numerator;
    public final int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) throw new ArithmeticException("Denominator can't be zero");
        /*if (numerator < 0 || denominator < 0)
            throw new IllegalArgumentException("Both numerator and denominator must be positive integers");*/

        // simplification
        BigInteger num = BigInteger.valueOf(Math.abs(numerator));
        BigInteger den = BigInteger.valueOf(Math.abs(denominator));
        BigInteger gcd = num.gcd(den);

        this.numerator = num.divide(gcd).intValue();
        this.denominator = den.divide(gcd).intValue();
    }

    public Fraction(int value) {
        this.numerator = Math.abs(value);
        this.denominator = 1;
    }

    static Fraction multiply(Fraction fraction1, Fraction fraction2) {
        if (BigInteger.valueOf((long) fraction1.numerator * fraction2.numerator).longValue() > Integer.MAX_VALUE &&
                BigInteger.valueOf((long) fraction1.denominator * fraction2.denominator).longValue() > Integer.MAX_VALUE) {

            System.err.println("Overflow in both numerator and denominator");
            return new Fraction(1);
        }

        if (BigInteger.valueOf((long) fraction1.numerator * fraction2.numerator).longValue() > Integer.MAX_VALUE) {

            System.err.println("Overflow in numerator");
            return new Fraction(1);
        }
        if (BigInteger.valueOf((long) fraction1.denominator * fraction2.denominator).longValue() > Integer.MAX_VALUE) {

            System.err.println("Overflow in denominator");
            return new Fraction(1);
        }
        return new Fraction(fraction1.numerator * fraction2.numerator, fraction1.denominator * fraction2.denominator);
    }

    static Fraction reciprocal(Fraction fraction) {
        return new Fraction(fraction.denominator, fraction.numerator);
    }

    static Fraction division(Fraction fraction1, Fraction fraction2) {

        return Fraction.multiply(fraction1, reciprocal(fraction2));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        return numerator == fraction.numerator && denominator == fraction.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

    @Override
    public String toString() {
        return "%d/%d".formatted(numerator, denominator);
    }

    @Override
    public int intValue() {
        return (int) Math.round((double) numerator / denominator);
    }

    @Override
    public long longValue() {
        return Math.round((double) numerator / denominator);
    }

    @Override
    public float floatValue() {
        return (float) numerator / denominator;
    }

    @Override
    public double doubleValue() {
        return (double) numerator / denominator;
    }

    @Override
    public int compareTo(Fraction o) {
        return Double.compare(this.doubleValue(), o.doubleValue());
    }

    public static void main(String[] args) {

        System.out.println(new Fraction(100, 20));

        Fraction fraction1 = new Fraction(1134233482, 723422343);
        Fraction fraction2 = new Fraction(11, 79);

        //System.out.println(Fraction.multiply(fraction2, fraction1));

        // Crear 15 objetos Fraction
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(2, 3);
        Fraction f3 = new Fraction(3, 4);
        Fraction f4 = new Fraction(4, 5);
        Fraction f5 = new Fraction(5, 6);
        Fraction f6 = new Fraction(6, 7);
        Fraction f7 = new Fraction(7, 8);
        Fraction f8 = new Fraction(8, 9);
        Fraction f9 = new Fraction(9, 10);
        Fraction f10 = new Fraction(10, 11);
        Fraction f11 = new Fraction(11, 12);
        Fraction f12 = new Fraction(12, 13);
        Fraction f13 = new Fraction(13, 14);
        Fraction f14 = new Fraction(14, 15);
        Fraction f15 = new Fraction(15, 16);

        // Crear un ArrayList y añadir las fracciones
        List<Fraction> fractionList = new ArrayList<>();

        fractionList.add(f9);
        fractionList.add(f10);
        fractionList.add(f11);
        fractionList.add(f12);
        fractionList.add(f13);
        fractionList.add(f1);
        fractionList.add(f2);
        fractionList.add(f3);
        fractionList.add(f4);
        fractionList.add(f5);
        fractionList.add(f6);
        fractionList.add(f7);
        fractionList.add(f8);
        fractionList.add(f14);
        fractionList.add(f15);

        System.out.println(fractionList);

        //fractionList.sort(Fraction::compareTo);
        Collections.sort(fractionList.reversed());
        System.out.println(fractionList);

        System.out.println(Fraction.multiply(fractionList.get(0),fractionList.get(1)));
        System.out.println(Fraction.division(fractionList.get(0),fractionList.get(1)));
        System.out.println(fractionList.get(3).doubleValue());
    }
}
