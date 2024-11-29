package bookcenter.mappers;

import bookcenter.dtos.UsuarioDTO;
import bookcenter.modelo.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsuarioMapper extends MapperGenerico<UsuarioDTO, Usuario> {

    @Mapping(target = "clave", ignore = true)
    Usuario toEntityFromCADTO(UsuarioDTO.UsuarioCrearDto usuarioCrearDto);
}