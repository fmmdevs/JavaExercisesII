package devs.fmm.datastructuresandalgorithms;

import java.util.ArrayList;
import java.util.Collection;

public class QuizSearchforStringBuilder {
    public static void main(String[] args) {
        Collection<String> islands1 = new ArrayList<>();
        islands1.add("Galapagos");
        islands1.add("Revillagigedo");
        islands1.add("Clipperton");
        System.out.println(islands1.contains("Clipperton"));

        Collection<StringBuilder> islands2 = new ArrayList<>();
        islands2.add(new StringBuilder("Galápagos"));
        islands2.add(new StringBuilder("Revillagigedo"));
        islands2.add(new StringBuilder("Clipperton"));
        System.out.println(islands2.contains(new StringBuilder("Clipperton")));

        // This behaviour is because StringBuilder doesn't implement equals and hashCode so contains doesn't work as expected
    }
}
