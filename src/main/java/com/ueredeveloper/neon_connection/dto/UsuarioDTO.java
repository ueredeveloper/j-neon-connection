package com.ueredeveloper.neon_connection.dto;

import java.util.HashSet;
import java.util.Set;

import com.ueredeveloper.neon_connection.model.DocumentoModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {

    private Long id;
    private String nome;
    private Set<DocumentoModel> documentos = new HashSet<>();

    public UsuarioDTO() {
    }

    public UsuarioDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public UsuarioDTO(String nome) {
        this.nome = nome;
    }

    public UsuarioDTO(Long id, String nome, Set<DocumentoModel> documentos) {
        this.id = id;
        this.nome = nome;
        this.documentos = documentos;
    }

}