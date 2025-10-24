package com.ueredeveloper.neon_connection.repository;

import com.ueredeveloper.neon_connection.model.TipoInterferenciaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoInterferenciaRepository extends JpaRepository<TipoInterferenciaModel, Integer> {

}