package devs.fmm.datastructuresandalgorithms.mapkeystovalues;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class ConvertTwoDimensionalArraysToMap {

    static Map<String, String> convertToMap(String[][] array2d) {

        Map<String, String> map = new Hashtable<>();

        for (int i = 0; i < array2d.length; i++) {

            try {
                map.put(array2d[i][0], array2d[i][1]);
            } catch (NullPointerException e) {
                System.err.println("Error: attempting to put a null key or value in the subarray "+i+": "+ Arrays.toString(array2d[i]));
            }
        }
        return map;
    }

    public static void main(String[] args) {
        String[][] array = {
                {"red", "#FF0000"}, // array[0]
                {"green", "#00FF00"},
                {"blue", "#0000FF"}
        };

        String[][] array1 = {
                {"red", "#FF0000"}, // array[0]
                {"green", null},
                {"blue", "#0000FF"}
        };

        Map<String, String> map = convertToMap(array);

        System.out.println(map);

        Map<String, String> map1 = convertToMap(array1);
        System.out.println(map1);
    }
}
