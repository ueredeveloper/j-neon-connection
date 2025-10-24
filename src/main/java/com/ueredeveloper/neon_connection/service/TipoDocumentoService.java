package com.ueredeveloper.neon_connection.service;

import com.ueredeveloper.neon_connection.dto.TipoDocumentoDTO;
import com.ueredeveloper.neon_connection.model.TipoDocumentoModel;
import com.ueredeveloper.neon_connection.repository.TipoDocumentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipoDocumentoService {

    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;

    @Transactional
    public TipoDocumentoDTO save(TipoDocumentoDTO dto) {
        TipoDocumentoModel tipoDocumento;
        if (dto.getId() != null) {
            tipoDocumento = tipoDocumentoRepository.findById(dto.getId())
                    .orElseThrow();
        } else {
            tipoDocumento = new TipoDocumentoModel();
        }
        tipoDocumento.setDescricao(dto.getDescricao());
        TipoDocumentoModel savedTipoDocumento = tipoDocumentoRepository.save(tipoDocumento);
        return toDTO(savedTipoDocumento);
    }

    public List<TipoDocumentoDTO> findAll() {
        return tipoDocumentoRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public TipoDocumentoDTO findById(Long id) {
        TipoDocumentoModel tipoDocumento = tipoDocumentoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tipo de documento não encontrado com ID: " + id));
        return toDTO(tipoDocumento);
    }

    private TipoDocumentoDTO toDTO(TipoDocumentoModel model) {
        if (model == null) {
            return null;
        }
        return new TipoDocumentoDTO(model.getId(), model.getDescricao());
    }
}