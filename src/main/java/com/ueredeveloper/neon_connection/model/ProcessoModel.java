package com.ueredeveloper.neon_connection.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "processo")
@Getter
@Setter
public class ProcessoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 40)
    private String numero;

    public ProcessoModel() {
    }

    public ProcessoModel(String numero) {
        this.numero = numero;
    }

}
