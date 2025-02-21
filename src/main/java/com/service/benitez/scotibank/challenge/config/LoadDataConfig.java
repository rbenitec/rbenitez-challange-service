package com.service.benitez.scotibank.challenge.config;

import com.service.benitez.scotibank.challenge.memory.MemoryRepository;
import com.service.benitez.scotibank.challenge.model.entities.Students;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDataConfig {

    @Bean
    public MemoryRepository memoryRepository() {
        MemoryRepository repository = new MemoryRepository();
        repository.save(new Students(1, "Juan", "Perez", "Activo", 20)).subscribe();
        repository.save(new Students(2, "Maria", "Lopez", "Activo", 22)).subscribe();
        repository.save(new Students(3, "Carlos", "Sanchez", "Inactivo", 23)).subscribe();
        repository.save(new Students(4, "Luisa", "Martinez", "Activo", 21)).subscribe();
        repository.save(new Students(5, "Ana", "Gonzalez", "Inactivo", 24)).subscribe();
        return repository;
    }
}
