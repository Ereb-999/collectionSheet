package pro.Sky.sheet.collections.sheet;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_GATEWAY)
public class EcxeptionRuntim extends RuntimeException{
    public EcxeptionRuntim() {
    }

    public EcxeptionRuntim(String message) {
        super(message);
    }

    public EcxeptionRuntim(String message, Throwable cause) {
        super(message, cause);
    }

    public EcxeptionRuntim(Throwable cause) {
        super(cause);
    }

    public EcxeptionRuntim(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
