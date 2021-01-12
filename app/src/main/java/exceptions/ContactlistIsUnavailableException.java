/**
 * @author Dustin Eikmeier
 * @version 1.0
 * @since 1.8
 */

package exceptions;

public class ContactlistIsUnavailableException extends Exception {
    public ContactlistIsUnavailableException() {
    }

    public ContactlistIsUnavailableException(String message) {
        super(message);
    }

    public ContactlistIsUnavailableException(String message, Throwable cause) {
        super(message, cause);
    }

    public ContactlistIsUnavailableException(Throwable cause) {
        super(cause);
    }

    public ContactlistIsUnavailableException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
