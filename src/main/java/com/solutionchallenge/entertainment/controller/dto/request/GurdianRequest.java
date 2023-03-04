package com.solutionchallenge.entertainment.controller.dto.request;

import com.solutionchallenge.entertainment.service.dto.GurdianDTO;
import com.solutionchallenge.entertainment.service.dto.SeniorDTO;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.Date;
@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class GurdianRequest {
    @NotNull
    private String nickName;
    @NotNull
    private String password;
    @NotNull
    private String name;
    @NotNull
    private String address;
    @NotNull
    private String phone;
    @NotNull
    private String email;
    private String gender;
    private Date birth;
    private String seniorNickName;
    private String seniorName;
    private String seniorAddress;
    private String seniorPhone;
    private String seniorGender;
    private Date seniorBirth;

    private String seniorEmail;

    public GurdianDTO toServiceDto(){
        return GurdianDTO.of(nickName, password, name, address, phone, email, gender, birth, seniorNickName);
    }
    public GurdianInputSeniorRequest toInputRequest(){
        return GurdianInputSeniorRequest.of(seniorName,seniorAddress,seniorPhone,seniorGender,seniorBirth,seniorEmail);
    }
}
