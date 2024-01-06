package com.example.UserLoginSystem.service;
import com.example.UserLoginSystem.model.User;
import com.example.UserLoginSystem.model.dto.SignInInputDto;
import com.example.UserLoginSystem.repository.UserRepo;
import jakarta.xml.bind.DatatypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    public String signUpUser(User user) throws NoSuchAlgorithmException {
            String newEmail = user.getUserEmail();

          User user1 = userRepo.findFirstByUserEmail(newEmail);

            if(user1 == null){
                String encryptedPassword = passwordEncrypted(user.getUserPassword());
                user.setUserPassword(encryptedPassword);
                userRepo.save(user);
                return "create account successful";
            }
            else {
                return "you are already register";

                 }
    }
    public String signIn(SignInInputDto signInInputDto) throws NoSuchAlgorithmException {
        User user = userRepo.findFirstByUserEmail(signInInputDto.getEmail());
         if (user == null) return "email not found";

            String encrycruptPassword = passwordEncrypted(signInInputDto.getPassword());
            User user1 = userRepo.findByUserPassword(encrycruptPassword);
            if (user1 == null) return "password invalid";
            return "login successful";
    }
    public String passwordEncrypted(String password) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(password.getBytes());
        byte[] digested = messageDigest.digest();
        return DatatypeConverter.printHexBinary(digested);
    }
}

