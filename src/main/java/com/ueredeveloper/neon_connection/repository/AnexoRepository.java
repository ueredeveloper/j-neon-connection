package com.ueredeveloper.neon_connection.repository;

import com.ueredeveloper.neon_connection.model.AnexoModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnexoRepository extends JpaRepository<AnexoModel, Long> {

}