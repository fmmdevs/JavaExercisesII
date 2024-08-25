package devs.fmm.advancedstringprocessing.decomposestringsintotokens;

import java.util.StringTokenizer;

public class SplitAddressLinesStringTokenizer {

    static void splitAddress(String text) {
        StringTokenizer st = new StringTokenizer(text, "\n\r");
        StringBuilder sb = new StringBuilder();

        boolean missingLine = st.countTokens()<4;

        while (st.hasMoreTokens()) {
            sb.append(st.nextToken()).append(";");
        }

        if (missingLine) sb.append("Drusselstein");

        System.out.println(sb);
    }

    public static void main(String[] args) {
        String text1 = "Boots and Bootles\n21 Pickle Street\n424242 Douglas\nArendelle";// → Boots and Bootles;21 Pickle street;424242 Douglas;Arendelle
        String text2 = "Doofenshmirtz Evil Inc.\nStrudelkuschel 4427\nDanville"; // → Doofenshmirtz Evil Inc.;Strudelkuschel 4427;Gimmelshtump; Drusselstein

        splitAddress(text1);

        splitAddress(text2);

    }
}
