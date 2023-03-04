package com.solutionchallenge.entertainment.service.dto;

import lombok.*;

import java.util.Date;
@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GurdianDTO {
    private String nickName;
    private String password;
    private String name;
    private String email;
    private String address;
    private String phone;
    private String gender;
    private Date birth;
    private String seniorNickname;

    public static GurdianDTO of(String nickName, String password, String name, String address, String phone, String email, String gender, Date birth, String seniorNickName) {
        return new GurdianDTO(nickName, password, name, email, address, phone, gender, birth, seniorNickName);
    }
}
