package com.solutionchallenge.entertainment.controller.dto;

import com.solutionchallenge.entertainment.controller.dto.response.BriefLectureResponse;
import com.solutionchallenge.entertainment.controller.dto.response.LectureInfoResponse;
import com.solutionchallenge.entertainment.service.UserLectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user-lecture")
public class UserLectureController {

    private final UserLectureService userLectureService;

    @PostMapping("/apply")
    public ResponseEntity<?> applyLecture(@RequestParam Long userId, @RequestParam Long lectureId){

        userLectureService.applyLecture(userId, lectureId);

        return ResponseEntity.ok("Apply Lecture Succeed");
    }


    @GetMapping("/applied")
    public ResponseEntity<?> myLecture(@RequestParam String state, @RequestParam Long userId){

        List<BriefLectureResponse> responses = userLectureService.myLecture(state, userId);

        return ResponseEntity.ok(responses);
    }

    @GetMapping("/main")
    public ResponseEntity<?> showMainLecture(){

        List<BriefLectureResponse> reponses = userLectureService.showAllLecture("all", "modifiedDate");

        return ResponseEntity.ok(reponses);
    }

    @GetMapping("/all")
    public ResponseEntity<?> showAllLecture(@RequestParam String category, @RequestParam String sort){

        List<BriefLectureResponse> reponses = userLectureService.showAllLecture(category, sort);

        return ResponseEntity.ok(reponses);
    }

    @GetMapping("/information")
    public ResponseEntity<?> showLectureInfo(@RequestParam Long lectureId){

        LectureInfoResponse response = userLectureService.showLectureInfo(lectureId);

        return ResponseEntity.ok(response);
    }

/*
    @DeleteMapping("/cancel")
    public ResponseEntity<?> cancelLecture(@RequestParam Long userId, @RequestParam Long lectureId){

        userLectureService.cancelLecture(userId, lectureId);

        return ResponseEntity.ok("Lecture Canceled");
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchLecture(){

        return ResponseEntity.ok("");
    }
*/
}
