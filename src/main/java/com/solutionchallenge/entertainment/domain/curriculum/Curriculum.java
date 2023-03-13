package com.solutionchallenge.entertainment.domain.curriculum;

import com.solutionchallenge.entertainment.domain.BaseTimeEntity;
import com.solutionchallenge.entertainment.domain.lecture.Lecture;
import com.solutionchallenge.entertainment.service.dto.TutorLectureDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Curriculum extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long curriculumId;

    @Column
    private String content;
    private String imageUrl;


    @ManyToOne
    @JoinColumn(name="lecture_Id")
    private Lecture lecture;

    public static Curriculum getNewInstance(String content, Lecture lecture) {
        return Curriculum.builder()
                .content(content)
                .lecture(lecture)
                .build();
    }
}
