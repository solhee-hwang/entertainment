package com.solutionchallenge.entertainment.service.dto;

import lombok.*;

import java.util.List;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class InterestDTO {
    private List<String> contents;

    public static InterestDTO of(List<String> contents) {
        return new InterestDTO(contents);
    }
}
