package lesson3.developers;

public class Main {

    public static void main(String[] args) {
        Developer[] list = {
                new JuniorDeveloper("Mike", 500, 0),
                new JuniorDeveloper("Dima", 500, 1),
                new JuniorDeveloper("Vova", 500, 2),
                new SeniorDeveloper("Jack", 500, 5),
                new SeniorDeveloper("Nick", 500, 11),
                new SeniorDeveloper("Kot", 500, 15),
                new TeamLeadDeveloper("Robby", 500, 7),
                new TeamLeadDeveloper("Bobby", 500, 15),
                new TeamLeadDeveloper("Willy", 500, 25),
                new MegaDeveloper("Vit", 500, 9)
        };

        FindPrint fp = new FindPrint();
        fp.findSeniorMore1500(list);
        fp.threeLists(list);


    }
}
