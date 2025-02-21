package com.service.benitez.scotibank.challenge.mapper;

import com.service.benitez.scotibank.challenge.model.dto.RequestStudentDto;
import com.service.benitez.scotibank.challenge.model.entities.Students;
import org.springframework.stereotype.Component;

@Component
public class RequestStudentMapper {
    public Students toEntity(RequestStudentDto dto) {
        return new Students(
                dto.getId(),
                dto.getNombre(),
                dto.getApellido(),
                dto.getEstado(),
                dto.getEdad()
        );
    }
}
