package bookcenter.mappers;

import bookcenter.dtos.DetalleCompraDTO;
import bookcenter.modelo.DetalleCompra;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ProductoMapper.class})
public interface DetalleCompraMapper extends MapperGenerico<DetalleCompraDTO,DetalleCompra>{
    DetalleCompra toEntity(DetalleCompraDTO dto);
    DetalleCompraDTO toDTO(DetalleCompra detalleCompra);
}
