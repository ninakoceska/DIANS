package com.example.demo.model.response;

import com.example.demo.model.User;
import lombok.Data;

@Data
public class LogInResponse {
    private User user;
    private String  errorMessage;

    public LogInResponse(User user) {
        this.user = user;
    }

    public LogInResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public User getUser() {
        return user;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
