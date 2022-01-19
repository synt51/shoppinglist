package de.neuefische.backend.service;

import de.neuefische.backend.models.UserMongo;
import de.neuefische.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongoUserDetailsService implements UserDetailsService {

    public static final String AUTHORITY_API_READWRITE = "API_READWRITE"; //RW Berechtigung für API

    private final UserRepository userRepository;

    public MongoUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found..."));
//        UserMongo user = userRepository.findByUsername(username);
//        if(user == null) {
//            throw new UsernameNotFoundException("User not found");
//        }
//        return new User(user.getUsername(), user.getPassword(),
//                List.of(new SimpleGrantedAuthority("user")));
    }
}
