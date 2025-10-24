package com.ueredeveloper.neon_connection.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "documento")
@Getter
@Setter
public class DocumentoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 40)
	private String numero;

	@Column(nullable = true, unique = true, length = 40)
	private String numeroSei;

	@ManyToOne
	@JoinColumn(name = "tipo_documento_id")
	private TipoDocumentoModel tipoDocumento;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "processo")
	private ProcessoModel processo;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "endereco_id")
	private EnderecoModel endereco;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "documento_usuario", joinColumns = @JoinColumn(name = "documento_id"), inverseJoinColumns = @JoinColumn(name = "usuario_id"))
	private Set<UsuarioModel> usuarios = new HashSet<>();

	public DocumentoModel() {
	}

	public DocumentoModel(Long id, String numero, String numeroSei, TipoDocumentoModel tipoDocumento,
			ProcessoModel processo, EnderecoModel endereco, Set<UsuarioModel> usuarios) {
		this.id = id;
		this.numero = numero;
		this.numeroSei = numeroSei;
		this.tipoDocumento = tipoDocumento;
		this.processo = processo;
		this.endereco = endereco;
		this.usuarios = usuarios;
	}

}
