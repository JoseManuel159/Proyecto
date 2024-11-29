package bookcenter.controlador;

import bookcenter.modelo.DetalleCompra;
import bookcenter.servicio.DetalleCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/detalle-compra")
public class DetalleCompraController {

    @Autowired
    private DetalleCompraService varDetalleCompraService;

    @GetMapping("/ver")
    public ResponseEntity<List<DetalleCompra>> findAll() {
        List<DetalleCompra> objDetalleCompra = varDetalleCompraService.findAll();
        return ResponseEntity.ok(objDetalleCompra);
    }

    @GetMapping("/ver/{id}")
    public ResponseEntity<DetalleCompra> findByCategoria(@PathVariable Long id) {
        DetalleCompra objDetallCompra = varDetalleCompraService.findById(id);
        return ResponseEntity.ok(objDetallCompra);
    }

    @PostMapping("/guardar")
    public ResponseEntity<DetalleCompra> guardar(@RequestBody DetalleCompra objDetalleCompra) {
        DetalleCompra nuevoDetalleCompra = varDetalleCompraService.save(objDetalleCompra);
        return new ResponseEntity<>(nuevoDetalleCompra, HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id) {
        varDetalleCompraService.delete(id);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<DetalleCompra> editar(@RequestBody DetalleCompra objDetalleCompra, @PathVariable Long id) {
        DetalleCompra compraActualizada = varDetalleCompraService.update(id, objDetalleCompra);
        return ResponseEntity.ok(compraActualizada);
    }
}
