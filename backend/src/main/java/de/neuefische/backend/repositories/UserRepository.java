package de.neuefische.backend.repositories;

import de.neuefische.backend.models.UserMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserMongo, String> {

    UserMongo findByUsername(String username);
}
