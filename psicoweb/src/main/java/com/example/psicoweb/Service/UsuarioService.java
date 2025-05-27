package com.example.psicoweb.Service;

import com.example.psicoweb.Repository.PacienteRepository;
import com.example.psicoweb.Repository.UsuarioRepository;
import com.example.psicoweb.model.Paciente;
import com.example.psicoweb.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public Optional<Usuario> login(String correo, String contrasena) {
        Optional<Usuario> usuario = usuarioRepository.findByCorreo(correo);

        if (usuario.isPresent()) {
            if (passwordEncoder.matches(contrasena, usuario.get().getContrasena())) {
                return usuario;
            }
        }

        return Optional.empty();
    }


    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    public Usuario modificarRol(Long id, String nuevoRol) {
        Usuario u = usuarioRepository.findById(id).orElseThrow();
        u.setRol(nuevoRol);
        return usuarioRepository.save(u);
    }

    public Optional<Usuario> obtenerPorCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }


    @Autowired
    private PacienteRepository pacienteRepository;

    public Usuario registrarUsuario(Usuario usuario) {
        usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena()));
        Usuario nuevoUsuario = usuarioRepository.save(usuario);

        if ("usuario".equalsIgnoreCase(nuevoUsuario.getRol())) {
            Paciente paciente = new Paciente();
            paciente.setNombre(nuevoUsuario.getNombre());
            paciente.setApellido(nuevoUsuario.getApellido());
            paciente.setCorreo(nuevoUsuario.getCorreo());
            paciente.setUsuario(nuevoUsuario);
            pacienteRepository.save(paciente);
        }

        return nuevoUsuario;
    }
}