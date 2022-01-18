package de.neuefische.backend.controller;

import de.neuefische.backend.models.UserMongo;
import de.neuefische.backend.service.MongoUserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserController {

    private final MongoUserDetailsService mongoUserDetailsService;

    public UserController(MongoUserDetailsService mongoUserDetailsService){
        this.mongoUserDetailsService = mongoUserDetailsService;
    }

    @GetMapping("/user/me")
    public String getUser(Principal principal){
        String username = principal.getName();
        //return mongoUserDetailsService.getUserByUsername(username);
        return "Hey " + username + ", what's poppin' mate? Git gud and praise the sun!";
    }
}
