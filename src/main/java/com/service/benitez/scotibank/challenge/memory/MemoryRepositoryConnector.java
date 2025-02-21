package com.service.benitez.scotibank.challenge.memory;

import com.service.benitez.scotibank.challenge.model.entities.Students;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MemoryRepositoryConnector {
    Mono<Students> save(Students entity);

    Mono<Students> findById(String id);

    Flux<Students> findAll();

    Mono<Void> deleteById(String id);

    Flux<Students> findStudentByStatus(String status);
}
