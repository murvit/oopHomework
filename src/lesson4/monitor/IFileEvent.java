package lesson4.monitor;

import java.io.File;

public interface IFileEvent {
	void onFileAdded(File f);
}
