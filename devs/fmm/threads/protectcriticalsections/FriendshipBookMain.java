package devs.fmm.threads.protectcriticalsections;

import java.util.concurrent.TimeUnit;

public class FriendshipBookMain {
    public static void main(String[] args) throws InterruptedException {
        FrienshipBook book = new FrienshipBook();

        String q1 = "The flowers need sunshine and " + "I need Captain CiaoCiao to be happy";

        new Thread(new Autor(q1, book)).start();

        String q2 = "When you laugh, the all laugh. " + "When you cry, you cry alone.";

        new Thread(new Autor(q2, book)).start();

        TimeUnit.SECONDS.sleep(1);

        System.out.println(book);

    }
}
