package com.solutionchallenge.entertainment.controller;

import com.solutionchallenge.entertainment.controller.dto.request.LikeLectureRequest;
import com.solutionchallenge.entertainment.service.LikeLectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/likeLecture")
@RequiredArgsConstructor
public class LikeLectureController {
    private final LikeLectureService likeLectureService;
    @PostMapping()
    public ResponseEntity<?> likeUnlike(@RequestBody LikeLectureRequest likeLectureRequest){
        likeLectureService.likeUnlike(likeLectureRequest.toServiceDto());
        return ResponseEntity.ok("좋아요");
    }
}
