package lesson4.compare2.humans2;

import java.util.Arrays;

/**
 * Created by VMurashkin on 26.05.2015.
 *
 */
public class Main {
    public static void main(String[] args) {
        Human[] list = {
                new Human(40), new Human(20), new Human(3), new Human(7)
        };
        Arrays.sort(list, new HumanComparator());
        for (Human h : list)
            System.out.println(h.getAge());
        Arrays.sort(list, new HumanReverseComparator());
        for (Human h : list)
            System.out.println(h.getAge());
    }
}
