package bookcenter.servicio.implementacion;

import bookcenter.modelo.Cliente;
import bookcenter.repositorio.ClienteRepository;
import bookcenter.repositorio.CrudGenericoRepository;
import bookcenter.servicio.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ClienteImplementacion extends CrudGenericoImplementacion<Cliente,Long> implements ClienteService {
    private final ClienteRepository varClienteRepository;

    @Override
    protected CrudGenericoRepository<Cliente, Long> getRepo() {
        return varClienteRepository;
    }


    @Override
    public void editarCliente(Cliente paraCliente, Long id) {
        Cliente objCliente = varClienteRepository.findById(id).orElse(new Cliente());
        if(objCliente != null) {
            objCliente.setNombre(paraCliente.getNombre());
            objCliente.setDniCliente(paraCliente.getDniCliente());
            objCliente.setTelefono(paraCliente.getTelefono());
            varClienteRepository.save(objCliente);
        }
    }
}
