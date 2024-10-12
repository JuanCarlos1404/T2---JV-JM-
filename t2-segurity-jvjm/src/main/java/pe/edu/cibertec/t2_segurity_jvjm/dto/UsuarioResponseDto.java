package pe.edu.cibertec.t2_segurity_jvjm.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UsuarioResponseDto {
    private Integer idusuario;
    private String email;
    private String token;
}
