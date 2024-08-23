package devs.fmm.advancedstringprocessing.formatstrings;

public class AlignedOutputs {
    static void printList(String[] names, boolean[] paid) {

        if (names == null || paid == null) throw new NullPointerException("One of the parameters is null");

        if (names.length != paid.length)
            throw new IllegalArgumentException("Arrays names and paid have different length");

        StringBuilder sb = new StringBuilder();
        String paidString;

        // 1. Find the longest name
        int maxLengthNames = 0;
        for (String name : names) {
            maxLengthNames = Math.max(name.length(), maxLengthNames);
        }

        for (int i = 0; i < names.length; i++) {

            paidString = paid[i] ? "paid" : "not paid";

            sb.append(String.format("%"+(-maxLengthNames)+"s    %s%n", names[i], paidString));
        }

        System.out.println(sb);


    }

    public static void main(String[] args) {

        String[] names = {"Pedro", "Maria Isabel", "Gog"};
        boolean[] paid = {true, false, false};

        printList(names, paid);

    }
}
