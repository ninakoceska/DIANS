package com.example.demo.model;


import com.example.demo.model.exception.*;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.Base64;

@Data
@Table(name="Winery_Users")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String password;

    String email;

    String username;



    public void setPassword(String password)throws InvalidPasswordSavedException, InvalidPasswordSpecialCharException, InvalidPasswordLenghtException {
        this.password=password;
       //this.password= Base64.getEncoder().encodeToString(plainText.getBytes());
    }

    public void setEmail(String email)throws InvalidEmailException, MailCantExitsException {

//        if(!email.contains("@") || !email.contains("com") || !email.contains(".")){
//            throw new InvalidEmailException(email);
//        }
//
//        if(!email.contains("hotmail") && !email.contains("gmail") && !email.contains("yahoo") && !email.contains("outlook")){
//            throw new MailCantExitsException(email);
//        }


        this.email=email;
    }



    public Long getId() {
        return this.id;
    }


    public String getPassword() {
        return this.password;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }


}
