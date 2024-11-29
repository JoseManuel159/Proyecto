package bookcenter.controlador;

import bookcenter.modelo.Categoria;
import bookcenter.modelo.Pedido;
import bookcenter.servicio.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService varCategoriaService;

    @GetMapping("/ver")
    public ResponseEntity<List<Categoria>> findAll() {
        List<Categoria> objCategoria = varCategoriaService.findAll();
        return ResponseEntity.ok(objCategoria);
    }

    @GetMapping("/ver/{id}")
    public ResponseEntity<Categoria> findByCategoria(@PathVariable Long id) {
        Categoria objCategoria = varCategoriaService.findById(id);
        return ResponseEntity.ok(objCategoria);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Categoria> guardar(@RequestBody Categoria objCategoria) {
        Categoria nuevoCategoria = varCategoriaService.save(objCategoria);
        return new ResponseEntity<>(nuevoCategoria, HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id) {
        varCategoriaService.delete(id);
    }
    @PutMapping("/editar/{id}")
    public ResponseEntity<Categoria> editar(@RequestBody Categoria objCategoria, @PathVariable Long id) {
        Categoria categoriaActualizado = varCategoriaService.update(id, objCategoria);
        return ResponseEntity.ok(categoriaActualizado);
    }

}
