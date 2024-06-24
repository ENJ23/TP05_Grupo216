package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.DTO.AlumnoDTO;
import ar.edu.unju.fi.map.AlumnoMapDTO;
import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.repository.AlumnoRepository;
import ar.edu.unju.fi.service.AlumnoService;

public class AlumnoServiceImp implements AlumnoService{

		@Autowired
		AlumnoRepository alumnoRepository;
		@Autowired 
		AlumnoMapDTO alumnoMapDTO;
		
		@Override
		public void guardarAlumno (AlumnoDTO alumno) {
			alumnoMapDTO.convertirAlumnoDTOAAlumno(alumno);
			alumnoRepository.save
			(alumnoMapDTO.convertirAlumnoDTOAAlumno(alumno));
		}

		@Override
		public List<Alumno> mostrarAlumnos() {
			// TODO Auto-generated method stub
			//return carreraRepository.findAll();
			return docenteRepository.findDocenteByEstado(true);
		}

		@Override
		public void borrarAlumno(String lu) {
			System.out.println("esta es la libreta universitaria: "+lu);
			// TODO Auto-generated method stub
			List<Alumno> todosLosAlumnos = alumnoRepository.findAll();
			for (int i = 0; i < todosLosAlumnos.size(); i++) {
			      Alumno alumno = todosLosAlumnos.get(i);
			      if (alumno.getLu().equals(lu)) {
			        alumno.setEstado(false);
			        alumnoRepository.save(alumno);
			        break;
			      }
			    }
		}
		



		@Override
		public AlumnoDTO buscarAlumno(String alumno) {
			
			List<Alumno> todosLosAlumnos = alumnoRepository.findAll();
			for (Alumno alumno : todosLosAlumnos){
				if (alumno.getLu().equals(lu)){
					return alumnoMapDTO.convertirAlumnoAAlumnoDTO(alumno);
				}
			}
			return null;
		}

		@Override
		public void modificarAlumno(AlumnoDTO alumnoModificada) {
			List<Alumno> todosLosAlumnos = alumnoRepository.findAll();
			for (int i = 0 ; i < todosLosAlumnos.size() ; i++) {
				AlumnoDTO alumno = alumnoMapDTO.convertirAlumnoAAlumnoDTO(todosLosAlumnos.get(i));
				if (alumno.getLu().equals(alumnoModificada.getLu())) {
					todosLosAlumnos.set(i, alumnoMapDTO.convertirAlumnoDTOAAlumno(alumnoModificada));
					break;
				}
			}
		}

	}
}
