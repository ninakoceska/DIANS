package com.example.demo.service;


import com.example.demo.model.Comment;
import com.example.demo.model.exception.NoWineryException;

public interface CommentService {

    Comment addComment(String text, Long id)throws NoWineryException;
}
