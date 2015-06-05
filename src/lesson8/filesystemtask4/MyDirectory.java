package lesson8.filesystemtask4;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by VMurashkin on 05.06.2015.
 * Example of Directory
 */

public class MyDirectory extends MyFile implements Serializable{

    Set<MyFile> myFiles = new HashSet<>();
    Set<MyDirectory> myDirectories = new HashSet<>();
    MyDirectory myParentDirectory;

    public MyDirectory (){
        super();
    }

    public MyDirectory(String name) {
        super(name);
    }
}
