package com.example.psicoweb.Service;

import com.example.psicoweb.Repository.PsicologoRepository;
import com.example.psicoweb.model.Psicologo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PsicologoService {

    @Autowired
    private PsicologoRepository psicologoRepository;

    public Psicologo registrarPsicologo(Psicologo psicologo) {
        return psicologoRepository.save(psicologo);
    }

    public List<Psicologo> obtenerTodos() {
        return psicologoRepository.findAll();
    }

    public Psicologo obtenerPorId(Long id) {
        return psicologoRepository.findById(id).orElse(null);
    }
}
