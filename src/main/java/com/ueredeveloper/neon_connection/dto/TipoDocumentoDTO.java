package com.ueredeveloper.neon_connection.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoDocumentoDTO {

    Long id;
    String descricao;

    public TipoDocumentoDTO() {
    }

    public TipoDocumentoDTO(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

}