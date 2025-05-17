package lk.ijse.gdse66.jwt.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JWTService {

    String generateToken(UserDetails userDetails);

    String extractUsername(String token);

    boolean validateToken(String token, UserDetails userDetails);
}