package com.example.psicoweb.Controller;



import com.example.psicoweb.Service.PacienteService;
import com.example.psicoweb.model.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
@CrossOrigin(origins = "*")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping("/registro")
    public Paciente registrar(@RequestBody Paciente paciente) {
        return pacienteService.registrarPaciente(paciente);
    }

    @GetMapping
    public List<Paciente> obtenerTodos() {
        return pacienteService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Paciente obtenerPorId(@PathVariable Long id) {
        return pacienteService.obtenerPorId(id);
    }
}