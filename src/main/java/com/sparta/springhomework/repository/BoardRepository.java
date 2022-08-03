package com.sparta.springhomework.repository;

import com.sparta.springhomework.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
