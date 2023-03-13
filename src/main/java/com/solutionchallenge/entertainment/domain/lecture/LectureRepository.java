package com.solutionchallenge.entertainment.domain.lecture;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LectureRepository extends JpaRepository<Lecture,Long> {
    List<Lecture> findAllByCategory(String category, Sort sort);

    //void findAll(String sort);

    //List<Lecture> findAllByCategory(Sort sort);
}
