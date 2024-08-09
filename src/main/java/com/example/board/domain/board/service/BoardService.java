package com.example.board.domain.board.service;

import com.example.board.domain.board.entity.Board;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardService {

    private final BoardRepository boardRepository;

    public Board findById(long id){
        return boardRepository.findById(id).orElseThrow(RuntimeException::new);
        //TODO : 예외처리 작성하기!
    }

    public void save(Board board){
        boardRepository.save(board);
    }
}
