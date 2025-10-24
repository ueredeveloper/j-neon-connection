package com.ueredeveloper.neon_connection.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "endereco")
@Getter
@Setter
public class EnderecoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 250)
    private String logradouro;

    @OneToMany(mappedBy = "endereco", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DocumentoModel> documentos = new ArrayList<>();


    public EnderecoModel() {
    }

    public EnderecoModel(String logradouro) {
        this.logradouro = logradouro;
    }

}
