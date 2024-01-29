package com.example.demo.web;

import com.example.demo.model.User;
import com.example.demo.model.response.RegisterResponse;
import com.example.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/register")
@CrossOrigin(origins="http://localhost:4200/")
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<RegisterResponse> register(@RequestBody User req){
        try {
            User user =  userService.saveUser(req.getUsername(), req.getPassword(), req.getEmail());
            return new ResponseEntity<>(new RegisterResponse(user), HttpStatus.OK);
        }catch (RuntimeException e){
            return new ResponseEntity<>(new RegisterResponse(e.getMessage()),HttpStatus.LOCKED);
        }

    }

}
