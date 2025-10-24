package com.ueredeveloper.neon_connection.service;

import com.ueredeveloper.neon_connection.dto.InterferenciaDTO;
import com.ueredeveloper.neon_connection.dto.TipoInterferenciaDTO;
import com.ueredeveloper.neon_connection.model.InterferenciaModel;
import com.ueredeveloper.neon_connection.model.SuperficialModel;
import com.ueredeveloper.neon_connection.model.TipoInterferenciaModel;
import com.ueredeveloper.neon_connection.repository.InterferenciaRepository;
import com.ueredeveloper.neon_connection.repository.TipoInterferenciaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InterferenciaService {

    @Autowired
    private InterferenciaRepository repository;

    @Autowired
    private TipoInterferenciaRepository tipoInterferenciaRepository;

    /**
     * Busca todas as interferências no banco de dados e as converte para uma lista
     * de DTOs.
     * 
     * @return Uma lista de InterferenciaDTO contendo apenas os dados necessários
     *         para o frontend.
     */
    public List<InterferenciaDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    private InterferenciaDTO converterParaDTO(InterferenciaModel interferencia) {
        String descricao = null;
        if (interferencia instanceof SuperficialModel superficial) {
            descricao = superficial.getDescricao();
        }

        TipoInterferenciaDTO tipoDTO = null;
        if (interferencia.getTipoInterferencia() != null) {
            tipoDTO = new TipoInterferenciaDTO(
                    interferencia.getTipoInterferencia().getId(),
                    interferencia.getTipoInterferencia().getDescricao());
        }

        return new InterferenciaDTO(
                interferencia.getId(),
                tipoDTO,
                interferencia.getLatitude(),
                interferencia.getLongitude(),
                descricao);
    }

    /**
     * Registra uma nova interferência no banco de dados a partir de um DTO.
     * Utiliza o campo 'tipoInterferencia' do DTO para determinar qual classe de
     * Interferencia instanciar.
     *
     * @param dto O InterferenciaDTO contendo os dados da nova interferência.
     * @return O InterferenciaDTO da interferência registrada.
     * @throws IllegalArgumentException se o tipo de interferência for
     *                                  desconhecido.
     */
    @Transactional
    public InterferenciaDTO save(InterferenciaDTO dto) {
        // Por enquanto, estamos tratando apenas 'Superficial'. A lógica pode ser
        // expandida.
        SuperficialModel interferencia = new SuperficialModel();
        interferencia.setLatitude(dto.getLatitude());
        interferencia.setLongitude(dto.getLongitude());
        interferencia.setDescricao(dto.getDescricao());

        if (dto.getTipoInterferencia() != null && dto.getTipoInterferencia().getId() != null) {
            TipoInterferenciaModel tipo = tipoInterferenciaRepository.findById(dto.getTipoInterferencia().getId())
                    .orElseThrow(() -> new IllegalArgumentException(
                            "Tipo de interferência não encontrado com id: " + dto.getTipoInterferencia().getId()));
            interferencia.setTipoInterferencia(tipo);
        }

        InterferenciaModel savedInterferencia = repository.save(interferencia);
        return converterParaDTO(savedInterferencia);
    }
}