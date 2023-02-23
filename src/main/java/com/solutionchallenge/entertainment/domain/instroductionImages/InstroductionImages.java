package com.solutionchallenge.entertainment.domain.instroductionImages;

import com.solutionchallenge.entertainment.domain.lecture.Lecture;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
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
