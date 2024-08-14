package com.example.board.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND,"member를 찾을 수 없습니다."),
    MEMBER_ALREADY_EXISTS(HttpStatus.CONFLICT,"이미 존재하는 회원입니다."),
    INVAILD_PASSWORD(HttpStatus.BAD_REQUEST,"비밀번호가 일치하지않습니다.");
    private final HttpStatus httpStatus;
    private final String message;
}
