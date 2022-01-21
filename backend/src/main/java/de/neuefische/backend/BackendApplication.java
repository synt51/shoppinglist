package de.neuefische.backend;

import de.neuefische.backend.models.ShoppingItem;
import de.neuefische.backend.models.UserMongo;
import de.neuefische.backend.repositories.ShoppingItemRepo;
import de.neuefische.backend.repositories.UserRepository;
import de.neuefische.backend.service.MongoUserDetailsService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.List;


@SpringBootApplication

public class BackendApplication implements CommandLineRunner{ //vorher implements CommandLineRunner

//    public BackendApplication(ShoppingItemRepo shoppingItemRepo) {
//        this.shoppingItemRepo = shoppingItemRepo;
//    }
    private static final Log LOG = LogFactory.getLog(BackendApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }


    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Override
    public void run(String... args) throws Exception{
        final String encodedPassword = encoder.encode("admin123456");
        final UserMongo user = UserMongo.newUser("HeinzAdmin", encodedPassword,
                List.of(new SimpleGrantedAuthority(MongoUserDetailsService.AUTHORITY_API_READWRITE)));

        try {
            userRepository.insert(user);
        } catch (DuplicateKeyException e){
            LOG.info("User '" + user.getUsername() + "' already exists.");
        }
        //UserMongo heinz = UserMongo.builder().username("heinzadmin").password(encodedPassword).build();

        //userRepository.save(heinz);

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
