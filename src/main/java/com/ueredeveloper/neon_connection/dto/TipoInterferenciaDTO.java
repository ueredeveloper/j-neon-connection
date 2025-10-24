package com.ueredeveloper.neon_connection.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoInterferenciaDTO {
    private Integer id;
    private String descricao;

    public TipoInterferenciaDTO() {
    }

    public TipoInterferenciaDTO(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }
}