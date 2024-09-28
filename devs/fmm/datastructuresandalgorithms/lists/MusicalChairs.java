package devs.fmm.datastructuresandalgorithms.lists;

import java.util.*;

public class MusicalChairs {
    List<String> names;

    public MusicalChairs(String... names) {
        this.names = new ArrayList<>(names.length);
        for (String name : names) {
            this.names.add(name);
        }
    }

    public void rotate(int distance) {
        Collections.rotate(names, distance);
    }

    public void rotateAndRemoveLast(int distance) {
        rotate(distance);
        names.remove(names.size() - 1);
    }

    public String play() {
        if (names.isEmpty()) return "There is no one here to play";
        Random random = new Random();
        do {
            rotateAndRemoveLast(random.nextInt(names.size()));
            System.out.println(this);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        } while (names.size() > 1);
        return "The winner is : " + this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String name : names) {
            sb.append(name).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }
}
