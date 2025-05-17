package com.example.psicoweb.Repository;

import com.example.psicoweb.model.Psicologo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PsicologoRepository extends JpaRepository<Psicologo, Long> {
}