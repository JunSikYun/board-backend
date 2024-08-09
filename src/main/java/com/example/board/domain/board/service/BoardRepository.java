package com.example.board.domain.board.service;

import com.example.board.domain.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface BoardRepository extends JpaRepository<Board,Long> {
}
