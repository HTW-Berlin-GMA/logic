import data.storable.user.User;
import data.storage.ActionsStorage;
import data.storage.Storage;
import data.storage.UserStorage;
import exceptions.StorableNotFoundException;
import models.LogicModels;
import models.user.LogicUsers;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * @author Dustin Eikmeier
 * @version 1.0
 * @since 1.8
 */

public class BusinessLogic {
    private Storage storageUser;
    private Storage storageActions;
    private LogicModels logicUsers;
    private LogicModels logicActionsFreedom;
    private LogicModels logicActionsNeighbourhood;

    public BusinessLogic(BigDecimal sizeStorageUsers, BigDecimal sizeStorageActions) {
        this.storageUser = new UserStorage(sizeStorageUsers);
        this.storageActions = new ActionsStorage(sizeStorageActions);
        this.logicUsers = new LogicUsers(sizeStorageUsers);
        this.logicActionsFreedom = new LogicUsers(sizeStorageActions);
        this.logicActionsNeighbourhood = new LogicUsers(sizeStorageActions);
    }

    public UUID user_add(String username) {
        return this.logicUsers.create(username);
    }

    public User user_show(UUID id) throws StorableNotFoundException {
        return (User) this.logicUsers.read(id);
    }


    public Storage getStorageUser() {
        return this.storageUser;
    }

    public Storage getStorageActions() {
        return this.storageActions;
    }

    public LogicModels getLogicUsers() {
        return this.logicUsers;
    }

    public LogicModels getLogicActionsFreedom() {
        return this.logicActionsFreedom;
    }

    public LogicModels getLogicActionsNeighbourhood() {
        return this.logicActionsNeighbourhood;
    }

    public boolean clear() {
        this.storageUser.getList().clear();
        this.storageActions.getList().clear();
        return true;
    }
}
