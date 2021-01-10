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

public class UpdateAction {
    private Storage storage;

    public UpdateAction(Storage storage) {
        this.storage = storage;
    }

    public boolean updateName(int id, String name) {
        ((Actions) this.storage.getList().get(id)).setActionName(name);
        return true;
    }

    public boolean updateActivity(int id, String activitiy) {
        ((Actions) this.storage.getList().get(id)).setActivity(activitiy);
        return true;
    }

    public boolean updateStreet(int id, String street) {
        ((Actions) this.storage.getList().get(id)).setStreet(street);
        return true;
    }

    public boolean updateHouseNumber(int id, String house_number) {
        ((Actions) this.storage.getList().get(id)).setHouseNumber(house_number);
        return true;
    }

    public boolean updatePostCode(int id, String post_code) {
        ((Actions) this.storage.getList().get(id)).setPostCode(post_code);
        return true;
    }

    public boolean updateCity(int id, String city) {
        ((Actions) this.storage.getList().get(id)).setCity(city);
        return true;
    }

    public boolean updateCountry(int id, String country) {
        ((Actions) this.storage.getList().get(id)).setCountry(country);
        return true;
    }

    public boolean updateMaximalNumberOfParticipants(int id, String maximal_number_of_participants) {
        ((ActionsFreedom) this.storage.getList().get(id)).setMaximalNumberOfParticipants(Integer.valueOf(maximal_number_of_participants).intValue());
        return true;
    }

    public boolean updateNumberOfParticipants(int id, String number_of_participants) {
        ((ActionsFreedom) this.storage.getList().get(id)).setNumberOfParticipants(Integer.valueOf(number_of_participants).intValue());
        return true;
    }

    public boolean updateIsCompleted(int id, String isCompleted) {
        ((ActionsNeighbourhood) this.storage.getList().get(id)).setCompleted(Boolean.getBoolean(isCompleted));
        return true;
    }
}
