package lesson4.compare.humans;

import java.util.Comparator;

/**
 * Created by VMurashkin on 26.05.2015.
 * class HumanReverseComparator
 */
class HumanReverseComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Human h1 = (Human) o1;
        Human h2 = (Human) o2;
        if (h1.getAge() < h2.getAge())
            return 1;
        else if (h1.getAge() == h2.getAge())
            return 0;
        else if (h1.getAge() > h2.getAge())
            return -1;
        return 0; // make compiler happy
    }
}
