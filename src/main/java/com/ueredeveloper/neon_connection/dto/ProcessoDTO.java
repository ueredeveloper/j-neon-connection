package com.ueredeveloper.neon_connection.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProcessoDTO {

    private Long id;
    private String numero;

    public ProcessoDTO() {
    }

    public ProcessoDTO(Long id, String numero) {
        this.id = id;
        this.numero = numero;
    }
}
