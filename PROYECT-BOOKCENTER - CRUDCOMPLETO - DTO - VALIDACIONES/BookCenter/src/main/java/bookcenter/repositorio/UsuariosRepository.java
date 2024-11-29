package bookcenter.repositorio;

import bookcenter.modelo.Usuario;

import java.util.Optional;

public interface UsuariosRepository extends CrudGenericoRepository<Usuario,Long> {
    Optional<Usuario> findOneByUser(String user);

}
