package bookcenter.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CredencialesDTO {
    @NotNull
    private Long id;
    @NotNull
    private String usuarioLogin;
    @NotNull
    private String contrasena;
}
