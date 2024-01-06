package com.example.UserLoginSystem.repository;

import com.example.UserLoginSystem.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User,Long> {


    User findFirstByUserEmail(String userEmail);

    User findByUserPassword(String encrycruptPassword);
}
