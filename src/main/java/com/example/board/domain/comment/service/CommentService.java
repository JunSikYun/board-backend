package com.example.board.domain.comment.service;

import com.example.board.domain.comment.entity.Comment;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentService {
    private final CommentRepository commentRepository;

    public Comment findById(long id){
        return commentRepository.findById(id).orElseThrow(RuntimeException::new);
        //TODO : 예외처리 필요!
    }

    public void save(Comment comment){
        commentRepository.save(comment);
    }
}
