package com.pm.secureapispringboot.resources;


import com.pm.secureapispringboot.domain.Response;
import com.pm.secureapispringboot.dtoRequest.UserRequest;
import com.pm.secureapispringboot.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

import static com.pm.secureapispringboot.utils.RequestUtils.getResponse;
import static java.util.Collections.emptyMap;
import static org.springframework.http.HttpStatus.CREATED;

/**
 * @author Douglas Nyabasa
 * @version 1.0
 * @since 25/06/2025
 */


@RestController
@RequestMapping(path = {"/user"})
public class UserResource {

    private final UserService userService;


    public UserResource(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/register")
    public ResponseEntity<Response> register(@RequestBody @Valid UserRequest user, HttpServletRequest request) {
        userService.createUser(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
        return ResponseEntity.created(getUri()).body(getResponse(request, emptyMap(),"Account created.Check your email to enable account",CREATED));


    }

    private URI getUri() {
        return  URI.create("/user");
    }


}
