package bookcenter.servicio;

import bookcenter.modelo.Cliente;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClienteService extends CrudGenericoService<Cliente,Long> {
    public void editarCliente(Cliente cliente, Long id);
}
