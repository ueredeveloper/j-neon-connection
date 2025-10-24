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
@Table(name = "tipo_documento")
@Getter
@Setter
public class TipoDocumentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    
    @Column(length = 40)
    String descricao;

    public TipoDocumentoModel() {
    }

    public TipoDocumentoModel(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

}
