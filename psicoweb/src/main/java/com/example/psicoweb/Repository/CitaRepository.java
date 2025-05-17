package com.example.psicoweb.Repository;

import com.example.psicoweb.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CitaRepository extends JpaRepository<Cita, Long> {
    List<Cita> findByIdPsicologo(Long id);
    List<Cita> findByIdPaciente(Long id);
}
