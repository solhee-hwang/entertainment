package com.solutionchallenge.entertainment.domain.tutor;

import com.solutionchallenge.entertainment.domain.BaseTimeEntity;
import com.solutionchallenge.entertainment.domain.lecture.Lecture;
import com.solutionchallenge.entertainment.domain.significant.Sigificant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Tutor extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tutorId;

    @Column
    private String name;
    private String nickName;
    private String password;
    private String phoneNum;
    private Date birth;
    private String gender;
    private String profilUrl;
    private String address;
    private String email;
    private String career;
    private String introduction;

    @OneToMany(mappedBy = "tutor", orphanRemoval = true)
    private List<Sigificant> sigificants = new ArrayList<>();

    @OneToMany(mappedBy = "tutor", orphanRemoval = true)
    private List<Lecture> lectures = new ArrayList<>();

}
