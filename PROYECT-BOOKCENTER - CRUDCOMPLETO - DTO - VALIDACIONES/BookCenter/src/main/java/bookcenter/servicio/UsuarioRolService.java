package bookcenter.servicio;

import bookcenter.modelo.UsuarioRol;

import java.util.List;

public interface UsuarioRolService {
    List<UsuarioRol> findOneByUsuarioUser(String user);
    UsuarioRol save(UsuarioRol ur);
}
