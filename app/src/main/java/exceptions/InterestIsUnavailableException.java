/**
 * @author Dustin Eikmeier
 * @version 1.0
 * @since 1.8
 */

package exceptions;

public class InterestIsUnavailableException extends Exception {
    public InterestIsUnavailableException() {
    }

    public InterestIsUnavailableException(String message) {
        super(message);
    }

    public InterestIsUnavailableException(String message, Throwable cause) {
        super(message, cause);
    }

    public InterestIsUnavailableException(Throwable cause) {
        super(cause);
    }

    public InterestIsUnavailableException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
