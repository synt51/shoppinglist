package de.neuefische.backend.controller;

import de.neuefische.backend.models.LoginData;
import de.neuefische.backend.models.UserMongo;
import de.neuefische.backend.repositories.UserRepository;
import de.neuefische.backend.service.MongoUserDetailsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest {

    @LocalServerPort
    private int port;

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final WebClient webTestClient = WebClient.create();

    @Test
    void getUserWithValidCredentialsAndAuthority() {
        //GIVEN
        when(userRepository.findByUsername("some-user")).thenReturn(Optional.of(UserMongo.builder()
                .username("some-user")
                .password(passwordEncoder.encode("secretPassword"))
                .accountNonExpired(true)
                .authorities(List.of(new SimpleGrantedAuthority(MongoUserDetailsService.AUTHORITY_API_READWRITE)))
                .credentialsNonExpired(true)
                .accountNonLocked(true)
                .enabled(true)
                .build()));

        LoginData loginData = new LoginData("some-user","secretPassword");

        ResponseEntity<String> login = webTestClient.post()
                .uri("http://localhost:"+port+"/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(loginData)
                .retrieve()
                .toEntity(String.class)
                .block();

        String token = login.getBody();
        //WHEN

        ResponseEntity<String> getUser = webTestClient.get()
                .uri("http://localhost:"+port+"/api")
                .header("Authorization","Bearer"+token)
                .retrieve()
                .toEntity(String.class)
                .block();

        //THEN
        assertThat(getUser.getStatusCode(),is(HttpStatus.OK));
        assertThat(getUser.getBody(),is("Hey some-user, what's poppin' mate? Git gud and praise the sun!"));
    }

    @Test
    void getUserWithValidCredentialsButNoAuthority(){
        //GIVEN
        when(userRepository.findByUsername("some-user")).thenReturn(Optional.of(UserMongo.builder()
                .username("some-user")
                .password(passwordEncoder.encode("secretPassword"))
                .accountNonExpired(true)
                .authorities(List.of())
                .credentialsNonExpired(true)
                .accountNonLocked(true)
                .enabled(true)
                .build()));

        LoginData loginData = new LoginData("some-user","secretPassword");

        ResponseEntity<String> login = webTestClient.post()
                .uri("http://localhost:"+port+"/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(loginData)
                .retrieve()
                .toEntity(String.class)
                .block();

        String token = login.getBody();
        //WHEN

        ResponseEntity<String> getUser = webTestClient.get()
                .uri("http://localhost:"+port+"/api")
                .header("Authorization","Bearer"+token)
                .retrieve()
                .toEntity(String.class)
                .block();
        //THEN

        assertThat(getUser.getStatusCode(),is(HttpStatus.OK));
        assertThat(getUser.getBody(),is("Nope, access denied!"));
    }

    @Test
    void getUserWithInValidToken() {
        //GIVEN
        when(userRepository.findByUsername("some-user")).thenReturn(Optional.of(UserMongo.builder()
                .username("some-user")
                .password(passwordEncoder.encode("secretPassword"))
                .accountNonExpired(true)
                .authorities(List.of())
                .credentialsNonExpired(true)
                .accountNonLocked(true)
                .enabled(true)
                .build()));

        LoginData loginData = new LoginData("some-user","secretPassword");
        //WHEN
        ResponseEntity<String> getUser = webTestClient.get()
                .uri("http://localhost:"+port+"/api")
                .header("Authorization","Bearer"+"randomToken")
                .retrieve()
                .onStatus(httpStatus -> httpStatus.equals(HttpStatus.FORBIDDEN),
                        clientResponse -> Mono.empty())
                .toEntity(String.class)
                .block();
        //THEN
        assertThat(getUser.getStatusCode(),is(HttpStatus.FORBIDDEN));
    }

//    @Test
//    void postNewItem() {
//        //GIVEN
//
//        //WHEN
//
//        //THEN
//
//    }
}