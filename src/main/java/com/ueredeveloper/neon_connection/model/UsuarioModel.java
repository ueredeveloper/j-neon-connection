package com.ueredeveloper.neon_connection.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuario")
@Getter
@Setter
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 250, unique = true, nullable = false)
    private String nome;

    @ManyToMany(mappedBy = "usuarios")
    @JsonBackReference
    private Set<DocumentoModel> documentos = new HashSet<>();

    public UsuarioModel() {
    }

    public UsuarioModel(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public UsuarioModel(String nome) {
        this.nome = nome;
    }

}
