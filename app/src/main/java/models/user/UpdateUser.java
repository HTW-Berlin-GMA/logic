/**
 * @author Dustin Eikmeier
 * @version 1.0
 * @since 1.8
 */

package models.user;

import data.storable.Storable;
import data.storable.user.User;
import data.storage.Storage;
import exceptions.UsernameUsedException;

public class UpdateUser {
    private Storage storage;

    public UpdateUser(Storage storage) {
        this.storage = storage;
    }

    public boolean updateUsername(int id, String username) throws UsernameUsedException {
        if (this.checkUsername(username)) {
            throw new UsernameUsedException();
        } else {
            ((User) this.storage.getList().get(id)).setUsername(username);
            return true;
        }
    }

    public boolean updatePrename(int id, String prename) {
        ((User) this.storage.getList().get(id)).setFirstname(prename);
        return true;

    }

    public boolean updateSurname(int id, String surname) {
        ((User) this.storage.getList().get(id)).setFirstname(surname);
        return true;

    }

    private boolean checkUsername(String username) {
        boolean isAvailable = true;
        for (Storable k : this.storage.getList()) {
            if (((User) k).getUsername().equals(username)) {
                isAvailable = false;
                return isAvailable;
            }
        }
        return isAvailable;
    }
}
