/**
 * @author Dustin Eikmeier
 * @version 1.0
 * @since 1.8
 */

package models.actions;

import data.storable.actions.Actions;
import data.storable.actions.ActionsNeighbourhoodImpl;
import data.storage.Storage;
import data.storage.StorageImpl;
import exceptions.ActionNotFoundException;
import mode.UpdateType;
import models.LogicModels;

import java.math.BigDecimal;
import java.util.UUID;

public class LogicActionsFreedom implements LogicModels {
    private Storage storage;

    public LogicActionsFreedom(BigDecimal sizeStorage) {
        this.storage = new StorageImpl(sizeStorage);
    }

    public LogicActionsFreedom(Storage storage) {
        this.storage = storage;
    }

    public UUID create(String name) {
        Actions action = new ActionsNeighbourhoodImpl(name, this.setUUID());
        this.storage.getMap().put(action.getID(), action);
        return action.getID();
    }

    public Actions read(UUID uuid) throws ActionNotFoundException {
        return (Actions) this.storage.getMap().get(uuid);
    }

    public boolean update(UUID uuid, UpdateType update_type, String value) throws ActionNotFoundException {
        switch (update_type) {
            case NAME:
                (new UpdateAction(this.storage)).updateName(uuid, value);
                break;
            case STREET:
                (new UpdateAction(this.storage)).updateStreet(uuid, value);
                break;
            case HOUSE_NUMBER:
                (new UpdateAction(this.storage)).updateHouseNumber(uuid, value);
                break;
            case POST_CODE:
                (new UpdateAction(this.storage)).updatePostCode(uuid, value);
                break;
            case CITY:
                (new UpdateAction(this.storage)).updateCity(uuid, value);
                break;
            case COUNTRY:
                (new UpdateAction(this.storage)).updateCountry(uuid, value);
                break;
            case ACTIVITY:
                (new UpdateAction(this.storage)).updateActivity(uuid, value);
                break;
            case MAX_PARTICIPANTS:
                (new UpdateAction(this.storage)).updateMaximalNumberOfParticipants(uuid, value);
                break;
            case ACTUALLY_PARTICIPANTS:
                (new UpdateAction(this.storage)).updateNumberOfParticipants(uuid, value);
                break;
            case FINISHED_STATUS:
                (new UpdateAction(this.storage)).updateIsCompleted(uuid, value);
                break;
            default:
                throw new IllegalArgumentException();
        }
        return true;
    }

    public boolean delete(UUID uuid) throws ActionNotFoundException {
        if (this.storage.getMap().remove(uuid) == null) {
            throw new ActionNotFoundException("wrong uuid");
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
}
