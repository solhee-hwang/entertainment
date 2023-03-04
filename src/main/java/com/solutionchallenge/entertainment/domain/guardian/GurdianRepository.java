package com.solutionchallenge.entertainment.domain.guardian;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GurdianRepository extends JpaRepository<Gurdian,Long> {
    Optional<Gurdian> findByEmail(String email);

    Optional<Gurdian> findByNickName(String nickName);
}
