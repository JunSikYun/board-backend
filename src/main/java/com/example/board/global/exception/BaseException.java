package com.example.board.global.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class BaseException extends RuntimeException{
    private final ErrorCode errorCode;

    public static BaseException from(ErrorCode errorCode){
        return new BaseException(errorCode);
    }



}
