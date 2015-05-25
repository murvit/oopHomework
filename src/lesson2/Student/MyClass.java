package lesson2.Student;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MyClass {

    public static void main(String[] args) {
        StudentList sl = new StudentList();
        Calendar cal = Calendar.getInstance();
        cal.set(1986, 1, 1);
        sl.add(new Student("Seva", "Evgienko", cal.getTime()));
        cal.set(1970, 3, 28);
        sl.add(new Student("Vasya", "Pupkin", cal.getTime()));
        cal.set(1988, 5, 6);
        sl.add(new Student("Vasya", "Gaikin", cal.getTime()));
        cal.set(1974, 8, 8);
        sl.add(new Student("Vit", "Mur", cal.getTime()));
        cal.set(1980, 8, 28);
        sl.add(new Student("Lia", "Mur", cal.getTime()));

        List<Student> students = sl.findByName("Vasya");
        System.out.println("Students with name Vasya:");
        for (Student s : students)
            System.out.println(s);

        students = sl.findBySurname("Mur");
        System.out.println("Students with surname Mur");
        for (Student s : students)
            System.out.println(s);

        ///cal.set(1974, 8, 8);
        // = sl.findByBirth(cal);
        //System.out.println(s);


    }
}
