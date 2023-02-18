package com.solutionchallenge.entertainment.domain.interest;

import com.solutionchallenge.entertainment.domain.BaseTimeEntity;
import com.solutionchallenge.entertainment.domain.senior.Senior;

import javax.persistence.*;

@Entity
public class Interest extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long interesId;

    @Column
    private String content;

    @ManyToOne
    @JoinColumn(name="senior_Id")
    private Senior senior;
}
