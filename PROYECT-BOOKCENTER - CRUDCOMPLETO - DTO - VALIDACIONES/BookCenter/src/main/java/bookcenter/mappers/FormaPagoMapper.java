package bookcenter.mappers;

import bookcenter.dtos.FormaPagoDTO;
import bookcenter.modelo.FormaPago;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FormaPagoMapper {
    FormaPagoDTO toDTO(FormaPago formaPago);
    FormaPago toEntity(FormaPagoDTO formaPagoDTO);
}
