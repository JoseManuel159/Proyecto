package bookcenter.mappers;

import bookcenter.dtos.ProductoDTO;
import bookcenter.modelo.Producto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductoMapper {
    ProductoDTO toDTO(Producto producto);
    Producto toEntity(ProductoDTO dto);
}
