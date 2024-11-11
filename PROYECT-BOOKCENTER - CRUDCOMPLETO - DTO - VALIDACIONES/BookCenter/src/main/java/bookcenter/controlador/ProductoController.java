package bookcenter.controlador;

import bookcenter.modelo.Categoria;
import bookcenter.modelo.Producto;
import bookcenter.servicio.ProductoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    private ProductoService varProductoService;

    @GetMapping("/ver")
    public ResponseEntity<List<Producto>> findAll() {
        List<Producto> objProducto = varProductoService.findAll();
        return ResponseEntity.ok(objProducto);
    }

    @GetMapping("/ver/{id}")
    public ResponseEntity<Producto> findByCategoria(@PathVariable Long id) {
        Producto objProducto = varProductoService.findById(id);
        return ResponseEntity.ok(objProducto);
    }

    @PostMapping("/guardar")
    public ResponseEntity<String> guardar(@Valid @RequestBody Producto objProducto, BindingResult result) {
        if(result.hasErrors()) {
            return new ResponseEntity<>(result.getFieldError().getDefaultMessage(),HttpStatus.BAD_REQUEST);
        }
        varProductoService.save(objProducto);
        return new ResponseEntity<>("CREADO",HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id) {
        varProductoService.delete(id);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Producto> editar(@RequestBody Producto objProducto, @PathVariable Long id) {
        varProductoService.editarProducto(objProducto, id);
        return ResponseEntity.ok(objProducto);
    }

}
