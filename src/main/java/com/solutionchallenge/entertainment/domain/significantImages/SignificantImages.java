package com.solutionchallenge.entertainment.domain.significantImages;

import com.solutionchallenge.entertainment.domain.BaseTimeEntity;
import com.solutionchallenge.entertainment.domain.significant.Sigificant;
import com.solutionchallenge.entertainment.domain.significant.SignificantRepository;

import javax.persistence.*;

@Entity
public class SignificantImages extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long significantImageId;

    @Column
    private Long imageUrl;

    @ManyToOne
    @JoinColumn(name="significant_Id")
    private Sigificant significant;
}
