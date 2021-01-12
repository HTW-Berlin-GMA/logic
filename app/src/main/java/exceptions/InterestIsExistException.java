/**
 * @author Dustin Eikmeier
 * @version 1.0
 * @since 1.8
 */

package exceptions;

public class InterestIsExistException extends Exception {
    public InterestIsExistException() {
    }

    public InterestIsExistException(String message) {
        super(message);
    }

    public InterestIsExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public InterestIsExistException(Throwable cause) {
        super(cause);
    }

    public InterestIsExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
