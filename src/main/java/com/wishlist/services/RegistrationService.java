package com.wishlist.services;

import com.wishlist.enums.UserRole;
import com.wishlist.model.RegistrationRequest;
import com.wishlist.model.User;
import com.wishlist.registration.EmailValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final EmailValidator emailValidator;
    private final UserService userService;

    public String register(RegistrationRequest request) {
       boolean isEmailValid = emailValidator.test(request.getEmail());
       if(!isEmailValid){
           throw  new IllegalStateException(String.format("Email %s is not valid", request.getEmail()));
       }

        return userService.signUpUser(new User(request.getUsername(), request.getEmail(), request.getPassword(), UserRole.USER));
    }
}
