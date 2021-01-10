/**
 * @author Dustin Eikmeier
 * @version 1.0
 * @since 1.8
 */

package exceptions;

public class StorableNotFoundException extends Exception {
    public StorableNotFoundException() {
    }

    public StorableNotFoundException(String message) {
        super(message);
    }

    public StorableNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public StorableNotFoundException(Throwable cause) {
        super(cause);
    }

    public StorableNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
