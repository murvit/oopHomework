package lesson3.Developers;

/**
 * Created by User on 25.05.2015.
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
