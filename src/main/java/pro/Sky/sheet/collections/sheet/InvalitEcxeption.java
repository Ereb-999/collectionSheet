package pro.Sky.sheet.collections.sheet;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalitEcxeption extends  RuntimeException{

    public InvalitEcxeption() {
    }

    public InvalitEcxeption(String message) {
        super(message);
    }

    public InvalitEcxeption(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalitEcxeption(Throwable cause) {
        super(cause);
    }

    public InvalitEcxeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
