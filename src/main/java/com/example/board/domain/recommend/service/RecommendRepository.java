package com.example.board.domain.recommend.service;

import com.example.board.domain.recommend.entity.Recommend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface RecommendRepository extends JpaRepository<Recommend,Long> {
}
