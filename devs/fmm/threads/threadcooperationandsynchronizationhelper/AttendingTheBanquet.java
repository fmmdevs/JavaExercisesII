package devs.fmm.threads.threadcooperationandsynchronizationhelper;

import java.util.concurrent.Semaphore;

public class AttendingTheBanquet {
    // Table with 4 free seats
    static Semaphore seats = new Semaphore(4);

    static String greenText = "\u001B[32m";
    static String redText = "\u001B[31m";
    static String resetText = "\u001B[0m";

    record Guest(String name) implements Runnable {
        @Override
        public void run() {

            try {
                System.out.println(name + " is waiting for a seat...");

                seats.acquire();
                System.out.println(greenText + name + " is seated" + resetText);
                Thread.sleep(3000);

            } catch (InterruptedException e) {
                System.out.println(e);
            } finally {
                System.out.println(redText + name + " is leaving the table" + resetText);
                seats.release();

            }

        }
    }

    public static void main(String[] args) {


        // 12 guests
        Guest guest1 = new Guest("Barbosa");
        Guest guest2 = new Guest("Jack");
        Guest guest3 = new Guest("Sparrow");
        Guest guest4 = new Guest("Tuck");
        Guest guest5 = new Guest("Bob");
        Guest guest6 = new Guest("Parrot");
        Guest guest7 = new Guest("Ahoy");
        Guest guest8 = new Guest("Manga");
        Guest guest9 = new Guest("Jesus");
        Guest guest10 = new Guest("Mossad");
        Guest guest11 = new Guest("Spanglish");
        Guest guest12 = new Guest("Barba Negra");

        Thread t1 = new Thread(guest1);
        Thread t2 = new Thread(guest2);
        Thread t3 = new Thread(guest3);
        Thread t4 = new Thread(guest4);
        Thread t5 = new Thread(guest5);
        Thread t6 = new Thread(guest6);
        Thread t7 = new Thread(guest7);
        Thread t8 = new Thread(guest8);
        Thread t9 = new Thread(guest9);
        Thread t10 = new Thread(guest10);
        Thread t11 = new Thread(guest11);
        Thread t12 = new Thread(guest12);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();
        t11.start();
        t12.start();


    }
}
