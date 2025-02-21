package com.service.benitez.scotibank.challenge.service.impl;

import com.service.benitez.scotibank.challenge.mapper.RequestStudentMapper;
import com.service.benitez.scotibank.challenge.memory.MemoryRepositoryConnector;
import com.service.benitez.scotibank.challenge.model.dto.RequestStudentDto;
import com.service.benitez.scotibank.challenge.model.dto.ResponseSaveStudent;
import com.service.benitez.scotibank.challenge.model.entities.Students;
import com.service.benitez.scotibank.challenge.service.ChallengeService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
public class ChallengeServiceImpl implements ChallengeService {

    private Function<Students, ResponseSaveStudent> studentSaveMapper;
    private RequestStudentMapper requestStudentMapper;
    private final MemoryRepositoryConnector memoryRepositoryConnector;

    public ChallengeServiceImpl(MemoryRepositoryConnector memoryRepositoryConnector) {
        this.memoryRepositoryConnector = memoryRepositoryConnector;
    }

    @Override
    public Mono<ResponseSaveStudent> saveStudent(RequestStudentDto studentDto) {
        return memoryRepositoryConnector.save(requestStudentMapper.toEntity(studentDto))
                .map(studentSaveMapper::apply);
    }

    @Override
    public Flux<Students> findStudentActivated(String status) {
        return memoryRepositoryConnector.findStudentByStatus(status);
    }
}
