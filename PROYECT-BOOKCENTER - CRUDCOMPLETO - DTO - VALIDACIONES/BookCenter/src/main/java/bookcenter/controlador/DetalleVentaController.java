package bookcenter.controlador;

import bookcenter.modelo.DetalleVenta;
import bookcenter.servicio.DetalleVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalle-venta")
public class DetalleVentaController {
    @Autowired
    private DetalleVentaService varDetalleVentaService;

    @GetMapping("/ver")
    public ResponseEntity<List<DetalleVenta>> findAll() {
        List<DetalleVenta> objDetalleVenta = varDetalleVentaService.findAll();
        return ResponseEntity.ok(objDetalleVenta);
    }

    @GetMapping("/ver/{id}")
    public ResponseEntity<DetalleVenta> findByCategoria(@PathVariable Long id) {
        DetalleVenta objDetalleVenta = varDetalleVentaService.findById(id);
        return ResponseEntity.ok(objDetalleVenta);
    }

    @PostMapping("/guardar")
    public ResponseEntity<DetalleVenta> guardar(@RequestBody DetalleVenta objDetalleVenta) {
        DetalleVenta nuevoDetalleVenta = varDetalleVentaService.save(objDetalleVenta);
        return new ResponseEntity<>(nuevoDetalleVenta, HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id) {
        varDetalleVentaService.delete(id);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<DetalleVenta> editar(@RequestBody DetalleVenta objDetalleVenta, @PathVariable Long id) {
        DetalleVenta ventaActualizada = varDetalleVentaService.update(id, objDetalleVenta);
        return ResponseEntity.ok(ventaActualizada);
    }
}
