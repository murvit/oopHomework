package lesson3.student2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentList {
    private Student[] list = new Student[100];
    private int p = 0;

    public void add(Student s) {
        list[p++] = s;
    }

    public Student get(int n) {
        return list[n];
    }

    public List<Student> findByName(String name) {
        List<Student> result = new ArrayList<>();
        for (int i = 0; i < p; i++) {
            if (list[i].getName().equalsIgnoreCase(name))
                result.add(list[i]);
        }
        return result;
    }

    public List<Student> findBySurname(String surname) {
        List<Student> result = new ArrayList<>();
        for (int i = 0; i < p; i++) {
            if (list[i].getSurname().equalsIgnoreCase(surname))
                result.add(list[i]);
        }
        return result;
    }

    public List<Student> findByBirth(Date date) {
        List<Student> result = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            if (list[i].getBirth().equals(date))
                result.add(list[i]);
        }
        return result;
    }

    public void deleteStudent(int num) {
        System.arraycopy(this.list, num, this.list, num-1, 100-num);
        this.list[99]=null;
    }

}
