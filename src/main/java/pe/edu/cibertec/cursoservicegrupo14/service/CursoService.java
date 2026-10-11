package pe.edu.cibertec.cursoservicegrupo14.service;

import pe.edu.cibertec.cursoservicegrupo14.dto.CursoDisponibilidadDTO;
import java.util.List;

public interface CursoService {

    CursoDisponibilidadDTO obtenerCursoPorId(Long idCurso);

    List<CursoDisponibilidadDTO> obtenerCursosPorEstudiante(Long estudianteId);
}