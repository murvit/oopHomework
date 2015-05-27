package lesson3.student2;

import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by VMurashkin on 26.05.2015.
 * class EnterStudents
 */
public class EnterStudents {
    String name, surname;
    Date birth = null;
    Scanner sc = new Scanner(new InputStreamReader(System.in));
    SimpleDateFormat sf = new SimpleDateFormat("yyyy.MM.dd");
    StudentList sl = new StudentList();


    public StudentList fill() throws SurnameNullException, ParseException {
        while (true) {
            System.out.println("Enter name: (Press Enter to stop)");
            name = sc.nextLine();
            if (name.isEmpty()) break;
            System.out.println("Enter Surname:");
            surname = sc.nextLine();
            if (surname.isEmpty())
                throw new SurnameNullException("Surname is null");
            System.out.println("Enter date of birth (yyyy.MM.dd):");
            String stringDate = sc.nextLine();
            birth = sf.parse(stringDate);
            sl.add(new Student(name, surname, birth));
        }
        return sl;

    }

    class SurnameNullException extends Exception {
        public SurnameNullException(String message) {
            super(message);
        }

    }
}
