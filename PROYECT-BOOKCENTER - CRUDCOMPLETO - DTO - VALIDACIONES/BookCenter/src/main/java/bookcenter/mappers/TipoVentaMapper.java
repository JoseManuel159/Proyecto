package bookcenter.mappers;

import bookcenter.dtos.TipoVentaDTO;
import bookcenter.modelo.TipoVenta;
import lombok.Data;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TipoVentaMapper {
    TipoVentaDTO toDTO(TipoVenta tipoVenta);
    TipoVenta toEntity(TipoVentaDTO tipoVentaDTO);
}
