package com.example.demo.model.response;

import com.example.demo.model.User;
import lombok.Data;

@Data
public class RegisterResponse {
    private User user;
    private String errorMessage;

    public RegisterResponse(User user) {
        this.user = user;
    }

    public RegisterResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public User getUser() {
        return user;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
