package devs.fmm.threads.protectcriticalsections;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FrienshipBook {
    private final StringBuilder text = new StringBuilder();
    Lock lockBook = new ReentrantLock();


    public void appendChar(char character) {

        text.append(character);
    }

    public void appendDivider() {
        text.append("\n_,.‐'~'‐.,__,.‐'~'‐.,__,.‐'~'‐.,__,.‐'~'‐.,__,.‐'~'‐.,_\n");
    }

    @Override
    public String toString() {
        return text.toString();
    }
}

class Autor implements Runnable {
    private final String text;
    private final FrienshipBook book;

    public Autor(String text, FrienshipBook book) {
        this.text = text;
        this.book = book;
    }

    @Override
    public void run() {
        book.lockBook.lock();
        try {
            for (int i = 0; i < text.length(); i++) {
                book.appendChar(text.charAt(i));
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
                book.appendDivider();
            }

        } finally {
            book.lockBook.lock();
        }
    }
}
