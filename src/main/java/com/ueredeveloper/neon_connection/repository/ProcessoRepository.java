package com.ueredeveloper.neon_connection.repository;

import com.ueredeveloper.neon_connection.model.ProcessoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProcessoRepository extends JpaRepository<ProcessoModel, Long> {
    Optional<ProcessoModel> findByNumero(String numero);
}