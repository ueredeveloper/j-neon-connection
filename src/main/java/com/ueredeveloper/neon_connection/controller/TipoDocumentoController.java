package com.ueredeveloper.neon_connection.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ueredeveloper.neon_connection.dto.TipoDocumentoDTO;
import com.ueredeveloper.neon_connection.service.TipoDocumentoService;

import java.util.List;

@RestController
@RequestMapping("/tipos-documento")
public class TipoDocumentoController {

    @Autowired
    private TipoDocumentoService tipoDocumentoService;

    @PostMapping
    public ResponseEntity<TipoDocumentoDTO> save(@RequestBody TipoDocumentoDTO dto) {
        TipoDocumentoDTO savedDto = tipoDocumentoService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDto);
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<TipoDocumentoDTO>> findAll() {
        List<TipoDocumentoDTO> tipos = tipoDocumentoService.findAll();
        return ResponseEntity.ok(tipos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoDocumentoDTO> getById(@PathVariable Long id) {
        TipoDocumentoDTO tipo = tipoDocumentoService.findById(id);
        return ResponseEntity.ok(tipo);
    }
}