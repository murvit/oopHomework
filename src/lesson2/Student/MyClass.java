package lesson2.Student;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class MyClass {

    public static void main(String[] args) {
        StudentList sl = new StudentList();
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy.MM.dd");
        try {
            sl.add(new Student("Seva", "Evgienko", sf.parse("1986.1.1")));
            sl.add(new Student("Vasya", "Pupkin", sf.parse("1970.3.28")));
            sl.add(new Student("Vasya", "Gaikin", sf.parse("1988.5.6")));
            sl.add(new Student("Vit", "Mur", sf.parse("1974.8.8")));
            sl.add(new Student("Lia", "Mur", sf.parse("1980.8.28")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<Student> students = sl.findByName("Vasya");
        System.out.println("Students with name Vasya:");
        for (Student s : students)
            System.out.println(s);

        students = sl.findBySurname("Mur");
        System.out.println("Students with surname Mur");
        for (Student s : students)
            System.out.println(s);

        try {
            students = sl.findByBirth(sf.parse("1988.5.6"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Students with birthday 1988.05.06");
        for (Student s : students)
            System.out.println(s);

        System.out.println("Printing students");
        for (int i = 0; i < 5; i++)
            System.out.println(sl.get(i));

        System.out.println("Deleting student #3");
        sl.deleteStudent(3);


        System.out.println("Printing students");
        for (int i = 0; i < 5; i++)
            System.out.println(sl.get(i));
    }
}
