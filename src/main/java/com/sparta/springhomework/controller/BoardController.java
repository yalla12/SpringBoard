package com.sparta.springhomework.controller;

import com.sparta.springhomework.domain.Board;
import com.sparta.springhomework.domain.BoardRequestDto;
import com.sparta.springhomework.domain.BoardResponse;
import com.sparta.springhomework.domain.Comment;
import com.sparta.springhomework.dto.CommentDto;
import com.sparta.springhomework.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/board")
public class BoardController {

    private final BoardService boardService;




    // 전체 게시글 목록 조회
    @GetMapping("/findAll")
    public List<BoardResponse> boardList() {
        return  boardService.boardList();
    }

    // 게시글 작성
    @PostMapping("/save")
    public ResponseEntity<Board> boardSave(@RequestBody BoardRequestDto boardRequestDto) {
        return ResponseEntity.ok(boardService.boardSave(boardRequestDto));
    }

    // 게시글 조회
    @GetMapping("/findOne/{id}")
    public Board boardSelect(@PathVariable Long id) {
        return boardService.boardSelect(id);
    }

    // 비밀번호 확인
    @GetMapping("/pwdCheck/{id}/{pwd}")
    public String pwdCheck(@PathVariable Long id, @PathVariable String pwd) {
        Boolean flag = boardService.pwdCheck(id, pwd);
        String result = "";
        if(flag) {
            result = "비밀번호가 일치합니다.";
        } else {
            result = "비밀번호가 일치하지 않습니다.";
        }
        return result;
    }

    // 게시글 수정
    @PutMapping("/update/{id}")
    public ResponseEntity<Board> boardUpdate(@PathVariable Long id,@RequestBody BoardRequestDto boardRequestDto) {

        return ResponseEntity.ok(boardService.boardUpdate(id, boardRequestDto));
    }

    // 게시글 삭제
    @DeleteMapping("/delete/{id}")
    public void boardDelete(@PathVariable Long id) {
        boardService.boardDelete(id);
    }


    // 댓글 작성
    @PostMapping("/comment/save")
    public ResponseEntity<Comment> saveComment(@RequestBody CommentDto commentDto) {

        return ResponseEntity.ok(boardService.saveComment(commentDto));
    }

    //댓글 목록 조회
    @GetMapping("/comment/findByComment/{id}")
    public List<Comment>findByComment(@PathVariable Long id) {
        return  boardService.findByComment(id);
    }

    //댓글 수정
    @PutMapping("/comment/update/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long id,@RequestBody CommentDto commentDto) {

        return ResponseEntity.ok(boardService.updateComment(id, commentDto));
    }

    // 게시글 삭제
    @DeleteMapping("/comment/delete/{id}")
    public void deleteComment(@PathVariable Long id) {
        boardService.deleteComment(id);
    }


}
