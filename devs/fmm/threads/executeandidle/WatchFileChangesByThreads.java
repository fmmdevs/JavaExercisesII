package devs.fmm.threads.executeandidle;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;

public class WatchFileChangesByThreads {
    public static void main(String[] args) {

        String path = "/home/workzone/Documentos/DevProjects/Java/Java Programming Exercises/Recursos/testingFile.txt";
        FileChangeWatcher fileChangeWatcher = new FileChangeWatcher(path);
        Thread t = new Thread(fileChangeWatcher);
        t.start();

    }
}

class FileChangeWatcher implements Runnable {

    private final File file;
    private final String path;
    private FileTime lastModifiedTime;

    public FileChangeWatcher(String path) {
        this.path = path;
        file = new File(path);
        try {
            lastModifiedTime = Files.getLastModifiedTime(Path.of(path));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public void run() {
        while (true) {

            System.out.printf("File name: %s size: %s Bytes, last modification: %s%n", file.getName(), file.length(), lastModifiedTime);

            try {
                Path filePath = Path.of(path);
                if (!Files.getLastModifiedTime(filePath).equals(lastModifiedTime)) {
                    System.out.println("--------------------------------");
                    System.out.println("Last modified time CHANGED!");
                    System.out.println("Before : " + lastModifiedTime);
                    lastModifiedTime = Files.getLastModifiedTime(filePath);
                    System.out.println("Now : " + lastModifiedTime);
                    System.out.println("---------------------------------");
                }
            } catch (IOException e) {
                System.out.println(e);
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
