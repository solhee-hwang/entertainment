package com.solutionchallenge.entertainment.domain.curriculum;

import com.solutionchallenge.entertainment.domain.BaseTimeEntity;
import com.solutionchallenge.entertainment.domain.lecture.Lecture;

import javax.persistence.*;

@Entity
public class Curriculum extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long curriculumId;

    @Column
    private Long content;
    private int week;
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name="lecture_Id")
    private Lecture lecture;
}
