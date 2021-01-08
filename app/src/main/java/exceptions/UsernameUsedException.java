/**
 * @author Dustin Eikmeier
 * @version 1.0
 * @since 1.8
 */

package exceptions;

public class UsernameUsedException extends Exception {
    public UsernameUsedException() {
    }

    public UsernameUsedException(String message) {
        super(message);
    }

    public UsernameUsedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsernameUsedException(Throwable cause) {
        super(cause);
    }

    public UsernameUsedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
