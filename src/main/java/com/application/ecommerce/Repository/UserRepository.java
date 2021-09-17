package com.application.ecommerce.Repository;

import com.application.ecommerce.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findUserById(Long id);

}
