package bookcenter.dtos;

import lombok.Data;

@Data
public class DetalleCompraDTO {
    private ProductoDTO producto;
    private Integer cantidad;
    private Double precioCompra;
    private Double subtotal;
}
