package com.example.board.application.facade;

import com.example.board.application.dto.request.CreateAccountRequest;
import com.example.board.application.dto.response.CanUseMemberIdResponse;
import com.example.board.domain.member.entity.Member;
import com.example.board.domain.member.service.MemberService;
import com.example.board.global.jwt.JwtProvider;
import jakarta.persistence.Access;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class AccountFacade {
    private final MemberService memberService;
    private final JwtProvider jwtProvider;
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


    public String loginAccount(String memberId, String password){
        // 1.memberId 조회
        // 2.가져온 값에서 password와 일치하나 확인

        //memberId 조회
        Member member=memberService.findByMemberId(memberId);

        String databasePassword=member.getPassword();
        if(!BCrypt.checkpw(password,databasePassword)){
            throw new RuntimeException();
        }
        //여기서 jwt 발급 필요

        //DB에서 가져오는 PW는 암호화되어있기 때문에 false만 뜸
//        if(databasePassword.equals(password)){
//            return true;
//        }
//        return false;
        return jwtProvider.createAccessToken(member.getId());
    }
}
