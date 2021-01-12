/**
 * @author Dustin Eikmeier
 * @version 1.0
 * @since 1.8
 */

package models.actions;

import data.storable.actions.Actions;
import data.storable.actions.ActionsFreedom;
import data.storable.actions.ActionsNeighbourhood;
import data.storage.Storage;

import java.util.UUID;

public class UpdateAction {
    private Storage storage;

    public UpdateAction(Storage storage) {
        this.storage = storage;
    }

    public boolean updateName(UUID uuid, String name) {
        ((Actions) this.storage.getMap().get(uuid)).setActionName(name);
        return true;
    }

    public boolean updateActivity(UUID uuid, String activitiy) {
        ((Actions) this.storage.getMap().get(uuid)).setActivity(activitiy);
        return true;
    }

    public boolean updateStreet(UUID uuid, String street) {
        ((Actions) this.storage.getMap().get(uuid)).setStreet(street);
        return true;
    }

    public boolean updateHouseNumber(UUID uuid, String house_number) {
        ((Actions) this.storage.getMap().get(uuid)).setHouseNumber(house_number);
        return true;
    }

    public boolean updatePostCode(UUID uuid, String post_code) {
        ((Actions) this.storage.getMap().get(uuid)).setPostCode(post_code);
        return true;
    }

    public boolean updateCity(UUID uuid, String city) {
        ((Actions) this.storage.getMap().get(uuid)).setCity(city);
        return true;
    }

    public boolean updateCountry(UUID uuid, String country) {
        ((Actions) this.storage.getMap().get(uuid)).setCountry(country);
        return true;
    }

    public boolean updateMaximalNumberOfParticipants(UUID uuid, String maximal_number_of_participants) {
        ((ActionsFreedom) this.storage.getMap().get(uuid)).setMaximalNumberOfParticipants(Integer.valueOf(maximal_number_of_participants).intValue());
        return true;
    }

    public boolean updateNumberOfParticipants(UUID uuid, String number_of_participants) {
        ((ActionsFreedom) this.storage.getMap().get(uuid)).setNumberOfParticipants(Integer.valueOf(number_of_participants).intValue());
        return true;
    }

    public boolean updateIsCompleted(UUID uuid, String isCompleted) {
        ((ActionsNeighbourhood) this.storage.getMap().get(uuid)).setCompleted(Boolean.getBoolean(isCompleted));
        return true;
    }
}
