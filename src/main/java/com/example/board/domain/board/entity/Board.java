package com.example.board.domain.board.entity;

import com.example.board.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@JoinColumn은 데이터베이스에서 스키마 생성할 때 Column을 어떤 걸로 생성하느냐
    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member;
    @Column(name="title",nullable=false)
    private String title;
    //@CreateDate SQL에서 자동으로 시간을 INSERT 해줌
    @CreatedDate
    @Column(name="create_at",nullable=false)
    private LocalDateTime createAt;
    //@ColumnDefault는 초기값을 0으로 INSERT 해줌
    @ColumnDefault("0")
    @Column(name="view",nullable=false)
    private int view;
    @Column(name="content",nullable=false)
    private String content;
}
d