package bookcenter.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class UsuarioDTO {
    private Long idUsuario;
    @NotNull
    private String user;
    @NotNull
    private String estado;
    private String token;
    private String rol; // Nuevo campo para el rol

    public record CredencialesDto(String user, char[] clave) { }

    public record UsuarioCrearDto(String user, char[] clave, String rol, String estado) { }


}
