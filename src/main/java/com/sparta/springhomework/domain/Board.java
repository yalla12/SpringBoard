package com.sparta.springhomework.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
@ToString
@Getter
@NoArgsConstructor
@Entity
public class Board extends Timestamped  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // id 자동 증가 명령
    private Long id; // 게시물 id

    @Column(nullable = false)
    private String title; // 제목

    @Column(nullable = false)
    private String writer; // 작성자

    @Column(nullable = false)
    private String content; // 작성 내용

    @Column(nullable = false)
    private String pwd; // 글 비빌번호


    public Board(BoardRequestDto boardRequestDto) {
        this.title = boardRequestDto.getTitle();
        this.writer = boardRequestDto.getWriter();
        this.content = boardRequestDto.getContent();
        this.pwd = boardRequestDto.getPwd();
    }

    public void update(BoardRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.writer = requestDto.getWriter();
        this.content = requestDto.getContent();
        this.pwd = requestDto.getPwd();
    }




}
