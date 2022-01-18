package de.neuefische.backend;

import de.neuefische.backend.models.ShoppingItem;
import de.neuefische.backend.models.UserMongo;
import de.neuefische.backend.repositories.ShoppingItemRepo;
import de.neuefische.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;


@SpringBootApplication

public class BackendApplication implements CommandLineRunner{ //vorher implements CommandLineRunner

//    public BackendApplication(ShoppingItemRepo shoppingItemRepo) {
//        this.shoppingItemRepo = shoppingItemRepo;
//    }

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }


    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Override
    public void run(String... args) throws Exception{
        String encodedPassword = encoder.encode("admin123456");
        UserMongo heinz = UserMongo.builder().username("heinzadmin").password(encodedPassword).build();

        UserMongo heinz3 = UserMongo.builder().username("heinzadmin2").password("admin12345").build();
        userRepository.save(heinz);

        userRepository.save(heinz3);

        System.out.println(userRepository.findAll());
    }
//    private final ShoppingItemRepo shoppingItemRepo;
//
//    @Override
//    public void run(String... args) throws Exception{
//        final ShoppingItem rtx = ShoppingItem.builder().itemName("RTX 3080").itemCount(1).build();
//        ShoppingItem amd = ShoppingItem.builder().itemName("RX6800").itemCount(1).build(); //shoppingItemRepo.insert(rtx);
//
//        shoppingItemRepo.findAll();
//        shoppingItemRepo.saveAll(Arrays.asList(rtx, amd));
//
//        System.out.println(shoppingItemRepo.findAll());
//
//
//    }
}
