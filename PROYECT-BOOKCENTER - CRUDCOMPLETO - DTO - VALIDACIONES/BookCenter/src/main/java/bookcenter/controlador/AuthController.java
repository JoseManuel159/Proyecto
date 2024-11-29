package bookcenter.controlador;

import bookcenter.dtos.UsuarioDTO;
import bookcenter.mappers.UsuarioMapper;
import bookcenter.modelo.Usuario;
import bookcenter.security.JwtTokenUtil;
import bookcenter.security.JwtUserDetailsService;
import bookcenter.servicio.UsuariosService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class AuthController {
    private final UsuariosService userService;
    private final UsuarioMapper usuarioMapper;
    private final JwtTokenUtil jwtTokenUtil;
    private final JwtUserDetailsService jwtUserDetailsService;
    @PostMapping("/login")
    public ResponseEntity<UsuarioDTO> login(@RequestBody @Valid UsuarioDTO.CredencialesDto credentialsDto, HttpServletRequest request) {
        UsuarioDTO userDto = userService.login(credentialsDto);
        final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(credentialsDto.user());
        userDto.setToken(jwtTokenUtil.generateToken(userDetails));
        request.getSession().setAttribute("USER_SESSION", userDto.getUser());
        return ResponseEntity.ok(userDto);
    }
    @PostMapping("/register")
    public ResponseEntity<UsuarioDTO> register(@RequestBody @Valid UsuarioDTO.UsuarioCrearDto user) {
        System.out.println("Passss...."+ user.rol());
        UsuarioDTO createdUser = userService.register(user);
        final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(user.user());
        createdUser.setToken(jwtTokenUtil.generateToken(userDetails));
        return ResponseEntity.created(URI.create("/users/" + createdUser.getUser())).body(createdUser);
    }
    @GetMapping("/all")
    public ResponseEntity<List<UsuarioDTO>> findAll() {
        List<UsuarioDTO> list = usuarioMapper.toDTOs(userService.findAll());
        return ResponseEntity.ok(list);
    }
    @GetMapping("/all/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable("id") Long id) {
            Usuario obj = userService.findById(id);
            return ResponseEntity.ok(usuarioMapper.toDTO(obj));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UsuarioDTO> update(@Valid @PathVariable("id") Long
                                                       id, @RequestBody UsuarioDTO dto) {
        dto.setIdUsuario(id);
        Usuario obj = userService.update(id, usuarioMapper.toEntity(dto));
        return ResponseEntity.ok(usuarioMapper.toDTO(obj));
    }

    @PutMapping("/update-status/{id}")
    public ResponseEntity<UsuarioDTO> updateStatus(@PathVariable("id") Long id) {
        // Obtener usuario por ID
        Usuario obj = userService.findById(id);
        // Cambiar el estado (Alternar entre Activo/Inactivo)
        obj.setEstado(obj.getEstado().equals("Activo") ? "Inactivo" : "Activo");
        // Guardar cambios
        Usuario updatedUser = userService.update(id, obj);
        // Retornar el DTO del usuario actualizado
        return ResponseEntity.ok(usuarioMapper.toDTO(updatedUser));
    }



}
