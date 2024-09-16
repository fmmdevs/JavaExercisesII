package devs.fmm.datastructuresandalgorithms.lists;

import java.text.NumberFormat;
import java.util.*;

public class Receipt {


    record Item(String name, int price) {
    }


    List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }


    public int total() {
        int sum = 0;
        for (Item item : items) {
            sum += item.price();
        }
        return sum;
    }

    @Override
    public String toString() {

        List<Item> ordered = new ArrayList<>(items);

        ordered.sort(Comparator.comparingDouble(Item::price).thenComparing(Item::name));

        //System.out.println(ordered);

        int nItems = 1;

        StringBuilder result = new StringBuilder("-".repeat(62)).append("\n");

        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.of("es", "ES"));

        for (int i = 1; i < ordered.size(); i++) {

            if (ordered.get(i - 1).equals(ordered.get(i))) {

                while (ordered.get(i - 1).equals(ordered.get(i)) && i < ordered.size() - 1) {
                    nItems++;
                    i++;
                }

                if (i == ordered.size() - 1 && ordered.get(i).equals(ordered.get(i - 1))) {
                    nItems++;
                }

                result.append("%dx%20s%20s%20s%n".formatted(nItems, ordered.get(i - 1).name(), nf.format((double) ordered.get(i - 1).price() / 100), nf.format(((double) ordered.get(i - 1).price() / 100) * nItems)));
                nItems = 1;

            } else {
                result.append("%dx%20s%20s%20s%n".formatted(nItems, ordered.get(i - 1).name(), nf.format((double) ordered.get(i - 1).price() / 100), nf.format(((double) ordered.get(i - 1).price() / 100) * nItems)));
            }
        }

        result.append("%nSum: %s".formatted(nf.format((double) total() / 100)));

        return result.toString();
    }


}
