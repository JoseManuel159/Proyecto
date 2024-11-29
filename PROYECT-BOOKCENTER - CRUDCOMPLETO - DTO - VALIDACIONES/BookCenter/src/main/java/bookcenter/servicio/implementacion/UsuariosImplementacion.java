package bookcenter.servicio.implementacion;

import bookcenter.dtos.UsuarioDTO;
import bookcenter.excepcion.ModelNotFoundException;
import bookcenter.mappers.UsuarioMapper;
import bookcenter.modelo.Rol;
import bookcenter.modelo.Usuario;
import bookcenter.modelo.UsuarioRol;
import bookcenter.repositorio.CrudGenericoRepository;
import bookcenter.repositorio.UsuariosRepository;
import bookcenter.servicio.RolService;
import bookcenter.servicio.UsuarioRolService;
import bookcenter.servicio.UsuariosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.nio.CharBuffer;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UsuariosImplementacion extends CrudGenericoImplementacion<Usuario,Long> implements UsuariosService {
    private final UsuariosRepository repo;

    private final RolService rolService;
    private final UsuarioRolService iurService;

    private final PasswordEncoder passwordEncoder;
    private final UsuarioMapper userMapper;

    @Override
    protected CrudGenericoRepository<Usuario, Long> getRepo() {
        return repo;
    }


    @Override
    public void editarUsuarios(Usuario usuario, Long id) {

    }



    @Override
    public UsuarioDTO login(UsuarioDTO.CredencialesDto credentialsDto) {
        Usuario user = repo.findOneByUser(credentialsDto.user())
                .orElseThrow(() -> new ModelNotFoundException("Unknown user", HttpStatus.NOT_FOUND));

        if (passwordEncoder.matches(CharBuffer.wrap(credentialsDto.clave()), user.getClave())) {
            return userMapper.toDTO(user);
        }

        throw new ModelNotFoundException("Invalid password", HttpStatus.BAD_REQUEST);
    }



    @Override
    public UsuarioDTO register(UsuarioDTO.UsuarioCrearDto userDto) {
        Optional<Usuario> optionalUser = repo.findOneByUser(userDto.user());
        if (optionalUser.isPresent()) {
            throw new ModelNotFoundException("Login already exists", HttpStatus.BAD_REQUEST);
        }
        Usuario user = userMapper.toEntityFromCADTO(userDto);
        user.setClave(passwordEncoder.encode(CharBuffer.wrap(userDto.clave())));
        Usuario savedUser = repo.save(user);
        Rol r;
        switch (userDto.rol()){
            case "ADMIN":{
                r=rolService.getByNombre(Rol.RolNombre.ADMIN).orElse(null);
            } break;
            case "DBA":{
                r=rolService.getByNombre(Rol.RolNombre.DBA).orElse(null);
            } break;
            default:{
                r=rolService.getByNombre(Rol.RolNombre.USER).orElse(null);
            } break;
        }

        iurService.save(UsuarioRol.builder()
                .usuario(savedUser)
                .rol(r)
                .build());
        return userMapper.toDTO(savedUser);
    }

}
