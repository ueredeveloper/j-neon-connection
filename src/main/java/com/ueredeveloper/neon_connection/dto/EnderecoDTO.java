package com.ueredeveloper.neon_connection.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDTO {

    private Long id;

    private String logradouro;

    public EnderecoDTO() {
    }

    public EnderecoDTO(Long id, String logradouro) {
        this.id = id;
        this.logradouro = logradouro;
    }

}
