package bookcenter.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {
    @NotNull
    @Size(min = 8, max = 8, message = "DNI DE 8 DIGITOS")
    private String dniCliente;
    @NotNull
    private String nombre;
    private String telefono;
}
