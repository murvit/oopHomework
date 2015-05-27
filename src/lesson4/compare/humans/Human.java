package lesson4.compare.humans;

/**
 * Created by VMurashkin on 26.05.2015.
 *
 */
class Human implements Comparable {
    private int age;
    public Human(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }
    @Override
    public int compareTo(Object another) {
        Human h = (Human) another;
        if (age < h.age)
            return -1;
        else if (age == h.age)
            return 0;
        else if (age > h.age)
            return 1;
        else
            return 0; // make compiler happy
    }
}