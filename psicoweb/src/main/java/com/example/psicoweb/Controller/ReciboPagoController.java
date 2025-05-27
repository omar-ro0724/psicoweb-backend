package com.example.psicoweb.Controller;

import com.example.psicoweb.model.ReciboPago;
import com.example.psicoweb.Service.ReciboPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recibos")
@CrossOrigin(origins = "*")
public class ReciboPagoController {

    @Autowired
    private ReciboPagoService reciboPagoService;

    @GetMapping("/cita/{idCita}")
    public ResponseEntity<ReciboPago> obtenerReciboPorCita(@PathVariable Long idCita) {
        return reciboPagoService.obtenerPorCita(idCita)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
