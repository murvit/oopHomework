package lesson10.userdatabasetask7;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by VMurashkin on 14.06.2015.
 * User database
 */
public class UserDatabase implements Serializable {
    Map<Integer, User> database = new TreeMap<>();


    public void add() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter name");
        String name = reader.readLine();
        System.out.println("Enter age");
        int age = Integer.parseInt(reader.readLine());
        System.out.println("Enter sex. (male/female)");
        String sSex = reader.readLine();
        Boolean sex = (sSex.equals("male"));
        User user = new User(name, age, sex);
        int userID = database.size() + 1;
        database.put(userID, user);
        System.out.println("User #" + userID + " added");
    }

    public void remove() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter User ID");
        int userID = Integer.parseInt(reader.readLine());
        if (database.containsKey(userID)) {
            database.remove(userID);
            System.out.println("User #" + userID + " removed");
        } else
            System.out.println("User #" + userID + " not found");
    }

    public void search() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter User ID");
        int userID = Integer.parseInt(reader.readLine());
        if (database.containsKey(userID)) {
            User user = database.get(userID);
            String userSex = (user.isSex() ? "male" : "female");
            System.out.println("User #" + userID + " Name:" + user.getName() + " Age: " + user.getAge() + " Sex: " + userSex);
        } else
            System.out.println("User #" + userID + " not found");
    }

    public void save(String path) {
        try (ObjectOutputStream ous = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File(path))));) {
            ous.writeObject(database);
            System.out.println("Saved OK");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(String path) {
        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File(path))));) {
            database = (Map<Integer , User>) ois.readObject();
            System.out.println("Loaded OK");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void list(){
        System.out.println("List of all users:");

        for (int i = 1; i <= database.size(); i++) {
            User user = database.get(i);
            String userSex = (user.isSex() ? "male" : "female");
            System.out.println("User #" + i + " Name:" + user.getName() + " Age: " + user.getAge() + " Sex: " + userSex);

        }
    }

    public void help(){
        System.out.println("'add' to add user");
        System.out.println("'search' to search user by ID");
        System.out.println("'remove' to remove user by ID");
        System.out.println("'load' to load database");
        System.out.println("'save' to save database");
        System.out.println("'exit to exit");

    }


}
