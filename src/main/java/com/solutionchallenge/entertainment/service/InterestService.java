package com.solutionchallenge.entertainment.service;

import com.solutionchallenge.entertainment.domain.interest.Interest;
import com.solutionchallenge.entertainment.domain.interest.InterestRepository;
import com.solutionchallenge.entertainment.domain.senior.Senior;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class InterestService {
    private final InterestRepository interestRepository;
    private final InterestRelationService interestRelationService;

    public void create(Senior senior, List<String> contents) {
        if(contents==null) return;
        for(String content:contents){
            log.info("관심사 True"+interestRepository.existsByContent(content));
            if(interestRepository.existsByContent(content)){
                Interest interest = interestRepository.findByContent(content).get();
                interestRelationService.create(senior,interest);
            }else{
                Interest interest = Interest.getNewInstance(content);
                interestRelationService.create(senior,interestRepository.save(interest));
            }

        }
    }
}
