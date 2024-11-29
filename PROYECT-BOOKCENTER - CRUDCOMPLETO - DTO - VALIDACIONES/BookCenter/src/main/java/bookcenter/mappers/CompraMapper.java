package bookcenter.mappers;

import bookcenter.dtos.CompraDTO;
import bookcenter.modelo.Compra;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {DetalleCompraMapper.class})
public interface CompraMapper extends MapperGenerico<CompraDTO,Compra>{
    CompraDTO toDTO(Compra compra);
    Compra toEntity(CompraDTO compraDTO);
}
