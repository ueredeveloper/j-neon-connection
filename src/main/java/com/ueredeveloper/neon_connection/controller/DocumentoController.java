package com.ueredeveloper.neon_connection.controller;

import com.ueredeveloper.neon_connection.dto.DocumentoDTO;
import com.ueredeveloper.neon_connection.service.DocumentoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/documentos")
@CrossOrigin(origins = "*", maxAge = 3600)
public class DocumentoController {

    @Autowired
    private DocumentoService service;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<DocumentoDTO> save(@RequestBody DocumentoDTO documentoDTO) {
        DocumentoDTO savedDocumento = service.save(documentoDTO);
        return ResponseEntity.ok(savedDocumento);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentoDTO> findById(@PathVariable Long id) {
        DocumentoDTO documentoDTO = service.findById(id);
        return ResponseEntity.ok(documentoDTO);
    }

    @GetMapping("/find-all")
    public List<DocumentoDTO> findAll() {
        System.out.println("findAll");
        return service.findAll();
    }
}
