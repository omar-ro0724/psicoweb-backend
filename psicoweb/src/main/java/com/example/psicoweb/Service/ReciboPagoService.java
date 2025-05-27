package com.example.psicoweb.Service;

import com.example.psicoweb.Repository.ReciboPagoRepository;
import com.example.psicoweb.model.ReciboPago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReciboPagoService {

    @Autowired
    private ReciboPagoRepository reciboPagoRepository;
    public ReciboPago registrarPago(ReciboPago pago) {
        return reciboPagoRepository.save(pago);
    }

    public ReciboPago obtenerPorId(Long id) {
        return reciboPagoRepository.findById(id).orElse(null);
    }

    public Optional<ReciboPago> obtenerPorCita(Long idCita) {
        return reciboPagoRepository.findAll()
                .stream()
                .filter(r-> r.getCita().getIdCita().equals(idCita))
                .findFirst();
    }

}
