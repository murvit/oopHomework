package lesson4.compare.figures;

import java.util.*;

/**
 * Created by VMurashkin on 25.05.2015.
 *
 */
public class Main {
    public static void main(String[] args) {
        List<Figure> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            if (random.nextInt(2) == 1)
                list.add(new Rectangle(random.nextDouble() * 30, random.nextDouble() * 30));
            else
                list.add(new Circle(random.nextDouble() * 30));
        }
        System.out.println("List of figures");
        for (Figure f : list) {
            System.out.println(f);
            System.out.println("Square is:" + f.coountSquare());
        }

        System.out.println("\nList of sorted figures");
        Collections.sort(list, new FigureComparator());
        for (Figure f : list) {
            System.out.println(f);
            System.out.println("Square is:" + f.coountSquare());
        }

    }
}
