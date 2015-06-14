package lesson10;

import util.Constants;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by VMurashkin on 12.06.2015.
 * Lesson 10 Task 1-2
 */
public class DictionaryTask12 implements Serializable {

    private static Map<String, String> vocabulary = new HashMap<>();

    DictionaryTask12() {

    }

    DictionaryTask12(String path) {
        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(path)));
        ) {
            vocabulary = (Map<String, String>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void translate(String word) {
        String result = vocabulary.get(word);
        if (result == null)
            System.out.println("I don`t know what is '" + word + "' try add it to vocabulary");
        else
            System.out.println(result);
    }

    public void add(Map<String, String> dict, String key, String value) {
        dict.put(key, value);
    }

    public void help() {
        System.out.println("Enter word to translate it");
        System.out.println("Enter `word1=word2` to add word1 and its translation (word2) to vocabulary");
        System.out.println("Enter `!save` to save vocabulary");
        System.out.println("Enter `!exit` to exit");
    }

    public void save(String path) {
        try (ObjectOutputStream ous = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(path)));
        ) {
            ous.writeObject(vocabulary);
            System.out.println("Saved OK");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        DictionaryTask12 dictionary = new DictionaryTask12(Constants.FILE_PATH_LESSON_10 + "voc.txt");
        dictionary.help();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String word = reader.readLine();
            if (word.equals("!exit"))
                break;
            else if (word.equals("!save")) {
                dictionary.save(Constants.FILE_PATH_LESSON_10 + "voc.txt");
            } else if (word.contains("=")) {
                String word1 = word.substring(0, word.indexOf("="));
                String word2 = word.substring(word.indexOf("=")+1);
                System.out.println("word = '" + word1 + "` translate = '" + word2+"`");
                dictionary.add(vocabulary, word1, word2);
            } else {
                dictionary.translate(word);
            }
        }
    }

}
