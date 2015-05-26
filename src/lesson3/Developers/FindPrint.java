package lesson3.Developers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 25.05.2015.
 * class FindPrint
 */
public class FindPrint {

    public void findSeniorMore1500(Developer [] list) {
        System.out.println("Seniors with salary more than 1500:");
        for (Developer d : list) {
            if (d instanceof SeniorDeveloper && d.getSalary() > 1500) {
                System.out.println(d + " full salary: " + d.getSalary());
            }
        }
    }

    public void threeLists (Developer [] list){
        List<Developer> juniors = new ArrayList<>();
        List<Developer> seniors = new ArrayList<>();
        List<Developer> teamLeads = new ArrayList<>();

        for (Developer d: list){
            if (d instanceof  JuniorDeveloper)
                juniors.add(d);
            else if (d instanceof SeniorDeveloper)
                seniors.add(d);
            else if (d instanceof TeamLeadDeveloper)
                teamLeads.add(d);
        }
        System.out.println("Juniors: ");
        for (Developer d :juniors)
            System.out.println(d);
        System.out.println("Seniors: ");
        for (Developer d :seniors)
            System.out.println(d);
        System.out.println("Team leads: ");
        for (Developer d :teamLeads)
            System.out.println(d);

    }
}
