package bookcenter.dtos;

import lombok.Data;

@Data
public class DetalleVentaDTO {
    private ProductoDTO producto;
    private Integer cantidad;
}
