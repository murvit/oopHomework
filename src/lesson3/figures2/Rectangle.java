package lesson3.figures2;

/**
 * Created by VMurashkin on 25.05.2015.
 *
 */

public class Rectangle extends Figure {
    double height;
    double width;
    Rectangle (double height, double width){
        this.height = height;
        this.width=width;
        this.name="Rectangle";
    }

    @Override
    public double coountSquare() {
        return width*height;
    }
}
