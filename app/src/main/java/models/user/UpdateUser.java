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

    public boolean updateBirthdate(int id, String birthdate) {
        ((User) this.storage.getList().get(id)).setFirstname(birthdate);
        return true;

    }

    public boolean updateStreet(int id, String street) {
        ((User) this.storage.getList().get(id)).setFirstname(street);
        return true;

    }

    public boolean updateHouseNumber(int id, String house_number) {
        ((User) this.storage.getList().get(id)).setFirstname(house_number);
        return true;

    }

    public boolean updatePostCode(int id, String post_code) {
        ((User) this.storage.getList().get(id)).setFirstname(post_code);
        return true;

    }

    public boolean updateCity(int id, String city) {
        ((User) this.storage.getList().get(id)).setFirstname(city);
        return true;

    }

    public boolean updateCountry(int id, String country) {
        ((User) this.storage.getList().get(id)).setFirstname(country);
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
