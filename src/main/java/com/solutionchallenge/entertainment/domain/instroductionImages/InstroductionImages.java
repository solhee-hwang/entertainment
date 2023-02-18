package com.solutionchallenge.entertainment.domain.instroductionImages;

import com.solutionchallenge.entertainment.domain.lecture.Lecture;

import javax.persistence.*;

@Entity
public class InstroductionImages {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long instroductionImageId;

    @Column
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "lecture_Id")
    private Lecture lecture;
}
