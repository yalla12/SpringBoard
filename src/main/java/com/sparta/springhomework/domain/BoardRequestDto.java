package com.sparta.springhomework.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@RequiredArgsConstructor
public class BoardRequestDto {

    private final String title; // 제목


    private final String writer; // 작성자


    private final String content; // 작성 내용


    private final String pwd; // 글 비빌번호

}
