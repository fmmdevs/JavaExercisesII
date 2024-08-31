package devs.fmm.threads.executeandidle;

import java.net.URI;
import java.util.Arrays;

public class MainUncaughtExceptionHandler {
    public static void main(String[] args) throws Exception{

        // Thread that throws an ArithmeticException
        Thread thread = new Thread(() -> {
            System.out.println(1/0);
        });

        Thread thread2 = new Thread(() -> {
            System.out.println(1/0);
        });


        // Default Uncaught Exception Handler
        Thread.UncaughtExceptionHandler defaultHandler = new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("This is the default exception handler");
            }
        };

        // Thread specific Uncaught Exception Handler for thread2
        Thread.UncaughtExceptionHandler specificHandler2 = (t,e)->{
            System.out.println("This is the Uncaught Exception Handler for thread2");
        };

        Thread.setDefaultUncaughtExceptionHandler(defaultHandler);

        thread2.setUncaughtExceptionHandler(specificHandler2);

        // If there is an unchecked exception
        // 1. JVM first look if UncaughtExceptionHandler is set for this individual Thread
        // 2. If not look if is set in the Thread group
        // 3. Looks for the Global Handler



        thread.start();
        thread2.start();
        System.out.println(URI.create("captain").toURL());

       /* Thread[] threads=new Thread[10];
        Thread.enumerate(threads);
        System.out.println(Arrays.toString(threads));*/
    }
}
