package com.example.psicoweb.Service;

import com.example.psicoweb.Repository.CitaRepository;
import com.example.psicoweb.model.Cita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaService {
    @Autowired private CitaRepository repo;

    public Cita crear(Cita cita) { return repo.save(cita); }
    public List<Cita> porPsicologo(Long id) { return repo.findByIdPsicologo(id); }
    public List<Cita> porPaciente(Long id) { return repo.findByIdPaciente(id); }
}