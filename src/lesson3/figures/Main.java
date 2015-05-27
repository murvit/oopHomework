package lesson3.figures;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by VMurashkin on 25.05.2015.
 * Counting
 */
public class Main {
    public static void main(String[] args) {
        List<Figure> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            if (random.nextInt(2) == 1)
                list.add(new Rectangle(random.nextDouble()*30, random.nextDouble()*30));
            else
                list.add(new Circle(random.nextDouble()*30));
        }
        for (Figure f : list) {
            System.out.println(f);
            System.out.println("Square is:" + f.coountSquare());
        }

    }

}
