package bookcenter.servicio.implementacion;

import bookcenter.modelo.Acceso;
import bookcenter.repositorio.AccesoRepository;
import bookcenter.repositorio.CrudGenericoRepository;
import bookcenter.servicio.AccesoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccesoImplementacion extends CrudGenericoImplementacion<Acceso, Long> implements AccesoService {
    private final AccesoRepository repo;
    @Override
    protected CrudGenericoRepository<Acceso, Long> getRepo() {
        return repo;
    }
    @Override
    public List<Acceso> getAccesoByUser(String username) {
        return repo.getAccesoByUser(username);
    }
}
