package lesson3.Exceptions.MyInteger;

/**
 * Created by VMurashkin on 26.05.2015.
 */
public class NoDigitException extends Exception {
    public NoDigitException(String message) {
        super(message);
    }
}
