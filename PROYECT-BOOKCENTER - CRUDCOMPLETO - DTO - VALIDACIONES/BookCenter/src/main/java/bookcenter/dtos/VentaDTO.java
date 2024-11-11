package bookcenter.dtos;

import bookcenter.modelo.Venta;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class VentaDTO{
    @NotNull
    private Long id;
    private TipoVentaDTO tipoVenta;
    private LocalDateTime fechaEmision;
    private ClienteDTO dni_Cliente;
    private FormaPagoDTO formaPago;
    private List<DetalleVentaDTO> detallesVenta;
}
