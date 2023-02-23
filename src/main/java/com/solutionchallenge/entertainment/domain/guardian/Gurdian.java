package com.solutionchallenge.entertainment.domain.guardian;

import com.solutionchallenge.entertainment.domain.BaseTimeEntity;
import com.solutionchallenge.entertainment.domain.senior.Senior;
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
public class Gurdian extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long gurdianId;

    @Column
    private String name;
    private String nickName;
    private String password;
    private String phoneNum;
    private Date birth;
    private String gender;
    private String address;
    private String profilUrl;
    private String email;
    @OneToOne
    @JoinColumn(name="senior_Id")
    private Senior senior;

    @OneToMany(mappedBy = "gurdian",orphanRemoval = true)
    private List<Sigificant> sigificants = new ArrayList<>();
}
