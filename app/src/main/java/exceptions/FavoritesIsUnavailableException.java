/**
 * @author Dustin Eikmeier
 * @version 1.0
 * @since 1.8
 */

package exceptions;

public class FavoritesIsUnavailableException extends Exception {
    public FavoritesIsUnavailableException() {
    }

    public FavoritesIsUnavailableException(String message) {
        super(message);
    }

    public FavoritesIsUnavailableException(String message, Throwable cause) {
        super(message, cause);
    }

    public FavoritesIsUnavailableException(Throwable cause) {
        super(cause);
    }

    public FavoritesIsUnavailableException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
