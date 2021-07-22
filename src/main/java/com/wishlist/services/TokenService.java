package com.wishlist.services;

import com.wishlist.registration.token.ConfirmToken;
import com.wishlist.repositories.TokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TokenService {

    private final TokenRepository tokenRepository;

    public void saveConfirmToken(ConfirmToken token){
        tokenRepository.save(token);
    }
    public Optional<ConfirmToken> getToken(String token){
        return tokenRepository.findByToken(token);
    }
    public int updateConfirmedAt(String token){
        return tokenRepository.updateConfirmedAt(token, LocalDateTime.now());
    }
    public int setConfirmedAt(String token) {
        return tokenRepository.updateConfirmedAt(
                token, LocalDateTime.now());
    }

}
