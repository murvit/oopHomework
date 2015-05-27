package lesson3.figures;

/**
 * Created by VMurashkin on 25.05.2015.
 * class Figure
 */
public abstract class Figure {
    protected String name;

    Figure(){

    }

    public String getName() {
        return name;
    }

    public abstract double coountSquare();

    @Override
    public String toString() {
        return "Figure{" +
                "name='" + name + '\'' +
                '}';
    }
}
