package devs.fmm.mathematics.rounding;

public class CheckIfTinTinCheatedOnRounding {
    enum RoundingMode {
        CAST, ROUND, FLOOR, CEIL, RINT, UNKNOWN;
    }

    static RoundingMode detectRoundingMode(double[] numbers, int sum) {

        // Sometimes more than one rounding mode give the same result, in that case we return only one.
        if (sum == sumWithRounding(numbers, RoundingMode.CAST)) return RoundingMode.CAST;
        if (sum == sumWithRounding(numbers, RoundingMode.ROUND)) return RoundingMode.ROUND;
        if (sum == sumWithRounding(numbers, RoundingMode.FLOOR)) return RoundingMode.FLOOR;
        if (sum == sumWithRounding(numbers, RoundingMode.CEIL)) return RoundingMode.CEIL;
        if (sum == sumWithRounding(numbers, RoundingMode.RINT)) return RoundingMode.RINT;
        return RoundingMode.UNKNOWN;

    }

    static int sumWithRounding(double[] numbers, RoundingMode roundingMode) {


        int sum = 0;

        switch (roundingMode) {
            case CAST -> {
                for (double number : numbers) sum += (int) number;
            }
            case ROUND -> {
                for (double number : numbers) sum += Math.round(number);
            }
            case FLOOR -> {
                for (double number : numbers) sum += Math.floor(number);
            }
            case CEIL -> {
                for (double number : numbers) sum += Math.ceil(number);
            }
            case RINT -> {
                for (double number : numbers) sum += Math.rint(number);
            }
            default -> {
                // if rounding is unknown
                return -1;
            }
        }
        //System.out.printf("%n%s%n rounding by %s is %d%n", Arrays.toString(numbers), roundingMode, sum);
        return sum;
    }

    public static void main(String[] args) {

        double[] array1 = {41.55, 86.01, 82.21, 39.88, 79.09, 5.96, 71.01, 93.41, 99.97, 21.80, 58.27, 69.79, 49.85, 91.12, 98.48};
        double[] array2 = {33.90, 10.39, 54.79, 4.06, 6.96, 58.73, 2.64, 85.68, 9.37, 27.50, 11.42, 81.34, 65.62, 51.39, 40.38};
        double[] array3 = {34.95, 20.82, 5.64, 56.13, 16.85, 12.66, 43.61, 6.29, 74.18, 79.78, 74.52, 26.39, 35.50, 83.96, 97.21};
        double[] array4 = {98.60, 9.96, 69.80, 9.12, 10.91, 83.14, 42.53, 34.16, 48.92, 12.29, 98.00, 16.06, 2.92, 5.12, 89.47};
        double[] array5 = {77.80, 1.28, 89.25, 66.37, 7.44, 42.69, 50.98, 37.34, 11.26, 80.96, 47.39, 50.99, 49.06, 5.72, 78.58};

        int sumCast1 = sumWithRounding(array1, RoundingMode.CAST);
        int sumRound1 = sumWithRounding(array1, RoundingMode.ROUND);
        int sumFloor1 = sumWithRounding(array1, RoundingMode.FLOOR);
        int sumCeil1 = sumWithRounding(array1, RoundingMode.CEIL);
        int sumRint1 = sumWithRounding(array1, RoundingMode.RINT);

        int sumCast2 = sumWithRounding(array2, RoundingMode.CAST);
        int sumRound2 = sumWithRounding(array2, RoundingMode.ROUND);
        int sumFloor2 = sumWithRounding(array2, RoundingMode.FLOOR);
        int sumCeil2 = sumWithRounding(array2, RoundingMode.CEIL);
        int sumRint2 = sumWithRounding(array2, RoundingMode.RINT);

        int sumCast3 = sumWithRounding(array3, RoundingMode.CAST);
        int sumRound3 = sumWithRounding(array3, RoundingMode.ROUND);
        int sumFloor3 = sumWithRounding(array3, RoundingMode.FLOOR);
        int sumCeil3 = sumWithRounding(array3, RoundingMode.CEIL);
        int sumRint3 = sumWithRounding(array3, RoundingMode.RINT);

        int sumCast4 = sumWithRounding(array4, RoundingMode.CAST);
        int sumRound4 = sumWithRounding(array4, RoundingMode.ROUND);
        int sumFloor4 = sumWithRounding(array4, RoundingMode.FLOOR);
        int sumCeil4 = sumWithRounding(array4, RoundingMode.CEIL);
        int sumRint4 = sumWithRounding(array4, RoundingMode.RINT);

        int sumCast5 = sumWithRounding(array5, RoundingMode.CAST);
        int sumRound5 = sumWithRounding(array5, RoundingMode.ROUND);
        int sumFloor5 = sumWithRounding(array5, RoundingMode.FLOOR);
        int sumCeil5 = sumWithRounding(array5, RoundingMode.CEIL);
        int sumRint5 = sumWithRounding(array5, RoundingMode.RINT);

        double[] numbers = {199.99};
        System.out.println();
        System.out.println(detectRoundingMode(numbers,200));
        System.out.println(detectRoundingMode(numbers,199));

    }
}
