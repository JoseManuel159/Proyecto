package bookcenter.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CompraDTO {
    @NotNull
    private Long id;
    private LocalDateTime fechaEmision;
    private Double total;
    private List<DetalleCompraDTO> detallesCompra;

}
