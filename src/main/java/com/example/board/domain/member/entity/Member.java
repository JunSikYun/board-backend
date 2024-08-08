package com.example.board.domain.member.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Member {
    // IDENTITY값을 자동으로 생성하겠다는 의미
    //@Column에서 name은 Column 명, nullable은 null값 허용 여부
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="member_id",nullable = false)
    private String memberId;
    @Column(name="password",nullable = false)
    private String password;
    @Column(name="name",nullable = false)
    private String name;
    @Column(name="call",nullable = false)
    private  String call;
    @Column(name="gender",nullable = false)
    //@Enumerated()는 gender을 문자형으로 데이터 베이스에 저장하겠다는 의미
    //gender는 int, long이 아닌 사용자 지정 타입이므로
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(name="nick_name",nullable = false)
    private  String nickName;
    @Column(name="email",nullable = false)
    private String email;

    public Member(String memberId, String password, String name, String call, Gender gender, String nickName, String email) {
        this.memberId = memberId;
        this.password = password;
        this.name = name;
        this.call = call;
        this.gender = gender;
        this.nickName = nickName;
        this.email = email;
    }
}
