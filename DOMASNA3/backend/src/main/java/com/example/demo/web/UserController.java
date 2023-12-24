package com.example.demo.web;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins="http://localhost:4200/")
public class UserController{

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<Optional<User>> getUser(@PathVariable Long id){
        return new ResponseEntity<>(userService.findAllById(id), HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

}
