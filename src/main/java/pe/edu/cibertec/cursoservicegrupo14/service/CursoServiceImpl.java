package pe.edu.cibertec.cursoservicegrupo14.service;

import org.springframework.stereotype.Service;
import pe.edu.cibertec.cursoservicegrupo14.dto.CursoDisponibilidadDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CursoServiceImpl implements CursoService {

    private final Map<Long, CursoDisponibilidadDTO> cursos = new HashMap<>();
    private final Map<Long, List<Long>> cursosPorEstudiante = new HashMap<>();

    public CursoServiceImpl() {

        CursoDisponibilidadDTO curso1 = new CursoDisponibilidadDTO();
        curso1.setIdCurso(1L);
        curso1.setCodigoCurso("JAVA101");
        curso1.setNombreCurso("Programación Java");
        curso1.setVacantesDisponibles(20);
        curso1.setPrerrequisito("NINGUNO");
        curso1.setEstadoCurso("ABIERTO");
        cursos.put(1L, curso1);

        CursoDisponibilidadDTO curso2 = new CursoDisponibilidadDTO();
        curso2.setIdCurso(2L);
        curso2.setCodigoCurso("BD201");
        curso2.setNombreCurso("Base de Datos");
        curso2.setVacantesDisponibles(10);
        curso2.setPrerrequisito("JAVA101");
        curso2.setEstadoCurso("ABIERTO");
        cursos.put(2L, curso2);

        CursoDisponibilidadDTO curso3 = new CursoDisponibilidadDTO();
        curso3.setIdCurso(3L);
        curso3.setCodigoCurso("WEB301");
        curso3.setNombreCurso("Desarrollo Web");
        curso3.setVacantesDisponibles(0);
        curso3.setPrerrequisito("BD201");
        curso3.setEstadoCurso("CERRADO");
        cursos.put(3L, curso3);

        cursosPorEstudiante.put(1L, List.of(1L, 2L));
        cursosPorEstudiante.put(2L, List.of(2L, 3L));
        cursosPorEstudiante.put(3L, List.of(1L, 3L));
    }

    @Override
    public CursoDisponibilidadDTO obtenerCursoPorId(Long idCurso) {
        return cursos.get(idCurso);
    }

    @Override
    public List<CursoDisponibilidadDTO> obtenerCursosPorEstudiante(
            Long estudianteId) {

        List<Long> idsCursos = cursosPorEstudiante.getOrDefault(
                estudianteId, List.of()
        );

        List<CursoDisponibilidadDTO> resultado = new ArrayList<>();

        for (Long idCurso : idsCursos) {

            CursoDisponibilidadDTO curso = cursos.get(idCurso);

            if (curso != null) {
                resultado.add(curso);
            }
        }

        return resultado;
    }
}