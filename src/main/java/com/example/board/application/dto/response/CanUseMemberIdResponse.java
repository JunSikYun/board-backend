package com.example.board.application.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class CanUseMemberIdResponse {
    private boolean stats;
}
