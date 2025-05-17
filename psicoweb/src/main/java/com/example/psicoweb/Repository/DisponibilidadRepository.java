package com.example.psicoweb.Repository;

import com.example.psicoweb.model.Disponibilidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DisponibilidadRepository extends JpaRepository<Disponibilidad, Long> {
    List<Disponibilidad> findByIdPsicologo(Long idPsicologo);
}
