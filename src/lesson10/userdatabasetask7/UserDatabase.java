package lesson10.userdatabasetask7;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by VMurashkin on 14.06.2015.
 * User database
 */
public class UserDatabase implements Serializable {

    Map<Integer, User> database;
    IDatabaseWork work;

    public UserDatabase(IDatabaseWork work) {
        this.database = new TreeMap<>();
        this.work = work;
    }

    public void add() throws IOException {
        work.add(database);
    }

    public void remove() throws IOException {
        work.remove(database);
    }

    public void search() throws IOException {
        work.search(database);
    }

    public void save(String path) {
        work.save(database, path);
    }

    public void load(String path) {
        database = work.load(database, path);
    }

    public void list() {
        work.list(database);
    }

    void help() {
        work.help();
    }

}
