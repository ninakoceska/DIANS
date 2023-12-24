package com.example.demo.repository;

import com.example.demo.model.Comment;
import com.example.demo.model.Winery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
