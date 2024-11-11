package bookcenter.mappers;

import java.util.List;

public interface MapperGenerico<D,E> {
    D toDTO(E entity);
    E toEntity(D dto);
    List<D> toDTOs(List<E> entities);
}
