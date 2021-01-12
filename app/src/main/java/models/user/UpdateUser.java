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

import java.sql.Date;
import java.util.UUID;

public class UpdateUser {
    private Storage storage;

    public UpdateUser(Storage storage) {
        this.storage = storage;
    }

    public boolean updateUsername(UUID uuid, String username) throws UsernameUsedException {
        if (this.checkUsername(username)) {
            throw new UsernameUsedException();
        } else {
            ((User) this.storage.getMap().get(uuid)).setUsername(username);
            return true;
        }
    }

    public boolean updatePrename(UUID uuid, String prename) {
        ((User) this.storage.getMap().get(uuid)).setPrename(prename);
        return true;

    }

    public boolean updateSurname(UUID uuid, String surname) {
        ((User) this.storage.getMap().get(uuid)).setSurname(surname);
        return true;

    }

    public boolean updateBirthdate(UUID uuid, String birthdate) {
        ((User) this.storage.getMap().get(uuid)).setBirthdate(Date.valueOf(birthdate));
        return true;

    }

    public boolean updateStreet(UUID uuid, String street) {
        ((User) this.storage.getMap().get(uuid)).setStreet(street);
        return true;

    }

    public boolean updateHouseNumber(UUID uuid, String house_number) {
        ((User) this.storage.getMap().get(uuid)).setHouseNumber(house_number);
        return true;

    }

    public boolean updatePostCode(UUID uuid, String post_code) {
        ((User) this.storage.getMap().get(uuid)).setPostCode(post_code);
        return true;

    }

    public boolean updateCity(UUID uuid, String city) {
        ((User) this.storage.getMap().get(uuid)).setCity(city);
        return true;

    }

    public boolean updateCountry(UUID uuid, String country) {
        ((User) this.storage.getMap().get(uuid)).setCountry(country);
        return true;

    }

    public boolean updateEMailAddress(UUID uuid, String eMailAddress) {
        ((User) this.storage.getMap().get(uuid)).setMailAddress(eMailAddress);
        return true;

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
