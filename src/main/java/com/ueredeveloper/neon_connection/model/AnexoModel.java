package com.ueredeveloper.neon_connection.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "anexo")
@Getter
@Setter
public class AnexoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 40)
    private String numero;

    @OneToMany(mappedBy = "anexo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProcessoModel> processos = new ArrayList<>();

    public AnexoModel() {
    }

    public AnexoModel(String numero) {
        this.numero = numero;
    }

}
