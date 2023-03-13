package com.solutionchallenge.entertainment.controller.dto.response;

import com.solutionchallenge.entertainment.domain.curriculum.Curriculum;
import com.solutionchallenge.entertainment.domain.lecture.Lecture;
import com.solutionchallenge.entertainment.domain.tutor.Tutor;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LectureInfoResponse {

    private String tutorName;
    private String category;
    private String title;
    private int likeCount;
    private int maxPeople;
    private int presentPeople;
    private String lectureIntro;
    private List<String> lectureIntroImagesUrl;
    private List<String> curriculumContents;
    private List<String> curriculumImagesUrl;
    private String tutorGender;
    private Date tutorBirth;
    private String profileUrl;
    private String tutorIntro;
    //rivate List<Map<String,String>> reviews;

    private Date startDate;
    private Date endDate;
    private Date registerDate;
    private String activityTime;


    public static LectureInfoResponse getNewInstance(Lecture lecture, Tutor tutor, List<String> curriculumContents, List<String> curriculumImagesUrl, List<String> lectureIntroImagesUrl) {

        return LectureInfoResponse.builder()
                .tutorName(tutor.getName())
                .category(lecture.getCategory())
                .title(lecture.getTitle())
                .likeCount(lecture.getLikeCount())
                .maxPeople(lecture.getMaxRegistrant())
                .presentPeople(lecture.getPresentRegistrant())
                .lectureIntro(lecture.getInstroduction())
                .lectureIntroImagesUrl(lectureIntroImagesUrl)
                .curriculumContents(curriculumContents)
                .curriculumImagesUrl(curriculumImagesUrl)
                .tutorGender(tutor.getGender())
                .tutorBirth(tutor.getBirth())
                .profileUrl(tutor.getProfilUrl())
                .tutorIntro(tutor.getIntroduction())
                //.reviews()
                .startDate(lecture.getStartDate())
                .endDate(lecture.getEndDate())
                .registerDate(java.sql.Timestamp.valueOf(lecture.getCreateDate()))
                .activityTime(lecture.getActivityTime())
                .build();
    }
}
