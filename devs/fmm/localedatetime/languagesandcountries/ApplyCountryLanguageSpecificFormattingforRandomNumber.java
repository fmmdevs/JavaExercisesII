package devs.fmm.localedatetime.languagesandcountries;

import java.util.Locale;
import java.util.Random;

public class ApplyCountryLanguageSpecificFormattingforRandomNumber {

    public static void main(String[] args) {
        Random random = new Random();
        double randomDouble = random.nextDouble(10000, 12000);
      /*  System.out.println(randomDouble);
        System.out.printf("%f%n", randomDouble);
        System.out.printf("%.2f", randomDouble)*/;

        Locale[] locales = Locale.getAvailableLocales();
        System.out.println(locales.length);
        for (Locale locale : locales) {
            System.out.printf(locale, "%s(%s) : %.2f%n",locale,locale.getDisplayCountry(), randomDouble);
        }
    }
}
