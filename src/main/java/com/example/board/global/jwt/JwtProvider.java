package com.example.board.global.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtProvider {
    //secret, time 필요

    private final long ACCESS_EXPIRATION_TIME;
    private final SecretKey ACCESS_SECRET_KEY;
    public JwtProvider(
            //생성자의 매개변수를 통해 .yml의 값을 가져옴
            @Value("${jwt.access.exp-time}") long accessExpirationTime,
            @Value("${jwt.access.secret}") String accessSecret) {

        this.ACCESS_EXPIRATION_TIME=accessExpirationTime;
        this.ACCESS_SECRET_KEY= Keys.hmacShaKeyFor(Decoders.BASE64.decode(accessSecret));
    }

    public String createAccessToken(long memberId){
        long now=new Date().getTime();
        return Jwts.builder()
                .subject(memberId+"")
                //jwt를 어떤 걸로 암호화 시키는가
                .signWith(this.ACCESS_SECRET_KEY)
                .issuedAt(new Date(now))
                .expiration(new Date(now+this.ACCESS_EXPIRATION_TIME))
                .compact();
    }

}
