package devs.fmm.advancedstringprocessing.formatstrings;


public class BuildASCIITable {
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();

        sb.append(("  Dec Hex  Dec Hex   Dec Hex   Dec Hex   Dec Hex    Dec Hex"));
        for (int i = 0; i < 16; i++) {

            if (i < 4) {
                sb.append(String.format("%n  %d %s %c  %d %s %c   %d %s %c   %d %s %c   %d %s %c    %d %s %c",
                        i + 32, Integer.toHexString(i + 32), (char) i + 32,
                        i + 48, Integer.toHexString(i + 48), (char) i + 48,
                        i + 64, Integer.toHexString(i + 64), (char) i + 64,
                        i + 80, Integer.toHexString(i + 80), (char) i + 80,
                        i + 96, Integer.toHexString(i + 96), (char) i + 96,
                        i + 112, Integer.toHexString(i + 112), (char) i + 112));
            } else {

                sb.append(String.format("%n  %d %s %c  %d %s %c   %d %s %c   %d %s %c   %d %s %c   %d %s %c",
                        i + 32, Integer.toHexString(i + 32), (char) i + 32,
                        i + 48, Integer.toHexString(i + 48), (char) i + 48,
                        i + 64, Integer.toHexString(i + 64), (char) i + 64,
                        i + 80, Integer.toHexString(i + 80), (char) i + 80,
                        i + 96, Integer.toHexString(i + 96), (char) i + 96,
                        i + 112, Integer.toHexString(i + 112), (char) i + 112));

            }

        }

        sb.replace(sb.length() - 1, sb.length(), "DEL");
        System.out.println(sb);


    }
}

