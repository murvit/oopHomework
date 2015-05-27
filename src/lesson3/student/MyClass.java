package lesson3.student;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MyClass {

    public static void main(String[] args) {
        StudentList sl = new StudentList();
        EnterStudents es = new EnterStudents();
        Date birth=null;
        SimpleDateFormat sf = new SimpleDateFormat("yyyy.MM.dd");



        try {
            sl = es.fill();
        } catch (EnterStudents.SurnameNullException | ParseException e) {
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
            birth = sf.parse("1988.06.06");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        students = sl.findByBirth(birth);
        System.out.println("Students with birthday 1988.06.06");
        for (Student s : students)
            System.out.println(s);

        System.out.println("Printing students");
        for (int i = 0; i < 5; i++)
            System.out.println(sl.get(i));

        System.out.println("Deleting Student #3");
        sl.deleteStudent(3);

        System.out.println("Printing students");
        for (int i = 0; i < 5; i++)
            System.out.println(sl.get(i));
    }
}
