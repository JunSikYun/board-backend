package com.example.board.domain.member.service;

import com.example.board.domain.member.entity.Member;
import com.example.board.global.exception.BaseException;
import com.example.board.global.exception.ErrorCode;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberService {
    private final MemberRepository memberRepository;

    public Member findById(long id){
        return memberRepository.findById(id).orElseThrow(
                ()->BaseException.from(ErrorCode.MEMBER_NOT_FOUND));
    }

    public Member findByMemberId(String memberId){
        return memberRepository.findByMemberId(memberId).orElseThrow(
                ()->BaseException.from(ErrorCode.MEMBER_NOT_FOUND));
    }
    public boolean existsByMemberId(String memberId){
        return memberRepository.existsByMemberId(memberId);
    }
    public boolean notExistsByMemberId(String memberId){
        return !existsByMemberId(memberId);
    }
    public void save(Member member){
        memberRepository.save(member);
    }

}
