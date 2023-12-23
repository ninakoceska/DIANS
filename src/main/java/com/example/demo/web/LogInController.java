package com.example.demo.web;

import com.example.demo.model.User;
import com.example.demo.model.response.LogInResponse;
import com.example.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins="http://localhost:4200/")
public class LogInController {

    private final UserService userService;

    public LogInController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "/login")
    @PostMapping
    public ResponseEntity<LogInResponse> logIn(@RequestBody User userRequest ){
        String username = userRequest.getUsername();
        String pass = userRequest.getPassword();
        User user=null;
        try {
             user= userService.authenticate(username, pass);
            return new ResponseEntity<>(new LogInResponse(user), HttpStatus.OK);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(new LogInResponse(e.getMessage()),HttpStatus.NOT_FOUND);

        }




    }


}

