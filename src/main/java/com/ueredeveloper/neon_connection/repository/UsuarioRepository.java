package com.ueredeveloper.neon_connection.repository;

import com.ueredeveloper.neon_connection.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

    Optional<UsuarioModel> findByNome(String nome);
}