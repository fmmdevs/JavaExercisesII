package devs.fmm.localedatetime.threads.createthreads;

public class ParameterizeRunnableMain {
    public static void main(String[] args) {

        ParameterizeRunnable waveFlag = new ParameterizeRunnable("Wave flag",50);
        ParameterizeRunnable wink= new ParameterizeRunnable("Wink",100);
        Thread waveFlagThread = new Thread(waveFlag);
        Thread winkThread = new Thread(wink);
        waveFlagThread.start();
        winkThread.start();
    }
}

class ParameterizeRunnable implements Runnable {

    private String parameter;
    private int repetitions;

    public ParameterizeRunnable(String parameter,int repetitions) {
        this.parameter = parameter;
        this.repetitions=repetitions;
    }

    @Override
    public void run() {
        for (int i = 0; i < repetitions; i++) {
            System.out.printf("%s; %s%n", parameter, Thread.currentThread());
        }
    }
}



