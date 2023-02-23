package com.solutionchallenge.entertainment.service.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.Date;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SeniorDTO {
    private String nickName;
    private String password;
    private String name;
    private String address;
    private String phone;
    private String gender;
    private Date birth;

    public static SeniorDTO of(String nickName, String password, String name, String address, String phone, String gender, Date birth) {
        return new SeniorDTO(nickName, password, name, address, phone,gender,birth);
    }

}
