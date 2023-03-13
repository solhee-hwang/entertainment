package com.solutionchallenge.entertainment.controller.dto;

import com.solutionchallenge.entertainment.controller.dto.request.TutorLectureRequest;
import com.solutionchallenge.entertainment.controller.dto.response.BriefLectureResponse;
import com.solutionchallenge.entertainment.service.TutorLectureService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tutor-lecture")
public class TutorLectureController {

    private final TutorLectureService tutorLectureService;

    @PostMapping(value = "/register", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> register(@Valid @RequestPart TutorLectureRequest request, @RequestPart List<MultipartFile> lectureImages, @RequestPart List<MultipartFile> curriculumImages){

        tutorLectureService.register(request.toServiceDto(), lectureImages, curriculumImages);

        return ResponseEntity.ok("Register Succeed");
    }

    // 통과
    @PostMapping(value = "/register2", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> register2(@Valid @RequestBody TutorLectureRequest request){

        tutorLectureService.register2(request.toServiceDto());

        return ResponseEntity.ok("Register Succeed");
    }
    /*
    @PatchMapping("/modify")
    public ResponseEntity<?> modifyLecture(){

        tutorLectureService.modifyLecture();

        return ResponseEntity.ok("Modify Succeed");
    }
`
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteLecture(){

        tutorLectureService.deleteLecture();

        return ResponseEntity.ok("Delete Succeed");
    }
*/
    // 통과
    @GetMapping("/my-lecture")
    public ResponseEntity<?> showAllLecture(@RequestParam Long tutorId, @RequestParam String state){

        List<BriefLectureResponse> responses = tutorLectureService.showAllLecture(tutorId, state);

        return ResponseEntity.ok(responses);
    }

}
