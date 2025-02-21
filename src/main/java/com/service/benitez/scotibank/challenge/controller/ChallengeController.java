package com.service.benitez.scotibank.challenge.controller;

import com.service.benitez.scotibank.challenge.model.dto.RequestStudentDto;
import com.service.benitez.scotibank.challenge.model.dto.ResponseSaveStudent;
import com.service.benitez.scotibank.challenge.model.entities.Students;
import com.service.benitez.scotibank.challenge.service.ChallengeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class ChallengeController {

    private final ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @GetMapping("/list/student/all")
    public Flux<Students> getAllStudent(@RequestParam("status") String status) {
        return challengeService.findStudentActivated(status);
    }

    @PostMapping("/save-student")
    public Mono<ResponseEntity<ResponseSaveStudent>> registerChanges(@Valid @RequestBody RequestStudentDto student) {
        return challengeService.saveStudent(student)
                .map(ResponseEntity.status(HttpStatus.OK)::body)
                .defaultIfEmpty(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }
}
