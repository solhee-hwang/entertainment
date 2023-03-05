package com.solutionchallenge.entertainment.service;

import com.solutionchallenge.entertainment.domain.guardian.Gurdian;
import com.solutionchallenge.entertainment.domain.guardian.GurdianRepository;
import com.solutionchallenge.entertainment.domain.senior.Senior;
import com.solutionchallenge.entertainment.service.dto.GurdianDTO;
import com.solutionchallenge.entertainment.service.dto.InterestDTO;
import com.solutionchallenge.entertainment.service.dto.SeniorDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
@Slf4j
@RequiredArgsConstructor
public class GurdianService {
    private final GurdianRepository gurdianRepository;
    private final ImageHandler imageHandler;
    private final SeniorService seniorService;
    private final InterestService interestService;

    public void signUp(GurdianDTO gurdianDTO, MultipartFile profilImage, SeniorDTO seniorDTO, InterestDTO interestDTO) throws Exception{
        validateDuplicate(gurdianDTO);
        Senior getSenior = setSenior(gurdianDTO.getSeniorNickname(), seniorDTO);
        interestService.create(getSenior,interestDTO.getContents());
        Gurdian gurdian = Gurdian.newInstance(gurdianDTO, getSenior);
        String imageUrl = imageHandler.pareseFileInfo(profilImage, gurdianDTO.getNickName());
        gurdian.updateProfile(imageUrl);
        gurdianRepository.save(gurdian);
    }
    private void validateDuplicate(GurdianDTO gurdianDTO){
        gurdianRepository.findByEmail(gurdianDTO.getEmail())
                .ifPresent(m-> {
                    log.error("이미일 중복, email : {}", gurdianDTO.getEmail());
                    throw new IllegalArgumentException("GurdianEmail already exists");
                });
        gurdianRepository.findByNickName(gurdianDTO.getNickName())
                .ifPresent(m-> {
                    log.error("닉네임 중복, email : {}", gurdianDTO.getNickName());
                    throw new IllegalArgumentException("GurdianNickname already exists");
                });
    }
    private Senior setSenior(String seniorNickName, SeniorDTO seniorDTO){
        if(StringUtils.hasText(seniorNickName)){
            return seniorService.findByNickName(seniorNickName);
        }
        return seniorService.gurdianInputSenior(seniorDTO);
    }


}
