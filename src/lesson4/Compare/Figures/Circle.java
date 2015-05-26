package lesson4.Compare.Figures;

/**
 * Created by VMurashkin on 25.05.2015.
 *
 */
public class Circle extends Figure {
    double radius;

    Circle(double radius) {
        this.radius = radius;
        this.name = "Circle";
    }

    @Override
    public double coountSquare() {
        this.square = Math.PI * radius * radius;
        return this.square;
    }
}
