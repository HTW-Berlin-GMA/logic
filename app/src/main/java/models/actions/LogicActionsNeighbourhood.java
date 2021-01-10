/**
 * @author Dustin Eikmeier
 * @version 1.0
 * @since 1.8
 */

package models.actions;

import data.storable.Storable;
import data.storable.actions.Actions;
import data.storable.actions.ActionsNeighbourhoodImpl;
import data.storage.Storage;
import data.storage.StorageImpl;
import exceptions.ActionNotFoundException;
import mode.UpdateType;
import models.LogicModels;

import java.math.BigDecimal;
import java.util.UUID;

public class LogicActionsNeighbourhood implements LogicModels {
    private Storage storage;

    public LogicActionsNeighbourhood(BigDecimal sizeStorage) {
        this.storage = new StorageImpl(sizeStorage);
    }

    public LogicActionsNeighbourhood(Storage storage) {
        this.storage = storage;
    }

    public UUID create(String name) {
        Actions action = new ActionsNeighbourhoodImpl(name, this.setUUID());
        this.storage.getList().add(action);
        return this.storage.getList().get(this.storage.getList().indexOf(action)).getID();
    }

    public Actions read(UUID uuid) throws ActionNotFoundException {
        for (Storable k : this.storage.getList()) {
            if (k.getID().equals(uuid)) {
                this.storage.getList().remove(k);
                return (Actions) k;
            }
        }
        throw new ActionNotFoundException();
    }

    public boolean update(UUID uuid, UpdateType update_type, String value) throws ActionNotFoundException {
        int actionID = this.searchAction(uuid);
        switch (update_type) {
            case NAME:
                (new UpdateAction(this.storage)).updateName(actionID, value);
                break;
            case STREET:
                (new UpdateAction(this.storage)).updateStreet(actionID, value);
                break;
            case HOUSE_NUMBER:
                (new UpdateAction(this.storage)).updateHouseNumber(actionID, value);
                break;
            case POST_CODE:
                (new UpdateAction(this.storage)).updatePostCode(actionID, value);
                break;
            case CITY:
                (new UpdateAction(this.storage)).updateCity(actionID, value);
                break;
            case COUNTRY:
                (new UpdateAction(this.storage)).updateCountry(actionID, value);
                break;
            case ACTIVITY:
                (new UpdateAction(this.storage)).updateActivity(actionID, value);
                break;
            default:
                throw new IllegalArgumentException();
        }
        return true;
    }

    public boolean delete(UUID uuid) throws ActionNotFoundException {
        for (Storable k : this.storage.getList()) {
            if (k.getID().equals(uuid)) {
                this.storage.getList().remove(k);
                return true;
            }
        }
        throw new ActionNotFoundException();
    }

    @Override
    public Storage getStorage() {
        return null;
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

    private Integer searchAction(UUID uuid) throws ActionNotFoundException {
        int id = 0;
        for (Storable k : this.storage.getList()) {
            if (k.getID().equals(uuid)) {
                this.storage.getList().remove(k);
                return id;
            } else {
                id++;
            }
        }
        throw new ActionNotFoundException();
    }
}
