package com.ueredeveloper.neon_connection.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InterferenciaDTO {

    private Long id;
    private TipoInterferenciaDTO tipoInterferencia;
    private Double latitude;
    private Double longitude;
    private String descricao; // Específico para Superficial, pode ser nulo para outros tipos

    public InterferenciaDTO() {
    }

    public InterferenciaDTO(Long id, TipoInterferenciaDTO tipoInterferencia, Double latitude, Double longitude, String descricao) {
        this.id = id;
        this.tipoInterferencia = tipoInterferencia;
        this.latitude = latitude;
        this.longitude = longitude;
        this.descricao = descricao;
    }

}