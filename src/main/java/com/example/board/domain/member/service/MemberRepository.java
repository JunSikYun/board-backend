package com.example.board.domain.member.service;

import com.example.board.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface MemberRepository extends JpaRepository<Member,Long> {
    Optional<Member> findByMemberId(String memberId);
    boolean existsByMemberId(String memberId);
}
