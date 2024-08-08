package com.example.board.domain.comment.entity;

import com.example.board.domain.board.entity.Board;
import com.example.board.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "content",nullable = false)
    private String content;

    @CreatedDate
    @Column(name="create_at",nullable=false)
    private LocalDateTime createAt;
}
