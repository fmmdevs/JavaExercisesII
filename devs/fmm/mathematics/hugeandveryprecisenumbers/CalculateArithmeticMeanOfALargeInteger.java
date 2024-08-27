package devs.fmm.mathematics.hugeandveryprecisenumbers;

import java.math.BigInteger;

public class CalculateArithmeticMeanOfALargeInteger {
    public static void main(String[] args) {
        long long1 = Long.MAX_VALUE - 199;
        long long2 = Long.MAX_VALUE - 435;

        BigInteger sum = BigInteger.valueOf(long1).add(BigInteger.valueOf(long2));


        long arithmeticMean = sum.divide(BigInteger.TWO).longValue();

        System.out.printf("%d+%d = %d%n", long1, long2, sum);
        System.out.printf("%d/2 = %d", sum, arithmeticMean);

    }
}
