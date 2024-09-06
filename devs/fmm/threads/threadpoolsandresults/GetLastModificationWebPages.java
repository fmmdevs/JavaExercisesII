package devs.fmm.threads.threadpoolsandresults;

import javax.swing.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.concurrent.*;

public class GetLastModificationWebPages {

    private static ZonedDateTime getLastModified(URL url) {

        try {
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            long dateTime = con.getLastModified();
            // Just checking the HTTP headers
          /*  int n = 1;
            System.out.printf("URL: %s%n", url.toString());
            while (con.getHeaderField(n) != null) {
                System.out.printf("\tHeader n %d : %s = %s %n", n, con.getHeaderFieldKey(n), con.getHeaderField(n));
                n++;
            }*/

            con.disconnect();
            return ZonedDateTime.ofInstant(Instant.ofEpochMilli(dateTime), ZoneId.of("UTC"));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }

    }

    public static void main(String[] args) throws IOException {

       /* ZonedDateTime urlLastModified = getLastModified(URI.create("http://www.tutego.com/index.html").toURL());
        System.out.println("http://www.tutego.com/index.html " + urlLastModified);
        ZonedDateTime urlLastModified2 = getLastModified(URI.create("https://en.wikipedia.org/wiki/Main_Page").toURL());
        System.out.println("https://en.wikipedia.org/wiki/Main_Page " + urlLastModified2);*/

        record WebResourceLastModifiedCallable(URL url) implements Callable<String> {


            @Override
            public String call() throws Exception {
                ZonedDateTime lastModified = getLastModified(url);
                ZonedDateTime now = ZonedDateTime.now();
                long minutesBetween = Duration.between(lastModified,now).toMinutes();
                if(lastModified.toString().equals("1970-01-01T00:00Z[UTC]")){
                    return "%s => This URL doesn't have an last-modified header".formatted(url.toString());
                } else {
                    return "%s => Last modification: %s %d minutes ago".formatted(url.toString(), lastModified.toString(), minutesBetween);
                }

            }
        }

        try (ExecutorService executorService = Executors.newCachedThreadPool()) {

            WebResourceLastModifiedCallable lastModifiedCallable1 = new WebResourceLastModifiedCallable(URI.create("https://web.dragonball-api.com/").toURL());
            WebResourceLastModifiedCallable lastModifiedCallable2 = new WebResourceLastModifiedCallable(URI.create("https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/concurrent/Future.html").toURL());
            WebResourceLastModifiedCallable lastModifiedCallable3 = new WebResourceLastModifiedCallable(URI.create("https://en.wikipedia.org/wiki/Main_Page").toURL());

            Future<String> result1 = executorService.submit(lastModifiedCallable1);
            Future<String> result2 = executorService.submit(lastModifiedCallable2);
            Future<String> result3 = executorService.submit(lastModifiedCallable3);

            String lastModified1 = result1.get();
            String lastModified2 = result2.get();
            String lastModified3 = result3.get();

            //
            System.out.println(lastModified1);
            System.out.println(lastModified2);
            System.out.println(lastModified3);

            WebResourceLastModifiedCallable lastModifiedCallable4 = new WebResourceLastModifiedCallable(URI.create(JOptionPane.showInputDialog("URL")).toURL());
            Future<String> result4 = executorService.submit(lastModifiedCallable4);
            System.out.println(result4.get());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
