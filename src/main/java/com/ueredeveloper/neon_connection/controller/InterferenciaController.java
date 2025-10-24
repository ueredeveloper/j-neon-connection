package com.ueredeveloper.neon_connection.controller;

import com.ueredeveloper.neon_connection.dto.InterferenciaDTO;
import com.ueredeveloper.neon_connection.service.InterferenciaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/interferencias")
@CrossOrigin(origins = "*", maxAge = 3600)
public class InterferenciaController {

    @Autowired
    private InterferenciaService service;

    @GetMapping("/find-all")
    public List<InterferenciaDTO> findAll() {
        System.out.println("findAll");
        return service.findAll();
    }

    /**
     * Registra uma nova interferência.
     * O tipo de interferência (e.g., Superficial) é inferido ou tratado pelo
     * serviço.
     * 
     * @param interferenciaDTO O DTO com os dados da interferência a ser criada.
     * @return O DTO da interferência criada.
     */
    @PostMapping() // Aceita tanto /interferencias quanto /interferencias/
    public InterferenciaDTO save(@RequestBody InterferenciaDTO interferenciaDTO) {
        System.err.println("salvar interferência, descrição: " + interferenciaDTO.getDescricao());
        return service.save(interferenciaDTO);
    }
}
