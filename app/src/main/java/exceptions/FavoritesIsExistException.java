/**
 * @author Dustin Eikmeier
 * @version 1.0
 * @since 1.8
 */

package exceptions;

public class FavoritesIsExistException extends Exception {
    public FavoritesIsExistException() {
    }

    public FavoritesIsExistException(String message) {
        super(message);
    }

    public FavoritesIsExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public FavoritesIsExistException(Throwable cause) {
        super(cause);
    }

    public FavoritesIsExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
