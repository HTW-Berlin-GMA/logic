package models;

import data.storable.user.User;
import data.storage.Storage;
import data.storage.StorageImpl;
import models.user.LogicUsers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

class LogicModelsTest {
    private LogicModels lUser = new LogicUsers(new StorageImpl(BigDecimal.valueOf(99999)));

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void good_create_user_in_storage() {
        // SET-UP //
        User testUser = Mockito.mock(User.class);
        Storage testStorage = new StorageImpl(BigDecimal.valueOf(99999));
        testStorage.getList().add(testUser);
        // TEST //
        Assertions.assertEquals(testUser, testStorage.getList().get(0));
    }
}