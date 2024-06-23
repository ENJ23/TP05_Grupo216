package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Component
@Entity
public class Materia {
    private String codigo;
    private String nombre;
    private String curso;
    private Integer cantidad;
    private Boolean modalidad;
}