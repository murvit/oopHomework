package lesson3.figures2;

/**
 * Created by VMurashkin on 25.05.2015.
 * class Circle
 */
public class Circle extends Figure {
    double radius;

    Circle(double radius) {
        this.radius = radius;
        this.name = "Circle";
    }

    @Override
    public double coountSquare() {
        return Math.PI * radius * radius;
    }
}
