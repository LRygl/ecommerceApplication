package com.application.ecommerce.Services;

import com.application.ecommerce.Model.User;
import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User findUserById(Long id);
    void deleteUserById(Long id);

}
