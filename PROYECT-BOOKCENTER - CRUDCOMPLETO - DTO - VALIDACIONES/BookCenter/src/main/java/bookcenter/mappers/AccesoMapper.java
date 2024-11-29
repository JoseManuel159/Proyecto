package bookcenter.mappers;

import bookcenter.dtos.AccesoDTO;
import bookcenter.modelo.Acceso;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccesoMapper extends
        MapperGenerico<AccesoDTO, Acceso> {
}
