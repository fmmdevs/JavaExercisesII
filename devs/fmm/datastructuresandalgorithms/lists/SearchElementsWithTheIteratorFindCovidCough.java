package devs.fmm.datastructuresandalgorithms.lists;

import javax.management.MBeanAttributeInfo;
import java.util.*;

public class SearchElementsWithTheIteratorFindCovidCough {
    static class Ship {
        private List<String> persons = new ArrayList<>();
        private static int counter = 0;
        private int id;

        public Ship() {
            id = counter;
            counter++;
        }

        void addName(String name) {
            persons.add(name);
        }

        boolean contains(String name) {
            return persons.contains(name);
        }

        @Override
        public String toString() {
            return "Ship id : " + id + "\n\t" + persons;
        }
    }


    public static void main(String[] args) {
        final int NUMBER_OF_SHIPS = 100;
        List<Ship> ships = new LinkedList<>();
        for (int i = 0; i < NUMBER_OF_SHIPS; i++) {
            ships.add(new Ship());
        }
        ships.get(new Random().nextInt(ships.size())).addName("Covid Cough");

        // There are ships on the right side and on the left side
        // index is the first ship on the right side
        int index = new Random().nextInt(ships.size());
        ListIterator<Ship> iterator = ships.listIterator(index);

        // if there are more ships on the right side we start looking that side
        Ship currentShip;
        if (index < 50) {
            while (iterator.hasNext()) {
                currentShip = iterator.next();
                //System.out.println(currentShip);
                if (currentShip.contains("Covid Cough")) System.out.println(currentShip);
            }
            iterator = ships.listIterator(index);
            while (iterator.hasPrevious()) {
                currentShip = iterator.previous();
                //System.out.println(currentShip);
                if (currentShip.contains("Covid Cough")) System.out.println(currentShip);
            }
        } else {
            while (iterator.hasPrevious()) {
                currentShip = iterator.previous();
                //System.out.println(currentShip);
                if (currentShip.contains("Covid Cough")) System.out.println(currentShip);
            }
            iterator = ships.listIterator(index);
            while (iterator.hasNext()) {
                currentShip = iterator.next();
                //System.out.println(currentShip);
                if (currentShip.contains("Covid Cough")) System.out.println(currentShip);
            }

        }
    }
}
