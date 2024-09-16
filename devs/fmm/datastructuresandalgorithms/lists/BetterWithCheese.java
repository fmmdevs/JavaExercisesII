package devs.fmm.datastructuresandalgorithms.lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BetterWithCheese {
    static String[] vegetables = {"Carrot", "Potato", "Tomato", "Lettuce", "Cucumber",
            "Onion", "Broccoli", "Spinach", "Pepper", "Garlic"};

    static void insertCheeseAroundVegetable(List list) {

        List<String> vegetablesList = Arrays.asList(vegetables);

        for (int i = 0; i < list.size() - 1; i++) {
            if (vegetablesList.contains(list.get(i)) && vegetablesList.contains(list.get(i + 1))){
                list.add(i+1,"Cheese");
                i++;
            }
        }


    }

    public static void main(String[] args) {


        ArrayList<String> alimentos = new ArrayList<>();

        alimentos.add("Carrot");
        alimentos.add("Chicken");
        alimentos.add("Potato");
        alimentos.add("Fish");
        alimentos.add("Tomato");
        alimentos.add("Lettuce");
        alimentos.add("Cucumber");
        alimentos.add("Bread");
        alimentos.add("Onion");
        alimentos.add("Broccoli");
        alimentos.add("Spinach");
        alimentos.add("Eggs");
        alimentos.add("Pepper");
        alimentos.add("Garlic");

        alimentos.add("Tomato");
        alimentos.add("Lettuce");
        alimentos.add("Cucumber");
        alimentos.add("Onion");

        alimentos.add("Rice");
        alimentos.add("Pasta");
        alimentos.add("Bacon");
        alimentos.add("Yogurt");
        alimentos.add("Sausage");
        alimentos.add("Apple");
        alimentos.add("Banana");
        alimentos.add("Milk");
        alimentos.add("Steak");
        alimentos.add("Butter");

        Collections.shuffle(alimentos);
        System.out.println(alimentos);

        insertCheeseAroundVegetable(alimentos);

        System.out.println(alimentos);

    }
}
