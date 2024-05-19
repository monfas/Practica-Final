package edu.comillas.icai.gitt.pat.spring.jpa.Entidades;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Planta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) public Long id;
    @Column(nullable = false) public String tipo;
    @Column(nullable = false) public String nombre;
    @Column(nullable = false) public LocalDateTime tiempo;
    @ManyToOne
    @JoinColumn(name = "vecino_id", nullable = false) // Nombre de la columna en la tabla de plantas
    public Vecino vecino;
}
