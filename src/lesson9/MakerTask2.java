package lesson9;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VMurashkin on 10.06.2015.
 * Lesson9 Task2
 */
public class MakerTask2 {

    public List<String> makeAndDelete() {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            result.add("str" + i);

        result.remove(0);
        result.remove(0);
        result.remove(result.size() - 1);
        return result;
    }

    public static void main(String[] args) {
        MakerTask2 mt = new MakerTask2();
        List<String> list = mt.makeAndDelete();
        System.out.println(list);
    }
}
