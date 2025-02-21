package com.service.benitez.scotibank.challenge.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseSaveStudent {
    private boolean save;
    private Integer id;
    private String name;
    private String estado;

}
