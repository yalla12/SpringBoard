package com.sparta.springhomework.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@RequiredArgsConstructor
public class BoardRequestDto {

    private  String title; // 제목


    private  String writer; // 작성자


    private  String content; // 작성 내용


    private  String pwd; // 글 비빌번호

}
