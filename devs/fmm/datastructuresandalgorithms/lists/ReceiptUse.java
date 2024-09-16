package devs.fmm.datastructuresandalgorithms.lists;

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
    }
}
