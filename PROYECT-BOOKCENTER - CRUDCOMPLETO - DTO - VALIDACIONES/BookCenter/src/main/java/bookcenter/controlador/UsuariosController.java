package bookcenter.controlador;

import bookcenter.dtos.UsuarioDTO;
import bookcenter.mappers.UsuarioMapper;
import bookcenter.modelo.Credenciales;
import bookcenter.modelo.Usuarios;
import bookcenter.servicio.CredencialesService;
import bookcenter.servicio.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuariosController {
    @Autowired
    private UsuariosService varUsuariosService;
    @Autowired
    private CredencialesService credencialesService;
    @Autowired
    private UsuarioMapper usuarioMapper;


    @GetMapping("/ver")
    public ResponseEntity<List<Usuarios>> findAll() {
        List<Usuarios> objUsuarios = varUsuariosService.findAll();
        return ResponseEntity.ok(objUsuarios);
    }

    @GetMapping("/ver/{id}")
    public ResponseEntity<Usuarios> findByUsuarios(@PathVariable Long id) {
        Usuarios objUsuarios = varUsuariosService.findById(id);
        return ResponseEntity.ok(objUsuarios);
    }

    @PostMapping("/guardar")
    public void guardar(@RequestBody Usuarios objUsuarios) {
        varUsuariosService.save(objUsuarios);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id) {
        varUsuariosService.delete(id);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Usuarios> editar(@RequestBody Usuarios objUsuarios, @PathVariable Long id) {
        varUsuariosService.editarUsuarios(objUsuarios, id);
        return ResponseEntity.ok(objUsuarios);
    }

    //Registro de UsarioCompleto.
    @PostMapping("/registrar")
    public ResponseEntity<UsuarioDTO> registrarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        Usuarios usuario = usuarioMapper.toEntity(usuarioDTO);
        usuario.setCredencial(credencialesService.save(usuario.getCredencial()));
        Usuarios usuarioGuardado = varUsuariosService.save(usuario);
        return ResponseEntity.ok(usuarioMapper.toDTO(usuarioGuardado));
    }
    /*
    @GetMapping("/buscar")
    public ResponseEntity<UsuarioDTO> buscarPorLoginYContrasena(@RequestParam String usuarioLogin, @RequestParam String contrasena) {
        Credenciales credenciales = credencialesService.buscarPorUsuarioLoginYContrasena(usuarioLogin, contrasena);
        Usuarios usuario = varUsuariosService.findByCredencial(credenciales);
        return ResponseEntity.ok(usuarioMapper.toDTO(usuario));
    }*/

}
