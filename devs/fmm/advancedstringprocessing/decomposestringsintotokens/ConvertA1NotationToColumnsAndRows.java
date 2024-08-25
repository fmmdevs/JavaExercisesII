package devs.fmm.advancedstringprocessing.decomposestringsintotokens;

import java.sql.SQLOutput;
import java.util.Arrays;

public class ConvertA1NotationToColumnsAndRows {

    static String[] parseA1Notation(String a1) {
        String column = a1.replaceAll("\\d+", "");
        String row = a1.replaceAll("\\D+", "");
        //System.out.println(column);
        //System.out.println(row);

        if (column.isEmpty() || row.isEmpty()) return new String[]{"0", "0"};
        //System.out.println(column + " " + row);

        String[] result = new String[2];

        int columnNumber = 0;
        int multiplier = column.length() - 1;
        int aZDifference = Character.getNumericValue('Z') - Character.getNumericValue('A');
        //System.out.println(aZDifference);
        for (int i = 0; i < column.length(); i++) {
            //System.out.println(Character.getNumericValue(column.charAt(i)));

            if(column.length()==1){
                columnNumber= Character.getNumericValue(column.charAt(i))-9;
            } else {
                columnNumber += 1 + (Character.getNumericValue(column.charAt(i)) - 9) * multiplier * aZDifference;

            }

            //System.out.println(columnNumber);
            multiplier--;
        }
        result[0] = String.valueOf(columnNumber);
        result[1] = row;

        //System.out.println(Arrays.toString(result));
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(parseA1Notation("A1")));
        System.out.println(Arrays.toString(parseA1Notation("Z2")));
        /*
        System.out.println(Arrays.toString(parseA1Notation("B1")));
        System.out.println(Arrays.toString(parseA1Notation("C2")));
        System.out.println(Arrays.toString(parseA1Notation("D3")));
*/
        System.out.println(Arrays.toString(parseA1Notation("AA34")));
        System.out.println(Arrays.toString(parseA1Notation("BZ")));
        System.out.println(Arrays.toString(parseA1Notation("34")));
        System.out.println(Arrays.toString(parseA1Notation(" ")));
        System.out.println(Arrays.toString(parseA1Notation("")));
    }
}
