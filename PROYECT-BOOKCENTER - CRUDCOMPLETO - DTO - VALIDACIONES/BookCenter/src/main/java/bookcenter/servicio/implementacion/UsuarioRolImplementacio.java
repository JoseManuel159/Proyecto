package bookcenter.servicio.implementacion;

import bookcenter.modelo.UsuarioRol;
import bookcenter.repositorio.UsuarioRolRepository;
import bookcenter.servicio.UsuarioRolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioRolImplementacio implements UsuarioRolService {
    private final UsuarioRolRepository repo;
    @Override
    public List<UsuarioRol> findOneByUsuarioUser(String user) {
        return repo.findOneByUsuarioUser(user);
    }
    @Override
    public UsuarioRol save(UsuarioRol ur) {
        return repo.save(ur);
    }
}
