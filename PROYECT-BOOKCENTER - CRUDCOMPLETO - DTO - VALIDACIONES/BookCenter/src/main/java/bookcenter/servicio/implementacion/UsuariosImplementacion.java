package bookcenter.servicio.implementacion;

import bookcenter.modelo.Credenciales;
import bookcenter.modelo.Usuarios;
import bookcenter.repositorio.CredencialesRepository;
import bookcenter.repositorio.CrudGenericoRepository;
import bookcenter.repositorio.UsuariosRepository;
import bookcenter.servicio.CrudGenericoService;
import bookcenter.servicio.UsuariosService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UsuariosImplementacion extends CrudGenericoImplementacion<Usuarios,Long> implements UsuariosService {
    private final UsuariosRepository varUsuariosRepo;

    @Override
    protected CrudGenericoRepository<Usuarios, Long> getRepo() {
        return varUsuariosRepo;
    }


    @Override
    public void editarUsuarios(Usuarios paraUsuarios, Long id) {
        Usuarios objUsuarios = varUsuariosRepo.findById(id).orElse(new Usuarios());
        if(objUsuarios != null) {
            // Remover essa linha: objUsuarios.setId(id);
            objUsuarios.setNombres(paraUsuarios.getNombres());
            objUsuarios.setApellidoPaterno(paraUsuarios.getApellidoPaterno());
            objUsuarios.setApellidoMaterno(paraUsuarios.getApellidoMaterno());
            objUsuarios.setCargo(paraUsuarios.getCargo());
            objUsuarios.setDireccion(paraUsuarios.getDireccion());
            // objUsuarios.setDni(paraUsuarios.getDni()); // Evitar alterar o DNI
            objUsuarios.setFotoUsuaria(paraUsuarios.getFotoUsuaria());
            objUsuarios.setPermisos(paraUsuarios.getPermisos());
            objUsuarios.setCredencial(paraUsuarios.getCredencial());
            varUsuariosRepo.save(objUsuarios);
        }
    }
}
