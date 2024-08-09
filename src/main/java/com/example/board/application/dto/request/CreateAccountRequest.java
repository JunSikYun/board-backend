package com.example.board.application.dto.request;

import com.example.board.domain.member.entity.Gender;
import com.example.board.domain.member.entity.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;

@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class CreateAccountRequest {
    private String memberId;
    private  String password;
    private String name;
    private String call;
    private Gender gender;
    private String nickName;
    private String email;

    public Member toMember(){
        this.password= BCrypt.hashpw(this.password,BCrypt.gensalt());
        return new Member(
                memberId,
                password,
                name,
                call,
                gender,
                nickName,
                email
        );
    }
}
