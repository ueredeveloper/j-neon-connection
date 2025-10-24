package com.ueredeveloper.neon_connection.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "superficial")
@Getter
@Setter
public class SuperficialModel extends InterferenciaModel {

    @Column(length = 40)
    private String descricao;

    public SuperficialModel() {
    }

    public SuperficialModel(Long id, Double latitude, Double longitude, TipoInterferenciaModel tipoInterferencia,
            String descricao) {
        super(id, latitude, longitude, tipoInterferencia);
        this.descricao = descricao;
    }

}
