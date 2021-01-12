/**
 * @author Dustin Eikmeier
 * @version 1.0
 * @since 1.8
 */

package models.user;

import data.storable.actions.Activities;
import data.storable.user.User;
import data.storage.Storage;
import exceptions.InterestIsExistException;
import exceptions.InterestIsUnavailableException;
import exceptions.UserNotFoundException;

import java.util.List;
import java.util.UUID;

public class UserInterests {
    private Storage storage;

    public UserInterests(Storage storage) {
        this.storage = storage;
    }

    public boolean userInterestsListCreate(UUID uuid, String value) throws InterestIsExistException {
        if (((User) this.storage.getMap().get(uuid)).listInterests().contains(value)) {
            throw new InterestIsExistException();
        } else {
            ((User) this.storage.getMap().get(uuid)).listInterests().add(Activities.valueOf(value));
            return true;
        }
    }

    public List<Activities> userInterestsListRead(UUID uuid) throws UserNotFoundException {
        if (this.storage.getMap().get(uuid) == null) {
            throw new UserNotFoundException();
        }
        return ((User) this.storage.getMap().get(uuid)).listInterests();
    }

    public boolean userInterestsListDelete(UUID uuid, String value) throws InterestIsUnavailableException {
        if (((User) this.storage.getMap().get(uuid)).listInterests().remove(Activities.valueOf(value))) {
            throw new InterestIsUnavailableException();
        }
        return true;
    }
}
