package pro.Sky.sheet.collections.sheet;

public class Ecxeption extends RuntimeException{
    public Ecxeption() {
    }

    public Ecxeption(String message) {
        super(message);
    }

    public Ecxeption(String message, Throwable cause) {
        super(message, cause);
    }

    public Ecxeption(Throwable cause) {
        super(cause);
    }

    public Ecxeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
