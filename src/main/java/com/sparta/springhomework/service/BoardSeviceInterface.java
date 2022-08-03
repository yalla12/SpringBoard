package com.sparta.springhomework.service;

import com.sparta.springhomework.domain.*;
import com.sparta.springhomework.dto.CommentDto;

import java.util.List;

public interface BoardSeviceInterface {

    // 전체 게시글 목록 조회
    // 작성 날짜 기준으로 내림차순 정렬하기
    List<BoardResponse> boardList();

    // 게시글 작성
    // 제목, 작성자명, 비밀번호, 작성 내용을 입력하기
    Board boardSave(BoardRequestDto boardRequestDto);

    // 게시글 조회
    // 제목, 작성자명, 작성 날짜, 작성 내용을 조회하기
    Board boardSelect(Long id);

    // 게시글 비밀번호 확인
    Boolean pwdCheck(Long id, String pwd);

    // 게시글 수정
    Board boardUpdate(Long id, BoardRequestDto boardRequestDto);

    // 게시글 삭제
    void boardDelete(Long id);

    // 댓글 저장
    Comment saveComment(CommentDto commentDto);

    // 댓글 목록 조회
    List<Comment> findByComment(Long id);

    // 댓글 수정
    Comment updateComment(Long id, CommentDto commentDto);

    // 댓글 삭제
    void deleteComment(Long id);
}
