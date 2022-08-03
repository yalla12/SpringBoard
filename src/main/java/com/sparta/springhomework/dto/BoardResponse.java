package com.sparta.springhomework.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
public class BoardResponse {
    private String title; // 제목

    private String writer; // 작성자

    private LocalDateTime createdAt; // 삭정날짜

    public BoardResponse(String title, String writer, LocalDateTime createdAt) {
        this.title = title;
        this.writer = writer;
        this.createdAt = createdAt;
    }
}

