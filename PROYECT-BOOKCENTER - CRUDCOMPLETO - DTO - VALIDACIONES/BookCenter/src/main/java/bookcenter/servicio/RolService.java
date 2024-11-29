package bookcenter.servicio;

import bookcenter.modelo.Rol;

import java.util.Optional;

public interface RolService extends CrudGenericoService<Rol, Long> {
    public Optional<Rol> getByNombre(Rol.RolNombre rolNombre);

}
