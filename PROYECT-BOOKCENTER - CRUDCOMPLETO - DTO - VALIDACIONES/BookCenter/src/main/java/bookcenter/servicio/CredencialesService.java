package bookcenter.servicio;

import bookcenter.modelo.Credenciales;

public interface CredencialesService extends CrudGenericoService<Credenciales,Long>{
public void editarCredenciales(Credenciales credenciales, Long id);

}
