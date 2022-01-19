package de.neuefische.backend.controller;

import de.neuefische.backend.models.UserMongo;
import de.neuefische.backend.service.MongoUserDetailsService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collection;

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
        Collection<? extends GrantedAuthority> authorities =
                SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        final boolean isAllowed =
                authorities.stream()
                        .anyMatch(g -> MongoUserDetailsService.AUTHORITY_API_READWRITE.equals(g.getAuthority()));

        if (isAllowed) {
            return "Hey " + username + ", what's poppin' mate? Git gud and praise the sun!";
        } else {
            return "Nope, access denied!";
        }
    }
}
