package lesson8.filesystem;

import java.io.Serializable;

/**
 * Created by VMurashkin on 05.06.2015.
 * Example of file
 */


public class MyFile implements Serializable{
    String name;
//    MyDirectory myParentDirectory;
//    MyFileSystem myFileSystem;

    public MyFile(String name) {
        this.name = name;
 //       myParentDirectory = myFileSystem.myDirectories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyFile myFile = (MyFile) o;

        return name.equals(myFile.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public MyFile() {
    }

    @Override
    public String toString() {
        return name;
    }
}
