package lesson4.compare.figures;

/**
 * Created by VMurashkin on 25.05.2015.
 *
 */
public abstract class Figure{
    protected String name;
    double square;

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
