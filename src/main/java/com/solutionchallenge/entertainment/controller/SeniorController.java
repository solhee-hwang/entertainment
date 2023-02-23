package com.solutionchallenge.entertainment.controller;

import com.solutionchallenge.entertainment.controller.dto.request.SeniorRequest;
import com.solutionchallenge.entertainment.service.ImageHandler;
import com.solutionchallenge.entertainment.service.SeniorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/senior")
@RequiredArgsConstructor
public class SeniorController {
    private final SeniorService seniorService;
    private final ImageHandler imageHandler;
    public ResponseEntity<?> signUp(@RequestPart SeniorRequest seniorRequest, @RequestPart MultipartFile profilImage){
        seniorService.signUp(seniorRequest.toServiceDto(),profilImage);
    }
}


