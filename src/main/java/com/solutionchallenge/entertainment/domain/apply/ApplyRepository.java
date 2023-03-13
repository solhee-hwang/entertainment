package com.solutionchallenge.entertainment.domain.apply;

import com.solutionchallenge.entertainment.domain.senior.Senior;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ApplyRepository extends JpaRepository<Apply,Long> {

    //void deleteBySeniorIdAndLectureId(Long userId, Long lectureId);

    Optional<List<Apply>> findAllBySenior(Senior senior);
}
