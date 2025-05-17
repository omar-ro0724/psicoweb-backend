package com.example.psicoweb.Controller;

import com.example.psicoweb.Service.DisponibilidadService;
import com.example.psicoweb.model.Disponibilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disponibilidad")
@CrossOrigin(origins = "*")
public class DisponibilidadController {
    @Autowired private DisponibilidadService servicio;

    @PostMapping("/crear")
    public Disponibilidad crear(@RequestBody Disponibilidad d) { return servicio.crear(d); }

    @GetMapping("/porPsicologo/{id}")
    public List<Disponibilidad> porPsicologo(@PathVariable Long id) { return servicio.porPsicologo(id); }
}
