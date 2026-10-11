package pe.edu.cibertec.cursoservicegrupo14.controller;

import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.cursoservicegrupo14.dto.CursoDisponibilidadDTO;
import pe.edu.cibertec.cursoservicegrupo14.service.CursoService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping("/{idCurso}")
    public CursoDisponibilidadDTO obtenerCurso(@PathVariable Long idCurso) {
        return cursoService.obtenerCursoPorId(idCurso);
    }

    @GetMapping("/estudiante/{estudianteId}")
    public List<CursoDisponibilidadDTO> obtenerCursosPorEstudiante(
            @PathVariable Long estudianteId) {
        return cursoService.obtenerCursosPorEstudiante(estudianteId);
    }
}