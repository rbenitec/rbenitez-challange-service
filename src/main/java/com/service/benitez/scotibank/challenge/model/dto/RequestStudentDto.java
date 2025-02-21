package com.service.benitez.scotibank.challenge.model.dto;

import com.service.benitez.scotibank.challenge.util.ConstantsUtil;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
public class RequestStudentDto {
    @NotNull(message = "No debe ser nulo")
    private Integer id;

    @NotNull(message = "No debe ser nulo")
    @NotEmpty(message = "No debe ser vacio")
    @Size(min = 2, max = 50, message = "Longitud mayor de 2 y menor de 50")
    private String nombre;
    @NotNull(message = "No debe ser nulo")
    @NotEmpty(message = "No debe ser vacio")
    @Size(min = 2, max = 50, message = "Longitud mayor de 2 y menor de 50")
    private String apellido;
    @NotNull(message = "No debe ser nulo")
    @NotEmpty(message = "No debe ser vacio")
    @Pattern(regexp = ConstantsUtil.PATTER_STATUS, message = "Solo se permite los valores de [valido | invalido]")
    private String estado;

    @NotNull(message = "No debe ser nulo")
    @Max(message = "No se permite mayor a 100", value = 100)
    @Min(message = "No se permite manores de edad", value = 18)
    private Integer edad;

}
