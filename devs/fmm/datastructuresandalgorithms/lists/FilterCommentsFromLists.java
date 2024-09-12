package devs.fmm.datastructuresandalgorithms.lists;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterCommentsFromLists {
    static void reduceToComments(List<String> lines) {

        if (lines.size() == 0) return; // (For an empty list nothing happens)

        if (lines.size() < 4 || lines.size() % 4 != 0)
            throw new IllegalArgumentException("Illegal size %d of list, must be divisible by 4.%n".formatted(lines.size()));

        System.out.println(lines);

        int counter = 0;
        for (int i = lines.size() - 1; i >= 0; i -= 4) {
            counter++;
            lines.remove(lines.size() - 1 - counter);
            lines.remove(lines.size() - 1 - counter);
            lines.remove(lines.size() - 1 - counter);
        }
        System.out.println(lines);

    }

    public static void main(String[] args) {
        List<String> lines = new ArrayList<>();
        lines.add("A1");
        lines.add("A2");
        lines.add("A3");
        lines.add("A4");

        lines.add("B1");
        lines.add("B2");
        lines.add("B3");
        lines.add("B4");

        lines.add("C1");
        lines.add("C2");
        lines.add("C3");
        lines.add("C4");

        lines.add("D1");
        lines.add("D2");
        lines.add("D3");
        lines.add("D4");

        lines.add("E1");
        lines.add("E2");
        lines.add("E3");
        lines.add("E4");

        lines.add("F1");
        lines.add("F2");
        lines.add("F3");
        lines.add("F4");


        reduceToComments(lines);

        List<String> wrong = new ArrayList<>();
        wrong.add("One");
        reduceToComments(wrong);
        List<String> emptyList = new ArrayList<>();
        reduceToComments(emptyList);
    }
}
