package com.solutionchallenge.entertainment.domain.likeLecture;

import com.solutionchallenge.entertainment.domain.senior.Senior;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LikeLectureRespository extends JpaRepository<LikeLecture,Long> {
    Optional<List<LikeLecture>> findAllBySenior(Senior senior);
}
