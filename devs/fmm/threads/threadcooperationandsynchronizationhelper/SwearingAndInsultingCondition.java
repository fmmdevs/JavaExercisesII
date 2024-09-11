package devs.fmm.threads.threadcooperationandsynchronizationhelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class SwearingAndInsultingCondition {

    record Curser(
            List<String> curses,
            Lock lock,
            Condition condition
    ) implements Runnable {

        @Override
        public void run() {

            while (!Thread.currentThread().isInterrupted()) {
                lock.lock();
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(1000));
                    String name = Thread.currentThread().getName();
                    int rndCurse = ThreadLocalRandom.current().nextInt(curses.size());
                    System.out.println(name + ": " + curses.get(rndCurse));
                    condition.signal();
                    condition.await();
                } catch (InterruptedException e) {

                } finally {
                    lock.unlock();
                }
            }

        }
    }

    public static void main(String[] args) {
        List<String> pirateCurses1 = new ArrayList<>();
        pirateCurses1.add("Scurvy dog!");
        pirateCurses1.add("Bilge rat!");
        pirateCurses1.add("Ye’ll be walkin’ the plank!");
        pirateCurses1.add("May ye rot in Davy Jones’ locker!");
        pirateCurses1.add("Blaggard!");
        pirateCurses1.add("Ye’ll meet yer end by the rope’s end!");
        pirateCurses1.add("Son of a biscuit eater!");


        List<String> pirateCurses2 = new ArrayList<>();
        pirateCurses2.add("Avast, ye scallywag!");
        pirateCurses2.add("Blow me down!");
        pirateCurses2.add("Cursed be yer soul!");
        pirateCurses2.add("By thunder!");
        pirateCurses2.add("Ye mangy cur!");
        pirateCurses2.add("Dead men tell no tales!");
        pirateCurses2.add("Shiver me timbers!");

        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        new Thread(new Curser(pirateCurses1, lock, condition), "Jack Sparrow").start();
        new Thread(new Curser(pirateCurses2, lock, condition), "Barbosa").start();
    }
}
