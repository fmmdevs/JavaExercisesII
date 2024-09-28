package devs.fmm.datastructuresandalgorithms.lists;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class PlanetsGame {
    public static void main(String[] args) {

        List<Planet> planets = Arrays.asList(Planet.values());

        Collections.shuffle(planets);

        System.out.println(planets);

        List<String> answers = new ArrayList<>();

        int rightAnswer;
        int actualAnswer;
        int goodOnes = 0;
        int badOnes = 0;
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < planets.size(); i++) {
            System.out.println("What is the diameter of planet %s (in km)?".formatted(planets.get(i).name));
            answers.add(planets.get(i).diameter + "km");
            rightAnswer = planets.get(i).diameter;

            for (int j = 1; j < 4; j++) {
                if (i + j < planets.size()) {
                    answers.add(planets.get(i + j).diameter + "km");
                } else {
                    answers.add(planets.get(j - 1).diameter + "km");
                }
            }
            Collections.shuffle(answers);
            do {
                System.out.println(answers.get(0));
                answers.remove(0);
            } while (answers.size() > 0);

            actualAnswer = sc.nextInt();
            if (actualAnswer == rightAnswer) {
                System.out.println("Correct!");
                goodOnes++;
            } else {
                System.out.println("Wrong! The diameter of %s is %dkm".formatted(planets.get(i).name, planets.get(i).diameter));
                badOnes++;
            }


        }
        System.out.println("Good Ones = %d | Bad Ones = %d".formatted(goodOnes, badOnes));

    }
}
