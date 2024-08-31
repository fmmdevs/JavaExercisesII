package devs.fmm.threads.createthreads;

public class WavingAndFlagWaving {
    public static void main(String[] args) {

        Runnable wink = () -> {
            for (int i = 0; i < 50; i++) {
                System.out.println(Thread.currentThread().getName());
                System.out.println("wink");
            }
        };

        // Different ways for creating Threads
        WaveFlag waveFlag = new WaveFlag();
        Thread thread0 = new Thread(waveFlag);
        Thread thread1 = new Thread(wink);
        thread0.start();
        thread1.start();


        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                System.out.println("Hey");
            }
        });

    }
}

class WaveFlag implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName());
            System.out.println("wave flag");
        }
    }
}
