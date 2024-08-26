package devs.fmm.advancedstringprocessing.decomposestringsintotokens;

import java.util.Arrays;

public class SimpleStringCompressor {
    static String compress(String string) {

        StringBuilder compressed = new StringBuilder();

        compressed.append(string.charAt(0));

        int counter = 1;
        boolean end = false;

        for (int i = 1; i < string.length() - 1; i++) {

            //System.out.printf("charAt(%d)=%c  charAt(%d)=%c%n", i, string.charAt(i), (i-1), string.charAt(i - 1));

            if (string.charAt(i) != string.charAt(i - 1)) {
                //System.out.println("Trolololo");
                compressed.append(string.charAt(i));
            } else {

                while (string.charAt(i) == string.charAt(i - 1)) {
                    i++;
                    counter++;

                    if (i == string.length() - 1){
                        end = true;
                        break;

                    }

                    //System.out.printf("i = %d counter = %d%n",i,counter);
                }
                i--;
                if(end){
                    counter++;
                }
                compressed.append(counter);

            }
            counter = 1;
        }

        if (string.charAt(string.length() - 1) != string.charAt(string.length() - 2)) {
            compressed.append(string.charAt(string.length() - 1));
        }

        return compressed.toString();
    }

    public static void main(String[] args) {
        String string = "‐.‐‐..-";
        String string2 = "aaaaabbbbcccccddddddeeeeeeeeeeffffggggggghhhhiiiiijjjjkkkkkllllmmmmnnnnoooopppppqqqqrrrrssssstttttuuuuvvvvwwwwxxxxxyyyyzzzz";
        System.out.println(compress(string));
        System.out.println(compress(string2));


    }
}
