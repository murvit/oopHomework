package lesson3.developers;

/**
 * Created by User on 25.05.2015.
 * class MegaDeveloper
 */
public class MegaDeveloper extends Developer {

    public MegaDeveloper(String name, int basicSalary, int experience) {
        super(name, basicSalary, experience);
    }

    @Override
    public double getSalary() {
        return 0;
    }
}
