package com.ueredeveloper.neon_connection.repository;

import com.ueredeveloper.neon_connection.model.EnderecoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnderecoRepository extends JpaRepository<EnderecoModel, Long> {

    Optional<EnderecoModel> findByLogradouro(String logradouro);
}