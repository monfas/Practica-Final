package edu.comillas.icai.gitt.pat.spring.jpa.Controlador;


import edu.comillas.icai.gitt.pat.spring.jpa.Entidades.Planta;
import edu.comillas.icai.gitt.pat.spring.jpa.Entidades.Usuario;
import edu.comillas.icai.gitt.pat.spring.jpa.Repositorio.RepoPlanta;
import edu.comillas.icai.gitt.pat.spring.jpa.Repositorio.RepoVecino;
import edu.comillas.icai.gitt.pat.spring.jpa.Servicio.ServicioPlantas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class Controlador {
    @Autowired
    ServicioPlantas servicioPlantas;

    @PostMapping("/api/crearPlanta")
    @ResponseStatus(HttpStatus.CREATED)
    public Planta crea(@RequestBody Planta planta, @RequestHeader("Authorization") String credenciales) {
        Usuario usuario = servicioPlantas.autentica(credenciales);
        if (!usuario.rol.equals("Vecino")) throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        return servicioPlantas.creaPlanta(planta);
    }

    @GetMapping("/api/eventos")
    public Iterable<Planta> leePlantas() {
        Iterable<Planta> plantas = servicioPlantas.buscaplantas();
        if (plantas == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return plantas;
    }
}