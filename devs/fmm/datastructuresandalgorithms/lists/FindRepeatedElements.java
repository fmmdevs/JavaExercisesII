package devs.fmm.datastructuresandalgorithms.lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindRepeatedElements {
    record WeatherOccurrence(String weather, int occurrences, int startIndex) {
    }

    ;

    static WeatherOccurrence longestSequenceOfSameWeather(List<String> weather) {
        System.out.println(weather);

        List<WeatherOccurrence> weatherOccurrences = new ArrayList<>();


        int counter = 1;
        int maxCounter = 1;

        int startIndex = 0;
        int startIndexAux = 0;

        String weatherName = weather.get(0);
        String weatherNameAux = weather.get(0);

        for (int i = 0; i < weather.size() - 1; i++) {
            if (weather.get(i).equalsIgnoreCase(weather.get(i + 1))) {
                startIndexAux = i;
                weatherNameAux = weather.get(i);
            }

            while (weather.get(i).equalsIgnoreCase(weather.get(i + 1)) && i < weather.size() - 2) {
                counter++;
                i++;

            }
            if (counter > maxCounter) {
                maxCounter = counter;
                weatherName = weatherNameAux;
                startIndex = startIndexAux;
            }

            //System.out.printf("weather:%s\tocurrences:%d\tstart index:%d.%n", weatherName, maxCounter, startIndex);

            counter = 1;
        }


        return new WeatherOccurrence(weatherName, maxCounter, startIndex);
    }

    public static void main(String[] args) {
        List<String> weatherData = new ArrayList<>();
        weatherData.add("Rain");
        weatherData.add("sun");
        weatherData.add("hail");
        weatherData.add("sun");
        weatherData.add("sun");
        weatherData.add("sun");
        weatherData.add("sun");
        weatherData.add("sun");
        weatherData.add("sun");
        weatherData.add("hail");
        weatherData.add("hail");
        weatherData.add("hail");
        weatherData.add("hail");
        weatherData.add("hail");
        weatherData.add("hail");
        weatherData.add("hail");
        weatherData.add("rain");
        weatherData.add("rain");
        weatherData.add("rain");
        weatherData.add("rain");
        weatherData.add("sun");
        weatherData.add("sun");
        weatherData.add("sun");
        weatherData.add("sun");
        weatherData.add("sun");
        weatherData.add("sun");
        weatherData.add("sun");
        weatherData.add("sun");
        weatherData.add("sun");
        weatherData.add("sun");
        weatherData.add("sun");
        weatherData.add("sun");
        weatherData.add("sun");


        System.out.println(longestSequenceOfSameWeather(weatherData));


    }
}
