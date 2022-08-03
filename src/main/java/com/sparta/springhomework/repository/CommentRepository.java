package com.sparta.springhomework.repository;


import com.sparta.springhomework.domain.Board;
import com.sparta.springhomework.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {

    List<Comment> findAllByBoard(Board board);

}
