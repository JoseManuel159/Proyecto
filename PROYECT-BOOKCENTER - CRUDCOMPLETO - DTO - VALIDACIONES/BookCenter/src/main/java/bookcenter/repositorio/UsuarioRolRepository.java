package bookcenter.repositorio;

import bookcenter.modelo.UsuarioRol;
import bookcenter.modelo.UsuarioRolPK;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuarioRolRepository extends CrudGenericoRepository<UsuarioRol, UsuarioRolPK> {
    @Query("SELECT ur FROM UsuarioRol ur WHERE ur.usuario.user = :user")//Consulta JPQL
    List<UsuarioRol> findOneByUsuarioUser(@Param("user") String user);
}
