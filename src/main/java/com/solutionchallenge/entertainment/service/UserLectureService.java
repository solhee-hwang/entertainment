package com.solutionchallenge.entertainment.service;

import com.solutionchallenge.entertainment.controller.dto.response.BriefLectureResponse;
import com.solutionchallenge.entertainment.controller.dto.response.LectureInfoResponse;
import com.solutionchallenge.entertainment.domain.apply.Apply;
import com.solutionchallenge.entertainment.domain.apply.ApplyRepository;
import com.solutionchallenge.entertainment.domain.curriculum.Curriculum;
import com.solutionchallenge.entertainment.domain.curriculum.CurriculumRepository;
import com.solutionchallenge.entertainment.domain.instroductionImages.InstroductionImages;
import com.solutionchallenge.entertainment.domain.instroductionImages.InstroductionImagesRepository;
import com.solutionchallenge.entertainment.domain.lecture.Lecture;
import com.solutionchallenge.entertainment.domain.lecture.LectureRepository;
import com.solutionchallenge.entertainment.domain.likeLecture.LikeLecture;
import com.solutionchallenge.entertainment.domain.likeLecture.LikeLectureRespository;
import com.solutionchallenge.entertainment.domain.registration.RegistrationRepository;
import com.solutionchallenge.entertainment.domain.senior.Senior;
import com.solutionchallenge.entertainment.domain.senior.SeniorRepository;
import com.solutionchallenge.entertainment.domain.tutor.Tutor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserLectureService {


    private final SeniorRepository seniorRepository;
    private final ApplyRepository applyRepository;
    private final LectureRepository lectureRepository;
    //private final TutorRepository tutorRepository;
    private final RegistrationRepository registrationRepository;
    private final InstroductionImagesRepository instroductionImagesRepository;
    private final CurriculumRepository curriculumRepository;
    //private final ReivewRepository reivewRepository;
    private final LikeLectureRespository likeLectureRespository;

    public void applyLecture(Long userId, Long lectureId){

        Senior user = seniorRepository.findById(userId).orElseThrow(()-> new IllegalArgumentException("User doesn't exist"));
        Lecture lecture = lectureRepository.findById(lectureId).orElseThrow(()-> new IllegalArgumentException("Lecture doesn't exist"));

        Apply apply = Apply.getNewInstance(user, lecture, "applied");

        applyRepository.save(apply);
    }

    public LectureInfoResponse showLectureInfo(Long lectureId) {

        Lecture lecture = lectureRepository.findById(lectureId).orElseThrow(()-> new IllegalArgumentException("Lecture doesn't exist"));
        Tutor tutor = registrationRepository.findByLecture(lecture).orElseThrow(()-> new IllegalArgumentException("Tutor doesn't exist")).getTutor();
        List<Curriculum> curriculums = curriculumRepository.findAllByLecture(lecture).orElseThrow(()-> new IllegalArgumentException("Curriculum doesn't exist"));
        List<InstroductionImages> introImages = instroductionImagesRepository.findAllByLecture(lecture).orElseThrow(()-> new IllegalArgumentException("Images doesn't exist"));
        //List<Review> reviews = reivewRepository.findBy()
        List<String> lectureIntroImagesUrl = new ArrayList<>();
        List<String> curriculumContents = new ArrayList<>();
        List<String> curriculumImagesUrl = new ArrayList<>();
        for(Curriculum element : curriculums ){
            curriculumContents.add(element.getContent());
            curriculumImagesUrl.add(element.getImageUrl());
        }
        for(InstroductionImages element : introImages){
            lectureIntroImagesUrl.add(element.getImageUrl());
        }

        LectureInfoResponse response = LectureInfoResponse.getNewInstance(lecture, tutor, curriculumContents, curriculumImagesUrl, lectureIntroImagesUrl);

        return response;
    }

    public List<BriefLectureResponse> showAllLecture(String category, String sort) {

        String sortColumn ="modifiedDate";
        if(sort.equals("like")) sortColumn = "likeCount";
        //else if(sort.equals("distance")) sortKey = "distance";

        List<Lecture> lectures;

        // category : all / health / education / hobby / social
        if(category.equals("all")){
            lectures = lectureRepository.findAll(Sort.by(Sort.Direction.DESC, sortColumn));
        }
        else{
            lectures = lectureRepository.findAllByCategory(category, Sort.by(Sort.Direction.DESC, sortColumn));
        }

        List<BriefLectureResponse> responses = new ArrayList<>();

        for(Lecture element : lectures){
            responses.add(BriefLectureResponse.getNewInstance(element));
        }

        return responses;
    }


    public void cancelLecture(Long userId, Long lectureId) {

        Senior senior = seniorRepository.findById(userId).orElseThrow(()-> new IllegalArgumentException("Senior doesn't exist"));
        Lecture lecture = lectureRepository.findById(lectureId).orElseThrow(()-> new IllegalArgumentException("Senior doesn't exist"));

        applyRepository.deleteBySeniorAndLecture(senior, lecture);

    }

    // 통과
    public List<BriefLectureResponse> myLecture(String state, Long userId) {

        // state : appied: 수강 전 , completed: 수강 완료, in-progress:수강 중, interest: 관심 있는

        List<BriefLectureResponse> responses = new ArrayList<>();
        Senior senior = seniorRepository.findById(userId).orElseThrow(()-> new IllegalArgumentException("Senior doesn't exist"));

        if(state.equals("interest")){
            List<LikeLecture> likeLectures = likeLectureRespository.findAllBySenior(senior).orElseThrow(()-> new IllegalArgumentException("UserId is wrong"));
            for(LikeLecture element : likeLectures){
                responses.add(BriefLectureResponse.getNewInstance(element.getLecture()));
            }
        }
        else{
            List<Apply> applies = applyRepository.findAllBySenior(senior).orElseThrow(()-> new IllegalArgumentException("UserId is wrong"));
            for(Apply element : applies){
                if(element.getState().equals("completed") && state.equals("completed")){
                    responses.add(BriefLectureResponse.getNewInstance(element.getLecture()));
                }
                else if(element.getState().equals("applied") && state.equals("applied")){
                    responses.add(BriefLectureResponse.getNewInstance(element.getLecture()));
                }
                else if(element.getState().equals("in-progress") && state.equals("in-progress")){
                    responses.add(BriefLectureResponse.getNewInstance(element.getLecture()));
                }
            }
        }

        return responses;
    }


}
