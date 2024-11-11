package bookcenter.mappers;

import bookcenter.dtos.UsuarioDTO;
import bookcenter.modelo.Usuarios;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = CredencialesMapper.class)
public interface UsuarioMapper extends MapperGenerico<UsuarioDTO, Usuarios> {

    @Override
    @Mapping(source = "credencial", target = "credencial")
    UsuarioDTO toDTO(Usuarios usuario);

    @Override
    @Mapping(source = "credencial", target = "credencial")
    Usuarios toEntity(UsuarioDTO dto);
}