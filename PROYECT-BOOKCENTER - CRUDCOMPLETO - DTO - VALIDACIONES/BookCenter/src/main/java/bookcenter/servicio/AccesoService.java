package bookcenter.servicio;

import bookcenter.modelo.Acceso;

import java.util.List;

public interface AccesoService {
    List<Acceso> getAccesoByUser(String username);

}
