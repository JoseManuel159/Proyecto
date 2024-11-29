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
    public ResponseEntity<Producto> guardar(@Valid @RequestBody Producto objProducto, BindingResult result) {
        if (result.hasErrors()) {
            // Devuelve el mensaje de error si hay errores de validación
            return ResponseEntity.badRequest().body(null);
        }

        // Guarda el producto y devuelve el objeto creado
        Producto productoGuardado = varProductoService.save(objProducto);

        // Devuelve el producto guardado con un estado 201 Created
        return ResponseEntity.status(HttpStatus.CREATED).body(productoGuardado);
    }


    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id) {
        varProductoService.delete(id);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Producto> editar(@RequestBody Producto objProducto, @PathVariable Long id) {
        System.out.println("Producto recibido: " + objProducto);
        System.out.println("ID recibido: " + id);

        varProductoService.editarProducto(objProducto, id);
        return ResponseEntity.ok(objProducto);
    }

}
