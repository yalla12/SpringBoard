package com.sparta.springhomework.service;

import com.sparta.springhomework.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BoardService implements BoardSeviceInterface {

    private final BoardRepository boardRepository;


    @Override
    public List<BoardResponse> boardList() {
        List<Board> list =
                boardRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));

        List<BoardResponse> dtoList = new ArrayList<>();

        for(Board b : list) {
            BoardResponse boardRequestDto = new BoardResponse(b.getTitle(),b.getWriter(),b.getCreatedAt());
            dtoList.add(boardRequestDto);

        }

        return dtoList;
    }

    @Transactional
    @Override
    public void boardSave(BoardRequestDto boardRequestDto) {
        Board board = new Board(boardRequestDto);
        // 제목 빈 값 체크
        if (board.getTitle() == null || board.getTitle().isEmpty()) {
           throw new NullPointerException("제목이 공백입니다.");
        }
        // 글쓴이 빈 값 체크
        if (board.getWriter() == null || board.getWriter().isEmpty()) {
            throw new NullPointerException("작성자가 공백입니다.");
        }
        // 비밀번호 빈 값 체크
        if (board.getPwd() == null || board.getPwd().isEmpty()) {
            throw new NullPointerException("비밀번호가 공백입니다.");
        }
        // 내용 빈 값 체크
        if (board.getContent() == null || board.getContent().isEmpty()) {
            throw new NullPointerException("내용이 공백입니다.");
        }
        boardRepository.save(board);

    }

    @Override
    public Board boardSelect(Long id) {


        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        return board;
    }

    @Override
    public Boolean pwdCheck(Long id, String pwd) {
        boolean flag = false;
        Board board = boardSelect(id);

        if (board.getPwd().equals(pwd)) {
            flag = true;
        }
        return flag;
    }

    @Transactional
    @Override
    public void boardUpdate(Long id, BoardRequestDto boardRequestDto) {
        Board board = boardSelect(id);
        board.update(boardRequestDto);
        boardRepository.save(board);

    }

    @Transactional
    @Override
    public void boardDelete(Long id) {
        boardRepository.deleteById(id);

    }
}
