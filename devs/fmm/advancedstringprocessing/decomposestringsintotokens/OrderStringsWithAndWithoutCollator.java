package devs.fmm.advancedstringprocessing.decomposestringsintotokens;

import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;

public class OrderStringsWithAndWithoutCollator {
    public static void main(String[] args) {
        Comparator<String> comparator = Comparator.naturalOrder();
        System.out.println(comparator.compare("b", "a")); //  1
        System.out.println(comparator.compare("a", "b")); // -1 a<b
        System.out.println(comparator.compare("n", "ñ")); // -131 n<ñ
        System.out.println(comparator.compare("ñ", "o")); // 130 ñ>o (lmnñopq)-> ñ should be less than o

        System.out.println(Arrays.toString(Collator.getAvailableLocales()));
        Comparator<Object> collatorES = Collator.getInstance(Locale.forLanguageTag("es-ES"));
        System.out.println(collatorES.compare("b", "a")); // 1
        System.out.println(collatorES.compare("a", "b")); // -1
        System.out.println(collatorES.compare("n", "ñ")); // -1
        System.out.println(collatorES.compare("ñ", "o")); // -1 ñ>o
        System.out.println(Math.rint(1.5));
        System.out.println(Math.rint(1.49));
        System.out.println(Math.rint(1.51));

        System.out.println(Math.rint(-1.5));
        System.out.println(Math.rint(-1.49));
        System.out.println(Math.rint(-1.51));




    }
}
