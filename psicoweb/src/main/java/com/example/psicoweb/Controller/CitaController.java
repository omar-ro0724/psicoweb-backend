package com.example.psicoweb.Controller;

import com.example.psicoweb.Service.CitaService;
import com.example.psicoweb.model.Cita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
@CrossOrigin(origins = "*")
public class CitaController {
    @Autowired private CitaService servicio;

    @PostMapping("/agendar")
    public Cita agendar (@RequestBody Cita cita) { return servicio.crear(cita); }

    @GetMapping("/porPsicologo/{id}")
    public List<Cita> porPsicologo(@PathVariable Long id) { return servicio.porPsicologo(id); }

    @GetMapping("/porPaciente/{id}")
    public List<Cita> porPaciente(@PathVariable Long id) { return servicio.porPaciente(id); }
}