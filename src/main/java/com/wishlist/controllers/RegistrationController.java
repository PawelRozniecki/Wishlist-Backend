package com.wishlist.controllers;

import com.wishlist.model.Product;
import com.wishlist.model.RegistrationRequest;
import com.wishlist.model.User;
import com.wishlist.services.RegistrationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
@AllArgsConstructor

@Slf4j
public class RegistrationController {

    RegistrationService registrationService;
    @PostMapping("/signup")
    public String register(@RequestBody RegistrationRequest request){
        log.info(request.toString());
       return registrationService.register(request);

    }
    @GetMapping("/confirm")
    public String confirm(@RequestParam("token") String token){
        return registrationService.confirmToken(token);
    }


}
