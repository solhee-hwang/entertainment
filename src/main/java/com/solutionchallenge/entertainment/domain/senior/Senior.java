package com.solutionchallenge.entertainment.domain.senior;

import com.solutionchallenge.entertainment.domain.BaseTimeEntity;
import com.solutionchallenge.entertainment.domain.guardian.Gurdian;
import com.solutionchallenge.entertainment.domain.interest.Interest;
import com.solutionchallenge.entertainment.domain.likeLecture.LikeLecture;
import com.solutionchallenge.entertainment.domain.registration.Registration;
import com.solutionchallenge.entertainment.domain.review.Review;
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
public class Senior extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long seniorId;

    @Column
    private String name;
    private String nickName;
    private String password;
    private String phoneNum;
    private Date birth;
    private String gender;
    private String profilUrl;
    private String adress;
    private String email;

    @OneToOne(mappedBy = "senior")
    private Gurdian gurdian;

    @OneToMany(mappedBy = "senior", orphanRemoval = true)
    private List<Interest> interests = new ArrayList<>();

    @OneToMany(mappedBy = "senior", orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "senior", orphanRemoval = true)
    private List<Registration> registrations = new ArrayList<>();

    @OneToMany(mappedBy = "senior", orphanRemoval = true)
    private List<LikeLecture> likeLectures = new ArrayList<>();

}
