/**
 * @author Dustin Eikmeier
 * @version 1.0
 * @since 1.8
 */

package models;

import data.storable.Storable;
import data.storage.Storage;
import exceptions.StorableNotFoundException;
import mode.UpdateType;

import java.util.UUID;

public interface LogicModels {
    Storage getStorage();

    UUID create(String name);

    Storable read(UUID uuid) throws StorableNotFoundException;

    boolean update(UUID uuid, UpdateType update_type, String value) throws StorableNotFoundException;

    boolean delete(UUID uuid) throws StorableNotFoundException;
}
