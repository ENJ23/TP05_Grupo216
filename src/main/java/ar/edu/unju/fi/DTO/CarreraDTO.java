package ar.edu.unju.fi.DTO;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class CarreraDTO {

	private String nombre;
	private Integer duracion;
}
