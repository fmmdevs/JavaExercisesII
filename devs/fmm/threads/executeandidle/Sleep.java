package devs.fmm.threads.executeandidle;

public class Sleep {
    public static void main(String[] args) {


        String regexM = "\\d+m";
        String regexH = "\\d+h";
        String regexS = "\\d+s";
        String regexSNoUnit = "\\d+";

        // Checking is arguments are well-formed
        for (String arg : args) {
            if (!arg.matches(regexH) && !arg.matches(regexM) && !arg.matches(regexS) && !arg.matches(regexSNoUnit)) {
                System.err.println("Invalid parameter");
                System.exit(1);
            }
        }

        int h = 0;
        int m = 0;
        int s = 0;
        int timeAmount = 0;

        for (String timeUnit : args) {
            if (timeUnit.charAt(timeUnit.length() - 1) == 's' || timeUnit.charAt(timeUnit.length() - 1) == 'm' || timeUnit.charAt(timeUnit.length() - 1) == 'h') {
                timeAmount = Integer.parseInt(timeUnit.substring(0, timeUnit.length() - 1));
            } else if (timeUnit.matches(regexSNoUnit)) {
                timeAmount = Integer.parseInt(timeUnit);
            }

            if (timeUnit.matches(regexS) || timeUnit.matches(regexSNoUnit)) {
                s += timeAmount;
                /*System.out.println(timeUnit + " s");
                System.out.println(timeAmount + " seconds");
                System.out.printf("Sum %ds%n", s);*/
            }
            if (timeUnit.matches(regexM)) {
                m += timeAmount;
                /*System.out.println(timeUnit + " m");
                System.out.println(timeAmount + " minutes");
                System.out.printf("Sum %dm%n", m);*/

            }
            if (timeUnit.matches(regexH)) {
                h += timeAmount;
                /*System.out.println(timeUnit + " h");
                System.out.println(timeAmount + " hours");
                System.out.printf("Sum %dh%n", h);*/

            }
        }
        //System.out.printf("Total: HOURS=%d MINUTES=%d SECONDS=%d ", h, m, s);

        // Converting to ms
        m += h * 60;
        s += m * 60;

        System.out.println("Sleeping during "+ s +"s");
        int ms = s * 1000;

        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("End of Program");

    }
}
