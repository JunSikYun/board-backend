package com.example.board.application.controller;

import com.example.board.application.dto.response.CanUseMemberIdResponse;
import com.example.board.application.facade.AccountFacade;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class AccountController {
    private final AccountFacade accountFacade;

    @GetMapping("")
    public ResponseEntity<CanUseMemberIdResponse> canUseMemberId(
            @RequestParam(name="memberId") String memberId){
        CanUseMemberIdResponse response=accountFacade.canUseMemberId("apple");
        return ResponseEntity.ok(response);
    }
}
