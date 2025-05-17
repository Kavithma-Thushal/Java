package lk.ijse.gdse66.jwt.service.impl;

import lk.ijse.gdse66.jwt.auth.request.SignupRequest;
import lk.ijse.gdse66.jwt.auth.response.AuthResponse;
import lk.ijse.gdse66.jwt.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public AuthResponse signup(SignupRequest signupRequest) {
        return null;
    }
}