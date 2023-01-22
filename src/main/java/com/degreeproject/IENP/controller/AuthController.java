package com.degreeproject.IENP.controller;

import com.degreeproject.IENP.dto.AuthResponseDto;
import com.degreeproject.IENP.dto.LoginDto;
import com.degreeproject.IENP.dto.RegisterDto;
import com.degreeproject.IENP.entity.Faculty;
import com.degreeproject.IENP.entity.Role;
import com.degreeproject.IENP.entity.UserEntity;
import com.degreeproject.IENP.repository.FacultyRepository;
import com.degreeproject.IENP.repository.RoleRepository;
import com.degreeproject.IENP.repository.UserRepository;
import com.degreeproject.IENP.security.JwtGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private RoleRepository roleRepository;
    private AuthenticationManager authenticationManager;
    private JwtGenerator jwtGenerator;
    private FacultyRepository facultyRepository;

    @Autowired
    public AuthController(UserRepository userRepository,
                          PasswordEncoder passwordEncoder,
                          RoleRepository roleRepository,
                          AuthenticationManager authenticationManager,
                          JwtGenerator jwtGenerator,
                          FacultyRepository facultyRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.authenticationManager = authenticationManager;
        this.jwtGenerator = jwtGenerator;
        this.facultyRepository = facultyRepository;
    }

    @PostMapping("register")
    public ResponseEntity<AuthResponseDto> register(@RequestBody RegisterDto registerDto){
        if(userRepository.existsByUsername(registerDto.getUsername())){
            return new ResponseEntity<>(new AuthResponseDto("Email already taken"), HttpStatus.BAD_REQUEST);
        }
        UserEntity user = new UserEntity();
        user.setUsername(registerDto.getUsername());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        Role role =roleRepository.findByName("USER").get();
        user.setRole(Collections.singletonList(role));
        userRepository.save(user);

        Faculty userFaculty = new Faculty();

        userFaculty.setUsername(registerDto.getUsername());
        userFaculty.setName(registerDto.getName());
        userFaculty.setDepartment(registerDto.getDepartment());

        facultyRepository.save(userFaculty);

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        registerDto.getUsername(),
                        registerDto.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);

        return new ResponseEntity<>(new AuthResponseDto(token), HttpStatus.OK);

    }

    @PostMapping("login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    loginDto.getUsername(),
                    loginDto.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);

        return new ResponseEntity<>(new AuthResponseDto(token), HttpStatus.OK);
    }

}
