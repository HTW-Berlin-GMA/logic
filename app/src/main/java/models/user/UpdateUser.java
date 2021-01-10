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
        ((User) this.storage.getList().get(id)).setPrename(prename);
        return true;

    }

    public boolean updateSurname(int id, String surname) {
        ((User) this.storage.getList().get(id)).setSurname(surname);
        return true;

    }

    public boolean updateBirthdate(int id, String birthdate) {
        ((User) this.storage.getList().get(id)).setBirthdate(Date.valueOf(birthdate));
        return true;

    }

    public boolean updateStreet(int id, String street) {
        ((User) this.storage.getList().get(id)).setStreet(street);
        return true;

    }

    public boolean updateHouseNumber(int id, String house_number) {
        ((User) this.storage.getList().get(id)).setHouseNumber(house_number);
        return true;

    }

    public boolean updatePostCode(int id, String post_code) {
        ((User) this.storage.getList().get(id)).setPostCode(post_code);
        return true;

    }

    public boolean updateCity(int id, String city) {
        ((User) this.storage.getList().get(id)).setCity(city);
        return true;

    }

    public boolean updateCountry(int id, String country) {
        ((User) this.storage.getList().get(id)).setCountry(country);
        return true;

    }

    public boolean updateEMailAddress(int id, String eMailAddress) {
        ((User) this.storage.getList().get(id)).setMailAddress(eMailAddress);
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
