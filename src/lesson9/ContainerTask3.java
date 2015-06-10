package lesson9;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VMurashkin on 10.06.2015.
 * Lesson9 Task3
 */
public class ContainerTask3<T> {
    Object[] container;

    ContainerTask3(Object... obj) {
        container = obj;
    }

    public T get(int i) {
        return (T) container[i];
    }

    public static void main(String[] args) {
        ContainerTask3<Integer> ct1 = new ContainerTask3(1, 2, 3, 4, 5, 6);
        int first = ct1.get(0);
        ContainerTask3<String> ct2 = new ContainerTask3<>("1", "#", "fgg");
        String second = ct2.get(1);
        System.out.println("first element of first array is: " + first + "\nsecond element of second array is: " + second);
    }
}
