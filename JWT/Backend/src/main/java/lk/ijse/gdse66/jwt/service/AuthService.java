package lk.ijse.gdse66.jwt.service;

import lk.ijse.gdse66.jwt.auth.request.SigninRequest;
import lk.ijse.gdse66.jwt.auth.request.SignupRequest;
import lk.ijse.gdse66.jwt.auth.response.AuthResponse;

public interface AuthService {

    AuthResponse signup(SignupRequest signupRequest);

    AuthResponse signin(SigninRequest signinRequest);
}