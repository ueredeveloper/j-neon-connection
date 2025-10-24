package com.ueredeveloper.neon_connection.service;

import com.ueredeveloper.neon_connection.dto.*;
import com.ueredeveloper.neon_connection.model.*;
import com.ueredeveloper.neon_connection.repository.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DocumentoService {

    @Autowired
    private DocumentoRepository documentoRepository;

    @Autowired
    private ProcessoRepository processoRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;

    @Autowired
    private AnexoRepository anexoRepository;

    @Transactional
    public DocumentoDTO save(DocumentoDTO dto) {

        DocumentoModel documento;
        if (dto.getId() != null) {
            documento = documentoRepository.findById(dto.getId())
                    .orElseThrow();
        } else {
            documento = new DocumentoModel();
        }

        documento.setNumero(dto.getNumero());
        documento.setNumeroSei(dto.getNumeroSei());

        // PROCESSO
        if (dto.getProcesso() != null && dto.getProcesso().getNumero() != null) {
            AnexoModel anexo = null;
            // 1. Verifica e persiste o ANEXO
            if (dto.getProcesso().getAnexo() != null) {
                AnexoDTO anexoDTO = dto.getProcesso().getAnexo();
                // Valida o número do anexo, pois é obrigatório no modelo
                if (anexoDTO.getNumero() == null || anexoDTO.getNumero().trim().isEmpty()) {
                    throw new IllegalArgumentException(
                            "Número do anexo não pode ser nulo ou vazio se o anexo for fornecido.");
                }

                if (anexoDTO.getId() != null) {
                    // Tenta buscar pelo ID. Se não encontrar, cria um novo.
                    anexo = anexoRepository.findById(anexoDTO.getId())
                            .orElse(new AnexoModel());
                } else {
                    anexo = new AnexoModel();
                }
                anexo.setNumero(anexoDTO.getNumero());
                anexo = anexoRepository.save(anexo); // Salva o AnexoModel para torná-lo persistente
            }

            // 2. Verifica e persiste o PROCESSO
            ProcessoModel processo;
            ProcessoDTO processoDTO = dto.getProcesso();
            if (processoDTO.getId() != null) {
                processo = processoRepository.findById(processoDTO.getId())
                        .orElse(new ProcessoModel());
            } else {
                processo = new ProcessoModel();
            }

            processo.setNumero(processoDTO.getNumero());

            // 3. Associa o anexo ao processo
            processo.setAnexo(anexo);
            processo = processoRepository.save(processo); // Salva o ProcessoModel para torná-lo persistente

            // 4. Associa o processo ao documento
            documento.setProcesso(processo);
        }

        // ENDEREÇO
        if (dto.getEndereco() != null && dto.getEndereco().getLogradouro() != null) {
            EnderecoModel endereco;
            if (dto.getEndereco().getId() != null) {
                endereco = enderecoRepository.findById(dto.getEndereco().getId())
                        .orElseThrow();
            } else {
                endereco = new EnderecoModel();
            }
            endereco.setLogradouro(dto.getEndereco().getLogradouro());
            documento.setEndereco(endereco);
        }

        // TIPO DE DOCUMENTO
        if (dto.getTipoDocumento() != null && dto.getTipoDocumento().getId() != null) {
            TipoDocumentoModel tipoDocumento = tipoDocumentoRepository.findById(dto.getTipoDocumento().getId())
                    .orElseThrow();
            documento.setTipoDocumento(tipoDocumento);
        }

        // USUÁRIOS
        if (dto.getUsuarios() != null) {
            Set<UsuarioModel> usuarios = new HashSet<>();
            for (UsuarioDTO usuarioDTO : dto.getUsuarios()) {
                UsuarioModel usuario;
                if (usuarioDTO.getId() != null) {
                    usuario = usuarioRepository.findById(usuarioDTO.getId())
                            .orElseThrow();
                } else {
                    usuario = new UsuarioModel();
                }
                usuario.setNome(usuarioDTO.getNome());
                // usuario.setCpfCnpj(usuarioDTO.getCpfCnpj());
                usuarios.add(usuario);
            }
            documento.setUsuarios(usuarios);
        }

        DocumentoModel savedDocumento = documentoRepository.save(documento);
        return toDTO(savedDocumento);
    }

    public DocumentoDTO findById(Long id) {
        DocumentoModel documento = documentoRepository.findById(id)
                .orElseThrow();
        return toDTO(documento);
    }

    public List<DocumentoDTO> findAll() {
        return documentoRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private DocumentoDTO toDTO(DocumentoModel model) {
        if (model == null) {
            return null;
        }

        ProcessoDTO processoDTO = null;
        if (model.getProcesso() != null) {
            processoDTO = new ProcessoDTO(
                    model.getProcesso().getId(), model.getProcesso().getNumero(),
                    model.getProcesso().getAnexo() != null ? new AnexoDTO(model.getProcesso().getAnexo().getId(),
                            model.getProcesso().getAnexo().getNumero()) : null);
        }

        EnderecoDTO enderecoDTO = null;
        if (model.getEndereco() != null) {
            enderecoDTO = new EnderecoDTO(
                    model.getEndereco().getId(),
                    model.getEndereco().getLogradouro());
        }

        TipoDocumentoDTO tipoDocumentoDTO = null;
        if (model.getTipoDocumento() != null) {
            tipoDocumentoDTO = new TipoDocumentoDTO(
                    model.getTipoDocumento().getId(),
                    model.getTipoDocumento().getDescricao());
        }

        Set<UsuarioDTO> usuariosDTO = model.getUsuarios() != null
                ? model.getUsuarios().stream()
                        .map(usuario -> new UsuarioDTO(usuario.getId(), usuario.getNome()))
                        .collect(Collectors.toSet())
                : new HashSet<>();

        return new DocumentoDTO(
                model.getId(),
                model.getNumero(),
                model.getNumeroSei(),
                tipoDocumentoDTO,
                processoDTO,
                enderecoDTO,
                usuariosDTO);
    }
}
