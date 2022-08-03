package com.sparta.springhomework.dto;


import com.sparta.springhomework.domain.Board;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CommentDto {

    private String writer; // 작성자

    private String content; // 작성 내용

    private Long boardId; // 게시물 번호
}
