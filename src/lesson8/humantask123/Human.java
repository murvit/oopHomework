package lesson8.humantask123;

import util.Constants;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by VMurashkin on 05.06.2015.
 * Lesson 8 Task 1-3
 */

public class Human implements Serializable {
    String name, surname;
    int age;
    boolean sex;

    public Human() {
    }

    public Human(String name, String surname, int age, boolean sex) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.sex = sex;
    }

    public void saveHuman() {
        try (FileOutputStream fs = new FileOutputStream(Constants.FILE_PATH_LESSON_8 + "humans.txt");
             ObjectOutputStream ous = new ObjectOutputStream(fs)
        ) {
            ous.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Human readHuman() {
        Human human = new Human();
        try (FileInputStream fs = new FileInputStream(Constants.FILE_PATH_LESSON_8 + "humans.txt");
             ObjectInputStream ous = new ObjectInputStream(fs)
        ) {
            human = (Human) ous.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return human;
    }

    public static void saveHumans(Set<Human> humans) {
        try (FileOutputStream fs = new FileOutputStream(Constants.FILE_PATH_LESSON_8 + "humans.txt");
             ObjectOutputStream ous = new ObjectOutputStream(fs)
        ) {
            for (Human h : humans)
                ous.writeObject(h);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Set<Human> readHumans(int numberOfHumans) {
        Human human = new Human();
        Set<Human> humans = new HashSet<>();
        try (FileInputStream fs = new FileInputStream(Constants.FILE_PATH_LESSON_8 + "humans.txt");
             ObjectInputStream ous = new ObjectInputStream(fs)
        ) {
            for (int i = 0; i < numberOfHumans; i++) {
                human = (Human) ous.readObject();
                humans.add(human);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return humans;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Human that = (Human) o;

        if (age != that.age) return false;
        if (sex != that.sex) return false;
        if (!name.equals(that.name)) return false;
        return surname.equals(that.surname);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + age;
        result = 31 * result + (sex ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "HumanTask1{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
