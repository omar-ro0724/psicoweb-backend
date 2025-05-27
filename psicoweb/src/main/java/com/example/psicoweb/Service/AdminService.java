package com.example.psicoweb.service;

import com.example.psicoweb.model.Usuario;
import com.example.psicoweb.model.Psicologo;
import com.example.psicoweb.Repository.UsuarioRepository;
import com.example.psicoweb.Repository.PsicologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PsicologoRepository psicologoRepository;

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public List<Psicologo> getAllPsicologos() {
        return psicologoRepository.findAll();
    }

    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    public void eliminarPsicologo(Long id) {
        psicologoRepository.deleteById(id);
    }
}
