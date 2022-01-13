package de.neuefische.backend.repositories;

import de.neuefische.backend.models.ShoppingItem;
import de.neuefische.backend.models.ShoppingList;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShoppingListRepo extends MongoRepository<ShoppingList, String> {

}
