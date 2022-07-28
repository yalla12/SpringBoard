package com.sparta.springhomework.service;

import com.sparta.springhomework.domain.Board;
import com.sparta.springhomework.domain.BoardRepository;
import com.sparta.springhomework.domain.BoardRequestDto;
import com.sparta.springhomework.domain.BoardResponse;

import java.util.List;

public interface BoardSeviceInterface {

    // 전체 게시글 목록 조회
    // 작성 날짜 기준으로 내림차순 정렬하기
    List<BoardResponse> boardList();

    // 게시글 작성
    // 제목, 작성자명, 비밀번호, 작성 내용을 입력하기
    void boardSave(BoardRequestDto boardRequestDto);

    // 게시글 조회
    // 제목, 작성자명, 작성 날짜, 작성 내용을 조회하기
    Board boardSelect(Long id);

    // 게시글 비밀번호 확인
    Boolean pwdCheck(Long id, String pwd);

    // 게시글 수정
    void boardUpdate(Long id, BoardRequestDto boardRequestDto);

    // 게시글 삭제
    void boardDelete(Long id);
}
