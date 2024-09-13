package devs.fmm.datastructuresandalgorithms.lists;

import java.util.ArrayList;
import java.util.List;

public class EatingWithFriends {
    public record Guest(
            boolean likesToShoot,
            boolean likesToGamble,
            boolean likesBlackmail
    ) {
        public boolean similarInterest(Guest guest) {
            return ((this.likesToShoot() == guest.likesToShoot()) || (this.likesToGamble() == guest.likesToGamble()) || (this.likesBlackmail() == guest.likesBlackmail()));
        }
    }


    static int allGuestsHaveSimilarInterests(List<Guest> guests) {



        for (int i = 1; i < guests.size(); i ++) {
            Guest guest0 = guests.get(i - 1);
            Guest guest1 = guests.get(i);
            System.out.printf("i:%d.%n\tGuest %d: %s.%n \tGuest %d: %s.%n", i, i - 1, guests.get(i - 1), i, guests.get(i));
            System.out.println("\tSimilar interest: "+ guest0.similarInterest(guest1));
            if (guest1.similarInterest(guest0)) {
                continue;
            } else {
                return i;
            }
        }




        return 1;
    }

    public static void main(String[] args) {

        List<Guest> guests = new ArrayList<>();
        guests.add(new Guest(true, false, true));
        guests.add(new Guest(false, false, true));
        guests.add(new Guest(false, false, false));
        guests.add(new Guest(true, false, true));
        guests.add(new Guest(true, false, true));
        guests.add(new Guest(true, false, true));
        guests.add(new Guest(true, false, true));
        System.out.println(allGuestsHaveSimilarInterests(guests));


        List<Guest> guests1 = new ArrayList<>();
        guests1.add(new Guest(true, false, true));
        guests1.add(new Guest(false, false, true));
        guests1.add(new Guest(false, false, false));
        guests1.add(new Guest(true, true, true));
        guests1.add(new Guest(true, false, true));
        guests1.add(new Guest(true, false, true));
        guests1.add(new Guest(true, false, true));
        guests1.add(new Guest(true, false, true));
        System.out.println(allGuestsHaveSimilarInterests(guests1));

        List<Guest> guests2 = new ArrayList<>();
        guests2.add(new Guest(true, false, true));
        guests2.add(new Guest(false, false, true));
        guests2.add(new Guest(false, false, false));
        guests2.add(new Guest(true, false, true));
        guests2.add(new Guest(true, false, true));
        guests2.add(new Guest(true, false, true));
        guests2.add(new Guest(true, false, true));
        guests2.add(new Guest(true, false, true));
        guests2.add(new Guest(false, true, false));

        System.out.println(allGuestsHaveSimilarInterests(guests2));
    }
}
