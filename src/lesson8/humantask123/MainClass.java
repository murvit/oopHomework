package lesson8.humantask123;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by VMurashkin on 05.06.2015.
 * Lesson 8 Task 1-3
 */
public class MainClass {

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        Set<Human> humans = new HashSet<>();
        Set<Human> humansReaded = new HashSet<>();

        for (int i = 1; i < 11; i++) {
            Human human = new Human();
            System.out.println("Human #" + i);
            System.out.println("Enter name:");
            human.name = sc.readLine();
            if (human.name.equals("") || human.name.isEmpty())
                human.name = "Name" + i;
            System.out.println("Enter surname:");
            human.surname = sc.readLine();
            if (human.surname.equals("") || human.surname.isEmpty())
                human.surname = "Surname" + i;
            System.out.println("Enter age:");
            String sage = sc.readLine();
            if (sage.equals("") || sage.isEmpty())
                sage = "18";
            human.age = Integer.parseInt(sage);
            System.out.println("Enter sex");
            String ssex = sc.readLine();
            human.sex = Boolean.parseBoolean(ssex);
            humans.add(human);
        }
        Human.saveHumans(humans);
        int numberOfHumans = humans.size();
        System.out.println("All human are saved! You save " + numberOfHumans + " humans");
        System.out.println("Now reading humans");
        humansReaded = Human.readHumans(numberOfHumans);
        for (Human h : humansReaded)
            System.out.println(h);
    }
}


