package lesson7.recursion.monitiortask2;

import java.io.File;
import java.util.List;

public class FileEvent implements IFileEvent {
	@Override
	public void direcoryChanged(List<File> l) {
		System.out.println("Directory changed");
	}
}
