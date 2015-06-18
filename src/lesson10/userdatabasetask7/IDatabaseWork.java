package lesson10.userdatabasetask7;

import java.io.IOException;
import java.util.Map;

/**
 * Created by VMurashkin on 18.06.2015.
 * Interface to work with database
 */
public interface IDatabaseWork {

    void add(Map<Integer, User> database) throws IOException;

    void remove(Map<Integer, User> database) throws IOException;

    void search(Map<Integer, User> database) throws IOException;

    void save(Map<Integer, User> database, String path);

    Map<Integer, User> load(Map<Integer, User> database, String path);

    void list(Map<Integer, User> database);

    void help();

}
