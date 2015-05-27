package lesson4.compare.figures;

import java.util.Comparator;

/**
 * Created by VMurashkin on 26.05.2015.
 *
 */
public class FigureComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Figure figure1 = (Figure) o1;
        Figure figure2 = (Figure) o2;
        if (figure1.square > figure2.square)
            return 1;
        else if (figure1.square == figure2.square)
            return 0;
        else if (figure1.square < figure2.square)
            return -1;
        return 0;
    }
}
