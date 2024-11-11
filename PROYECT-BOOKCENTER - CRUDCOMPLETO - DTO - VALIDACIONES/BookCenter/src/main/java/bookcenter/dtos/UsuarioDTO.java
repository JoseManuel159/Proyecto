package bookcenter.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UsuarioDTO {
    @NotNull
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    @NotNull
    private String dni;
    private String cargo;
    private String fotoUsuaria;
    private String direccion;
    private String permisos;
    private CredencialesDTO credencial;
}
