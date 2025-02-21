package com.service.benitez.scotibank.challenge.service;

import com.service.benitez.scotibank.challenge.model.dto.RequestStudentDto;
import com.service.benitez.scotibank.challenge.model.dto.ResponseSaveStudent;
import com.service.benitez.scotibank.challenge.model.entities.Students;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ChallengeService {
    Mono<ResponseSaveStudent> saveStudent(RequestStudentDto student);

    Flux<Students> findStudentActivated(String status);
}
