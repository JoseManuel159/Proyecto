package bookcenter.controlador;

import bookcenter.modelo.Categoria;
import bookcenter.modelo.Credenciales;
import bookcenter.servicio.CredencialesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/credenciales")
public class CredencialesController {
    @Autowired
    private CredencialesService varCredencialesService;

    @GetMapping("/ver")
    public ResponseEntity<List<Credenciales>> findAll() {
        List<Credenciales> objCredenciales = varCredencialesService.findAll();
        return ResponseEntity.ok(objCredenciales);
    }

    @GetMapping("/ver/{id}")
    public ResponseEntity<Credenciales> findByCategoria(@PathVariable Long id) {
        Credenciales objCredenciales = varCredencialesService.findById(id);
        return ResponseEntity.ok(objCredenciales);
    }

    @PostMapping("/guardar")
    public void guardar(@RequestBody Credenciales objCredenciales) {
        varCredencialesService.save(objCredenciales);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id) {
        varCredencialesService.delete(id);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Credenciales> editar(@RequestBody Credenciales objCredenciales, @PathVariable Long id) {
        varCredencialesService.editarCredenciales(objCredenciales, id);
        return ResponseEntity.ok(objCredenciales);
    }

}
