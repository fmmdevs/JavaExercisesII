package devs.fmm.advancedstringprocessing.regularexpressionspatternrecognition;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExamples {
    public static void main(String[] args) {

        String regex = "\\d{10}";
        String text = "fdsaf123123123123jkfhd1322131231212sdkfkdk123123213312312";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println("Found 10 numbers in start index : " + matcher.start() + " ending at index : " + matcher.end());
        }

        System.out.println("-------------------------------------");
        // 1. Regex
        String regex1 = "[\\da-zA-Z]{5,10}";
        // 2. Pattern compile regex
        pattern = Pattern.compile(regex1);
        // 3. Matcher pattern text
        matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println("Found 10 numbers in start index : " + matcher.start() + " ending at index : " + matcher.end());
        }
        System.out.println("-------------------------------------");


    }
}
