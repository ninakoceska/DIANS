package com.example.demo.service.impl;

import com.example.demo.model.Comment;
import com.example.demo.model.Winery;
import com.example.demo.model.exception.NoWineryException;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.WineryRepository;
import com.example.demo.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    private final WineryRepository wineryRepository;

    public CommentServiceImpl(CommentRepository commentRepository, WineryRepository wineryRepository) {
        this.commentRepository = commentRepository;
        this.wineryRepository = wineryRepository;
    }


    @Override
    public Comment addComment(String text, Long id) throws NoWineryException {
        Winery winery = wineryRepository.findById(id).orElse(null);
        if(winery!=null){
            Comment comment = new Comment();
            comment.setComment(text);
            comment.setWinery(winery);
            winery.addComment(comment);
            return commentRepository.save(comment);

        }else{
            throw new NoWineryException();
        }
    }
}
