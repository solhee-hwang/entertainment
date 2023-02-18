package com.solutionchallenge.entertainment.domain.guardian;

import com.solutionchallenge.entertainment.domain.BaseTimeEntity;
import com.solutionchallenge.entertainment.domain.senior.Senior;
import com.solutionchallenge.entertainment.domain.significant.Sigificant;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Gurdian extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long gurdianId;

    @Column
    private String name;
    private String userID;
    private String email;
    private String password;
    private String phoneNum;
    private Date birth;
    private String gender;
    private String address;

    @OneToOne
    @JoinColumn(name="senior_Id")
    private Senior senior;

    @OneToMany(mappedBy = "gurdian",orphanRemoval = true)
    private List<Sigificant> sigificants = new ArrayList<>();
}
