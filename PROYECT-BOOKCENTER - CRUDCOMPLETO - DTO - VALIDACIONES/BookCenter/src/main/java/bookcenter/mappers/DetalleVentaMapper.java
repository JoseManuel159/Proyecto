package bookcenter.mappers;

import bookcenter.dtos.DetalleVentaDTO;
import bookcenter.modelo.DetalleVenta;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ProductoMapper.class})
public interface DetalleVentaMapper extends MapperGenerico<DetalleVentaDTO, DetalleVenta> {
    DetalleVenta toEntity(DetalleVentaDTO dto);
    DetalleVentaDTO toDTO(DetalleVenta detalleVenta);
}
