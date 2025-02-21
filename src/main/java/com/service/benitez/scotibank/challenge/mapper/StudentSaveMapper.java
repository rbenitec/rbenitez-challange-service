package com.service.benitez.scotibank.challenge.mapper;

import com.service.benitez.scotibank.challenge.model.dto.ResponseSaveStudent;
import com.service.benitez.scotibank.challenge.model.entities.Students;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class StudentSaveMapper implements Function<Students, ResponseSaveStudent> {

    @Override
    public ResponseSaveStudent apply(Students students) {
        return new ResponseSaveStudent(
                Boolean.TRUE,
                students.getId(),
                students.getNombre(),
                students.getEstado()
        );
    }
}
