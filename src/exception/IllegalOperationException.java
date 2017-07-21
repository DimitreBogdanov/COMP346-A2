package exception;

/**
 * Created by dimitrebogdanov on 2017-07-20.
 */
public class IllegalOperationException extends RuntimeException {
    public IllegalOperationException(String message) {
        super(message);
    }
}
