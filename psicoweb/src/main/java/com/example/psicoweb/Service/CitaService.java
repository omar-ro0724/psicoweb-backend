package com.example.psicoweb.Service;

import com.example.psicoweb.Repository.CitaRepository;
import com.example.psicoweb.Repository.ReciboPagoRepository;
import com.example.psicoweb.model.Cita;
import com.example.psicoweb.model.ReciboPago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class CitaService {
    @Autowired private CitaRepository citaRepository;

    public Cita crear(Cita cita) { return citaRepository.save(cita); }
    public List<Cita> porPsicologo(Long id) { return citaRepository.findByIdPsicologo(id); }
    public List<Cita> porPaciente(Long id) { return citaRepository.findByIdPaciente(id); }

    @Autowired
    private ReciboPagoRepository reciboPagoRepository;

    public Cita agendarCita(Cita cita) {
        Cita nuevaCita = citaRepository.save(cita);

        ReciboPago recibo = new ReciboPago();
        recibo.setCita(nuevaCita);
        recibo.setFechaEmision(LocalDate.from(LocalDateTime.now()));
        recibo.setReferencia(UUID.randomUUID().toString());
        recibo.setValor(60000.0);

        reciboPagoRepository.save(recibo);

        return nuevaCita;
    }

}