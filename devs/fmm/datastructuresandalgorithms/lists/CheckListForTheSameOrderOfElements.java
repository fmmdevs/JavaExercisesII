package devs.fmm.datastructuresandalgorithms.lists;

import java.util.ArrayList;
import java.util.List;

public class CheckListForTheSameOrderOfElements {
    static boolean isSameCircle(List<String> names1, List<String> names2) {
        System.out.println(names1);
        System.out.println(names2);
        if (names1.size() != names2.size()) {
            System.out.println("different number of names");
            return false;
        }

        // 0. All names in both?
        for (int i = 0; i < names1.size(); i++) {
            if (names2.indexOf(names1.get(i)) == -1) {
                System.out.println(names1.get(i) + " from names1 not in names2");
                return false;
            }

        }

        int name1Index = 0;
        int name2Index = 0;
        // 1. find one name that doesn't repeat in both lists
        for (int i = 0; i < names1.size(); i++) {
            if (names2.indexOf(names1.get(i)) == names2.lastIndexOf(names1.get(i))) {
                System.out.println(names1.get(i) + " is in the circle only one time each");
                name1Index = names1.indexOf(names1.get(i));
                name2Index = names2.indexOf(names1.get(i));
                break;
            }
        }

        // iterate over the 2 lists
        for (int i = 0; i < names1.size(); i++) {
            if (name1Index < names1.size()-1) {
                // if we are not in the last position we add one
                name1Index++;
            } else {
                // if we are in the last position we go to the position 0
                // (we are only doing a number of iterations equals to the size of the lists thanks to the for loop)
                name1Index = 0;
            }

            if (name2Index < names2.size()-1) {
                name2Index++;
            } else {
                name2Index = 0;
            }

            System.out.printf("%s equals %s ? %b.%n",names1.get(name1Index),names2.get(name2Index),names1.get(name1Index).equals(names2.get(name2Index)));
            if (!names1.get(name1Index).equals(names2.get(name2Index))) return false;


        }

        return true;
    }

    public static void main(String[] args) {
        List<String> names1 = new ArrayList<>();
        names1.add("Conchi");
        names1.add("Alex");
        names1.add("Juan");
        names1.add("Fran");
        names1.add("Nuria");
        names1.add("Juana");
        names1.add("Conchi");
        names1.add("Conchi");

        List<String> names2 = new ArrayList<>();
        names2.add("Conchi");
        names2.add("Conchi");
        names2.add("Alex");
        names2.add("Juan");
        names2.add("Fran");
        names2.add("Nuria");
        names2.add("Juana");
        names2.add("Conchi");

        List<String> names3 = new ArrayList<>();
        names3.add("Fran");
        names3.add("Nuria");
        names3.add("Juana");
        names3.add("Conchi");
        names3.add("Conchi");
        names3.add("Conchi");
        names3.add("Juan");
        names3.add("Alex");

        isSameCircle(names1, names2);

        System.out.println("-----");

        isSameCircle(names1, names3);
        System.out.println("-----");

        isSameCircle(names2, names3);

    }
}
