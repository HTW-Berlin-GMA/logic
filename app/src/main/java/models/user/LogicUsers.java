/**
 * @author Dustin Eikmeier
 * @version 1.0
 * @since 1.8
 */

package models.user;

import data.storable.Storable;
import data.storable.user.User;
import data.storable.user.UserImpl;
import data.storage.Storage;
import data.storage.StorageImpl;
import exceptions.UsernameNotFoundException;
import exceptions.UsernameUsedException;
import mode.UpdateType;
import models.LogicModels;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class LogicUsers implements LogicModels {
    private Storage storage;

    public LogicUsers(BigDecimal sizeStorage) {
        this.storage = new StorageImpl(sizeStorage);
    }

    public LogicUsers(Storage storage) {
        this.storage = storage;
    }

    public UUID create(String name) {
        if (!this.checkUsername(name)) {
            return null;
        }
        User user = new UserImpl(this.setUUID(), name);
        this.storage.getList().add(user);
        return user.getID();
    }

    public User read(UUID uuid) throws UsernameNotFoundException {
        for (Storable k : this.storage.getList()) {
            if (k.getID().equals(uuid)) {
                return (User) k;
            }
        }
        return null;
        // throw new UsernameNotFoundException();
    }

    public User show(String username) throws UsernameNotFoundException {
        List<User> tempUserList = new ArrayList<>();
        for (Storable k : this.storage.getList()) {
            tempUserList.add((User) k);
        }
        for (User k : tempUserList) {
            if (k.getUsername().equals(username)) {
                return k;
            }
        }
        return null;
    }

    public boolean update(UUID uuid, UpdateType update_type, String value) throws UsernameNotFoundException {
        int userID = this.searchUser(uuid);
        switch (update_type) {
            case USERNAME:
                try {
                    (new UpdateUser(this.storage)).updateUsername(userID, value);
                } catch (UsernameUsedException e) {
                    return false;
                }
                break;
            case PRENAME:
                (new UpdateUser(this.storage)).updatePrename(userID, value);
                break;
            case SURNAME:
                (new UpdateUser(this.storage)).updateSurname(userID, value);
                break;
            case BIRTHDATE:
                (new UpdateUser(this.storage)).updateBirthdate(userID, value);
                break;
            case E_MAIL_ADDRESS:
                (new UpdateUser(this.storage)).updateEMailAddress(userID, value);
                break;
            case STREET:
                (new UpdateUser(this.storage)).updateStreet(userID, value);
                break;
            case HOUSE_NUMBER:
                (new UpdateUser(this.storage)).updateHouseNumber(userID, value);
                break;
            case POST_CODE:
                (new UpdateUser(this.storage)).updatePostCode(userID, value);
                break;
            case CITY:
                (new UpdateUser(this.storage)).updateCity(userID, value);
                break;
            case COUNTRY:
                (new UpdateUser(this.storage)).updateCountry(userID, value);
                break;
            default:
                throw new IllegalArgumentException();
        }
        return true;
    }

    public boolean delete(UUID uuid) throws UsernameNotFoundException {
        for (Storable k : this.storage.getList()) {
            if (k.getID().equals(uuid)) {
                this.storage.getList().remove(k);
                return true;
            }
        }
        throw new UsernameNotFoundException();
    }

    @Override
    public Storage getStorage() {
        return this.storage;
    }

    private UUID setUUID() {
        UUID uuid = UUID.randomUUID();
        boolean run = true;
        do {
            if (this.checkUUID(uuid) == true) {
                return uuid;
            } else {
                continue;
            }
        }
        while (run);
        return null;
    }

    private boolean checkUUID(UUID uuid) {
        boolean isAvailable = true;
        for (Storable k : this.storage.getList()) {
            if (k.getID().equals(uuid)) {
                isAvailable = false;
                return isAvailable;
            }
        }
        return isAvailable;
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

    private Integer searchUser(UUID uuid) throws UsernameNotFoundException {
        int id = 0;
        for (Storable k : this.storage.getList()) {
            if (k.getID().equals(uuid)) {
                this.storage.getList().remove(k);
                return id;
            } else {
                id++;
            }
        }
        throw new UsernameNotFoundException();
    }
}
