package bookcenter.servicio;

import bookcenter.modelo.Usuarios;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UsuariosService extends CrudGenericoService<Usuarios,Long> {
    public void editarUsuarios(Usuarios usuario, Long id);
}
