package devs.fmm.mathematics.hugeandveryprecisenumbers;

import java.math.BigInteger;

public class NumberByNumberOverThePhone {
    static BigInteger completeNumber(int... parts) {

        StringBuilder completeNumberString = new StringBuilder();

        for (int part : parts) {
            completeNumberString.append(part);
        }

        return new BigInteger(completeNumberString.toString());
    }

    public static void main(String[] args) {

        System.out.println(completeNumber(123,22,989,77,9));
    }
}
