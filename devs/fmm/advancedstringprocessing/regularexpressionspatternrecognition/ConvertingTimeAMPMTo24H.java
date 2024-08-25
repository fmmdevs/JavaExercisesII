package devs.fmm.advancedstringprocessing.regularexpressionspatternrecognition;

import java.sql.SQLOutput;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConvertingTimeAMPMTo24H {

    static String hourConverter(String text) {
        // group 1 : hours, 2: minutes, 3 : aApP 4:mM
        String regex = "([01]?[012]):?([0-5][0-9])? ?([AaPp])[.]?([Mm])[.]?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        System.out.println(text);
        return matcher.replaceAll(matchResult -> {

            String hour = matchResult.group(1);

            int hourNumber = Integer.parseInt(hour);

            String minutes = matchResult.group(2);

            String amOrPm = matchResult.group(3) + matchResult.group(4);

            StringBuilder sb = new StringBuilder();


            if (amOrPm.equalsIgnoreCase("PM")) {
                if (hourNumber != 12) {
                    sb.append(hourNumber + 12);
                } else {
                    sb.append("00");
                }
            } else {
                if (hour.length() == 1) {
                    sb.append(0).append(hour);
                } else {
                    sb.append(hour);
                }
            }

            if (minutes == null) {
                sb.append("00");
            } else {
                sb.append(minutes);
            }

            System.out.println(hour + amOrPm + minutes);
            //System.out.println(sb);
            return sb.toString();
        });

    }

    public static void main(String[] args) {

        String text1 = "Harbour: 11:00 PM, entertainment districts: 1:30 a.m.!"; // → Harbour: 2300, entertainment districts: 0130!"
        String text2 = "Get out of bed: 12:00AM, bake a cake: 12 PM."; // → "Get out of bed: 0000, bake a cake: 1200"

        System.out.println(hourConverter(text1));
        System.out.println();
        System.out.println(hourConverter(text2));
    }
}
