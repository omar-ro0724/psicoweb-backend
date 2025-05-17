package com.example.psicoweb.Controller;

import com.example.psicoweb.Service.PsicologoService;
import com.example.psicoweb.Service.UsuarioService;
import com.example.psicoweb.model.Psicologo;
import com.example.psicoweb.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/psicologos")
@CrossOrigin(origins = "*")
public class PsicologoController {
    @Autowired
    private UsuarioService servicio;

    @GetMapping("/listar")
    public List<Usuario> listarPsicologos() {
        return servicio.listar().stream().filter(u -> u.getRol().equals("psicologo")).toList();
    }

    @PostMapping("/crear")
    public Usuario crearPsicologo(@RequestBody Usuario u) {
        u.setRol("psicologo");
        return servicio.registrarUsuario(u);
    }
}