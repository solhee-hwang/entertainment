package com.solutionchallenge.entertainment.domain.guardian;

import com.solutionchallenge.entertainment.domain.BaseTimeEntity;
import com.solutionchallenge.entertainment.domain.senior.Senior;
import com.solutionchallenge.entertainment.domain.significant.Sigificant;
import com.solutionchallenge.entertainment.service.dto.GurdianDTO;
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

    public static Gurdian newInstance(GurdianDTO gurdianDTO,Senior senior) {
        return Gurdian.builder()
                .name(gurdianDTO.getName())
                .nickName(gurdianDTO.getNickName())
                .password(gurdianDTO.getPassword())
                .phoneNum(gurdianDTO.getPhone())
                .birth(gurdianDTO.getBirth())
                .gender(gurdianDTO.getGender())
                .address(gurdianDTO.getAddress())
                .email(gurdianDTO.getEmail())
                .senior(senior)
                .build();
    }

    public void updateProfile(String profilUrl) {
        this.profilUrl = profilUrl;
    }
}
