package com.solutionchallenge.entertainment.controller.dto;

import com.solutionchallenge.entertainment.domain.curriculum.CurriculumRepository;
import com.solutionchallenge.entertainment.domain.days.DaysRepository;
import com.solutionchallenge.entertainment.domain.instroductionImages.InstroductionImagesRepository;
import com.solutionchallenge.entertainment.domain.lecture.LectureRepository;
import com.solutionchallenge.entertainment.domain.registration.RegistrationRepository;
import com.solutionchallenge.entertainment.domain.tutor.TutorRepository;
import com.solutionchallenge.entertainment.service.TutorLectureService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(TutorLectureController.class)
@AutoConfigureWebMvc
@Import({TutorLectureService.class, LectureRepository.class, CurriculumRepository.class, InstroductionImagesRepository.class,
        RegistrationRepository.class, DaysRepository.class, TutorRepository.class})
class TutorLectureControllerTest {

    @Test
    void register2() {
    }
}