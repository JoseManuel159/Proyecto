package bookcenter.controlador;

import bookcenter.mappers.ClienteMapper;
import bookcenter.modelo.Cliente;
import bookcenter.servicio.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//@CrossOrigin("*")
@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClientesController {
    @Autowired
    private ClienteService varClienteService;
    private ClienteMapper varClienteMapper;

    @GetMapping("/ver")
    public ResponseEntity<List<Cliente>> findAll() {
        List<Cliente> objCategoria = varClienteService.findAll();
        return ResponseEntity.ok(objCategoria);
    }

    @GetMapping("/ver/{id}")
    public ResponseEntity<Cliente> findByCategoria(@PathVariable Long id) {
        Cliente objCliente = varClienteService.findById(id);
        return ResponseEntity.ok(objCliente);
    }

    @PostMapping("/guardar")
    public void guardar(@Valid @RequestBody Cliente objCliente) {
        varClienteService.save(objCliente);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id) {
        varClienteService.delete(id);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Cliente> editar(@RequestBody Cliente objCliente, @PathVariable Long id) {
        Cliente clienteExistente = varClienteService.findById(id);
        if (clienteExistente != null) {
            clienteExistente.setNombre(objCliente.getNombre());
            clienteExistente.setTelefono(objCliente.getTelefono());
            varClienteService.save(clienteExistente);
            return ResponseEntity.ok(clienteExistente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
