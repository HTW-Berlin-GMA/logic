/**
 * @author Dustin Eikmeier
 * @version 1.0
 * @since 1.8
 */

package models;

import data.storable.Storable;
import data.storable.user.User;
import data.storable.user.UserImpl;
import data.storage.Storage;
import data.storage.StorageImpl;
import exceptions.UsernameNotFoundException;
import exceptions.UsernameUsedException;
import mode.UpdateTypeUser;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class LogicUsers implements LogicModels {
    private Storage storage;

    public LogicUsers(BigDecimal sizeStorage) {
        this.storage = new StorageImpl(sizeStorage);
    }

    public LogicUsers(Storage storage) {
        this.storage = storage;
    }

    public boolean userCreate(String username, Date birthdate, String eMailAddress) throws UsernameUsedException {
        if (this.checkUsername(username)) {
            throw new UsernameUsedException();
        }
        User user = new UserImpl(this.setUUID(), username, birthdate, eMailAddress);
        this.storage.getList().add(user);
        return true;
    }

    public boolean userErase(String uuid) throws UsernameNotFoundException {
        for (Storable k : this.storage.getList()) {
            if (k.getID().equals(UUID.fromString(uuid))) {
                this.storage.getList().remove(k);
                return true;
            }
        }
        throw new UsernameNotFoundException();
    }

    public User userRead(String uuid) throws UsernameNotFoundException {
        for (Storable k : this.storage.getList()) {
            if (k.getID().equals(UUID.fromString(uuid))) {
                this.storage.getList().remove(k);
                return (User) k;
            }
        }
        throw new UsernameNotFoundException();
    }

    public boolean userUpdate(String uuid, UpdateTypeUser uyu, String value) throws UsernameNotFoundException {
        int userID = this.searchUser(uuid);
        switch (uyu) {
            case USERNAME:
                break;
            case PRENAME:
                break;
            case SURNAME:
                break;
            case BIRTHDATE:
                break;
            case STREET:
                break;
            case HOUSE_NUMBER:
                break;
            case POST_CODE:
                break;
            case CITY:
                break;
            case COUNTRY:
                break;
            default:
                throw new IllegalArgumentException();
        }
        return true;
    }

    @Override
    public Storage getStorage() {
        return this.storage;
    }

    private UUID setUUID() {
        UUID uuid = UUID.randomUUID();
        if (this.checkUUID(uuid) == true) {
            return uuid;
        } else {
            return this.setUUID();
        }
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

    private Integer searchUser(String uuid) throws UsernameNotFoundException {
        int id = 0;
        for (Storable k : this.storage.getList()) {
            if (k.getID().equals(UUID.fromString(uuid))) {
                this.storage.getList().remove(k);
                return id;
            } else {
                id++;
            }
        }
        throw new UsernameNotFoundException();
    }
}
