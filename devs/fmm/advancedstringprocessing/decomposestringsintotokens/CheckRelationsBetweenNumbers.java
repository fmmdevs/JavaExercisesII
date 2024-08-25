package devs.fmm.advancedstringprocessing.decomposestringsintotokens;

import java.util.Arrays;

public class CheckRelationsBetweenNumbers {
    static boolean relationChecker(String relations) {
        if (relations.length() % 2 == 0) return false;
        if (relations.length() == 1) return true;

        // Removing spaces and then splitting with delimiters
        String[] elements = relations.replace(" ", "").splitWithDelimiters("[<>=]", -1);
        System.out.println(Arrays.toString(elements));

        int firstNumber;
        int secondNumber;
        String relation;

        for (int i = 0; i < elements.length - 3; i += 2) {
            System.out.printf("%s%s%s%n", elements[i], elements[i + 1], elements[i + 2]);
            firstNumber = Integer.parseInt(elements[i]);
            relation = elements[i + 1];
            secondNumber = Integer.parseInt(elements[i + 2]);

            if (relation.equals("<")) {
                if (!(firstNumber < secondNumber)) return false;
            }

            if (relation.equals(">")) {
                if (!(firstNumber > secondNumber)) return false;
            }

            if(relation.equals("=")){
                if(!(firstNumber==secondNumber)) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String relations1 = "1 < 2 > 1 < 10 = 10 > 2";
        String relations2 = "1<1";
        String relations3 = "1<";
        String relations4 = "1";

        System.out.println(relationChecker(relations1));
        System.out.println(relationChecker(relations2));
        System.out.println(relationChecker(relations3));
        System.out.println(relationChecker(relations4));

    }

}
