/**
 * @author Dustin Eikmeier
 * @version 1.0
 * @since 1.8
 */

package exceptions;

public class ContactlistIsUsedException extends Exception {
    public ContactlistIsUsedException() {
    }

    public ContactlistIsUsedException(String message) {
        super(message);
    }

    public ContactlistIsUsedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ContactlistIsUsedException(Throwable cause) {
        super(cause);
    }

    public ContactlistIsUsedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
