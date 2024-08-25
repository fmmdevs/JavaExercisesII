package devs.fmm.advancedstringprocessing.decomposestringsintotokens;

import java.util.Arrays;

public class SplitWordsAndReverse {

    public static void main(String[] args) {

        String text = "erehW did eht etarip esahcrup sih kooh? tA eht dnah‐dnoces pohs!";

        String[] reversedWords = text.split("[\\s\\W]+");

        StringBuilder[] words = new StringBuilder[reversedWords.length];
        StringBuilder result = new StringBuilder();

        // Option 1
        for (int i = 0; i < reversedWords.length; i++) {
            words[i] = new StringBuilder();
            for (int j = reversedWords[i].length() - 1; j >= 0; j--) {
                words[i].append(reversedWords[i].charAt(j));
            }
            // Avoiding last space
            if (i < reversedWords.length - 1) {
                result.append(words[i]).append(" ");
            } else {
                result.append(words[i]);
            }
        }

        // Option 2

        System.out.println(Arrays.toString(words));

        System.out.println(result);


    }
}
