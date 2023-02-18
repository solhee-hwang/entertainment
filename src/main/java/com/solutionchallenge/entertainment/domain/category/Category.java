package com.solutionchallenge.entertainment.domain.category;

import com.solutionchallenge.entertainment.domain.BaseTimeEntity;
import com.solutionchallenge.entertainment.domain.lecture.Lecture;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long categoryId;

    @Column
    private String content;

    @OneToMany(mappedBy = "category")
    private List<Lecture> lectures = new ArrayList<>();

}
