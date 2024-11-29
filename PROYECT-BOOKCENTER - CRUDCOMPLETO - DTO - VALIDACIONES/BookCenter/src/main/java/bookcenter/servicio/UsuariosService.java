package bookcenter.servicio;

import bookcenter.dtos.UsuarioDTO;
import bookcenter.modelo.Usuario;


public interface UsuariosService extends CrudGenericoService<Usuario,Long> {
    public void editarUsuarios(Usuario usuario, Long id);
    public UsuarioDTO login(UsuarioDTO.CredencialesDto credentialsDto);
    public UsuarioDTO register(UsuarioDTO.UsuarioCrearDto userDto);

}
