package lesson11;

import util.Constants;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VMurashkin on 18.06.2015.
 * Lesson11 task1 & 2
 */

public class HtmlTask12 {

    static URL url = null;


    public String getPage(URL url) {
        HttpURLConnection http = null;
        BufferedReader reader;
        StringBuilder sb = null;

        try {
            http = (HttpURLConnection) url.openConnection();
            reader = new BufferedReader(new InputStreamReader(http.getInputStream()));
            char[] buffer = new char[1024];
            sb = new StringBuilder();
            int r;
            try {
                while ((r = reader.read(buffer)) > 0) {
                    sb.append(buffer, 0, r);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (http != null)
                http.disconnect();
        }
        if (sb != null)
            return sb.toString();
        else
            return "";
    }

    public List<String> parsePage(String page) {
        List<String> result = new ArrayList<>();
        int count = 0;
        String strUrl;
        while ((count = page.indexOf("href=", count + 1)) > -1) {
            strUrl = page.substring(count + 6, page.indexOf('"', count + 7));
            if (strUrl.startsWith("/"))
                result.add(url.toString() + strUrl);
            else {
                if (strUrl.startsWith("http") || strUrl.startsWith("www"))
                    result.add(strUrl);
            }
        }
        for (String s : result) {
            System.out.println(s);
        }
        return result;
    }

    public static void main(String[] args) {
        String download = Constants.FILE_PATH_LESSON_11;
        HtmlTask12 pht = new HtmlTask12();

        try {
            url = new URL("http://www.java.com");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        String page = pht.getPage(url);
        //       System.out.println(page);
        List<String> urls = pht.parsePage(page);
        System.out.println("Writing all files to disk");
        for (int i = 0; i < urls.size(); i++) {
            File f = new File(download + "file" + i + ".txt");
            try {
                BufferedWriter fw = new BufferedWriter(new FileWriter(f));
                String path = urls.get(i);
                URL tmpURL = new URL(path);
                String text = pht.getPage(tmpURL);
                fw.write(text);
                fw.flush();
                System.out.println(path + " =====>   Write OK");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
