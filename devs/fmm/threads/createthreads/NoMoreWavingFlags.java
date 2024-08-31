package devs.fmm.threads.createthreads;

import javax.swing.*;

public class NoMoreWavingFlags {
    public static void main(String[] args) {

        Runnable winkFlag = () -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("wink");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println(e);
                    System.out.println("winkThread interrupted (during sleep)");
                    Thread.currentThread().interrupt();

                }
            }
        };

        Runnable waveFlag = () -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("wave flag");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println(e);
                    System.out.println("waveThread interrupted (during sleep)");
                    Thread.currentThread().interrupt();
                }

            }
        };


        Thread winkThread = new Thread(winkFlag);
        Thread waveThread = new Thread(waveFlag);
        winkThread.start();
        waveThread.start();

        String endInput;

        do {
            endInput = JOptionPane.showInputDialog("endw to stop winking.\nendf to stop flag waving.\n");
            if (endInput.equals("endf")) {
                waveThread.interrupt();
            }
            if (endInput.equals("endw")) {
                winkThread.interrupt();
            }
            if (waveThread.isInterrupted() && endInput.equals("continuef")) {
                waveThread.start();
            }
            if (waveThread.isInterrupted() && endInput.equals("continuew")) {
                winkThread.start();
            }
        } while (!endInput.equals("exit"));

        System.exit(0);

    }

}

