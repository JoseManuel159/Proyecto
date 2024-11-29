package bookcenter.security;



import bookcenter.modelo.Usuario;
import bookcenter.modelo.UsuarioRol;
import bookcenter.repositorio.UsuarioRolRepository;
import bookcenter.repositorio.UsuariosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

//Clase S4
@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

    private final UsuarioRolRepository repo;
    private final UsuariosRepository repoU;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario u=repoU.findOneByUser(username).orElse(null);
        List<UsuarioRol> user = repo.findOneByUsuarioUser(username);

        if (user == null) {
            throw new UsernameNotFoundException("Username not found: " + username);
        }

        List<GrantedAuthority> roles = new ArrayList<>();
        user.forEach(rol -> {
            roles.add(new SimpleGrantedAuthority(rol.getRol().getNombre().name()));
        });

        return new org.springframework.security.core.userdetails.User(u.getUser(), u.getClave(), roles);
    }
}