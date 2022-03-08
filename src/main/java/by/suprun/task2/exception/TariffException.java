package by.suprun.task2.exception;

public class TariffException extends Exception {

    public TariffException() {
        super();
    }

    public TariffException(String message) {
        super(message);
    }


    public TariffException(Exception cause) {
        super(cause);
    }

    public TariffException(String message, Exception exception) {
        super(message, exception);
    }
}
