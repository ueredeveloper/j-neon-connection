package com.ueredeveloper.neon_connection.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ueredeveloper.neon_connection.model.TipoDocumentoModel;

@Repository
public interface TipoDocumentoRepository extends JpaRepository<TipoDocumentoModel, Long> {

}