package com.solutionchallenge.entertainment.service;

import com.solutionchallenge.entertainment.domain.senior.Senior;
import com.solutionchallenge.entertainment.domain.senior.SeniorRepository;
import com.solutionchallenge.entertainment.service.dto.SeniorDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@Slf4j
@RequiredArgsConstructor
public class SeniorService {
    private final SeniorRepository seniorRepository;
    private final ImageHandler imageHandler
    public void signUp(SeniorDTO toServiceDto, MultipartFile profilImage) {
        Senior getSenior = Senior.getNewInstance(toServiceDto);
    }
}
