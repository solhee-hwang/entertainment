package com.solutionchallenge.entertainment.service;

import com.solutionchallenge.entertainment.domain.guardian.GurdianRepository;
import com.solutionchallenge.entertainment.domain.senior.SeniorRepository;
import com.solutionchallenge.entertainment.domain.tutor.Tutor;
import com.solutionchallenge.entertainment.domain.tutor.TutorRepository;
import com.solutionchallenge.entertainment.service.dto.TutorDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@Slf4j
@RequiredArgsConstructor
public class TutorService {
    private final TutorRepository tutorRepository;
    private final SeniorRepository seniorRepository;
    private final GurdianRepository gurdianRepository;
    private final ImageHandler imageHandler;


    public void signUp(TutorDTO tutorDTO, MultipartFile profileImage) throws Exception {
        validDuplicate(tutorDTO);
        Tutor tutor = Tutor.getNewInstance(tutorDTO);
        String profileUrl = imageHandler.pareseFileInfo(profileImage, tutorDTO.getNickName());
        tutor.updateProfileUrl(profileUrl);
        tutorRepository.save(tutor);

    }

    private void validDuplicate(TutorDTO tutorDTO) {
        tutorRepository.findByEmail(tutorDTO.getEmail())
                .ifPresent(m-> {
                    log.error("이미일 중복, email : {}", tutorDTO.getEmail());
                    throw new IllegalArgumentException("tutorEmail already exists");
                });
        tutorRepository.findByNickName(tutorDTO.getNickName())
                .ifPresent(m->{
                    log.error("닉네임 증복, nickname : {}",tutorDTO.getNickName());
                    throw new IllegalArgumentException("tutor already exists");
                });
        gurdianRepository.findByNickName(tutorDTO.getNickName())
                .ifPresent(m->{
                    log.error("닉네임 증복, nickname : {}",tutorDTO.getNickName());
                    throw new IllegalArgumentException("gurdian already exists");
                });
        seniorRepository.findByNickName(tutorDTO.getNickName())
                .ifPresent(m->{
                    log.error("닉네임 증복, nickname : {}",tutorDTO.getNickName());
                    throw new IllegalArgumentException("SeniorNickName already exists");
                });
    }
}
