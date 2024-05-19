package edu.comillas.icai.gitt.pat.spring.jpa.Servicio;

import edu.comillas.icai.gitt.pat.spring.jpa.Entidades.Planta;
import edu.comillas.icai.gitt.pat.spring.jpa.Entidades.Usuario;
import edu.comillas.icai.gitt.pat.spring.jpa.Repositorio.RepoPlanta;
import edu.comillas.icai.gitt.pat.spring.jpa.Repositorio.RepoVecino;
import edu.comillas.icai.gitt.pat.spring.jpa.Repositorio.RepoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
@Service
public class ServicioPlantas {
        @Autowired
        RepoPlanta repoPlanta;
        @Autowired
        RepoVecino repoVecino;
        @Autowired
        RepoUsuario repoUsuario;
        public Planta creaPlanta(Planta planta) {
            Planta nuevaplanta=repoPlanta.save(planta);
            return planta;
        }

        public Usuario autentica(String credenciales) {
        Usuario usuario = repoUsuario.findByCredenciales(credenciales);
        if(usuario == null) throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        return usuario;
    }
    public Iterable<Planta> buscaplantas() {
            return repoPlanta.findAll();
    }

    }

