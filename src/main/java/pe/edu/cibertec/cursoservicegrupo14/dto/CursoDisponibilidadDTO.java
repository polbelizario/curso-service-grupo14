package pe.edu.cibertec.cursoservicegrupo14.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CursoDisponibilidadDTO {

    private Long idCurso;
    private String codigoCurso;
    private String nombreCurso;
    private Integer vacantesDisponibles;
    private String prerrequisito;
    private String estadoCurso;

}