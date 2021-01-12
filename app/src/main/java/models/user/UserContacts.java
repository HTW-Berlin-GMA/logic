/**
 * @author Dustin Eikmeier
 * @version 1.0
 * @since 1.8
 */

package models.user;

import data.storable.user.User;
import data.storage.Storage;
import exceptions.ContactlistIsUnavailableException;
import exceptions.ContactlistIsUsedException;
import exceptions.UserNotFoundException;
import mode.UpdateTypeListsOfUsers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserContacts {
    private Storage storage;

    public UserContacts(Storage storage) {
        this.storage = storage;
    }

    public boolean userContactListCreate(UUID uuid, String name) throws ContactlistIsUsedException {
        if (((User) this.storage.getMap().get(uuid)).mapContacts().containsKey(name) == true) {
            throw new ContactlistIsUsedException();
        } else {
            ((User) this.storage.getMap().get(uuid)).mapContacts().put(name, new ArrayList<>());
            return true;
        }
    }

    public List<User> userContactListRead(UUID uuid, String name) throws ContactlistIsUnavailableException {
        if (((User) this.storage.getMap().get(uuid)).mapContacts().get(name) == null) {
            throw new ContactlistIsUnavailableException();
        }
        return ((User) this.storage.getMap().get(uuid)).mapContacts().get(name);
    }

    public boolean userContactListUpdate(UUID uuid, String name, UpdateTypeListsOfUsers update_type, String value) throws ContactlistIsUnavailableException, UserNotFoundException {
        if (((User) this.storage.getMap().get(uuid)).mapContacts().get(name) == null) {
            throw new ContactlistIsUnavailableException();
        }
        if (this.storage.getMap().get(UUID.fromString(value)) == null) {
            throw new UserNotFoundException();
        }

        switch (update_type) {
            case ADD:
                this.userContactListUpdateAdd((User) this.storage.getMap().get(uuid), name, (User) this.storage.getMap().get(UUID.fromString(value)));
                break;
            case REMOVE:
                this.userContactListUpdateRemove((User) this.storage.getMap().get(uuid), name, (User) this.storage.getMap().get(UUID.fromString(value)));
                break;
            default:
                return false;
        }

        return true;
    }

    public boolean userContactListDelete(UUID uuid, String name) throws ContactlistIsUnavailableException {
        if (((User) this.storage.getMap().get(uuid)).mapContacts().remove(name) == null) {
            throw new ContactlistIsUnavailableException();
        }
        return true;
    }

    private boolean userContactListUpdateAdd(User user, String nameList, User contact) {
        user.mapContacts().get(nameList).add(contact);
        return true;
    }

    private boolean userContactListUpdateRemove(User user, String nameList, User contact) {
        user.mapContacts().get(nameList).remove(contact);
        return true;
    }
}
