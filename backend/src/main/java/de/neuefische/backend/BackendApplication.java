package de.neuefische.backend;

import de.neuefische.backend.models.ShoppingItem;
import de.neuefische.backend.repositories.ShoppingItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Arrays;


@SpringBootApplication

public class BackendApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Autowired
    ShoppingItemRepo shoppingItemRepo;

    @Override
    public void run(String... args) throws Exception{
        final ShoppingItem rtx = ShoppingItem.builder().itemName("RTX 3080").itemCount(1).build();
        ShoppingItem amd = ShoppingItem.builder().itemName("RX6800").itemCount(1).build(); //shoppingItemRepo.insert(rtx);

        shoppingItemRepo.findAll();
        shoppingItemRepo.saveAll(Arrays.asList(rtx, amd));

        System.out.println(shoppingItemRepo.findAll());


    }
}
