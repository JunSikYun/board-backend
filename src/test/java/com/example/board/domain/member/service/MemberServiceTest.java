package com.example.board.domain.member.service;

import com.example.board.domain.member.entity.Gender;
import com.example.board.domain.member.entity.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberServiceTest {
    @Autowired
    MemberService memberService;

    @Nested
    @DisplayName("findById 테스트")
    class finById{
        @Test
        @DisplayName("실패, 데이터가 없는 경우")
        void whenFailDataNotExists(){
            Assertions.assertThrows(RuntimeException.class, ()->{
                memberService.findById(1L);
            });
        }
        @Test
        @DisplayName("성공, 데이터가 있는 경우")
        void whenSuccessDataNotExists(){
            Member member = new Member(
                    "memberId",
                    "password",
                    "name",
                    "call",
                    Gender.FEMALE,
                    "nickname",
                    "email");
            //null이 나옴 -> jpa id 생성 이전이므로
            System.out.println(member.getId());
            //jpa가 관리하는 member가 됨
            memberService.save(member);
            Assertions.assertNotNull(member.getId());
            long id=member.getId();
            Member foundMember=memberService.findById(id);
            assertEquals(member.getId(),memberService.findById(id).getId());
        }
    }
}