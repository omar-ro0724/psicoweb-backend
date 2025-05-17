package com.example.psicoweb.Service;

import com.example.psicoweb.Repository.DisponibilidadRepository;
import com.example.psicoweb.model.Disponibilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisponibilidadService {
    @Autowired private DisponibilidadRepository repo;

    public Disponibilidad crear(Disponibilidad d) { return repo.save(d); }
    public List<Disponibilidad> porPsicologo(Long id) { return repo.findByIdPsicologo(id); }
}
