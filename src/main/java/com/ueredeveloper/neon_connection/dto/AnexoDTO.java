package com.ueredeveloper.neon_connection.dto;

import com.ueredeveloper.neon_connection.model.AnexoModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnexoDTO {

    private Long id;
    private String numero;

    public AnexoDTO() {
    }

    public AnexoDTO(Long id, String numero) {
        this.id = id;
        this.numero = numero;
    }

    public AnexoDTO(String numero) {
        this.numero = numero;
    }

}
