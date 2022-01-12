package de.neuefische.backend;

import de.neuefische.backend.models.Item;
import de.neuefische.backend.repositories.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Autowired
    ItemRepo itemRepo;

    @Override
    public void run(String... args) throws Exception {
        final Item rtx = new Item("RTX 3080", 1);
        itemRepo.save(rtx);
    }


}
