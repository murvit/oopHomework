package lesson11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VMurashkin on 18.06.2015.
 * Lesson11 task1
 */
public class ParseHtmlTask1 {

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

    public void parsePage(String page) {
        List<String> result = new ArrayList<>();
        int count = 0;
        while ((count = page.indexOf("href=", count + 1)) > -1) {
            result.add(page.substring(count + 6, page.indexOf('"', count + 7)));
        }
        for (String s : result) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {

        ParseHtmlTask1 pht = new ParseHtmlTask1();
        URL url = null;
        try {
            url = new URL("http://www.google.com");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        String page = pht.getPage(url);
        pht.parsePage(page);

    }

}
