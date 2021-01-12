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
import exceptions.UserNotFoundException;
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
        this.storage.getMap().put(user.getID(), user);
        return user.getID();
    }

    public User read(UUID uuid) throws UserNotFoundException {
        return (User) this.storage.getMap().get(uuid);
    }

    public User show(String username) throws UserNotFoundException {
        List<User> tempUserList = new ArrayList<>();
        for (Storable k : this.storage.getMap().values()) {
            tempUserList.add((User) k);
        }
        for (User k : tempUserList) {
            if (k.getUsername().equals(username)) {
                return k;
            }
        }
        return null;
    }

    public boolean update(UUID uuid, UpdateType update_type, String value) throws UserNotFoundException {
        switch (update_type) {
            case USERNAME:
                try {
                    (new UpdateUser(this.storage)).updateUsername(uuid, value);
                } catch (UsernameUsedException e) {
                    return false;
                }
                break;
            case PRENAME:
                (new UpdateUser(this.storage)).updatePrename(uuid, value);
                break;
            case SURNAME:
                (new UpdateUser(this.storage)).updateSurname(uuid, value);
                break;
            case BIRTHDATE:
                (new UpdateUser(this.storage)).updateBirthdate(uuid, value);
                break;
            case E_MAIL_ADDRESS:
                (new UpdateUser(this.storage)).updateEMailAddress(uuid, value);
                break;
            case STREET:
                (new UpdateUser(this.storage)).updateStreet(uuid, value);
                break;
            case HOUSE_NUMBER:
                (new UpdateUser(this.storage)).updateHouseNumber(uuid, value);
                break;
            case POST_CODE:
                (new UpdateUser(this.storage)).updatePostCode(uuid, value);
                break;
            case CITY:
                (new UpdateUser(this.storage)).updateCity(uuid, value);
                break;
            case COUNTRY:
                (new UpdateUser(this.storage)).updateCountry(uuid, value);
                break;
            default:
                throw new IllegalArgumentException();
        }
        return true;
    }

    public boolean delete(UUID uuid) throws UserNotFoundException {
        if (this.storage.getMap().remove(uuid) == null) {
            throw new UserNotFoundException("wrong uuid");
        } else {
            return true;
        }
    }

    @Override
    public Storage getStorage() {
        return this.storage;
    }

    private UUID setUUID() {
        UUID uuid = UUID.randomUUID();
        if (this.storage.getMap().containsKey(uuid) != true) {
            return uuid;
        } else {
            return null;
        }
    }

    private boolean checkUsername(String username) {
        boolean isAvailable = true;
        for (Storable k : this.storage.getMap().values()) {
            if (((User) k).getUsername().equals(username)) {
                isAvailable = false;
                return isAvailable;
            }
        }
        return isAvailable;
    }
}
