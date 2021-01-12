/**
 * @author Dustin Eikmeier
 * @version 1.0
 * @since 1.8
 */

package exceptions;

public class ActionNotFoundException extends StorableNotFoundException {
    public ActionNotFoundException() {
    }

    public ActionNotFoundException(String message) {
        super(message);
    }

    public ActionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ActionNotFoundException(Throwable cause) {
        super(cause);
    }

    public ActionNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
