package lk.ijse.gdse66.jwt.service.impl;

import lk.ijse.gdse66.jwt.auth.request.SigninRequest;
import lk.ijse.gdse66.jwt.auth.request.SignupRequest;
import lk.ijse.gdse66.jwt.auth.response.AuthResponse;
import lk.ijse.gdse66.jwt.dto.UserDTO;
import lk.ijse.gdse66.jwt.entity.User;
import lk.ijse.gdse66.jwt.repository.UserRepository;
import lk.ijse.gdse66.jwt.service.AuthService;
import lk.ijse.gdse66.jwt.service.JWTService;
import lk.ijse.gdse66.jwt.util.Role;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AuthResponse signup(SignupRequest signupRequest) {

        UserDTO userDTO = UserDTO.builder()
                .name(signupRequest.getName())
                .email(signupRequest.getEmail())
                .password(passwordEncoder.encode(signupRequest.getPassword()))
                .role(Role.valueOf(signupRequest.getRole()))
                .build();

        User savedUser = userRepository.save(modelMapper.map(userDTO, User.class));
        String generatedToken = jwtService.generateToken(savedUser);
        return AuthResponse.builder().token(generatedToken).build();
    }

    @Override
    public AuthResponse signin(SigninRequest signinRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signinRequest.getEmail(), signinRequest.getPassword()));
        User user = userRepository.findByEmail(signinRequest.getEmail()).orElseThrow(() -> new RuntimeException("User not found!"));
        String generatedToken = jwtService.generateToken(user);
        return AuthResponse.builder().token(generatedToken).build();
    }
}