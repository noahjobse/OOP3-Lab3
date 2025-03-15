package exceptions;

public class KeyNotFoundException extends Exception {
    /**
     * Serial version UID for KeyNotFoundException.
     */
    private static final long serialVersionUID = 682267963980463371L;

    /**
     * Constructs a new KeyNotFoundException with no detail message.
     */
    public KeyNotFoundException() {
        super();
    }

    /**
     * Constructs a new KeyNotFoundException with the specified detail message.
     *
     * @param message the error message specific to the cause of the error.
     */
    public KeyNotFoundException(String message) {
        super(message);
    }
}
