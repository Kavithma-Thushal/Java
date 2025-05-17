package lk.ijse.gdse66.jwt.controller;

import lk.ijse.gdse66.jwt.auth.request.SignupRequest;
import lk.ijse.gdse66.jwt.auth.response.AuthResponse;
import lk.ijse.gdse66.jwt.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signUp(@RequestBody SignupRequest signupRequest){
        return ResponseEntity.ok(authService.signup(signupRequest));
    }
}