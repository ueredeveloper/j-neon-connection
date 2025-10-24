package com.ueredeveloper.neon_connection.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tipo_interferencia")
@Getter
@Setter
public class TipoInterferenciaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(length = 40)
    private String descricao;

    public TipoInterferenciaModel() {
    }

    public TipoInterferenciaModel(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

}