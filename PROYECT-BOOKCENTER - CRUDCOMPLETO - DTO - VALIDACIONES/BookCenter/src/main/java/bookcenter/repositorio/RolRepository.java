package bookcenter.repositorio;

import bookcenter.modelo.Rol;

import java.util.Optional;

public interface RolRepository extends CrudGenericoRepository<Rol, Long> {
    Optional<Rol> findByNombre(Rol.RolNombre rolNombre);

    Optional<Rol> findByDescripcion(String nombre);

}
