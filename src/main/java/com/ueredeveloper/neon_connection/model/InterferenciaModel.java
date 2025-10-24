package com.ueredeveloper.neon_connection.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "interferencia")
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED) // A tabela pai contém os campos comuns e as tabelas filhas apenas os
												// seus próprios.

public abstract class InterferenciaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = true, unique = false)
	private Double latitude;

	@Column(nullable = true, unique = false)
	private Double longitude;

	@ManyToOne
	@JoinColumn(name = "tipoInterferencia")
	private TipoInterferenciaModel tipoInterferencia;

	public InterferenciaModel() {
	}

	public InterferenciaModel(Long id, Double latitude, Double longitude) {
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public InterferenciaModel(Double latitude, Double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public InterferenciaModel(Long id, Double latitude, Double longitude, TipoInterferenciaModel tipoInterferencia) {
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.tipoInterferencia = tipoInterferencia;
	}

}
