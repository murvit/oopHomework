package lesson9.monitor;

import java.util.Map;

public interface IFileEvents {
    void onFileAdded(Map.Entry path);
    void onFileDeleted(Map.Entry path);
    void onFileChanged(Map.Entry path);
}
