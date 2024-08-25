package devs.fmm.advancedstringprocessing.regularexpressionspatternrecognition;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DefuseShoutingTexts {
    static String silentShoutingWords(String letter) {
        // 1. Regex
        String regex = "[A-Z]{4,}";

        // 2. Pattern.compile
        Pattern pattern = Pattern.compile(regex);

        // 3. Matcher pattern letter
        Matcher matcher = pattern.matcher(letter);

        // 4. replaceAll with the logic to transform de match
        return matcher.replaceAll(matchResult -> {
            String match = matchResult.group();
            return match.toLowerCase();
        });
    }

    public static void main(String[] args) {

        System.out.println(silentShoutingWords("AY Captain! Smutje MUST GO!"));
    }
}
