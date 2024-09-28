package devs.fmm.datastructuresandalgorithms.lists;

public class MusicalChairsUse {
    public static void main(String[] args) {
        MusicalChairs ms = new MusicalChairs("Juan", "Pablo", "Rodolfo", "Julia", "Roberto", "Chuty");
        System.out.println(ms);
        ms.rotate(1);
        System.out.println(ms);

        System.out.println(ms.play());
        System.out.println(ms);
    }
}
