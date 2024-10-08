package devs.fmm.datastructuresandalgorithms.sets;

import java.util.*;

public class UniqueIterator<E> implements Iterator<E> {

    Iterator<? extends E> iterator;
    private final Set<E> hasSeenSet = new HashSet<>();
    private E next;

    public UniqueIterator(Iterator<? extends E> iterator) {
        this.iterator = iterator;
        next = lookahead();
    }

    private E lookahead() {
        // We use the base iterator to iterate the Collection
        while (iterator.hasNext()) {
            E next = iterator.next();
            // Then if the element is not in the HashSet hasSeenSet we return it
            if (!hasSeenSet.contains(next)) return next;
        }
        // if we end the while loop we return null so hasNext will be false
        return null;
    }

    @Override
    public boolean hasNext() {
        // if next is null there is the end
        return next != null;
    }

    @Override
    public E next() {
        // result is always the return of lookahead()
        E result = next;
        hasSeenSet.add(result);
        next = lookahead();
        return result;
    }

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("asd");
        names.add("asdd");
        names.add("asdd");
        names.add("asd");
        names.add("asdasdf");
        names.add("asdaa");
        names.add("asda");
        names.add("asdaa");
        Iterator<String> uniqueIterator = new UniqueIterator(names.iterator());
        while (uniqueIterator.hasNext()) {
            System.out.println(uniqueIterator.next());
        }

    }
}
