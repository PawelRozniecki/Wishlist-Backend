package com.wishlist.services;

import com.wishlist.model.User;
import com.wishlist.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class UserService implements UserDetailsService {
    private final static String USER_NOT_FOUND_ERR_MSG = "User %s not found";
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(()->
                new UsernameNotFoundException(String.format(USER_NOT_FOUND_ERR_MSG, email)));
    }

    public String signUpUser(User user){
       boolean userExists =  userRepository.findByEmail(user.getEmail()).isPresent();
       if(userExists){
           throw new IllegalStateException("Email taken");
       }
       String encodedPass = encoder.encode(user.getPassword());
       log.info(encodedPass);
       user.setPassword(encodedPass);

       userRepository.save(user);

       // TODO : Send confirmation token
       return "Sign up complete";
    }
}
