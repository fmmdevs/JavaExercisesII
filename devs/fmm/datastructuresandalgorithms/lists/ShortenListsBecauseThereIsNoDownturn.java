package devs.fmm.datastructuresandalgorithms.lists;

import java.util.ArrayList;
import java.util.List;

public class ShortenListsBecauseThereIsNoDownturn {
    static List<Double> trimNonGrowingNumbers(List<Double> numbers) {
        System.out.println("---------------------------------------");
        System.out.println(numbers);
        double decrecentMinor = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            if (decrecentMinor >= numbers.get(i)) {
                numbers.remove(i);
                i--;
            } else {
                decrecentMinor = numbers.get(i);
            }
        }

        return numbers;
    }

    public static void main(String[] args) {
        List<Double> numbers = new ArrayList<>();
        numbers.add(0.0);
        numbers.add(1.0);
        numbers.add(2.0);
        numbers.add(3.0);
        numbers.add(4.0);
        numbers.add(5.0);
        List<Double> numbers1 = new ArrayList<>();
        numbers1.add(0.0);
        numbers1.add(0.0);
        numbers1.add(2.0);
        numbers1.add(1.0);
        numbers1.add(4.0);
        numbers1.add(5.0);
        numbers1.add(5.0);
        numbers1.add(5.0);
        numbers1.add(-5.0);
        numbers1.add(5.0);
        numbers1.add(5.0);

        System.out.println(trimNonGrowingNumbers(numbers));

        System.out.println(trimNonGrowingNumbers(numbers1));
    }
}
