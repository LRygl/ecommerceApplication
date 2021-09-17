package com.application.ecommerce.Services.ServiceImplementation;

import com.application.ecommerce.Model.User;
import com.application.ecommerce.Repository.UserRepository;
import com.application.ecommerce.Services.UserService;
import lombok.Builder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
@Qualifier("UserDetailsService")
public class UserServiceImpl implements UserService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    @Override
    public List<User> getAllUsers() {return userRepository.findAll();}

    @Override
    public User findUserById(Long id){
        return userRepository.findUserById(id);
    }

    @Override
    public void deleteUserById(Long id){userRepository.deleteById(id);}
}
