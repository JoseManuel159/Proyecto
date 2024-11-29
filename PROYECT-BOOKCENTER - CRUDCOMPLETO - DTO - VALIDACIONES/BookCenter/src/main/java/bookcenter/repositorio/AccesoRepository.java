package bookcenter.repositorio;

import bookcenter.modelo.Acceso;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccesoRepository extends CrudGenericoRepository<Acceso, Long> {
    @Query(value = """
 SELECT a.* FROM acceso_rol ar
 INNER JOIN usuario_rol ur ON (ur.rol_id=ar.rol_id)
 INNER JOIN accesos a ON (a.id_acceso=ar.acceso_id)
 INNER JOIN usuario u ON (u.id_usuario=ur.usuario_id)
 WHERE u.user=:username
 """, nativeQuery = true)
    List<Acceso> getAccesoByUser(@Param("username") String username);
}
