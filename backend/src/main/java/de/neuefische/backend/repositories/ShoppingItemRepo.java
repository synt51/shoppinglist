package de.neuefische.backend.repositories;


import de.neuefische.backend.models.ShoppingItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingItemRepo extends MongoRepository<ShoppingItem, String> {

    List<ShoppingItem> findAllByItemName(String itemName);

}
