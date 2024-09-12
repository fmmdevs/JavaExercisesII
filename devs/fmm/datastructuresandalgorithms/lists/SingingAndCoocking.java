package devs.fmm.datastructuresandalgorithms.lists;

import java.util.List;

public class SingingAndCoocking {
    record CrewMember(String name, Profession profession) {
        enum Profession {CAPTAIN, NAVIGATOR, CARPENTER, COOK, MUSICIAN, DOCTOR}
    }

    static boolean areSameNumberOfCooksAndMusicians(List<CrewMember> crewMemberList) {

        return false;
    }

    public static void main(String[] args) {

        CrewMember captain = new CrewMember("CiaoCiao", CrewMember.Profession.CAPTAIN);
        CrewMember cook1 = new CrewMember("Remy", CrewMember.Profession.COOK);
        CrewMember cook2 = new CrewMember("The Witch Cook", CrewMember.Profession.COOK);
        CrewMember musician1 = new CrewMember("Mahna Mahna", CrewMember.Profession.MUSICIAN);
        CrewMember musician2 = new CrewMember("Rowlf", CrewMember.Profession.MUSICIAN);

        List<CrewMember> crew1 = List.of(cook1, musician1);
        System.out.println(crew1);
        System.out.println(areSameNumberOfCooksAndMusicians(crew1)); // true
        List<CrewMember> crew2 = List.of(cook1, musician1, musician2, captain);
        System.out.println(crew2);
        System.out.println(areSameNumberOfCooksAndMusicians(crew2)); // false
        List<CrewMember> crew3 = List.of(cook1, musician1, musician2, captain, cook2);
        System.out.println(crew3);
        System.out.println(areSameNumberOfCooksAndMusicians(crew3)); // true
    }
}
