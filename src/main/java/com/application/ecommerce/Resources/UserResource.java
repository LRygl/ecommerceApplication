package com.application.ecommerce.Resources;

import com.application.ecommerce.Model.HttpResponse;
import com.application.ecommerce.Model.User;
import com.application.ecommerce.Services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = {"/api/v1"})
public class UserResource {
    private Logger logger = LoggerFactory.getLogger(getClass());

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    private UserService userService;

    @GetMapping(path = "/users")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        logger.debug("/v1/user endpoint has been hit with request - responding with " + HttpStatus.OK);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping(path = "/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
        User user = userService.findUserById(id);
        logger.debug("Returning user with UserId " + id + "Response is" + HttpStatus.OK);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

/*    @DeleteMapping(path = "/user/delete/{id}")
    public ResponseEntity<HttpResponse> deleteUserById(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return customHttpResponse(HttpStatus.NO_CONTENT, "User deleted succesfully");
    }

    private ResponseEntity<HttpResponse> customHttpResponse(HttpStatus httpStatus, String messageContent){
        return new ResponseEntity<>(new HttpResponse(httpStatus.value(),httpStatus, httpStatus.getReasonPhrase().toUpperCase(),messageContent.toUpperCase()), httpStatus);
    }*/
}
