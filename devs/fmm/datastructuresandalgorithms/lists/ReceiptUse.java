package devs.fmm.datastructuresandalgorithms.lists;

import java.util.Arrays;

public class ReceiptUse {
    public static void main(String[] args) {
        Receipt receipt = new Receipt();
        receipt.addItem(new Receipt.Item("Peanuts", 222));
        receipt.addItem(new Receipt.Item("Lightsaber", 19999));
        receipt.addItem(new Receipt.Item("Peanuts", 222));
        receipt.addItem(new Receipt.Item("Log book", 1000));
        receipt.addItem(new Receipt.Item("Peanuts", 222));
        receipt.addItem(new Receipt.Item("Peanuts", 222));
        receipt.addItem(new Receipt.Item("Peanuts", 222));
        receipt.addItem(new Receipt.Item("Lightsaber", 19999));
        receipt.addItem(new Receipt.Item("Lightsaber", 19999));
        receipt.addItem(new Receipt.Item("Peanuts", 222));
        System.out.println(receipt);

        Receipt receipt1 = new Receipt();

        receipt1.addItem(new Receipt.Item("Peanuts", 222));
        receipt1.addItem(new Receipt.Item("Soda", 150));
        receipt1.addItem(new Receipt.Item("Bread", 180));
        receipt1.addItem(new Receipt.Item("Cookies", 350));
        receipt1.addItem(new Receipt.Item("Soda", 150));
        receipt1.addItem(new Receipt.Item("Milk", 120));
        receipt1.addItem(new Receipt.Item("Cookies", 350));
        receipt1.addItem(new Receipt.Item("Peanuts", 222));
        receipt1.addItem(new Receipt.Item("Juice", 275));
        receipt1.addItem(new Receipt.Item("Chips", 300));
        receipt1.addItem(new Receipt.Item("Bread", 180));
        receipt1.addItem(new Receipt.Item("Chips", 300));
        receipt1.addItem(new Receipt.Item("Soda", 150));
        receipt1.addItem(new Receipt.Item("Juice", 275));
        receipt1.addItem(new Receipt.Item("Milk", 120));
        receipt1.addItem(new Receipt.Item("Peanuts", 222));
        receipt1.addItem(new Receipt.Item("Cookies", 350));
        receipt1.addItem(new Receipt.Item("Bread", 180));
        receipt1.addItem(new Receipt.Item("Milk", 120));
        receipt1.addItem(new Receipt.Item("Juice", 275));

        System.out.println(receipt1);

        int[] numbers1 = {1, 2, 3};
        System.out.println(Arrays.asList(numbers1).contains(1));
        Integer[] numbers = {1, 2, 3};
        System.out.println(Arrays.asList(numbers).contains(1));
        System.out.println(Arrays.asList(1, 2, 3).contains(1));
    }
}
