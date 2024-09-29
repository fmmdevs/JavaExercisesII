package devs.fmm.datastructuresandalgorithms.sets;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

public class FormSubsetsFindCommonElements {
    public static void main(String[] args) {
        // Creating inmmutable sets with Set.of
        Set<String> hobbies1 = Set.of("Candy making", "Camping", "Billiards", "Fishkeeping", "Eating", "Action figures", "Birdwatching", "Axe throwing");
        Set<String> hobbies2 = Set.of("Axe throwing", "Candy making", "Camping", "Action figures", "Case modding", "Skiing", "Satellite watching");

        Iterator<String> itHobbies1 = hobbies1.iterator();
        Iterator<String> itHobbies2 = hobbies2.iterator();

        int biggerSize = hobbies1.size() > hobbies2.size() ? hobbies1.size() : hobbies2.size();

        int coincidences = 0;
        while (itHobbies1.hasNext()) {
            if (hobbies2.contains(itHobbies1.next())) coincidences++;
        }

        // size-----100
        // coincidences----x
        double percentage1 = coincidences * 100 / hobbies1.size();
        double percentage2 = coincidences * 100 / hobbies2.size();
        System.out.println("Percentage of similarity from 1 : " + percentage1 + "%");
        System.out.println("Percentage of similarity from 2 : " + percentage2 + "%");


    }
}
