import data.storable.user.User;
import data.storage.ActionsStorage;
import data.storage.Storage;
import data.storage.UserStorage;

import java.math.BigDecimal;

/**
 * @author Dustin Eikmeier
 * @version 1.0
 * @since 1.8
 */

public class BusinessLogic {
    private Storage storageUser;
    private Storage storageActions;

    public BusinessLogic(BigDecimal sizeStorageUsers, BigDecimal sizeStorageActions) {
        this.storageActions = new UserStorage(sizeStorageUsers);
        this.storageActions = new ActionsStorage(sizeStorageActions);
    }
}
