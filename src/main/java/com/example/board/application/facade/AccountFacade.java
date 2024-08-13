package com.example.board.application.facade;

import com.example.board.application.dto.request.CreateAccountRequest;
import com.example.board.application.dto.response.CanUseMemberIdResponse;
import com.example.board.domain.member.entity.Member;
import com.example.board.domain.member.service.MemberService;
import jakarta.persistence.Access;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class AccountFacade {
    private final MemberService memberService;
    public CanUseMemberIdResponse canUseMemberId(String memberId){
        boolean status=memberService.notExistsByMemberId(memberId);
        return new CanUseMemberIdResponse(status);
        //존재하지 않으면 RUNTIME EXCEPTION 발생
        //존재하면 실행

        //1. 멤버 서비스에서 유저를 memberId로 조회
        //2. 존재할 경우 false를 반환
        //3. 존재하지 않으면 true를 반환
    }
    public void registerMember(CreateAccountRequest createAccountRequest){
        //1. memberId가 존재하면 오류 발생 필요



        String memberId=createAccountRequest.getMemberId();
        if(memberService.existsByMemberId(memberId)){
            throw new RuntimeException();
        }
        Member member=createAccountRequest.toMember();
        memberService.save(member);

    }
}
