package com.application.ecommerce.Resources;

import com.application.ecommerce.Model.User;
import com.application.ecommerce.Services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = {"/api"})
public class UserResource {
    private Logger logger = LoggerFactory.getLogger(getClass());

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    private UserService userService;

    @GetMapping(path = "/v1/user")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        logger.debug("/v1/user endpoint has been hit with request - responding with " + HttpStatus.OK);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

}
