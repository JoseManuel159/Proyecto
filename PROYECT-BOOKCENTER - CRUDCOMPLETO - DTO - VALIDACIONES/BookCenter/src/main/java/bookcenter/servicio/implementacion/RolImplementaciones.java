package bookcenter.servicio.implementacion;

import bookcenter.modelo.Rol;
import bookcenter.repositorio.CrudGenericoRepository;
import bookcenter.repositorio.RolRepository;
import bookcenter.servicio.RolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class RolImplementaciones extends CrudGenericoImplementacion<Rol, Long> implements RolService {
    private final RolRepository repo;
    @Override
    protected CrudGenericoRepository<Rol, Long> getRepo() {
        return repo;
    }
    @Override
    public Optional<Rol> getByNombre(Rol.RolNombre rolNombre) {
        return repo.findByNombre(rolNombre);
    }

}
