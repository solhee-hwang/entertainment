package com.solutionchallenge.entertainment.domain.registration;

import com.solutionchallenge.entertainment.domain.BaseTimeEntity;
import com.solutionchallenge.entertainment.domain.lecture.Lecture;
import com.solutionchallenge.entertainment.domain.senior.Senior;
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
public class Registration extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long regiestrationId;

    @ManyToOne
    @JoinColumn(name="senior_Id")
    private Senior senior;

    @ManyToOne
    @JoinColumn(name="lecture_Id")
    private Lecture lecture;
}
