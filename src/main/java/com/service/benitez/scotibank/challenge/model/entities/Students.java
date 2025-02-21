package com.service.benitez.scotibank.challenge.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class Students {
    private int id;
    private String nombre;
    private String apellido;
    private String estado;
    private int edad;

}
