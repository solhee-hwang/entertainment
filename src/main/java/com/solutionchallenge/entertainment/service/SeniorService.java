package com.solutionchallenge.entertainment.service;

import com.solutionchallenge.entertainment.domain.senior.Senior;
import com.solutionchallenge.entertainment.domain.senior.SeniorRepository;
import com.solutionchallenge.entertainment.service.dto.SeniorDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@Slf4j
@RequiredArgsConstructor
public class SeniorService {
    private final SeniorRepository seniorRepository;
    private final ImageHandler imageHandler;
    public void signUp(SeniorDTO seniorDTO, MultipartFile profilImage) throws Exception{
        validateDuplicate(seniorDTO);
        Senior getSenior = Senior.getNewInstance(seniorDTO);
        String profilUrl = imageHandler.pareseFileInfo(profilImage,getSenior.getNickName());
        getSenior.saveProfilUrl(profilUrl);
        seniorRepository.save(getSenior);

    }
    public Senior gurdianInputSenior(SeniorDTO seniorDTO){
        validateDuplicate(seniorDTO);
        Senior getSenior = Senior.getSeniorInfo(seniorDTO);
        getSenior.saveProfilUrl("empty");
        return seniorRepository.save(getSenior);
    }
    private void validateDuplicate(SeniorDTO seniorDTO){
        seniorRepository.findByEmail(seniorDTO.getEmail())
                .ifPresent(m-> {
                    log.error("이미일 중복, email : {}", seniorDTO.getEmail());
                    throw new IllegalArgumentException("SeniorEmail already exists");
                });
        seniorRepository.findByNickName(seniorDTO.getNickName())
                .ifPresent(m->{
                    log.error("닉네임 증복, nickname : {}",seniorDTO.getNickName());
                    throw new IllegalArgumentException("SeniorNickName already exists");
                });
    }
    public Senior findByNickName(String nickName ){
        return seniorRepository.findByNickName(nickName).orElseThrow(()-> new IllegalArgumentException("없는 유저입니다"));
    }
}
