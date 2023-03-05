package com.solutionchallenge.entertainment.controller;

import com.solutionchallenge.entertainment.controller.dto.request.GurdianInputSeniorRequest;
import com.solutionchallenge.entertainment.controller.dto.request.GurdianRequest;
import com.solutionchallenge.entertainment.service.GurdianService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
@RequestMapping("/gurdian")
@RequiredArgsConstructor
public class GurdianController {
    private final GurdianService gurdianService;
    //어르신 정보를 한번에 보낸다는 전제하
    @PostMapping(value = "signup", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> signUp(@Valid @RequestPart GurdianRequest gurdianRequest, @RequestPart MultipartFile profileImage) throws Exception {
        GurdianInputSeniorRequest gurdianInputSeniorRequest= gurdianRequest.toInputRequest();
        gurdianService.signUp(gurdianRequest.toServiceDto(), profileImage,gurdianInputSeniorRequest.toServiceDto(),gurdianRequest.toInterestServiceDto());
        return ResponseEntity.ok("signup complete");
    }
}



