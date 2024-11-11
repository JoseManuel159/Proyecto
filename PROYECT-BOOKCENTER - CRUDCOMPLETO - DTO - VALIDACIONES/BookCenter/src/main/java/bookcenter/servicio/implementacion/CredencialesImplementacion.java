package bookcenter.servicio.implementacion;

import bookcenter.modelo.Categoria;
import bookcenter.modelo.Credenciales;
import bookcenter.repositorio.CredencialesRepository;
import bookcenter.repositorio.CrudGenericoRepository;
import bookcenter.servicio.CredencialesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CredencialesImplementacion extends CrudGenericoImplementacion<Credenciales, Long> implements CredencialesService {
    private final CredencialesRepository varCredencialesRepository;

    @Override
    protected CrudGenericoRepository<Credenciales, Long> getRepo() {
        return varCredencialesRepository;
    }


    @Override
    public void editarCredenciales(Credenciales paraCredenciales, Long id) {
        Credenciales objCredenciales = varCredencialesRepository.findById(id).orElse(new Credenciales());
        if(objCredenciales != null) {
            objCredenciales.setContrasena(paraCredenciales.getContrasena());
            objCredenciales.setUsuarioLogin(paraCredenciales.getUsuarioLogin());
            varCredencialesRepository.save(objCredenciales);
        }
    }
}
