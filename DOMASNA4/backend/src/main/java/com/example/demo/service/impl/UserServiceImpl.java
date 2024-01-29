package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.model.exception.*;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User findUser(String username, String pass) {
        return userRepository.findByUsernameAndPassword(username, pass).orElseThrow(InvalidCredentialsException::new);
    }



    @Override
    public Optional<User> findAllById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User findAllByUsername(String username) {
        return userRepository.findAllByUsername(username).orElseThrow(() -> new NoUserFoundException(username));
    }


    @Override//register form
    public User saveUser(String username, String pass,String email) throws InvalidPasswordLenghtException,
            InvalidPasswordSavedException, InvalidPasswordSpecialCharException,
            InvalidUsernameException, NoUserFoundException, InfoMissingException{

        User user = new User();
        List<User> userList = userRepository.findAll();


        if(username.isEmpty() || pass.isEmpty() || email.isEmpty())throw new InfoMissingException();

        if(userList.stream().anyMatch(r->r.getUsername().equals(username))){
            throw new InvalidUsernameException(username);
        }

        if(userList.stream().anyMatch(r->r.getEmail().equals(email))){
            throw new InvalidEmailException(email);
        }

        checkMailContent(email);

        checkPasswordContent(pass);

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        String encodedPass = bCryptPasswordEncoder.encode(pass);

        user.setUsername(username);
        user.setPassword(encodedPass);
        user.setEmail(email);

        return userRepository.save(user);
    }


    @Override//log in form
    public User authenticate(String username, String pass) throws InvalidCredentialsException,
            InvalidPasswordLenghtException, InvalidPasswordSavedException,
            InvalidPasswordSpecialCharException, NoUserFoundException,
            PasswordIncorrectException,InfoMissingException{


        if(username.isEmpty() || pass.isEmpty()) throw new InfoMissingException();


        User user = userRepository.findAllByUsername(username).orElse(null);

        if(user==null) throw  new NoUserFoundException(username);


        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        if(!passwordEncoder.matches(pass,user.getPassword())) throw new PasswordIncorrectException();


        return user;

    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public void checkMailContent(String email)throws MailSpecialCharException,MailNotValidException
            ,MailNotCompletedException{

        if(!email.contains("@"))throw new MailSpecialCharException();

        if(!email.endsWith(".com")) throw new MailNotCompletedException();

        if(!email.contains("gmail") && !email.contains("hotmail") && !email.contains("yahoo")
                && !email.contains("outlook")) throw new MailNotValidException();

    }


    public void checkPasswordContent(String password)throws
            InvalidPasswordLenghtException, InvalidPasswordSavedException,PasswordNumberException,InvalidPasswordSpecialCharException{

       // if(!password.equals(repeatPassword)) throw new InvalidRepeatPassword();

        if(password.length()<8) throw new InvalidPasswordLenghtException();

        if (!password.matches(".*[A-Z].*")) throw new InvalidPasswordSavedException();

        if (!password.matches(".*\\d.*")) throw new PasswordNumberException();

        if (!password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\",.<>/?].*")) throw new InvalidPasswordSpecialCharException();

    }



}

