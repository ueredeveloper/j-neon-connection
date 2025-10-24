package com.ueredeveloper.neon_connection.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ueredeveloper.neon_connection.model.InterferenciaModel;

@Repository
public interface InterferenciaRepository extends JpaRepository<InterferenciaModel, Long> {
}
