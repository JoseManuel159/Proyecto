package bookcenter.dtos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductoDTO {
    private Long id;
    private String imagen;
    private String nombre;
    private String descripcion;
    private Integer cantidadEnStock;
    private BigDecimal costoCompra;
    private Double precioVenta;

}
