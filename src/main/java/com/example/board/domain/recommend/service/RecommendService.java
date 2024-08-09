package com.example.board.domain.recommend.service;

import com.example.board.domain.recommend.entity.Recommend;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class RecommendService {
    private final RecommendRepository recommendRepository;

    public Recommend findById(long id){
        return recommendRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public void save(Recommend recommend){
        recommendRepository.save(recommend);
    }
}
