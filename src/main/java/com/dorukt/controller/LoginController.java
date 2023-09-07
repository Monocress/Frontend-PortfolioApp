package com.dorukt.controller;

import com.dorukt.dto.request.LoginRequestDto;
import com.dorukt.repository.entity.Token;
import com.dorukt.repository.entity.User;
import com.dorukt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {

    private final UserService userService;



    @PostMapping
    public ResponseEntity<Token> login(@RequestBody LoginRequestDto dto) {
       return ResponseEntity.ok(userService.login(dto.getUsername(),dto.getPassword()));
    }



}
