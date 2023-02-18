package com.solutionchallenge.entertainment.domain.lecture;

import com.solutionchallenge.entertainment.domain.BaseTimeEntity;
import com.solutionchallenge.entertainment.domain.category.Category;
import com.solutionchallenge.entertainment.domain.instroductionImages.InstroductionImages;
import com.solutionchallenge.entertainment.domain.likeLecture.LikeLecture;
import com.solutionchallenge.entertainment.domain.tutor.Tutor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Lecture extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long lectureId;

    @Column
    private String instroduction;
    private Date startDate;
    private Date endDate;
    private String lcoation;
    private int likeCount;

    @ManyToOne
    @JoinColumn(name="tutor_Id")
    private Tutor tutor;

    @ManyToOne
    @JoinColumn(name="category_Id")
    private Category category;

    @OneToMany(mappedBy = "lecture",orphanRemoval = true)
    List<InstroductionImages> instroductionImages = new ArrayList<>();

    @OneToMany(mappedBy = "lecture",orphanRemoval = true)
    List<LikeLecture> likeLectures = new ArrayList<>();
}
