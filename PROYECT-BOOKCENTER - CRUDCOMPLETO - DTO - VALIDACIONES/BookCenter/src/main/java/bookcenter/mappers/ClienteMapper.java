package bookcenter.mappers;
import bookcenter.dtos.ClienteDTO;
import bookcenter.modelo.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    ClienteDTO toDTO(Cliente cliente);
    Cliente toEntity(ClienteDTO clienteDTO);
}
