package com.example.board.application.dto.request;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LoginAccountRequest {

    private String memberId;
    private String password;
}
