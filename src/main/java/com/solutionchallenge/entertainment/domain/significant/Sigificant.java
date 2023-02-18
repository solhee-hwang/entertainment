package com.solutionchallenge.entertainment.domain.significant;

import com.solutionchallenge.entertainment.domain.BaseTimeEntity;
import com.solutionchallenge.entertainment.domain.guardian.Gurdian;
import com.solutionchallenge.entertainment.domain.significantImages.SignificantImages;
import com.solutionchallenge.entertainment.domain.tutor.Tutor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Sigificant extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long significantId;

    @Column
    private String title;
    private String content;
    private String lectureName;
    private String seniorName;

    @ManyToOne
    @JoinColumn(name="gurdian_Id")
    private Gurdian gurdian;

    @ManyToOne
    @JoinColumn(name="tutor_Id")
    private Tutor tutor;

    @OneToMany(mappedBy = "significant", orphanRemoval = true)
    private List<SignificantImages> significantImages = new ArrayList<>();

}
