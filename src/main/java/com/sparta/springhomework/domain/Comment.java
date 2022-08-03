package com.sparta.springhomework.domain;

import com.sparta.springhomework.dto.CommentDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@ToString
@Getter
@NoArgsConstructor
@Entity
public class Comment extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // id 자동 증가 명령
    @Column(name = "comment_id")
    private Long CommentId; // 게시물 id

    @Column(nullable = false)
    private String writer; // 작성자

    @Column(nullable = false)
    private String content; // 작성 내용

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    public Comment(CommentDto commentDto, Board board) {
        this.writer = commentDto.getWriter();
        this.content = commentDto.getContent();
        this.board = board;
    }

    public void update(CommentDto commentDto) {
        this.writer = commentDto.getWriter();
        this.content = commentDto.getContent();
    }


}
