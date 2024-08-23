package devs.fmm.advancedstringprocessing.formatstrings;

public class StringFormatExamples {

    public static void main(String[] args) {

        /*
         * printf with two arguments : format string + object/variable/value
         * % [flags] [precision] [width] [conversion-character]
         * */

        System.out.printf("This is a format string %d", 124);

        boolean myBoolean = true;
        char myChar = '@';
        String myString = "Bro";
        int myInt = 50;
        double myDouble = 1000.2;

        // conversion-character examples
        System.out.printf("%b", myBoolean);
        System.out.printf("%c", myChar);
        System.out.printf("%s", myString);
        System.out.printf("%d", myInt);
        System.out.printf("%f", myDouble);
        System.out.println("------------");

        // % + width + conversion

        System.out.printf("Hello %-10s", myString); //Añade 10 espacios a la derecha (justifica a la izquierda)
        System.out.printf("Hello %10s", myString); // añade 10 espacios a la izquierda


        // precision (For decimal numbers)
        System.out.printf("\nYou have this much money %f", myDouble); // 6 decimal digits
        System.out.printf("\nYou have this much money %.2f", myDouble); // 2 decimal digits

        // flags
        // - : left-justify
        // + : signs for numeric values
        // 0 : numeric values are zero-padded. It needs its own width.
        // , : comma grouping separator if numbers > 1000

        // % flags precision width conversion-character
        System.out.printf("\nYou have this much money %010.2f", myDouble);
        System.out.printf("\nYou have this much money %010.2f", myDouble);
        System.out.printf("\nYou have this much money %0+10.2f", myDouble);
        System.out.printf("\nYou have this much money %,f", myDouble); // adds . like 1.000 (locale dependent)


    }
}
