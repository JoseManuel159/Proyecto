package bookcenter.mappers;

import bookcenter.dtos.VentaDTO;
import bookcenter.modelo.Venta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {TipoVentaMapper.class, ClienteMapper.class, FormaPagoMapper.class, DetalleVentaMapper.class})
public interface VentaMapper extends MapperGenerico<VentaDTO, Venta> {
    VentaDTO toDTO(Venta venta);
    Venta toEntity(VentaDTO ventaDTO);
}
