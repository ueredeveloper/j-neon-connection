package com.ueredeveloper.neon_connection.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Getter
@Setter
public class DocumentoDTO {
    private Long id;
    private String numero;
    private String numeroSei;
    private TipoDocumentoDTO tipoDocumento;
    private ProcessoDTO processo;
    private EnderecoDTO endereco;
    private Set<UsuarioDTO> usuarios;

    public DocumentoDTO() {
    }

    public DocumentoDTO(Long id, String numero, String numeroSei, TipoDocumentoDTO tipoDocumento, ProcessoDTO processo,
            EnderecoDTO endereco, Set<UsuarioDTO> usuarios) {
        this.id = id;
        this.numero = numero;
        this.numeroSei = numeroSei;
        this.tipoDocumento = tipoDocumento;
        this.processo = processo;
        this.endereco = endereco;
        this.usuarios = usuarios;
    }

    public DocumentoDTO(String numero, String numeroSei, TipoDocumentoDTO tipoDocumento, ProcessoDTO processo,
            EnderecoDTO endereco, Set<UsuarioDTO> usuarios) {
        this.numero = numero;
        this.numeroSei = numeroSei;
        this.tipoDocumento = tipoDocumento;
        this.processo = processo;
        this.endereco = endereco;
        this.usuarios = usuarios;
    }

}