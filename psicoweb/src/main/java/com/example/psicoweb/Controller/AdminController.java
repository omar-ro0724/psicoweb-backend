package com.example.psicoweb.Controller;

import com.example.psicoweb.model.Usuario;
import com.example.psicoweb.model.Psicologo;
import com.example.psicoweb.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        return ResponseEntity.ok(adminService.getAllUsuarios());
    }

    @GetMapping("/psicologos")
    public ResponseEntity<List<Psicologo>> getAllPsicologos() {
        return ResponseEntity.ok(adminService.getAllPsicologos());
    }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        adminService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/psicologos/{id}")
    public ResponseEntity<Void> eliminarPsicologo(@PathVariable Long id) {
        adminService.eliminarPsicologo(id);
        return ResponseEntity.noContent().build();
    }
}
