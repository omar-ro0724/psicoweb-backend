package com.example.psicoweb.Controller;

import com.example.psicoweb.Service.PagoService;
import com.example.psicoweb.model.Pago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pagos")
@CrossOrigin(origins = "*")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @PostMapping("/registrar")
    public Pago registrar(@RequestBody Pago pago) {
        return pagoService.registrarPago(pago);
    }

    @GetMapping("/{id}")
    public Pago obtenerPorId(@PathVariable Long id) {
        return pagoService.obtenerPorId(id);
    }
}