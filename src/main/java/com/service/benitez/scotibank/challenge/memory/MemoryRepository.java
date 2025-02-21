package com.service.benitez.scotibank.challenge.memory;

import com.service.benitez.scotibank.challenge.model.entities.Students;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class MemoryRepository implements MemoryRepositoryConnector {

    private final Map<Object, Students> storage = new ConcurrentHashMap<>();

    @Override
    public Mono<Students> save(Students entity) {
        if (storage.containsKey(entity.getId())) {
            // Retorna un error indicando que el ID ya existe
            return Mono.error(new IllegalStateException("El ID ya existe: " + entity.getId()));
        }
        storage.put(entity.getId(), entity);
        return Mono.just(entity);
    }

    @Override
    public Mono<Students> findById(String id) {
        return Mono.justOrEmpty(storage.get(id));
    }

    @Override
    public Flux<Students> findAll() {
        return Flux.fromIterable(storage.values());
    }

    @Override
    public Mono<Void> deleteById(String id) {
        storage.remove(id);
        return Mono.empty();
    }

    @Override
    public Flux<Students> findStudentByStatus(String status) {
        return Flux.fromIterable(storage.values())
                .filter(student -> status.equalsIgnoreCase(student.getEstado()));
    }

}
