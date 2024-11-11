package bookcenter.mappers;

import bookcenter.dtos.CredencialesDTO;
import bookcenter.modelo.Credenciales;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CredencialesMapper extends MapperGenerico<CredencialesDTO, Credenciales> {

}
