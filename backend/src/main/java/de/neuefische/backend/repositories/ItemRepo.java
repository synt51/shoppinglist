package de.neuefische.backend.repositories;


import de.neuefische.backend.models.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ItemRepo extends MongoRepository<Item, String> {

    List<Item> findAll();
    List<Item> findAllByName();

}
