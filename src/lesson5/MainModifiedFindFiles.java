package lesson5;

import util.Constants;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainModifiedFindFiles {

    static class MyFileFilter implements FilenameFilter {
        private String ext;

        public MyFileFilter(String ext) {
            this.ext = ext;
        }

        public boolean accept(File dir, String name) {
            return name.endsWith(ext);
        }
    }

    private static void findFiles(String srcPath, List<String> extList, List<String> list) throws IOException {
        File dir = new File(srcPath);
        List<File> files= new ArrayList<>();

        for (String ext:extList) {
            File arrTmpFiles [] = dir.listFiles(new MyFileFilter(ext));
            files.addAll(Arrays.asList(arrTmpFiles));
        }

        for (File file :files) {
            list.add(srcPath + file.getName());
        }
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> extList = new ArrayList<>();
        extList.add(".txt");
        extList.add(".mur");
        try {
            findFiles(Constants.FILE_PATH_LESSON_5, extList, list);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String s : list)
            System.out.println(s);
    }

}