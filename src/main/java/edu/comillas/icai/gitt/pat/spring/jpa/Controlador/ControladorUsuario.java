package edu.comillas.icai.gitt.pat.spring.jpa.Controlador;
import edu.comillas.icai.gitt.pat.spring.jpa.Repositorio.RepoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import edu.comillas.icai.gitt.pat.spring.jpa.Entidades.Usuario;

import java.util.Map;

@RestController
public class ControladorUsuario {
    @Autowired
    RepoUsuario repoUsuario;

    @GetMapping("/api/usuarios")
    public Usuario login(@RequestHeader("Authorization") String credenciales) {
        Usuario usuario = repoUsuario.findByCredenciales(credenciales);
        if (usuario == null) throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        return usuario;
    }

    @PostMapping("/api/registrarusuario")
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        // Aquí puedes añadir validaciones adicionales para el usuario

        return repoUsuario.save(usuario);
    }

    @PostMapping("/api/usuarios")
    public Usuario crear(@RequestBody Usuario usuario, @RequestHeader("Authorization") String credenciales) {
        usuario.credenciales = credenciales;
        usuario.rol = "USER";
        return repoUsuario.save(usuario);
    }
}
