package devs.fmm.threads.threadpoolsandresults;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.*;

public class UsingThreadPools {
    public static void main(String[] args) {


        record DistributeGift(String gift) implements Runnable {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + " gives " + DistributeGift.this.gift);
                    Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 4000));
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }
        Iterator<String> names = Arrays.asList("Polly Zist", "Jo Ghurt", "Lisa Bonn").iterator();


        // For creating new threads when is need
        // If we don't want to give a name to each thread :
        // ExecutorService crew = Executors.newCachedThreadPool();
        
        ExecutorService crew = Executors.newCachedThreadPool(runnable -> {
            // For customizing threads (setting a name)
            ThreadFactory threadFactory = Executors.defaultThreadFactory();
            Thread thread = threadFactory.newThread(runnable);
            thread.setName(names.next());
            return thread;
        });



        String[] gifts = {
                "Dragon", "Pomsies", "Coat", "Tablet", "Doll", "Art Station", "Bike", "Card Game", "Slime", "Nerf Blaster"
        };

        for (String gift : gifts) {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 2000));
                crew.submit(new DistributeGift(gift));
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

    }
}
