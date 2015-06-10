package lesson9.monitor;

import java.io.File;

public interface IFileEvents {
    void onFileAdded(File path);
    void onFileDeleted(File path);
    void onFileChanged(File path);
}
