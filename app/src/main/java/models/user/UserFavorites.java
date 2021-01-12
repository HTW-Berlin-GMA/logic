/**
 * @author Dustin Eikmeier
 * @version 1.0
 * @since 1.8
 */

package models.user;

import data.storable.actions.Actions;
import data.storable.user.User;
import data.storage.Storage;
import exceptions.FavoritesIsExistException;
import exceptions.FavoritesIsUnavailableException;
import exceptions.UserNotFoundException;

import java.util.List;
import java.util.UUID;

public class UserFavorites {
    private Storage storageUsers;
    private Storage storageActions;

    public UserFavorites(Storage storageUsers, Storage storageActions) {
        this.storageUsers = storageUsers;
        this.storageActions = storageActions;
    }

    public boolean userFavoritesListCreate(UUID uuid, String value) throws FavoritesIsExistException {
        if (((User) this.storageUsers.getMap().get(uuid)).listFavorites().contains(((Actions) this.storageActions.getMap().get(UUID.fromString(value))))) {
            throw new FavoritesIsExistException();
        } else {
            ((User) this.storageUsers.getMap().get(uuid)).listFavorites().add(((Actions) this.storageActions.getMap().get(UUID.fromString(value))));
            return true;
        }
    }

    public List<Actions> userFavoritesListRead(UUID uuid) throws UserNotFoundException {
        if (this.storageUsers.getMap().get(uuid) == null) {
            throw new UserNotFoundException();
        }
        return ((User) this.storageUsers.getMap().get(uuid)).listFavorites();
    }

    public boolean userFavoritesListDelete(UUID uuid, String value) throws FavoritesIsUnavailableException {
        if (((User) this.storageUsers.getMap().get(uuid)).listFavorites().remove(UUID.fromString(value))) {
            throw new FavoritesIsUnavailableException();
        }
        return true;
    }
}
