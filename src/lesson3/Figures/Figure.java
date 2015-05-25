package lesson3.Figures;

/**
 * Created by VMurashkin on 25.05.2015.
 */
public abstract class Figure {
    protected String name;

    Figure(){
        this.name=name;
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
