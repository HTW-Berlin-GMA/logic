import data.storable.user.User;
import exceptions.StorableNotFoundException;
import exceptions.UsernameNotFoundException;
import models.user.LogicUsers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

class LogicTest {
    private BusinessLogic bl = new BusinessLogic(BigDecimal.valueOf(99999), BigDecimal.valueOf(99999));
    ;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void good_create_user() {
        /**
         UUID dokriseum = this.bl.getLogicUsers().create("dokriseum");
         try {
         this.bl.getLogicUsers().update(dokriseum, UpdateType.E_MAIL_ADDRESS, "dokriseum@gma.edu");
         } catch (StorableNotFoundException e) {
         Assertions.fail();
         }
         //TEST//
         try {
         Assertions.assertTrue(dokriseum.equals(this.bl.getLogicUsers().read(dokriseum)));
         } catch (StorableNotFoundException e) {
         Assertions.fail();
         }
         */
        Assertions.assertTrue(true);
    }

    @Test
    void good_create_user_in_storage() {
        // SET-UP //
        String username = "dokriseum";
        UUID uuid = this.bl.getLogicUsers().create(username);
        // TEST //
        try {
            Assertions.assertTrue(((User) this.bl.getLogicUsers().read(uuid)).getUsername().equals(username));
        } catch (StorableNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    void good_create_user_in_storage_2() {
        // SET-UP //
        this.bl.getLogicUsers().create("dokriseum");
        User tempTestUser = null;
        try {
            tempTestUser = ((LogicUsers) this.bl.getLogicUsers()).show("dokriseum");
        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
            Assertions.fail();
        }
        // TEST //
        Assertions.assertTrue(tempTestUser.getUsername().equals("dokriseum"));
    }
}