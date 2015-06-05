package lesson8.filesystemtask4;

import util.Constants;

import java.io.*;
import java.util.*;

/**
 * Created by VMurashkin on 05.06.2015.
 * Lesson 8 Task 4 Example of File system
 */

public class MyFileSystem extends MyDirectory implements Serializable {
    private static final long serialVersionUID = 1L;
    MyDirectory myCurrentDirectory;

    public MyFileSystem() {
        myCurrentDirectory = new MyDirectory("main");
    }

    public void help() {
        System.out.println("Help: press 'dir' to print all files and directories in current directory");
        System.out.println("'help' for help");
        System.out.println("'md name' to make directory");
        System.out.println("'rd name' to remove directory and all files in it");
        System.out.println("'mf name' to make file");
        System.out.println("'rf name' to remove file");
        System.out.println("'cd directory' to change directory");
        System.out.println("'back' to parent directory");
        System.out.println("'save' to save current File system");
        System.out.println("'load' to load File sysytem from disk");
        System.out.println("'exit' to exit without saving File system");
    }

    public void dir() {
        System.out.println("Current directory: " + myCurrentDirectory);
        if (!myCurrentDirectory.name.equals("main"))
            System.out.println("..");
        for (MyDirectory md : myCurrentDirectory.myDirectories)
            System.out.println("D." + md.name);
        for (MyFile mf : myCurrentDirectory.myFiles)
            System.out.println("F." + mf.name);
        System.out.println("Directories: " + myCurrentDirectory.myDirectories.size());
        System.out.println("Files: " + myCurrentDirectory.myFiles.size());
    }

    public void mf(String name) {
        myCurrentDirectory.myFiles.add(new MyFile(name));
        dir();
    }

    public void md(String name) {
        MyDirectory d = new MyDirectory(name);
        d.myParentDirectory = this.myCurrentDirectory;
        myCurrentDirectory.myDirectories.add(d);
        dir();
    }

    public void rd(String name) {
        Iterator<MyDirectory> it = myCurrentDirectory.myDirectories.iterator();
        while (it.hasNext()) {
            MyDirectory md = it.next();
            if (md.name.equals(name))
                it.remove();
        }
        dir();
    }

    public void rf(String name) {
        Iterator<MyFile> it = myCurrentDirectory.myFiles.iterator();
        while (it.hasNext()) {
            MyFile mf = it.next();
            if (mf.name.equals(name))
                it.remove();
        }
        dir();
    }

    public void cd(String name) {
        Iterator<MyDirectory> it = myCurrentDirectory.myDirectories.iterator();
        while (it.hasNext()) {
            MyDirectory md = it.next();
            if (md.name.equals(name))
                this.myCurrentDirectory = md;
        }
        dir();
    }

    public void back() {
        if (!this.myCurrentDirectory.name.equals("main"))
            this.myCurrentDirectory = this.myCurrentDirectory.myParentDirectory;
        dir();
    }

    public void save() {
        try (FileOutputStream fs = new FileOutputStream(Constants.FILE_PATH_LESSON_8 + "files.txt");
             ObjectOutputStream ous = new ObjectOutputStream(fs)) {
            ous.writeObject(this);
            System.out.println("Saved ok");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public MyFileSystem load() {
        MyFileSystem m = new MyFileSystem();
        try (FileInputStream fs = new FileInputStream(Constants.FILE_PATH_LESSON_8 + "files.txt");
             ObjectInputStream ois = new ObjectInputStream(fs)) {
            m = (MyFileSystem) ois.readObject();
            System.out.println("Loaded ok");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return m;
    }
}

