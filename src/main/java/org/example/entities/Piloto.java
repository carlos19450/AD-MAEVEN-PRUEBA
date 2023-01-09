package org.example.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "pilotos")
public class Piloto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 50, unique = true)
    private String nombre;
    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimeinto;

    public Piloto() {
    }

    public Piloto(String nombre, LocalDate fechaNacimeinto) {
        this.nombre = nombre;
        this.fechaNacimeinto = fechaNacimeinto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimeinto() {
        return fechaNacimeinto;
    }

    public void setFechaNacimeinto(LocalDate fechaNacimeinto) {
        this.fechaNacimeinto = fechaNacimeinto;
    }

    @Override
    public String toString() {
        return "Piloto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fechaNacimeinto=" + fechaNacimeinto +
                '}';
    }
}