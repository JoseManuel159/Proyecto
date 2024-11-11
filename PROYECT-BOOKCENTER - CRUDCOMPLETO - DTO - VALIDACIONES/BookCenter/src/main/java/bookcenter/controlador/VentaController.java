package bookcenter.controlador;

import bookcenter.dtos.VentaDTO;
import bookcenter.mappers.VentaMapper;
import bookcenter.modelo.Pedido;
import bookcenter.modelo.Venta;
import bookcenter.servicio.PedidoService;
import bookcenter.servicio.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/venta")
public class VentaController {
    @Autowired
    private VentaService varVentaService;
    @Autowired
    private VentaMapper varVentaMapper;


    @GetMapping("/ver")
    public ResponseEntity<List<Venta>> findAll() {
        List<Venta> objVenta = varVentaService.findAll();
        return ResponseEntity.ok(objVenta);
    }

    @GetMapping("/ver/{id}")
    public ResponseEntity<Venta> findByCategoria(@PathVariable Long id) {
        Venta objVenta = varVentaService.findById(id);
        return ResponseEntity.ok(objVenta);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Venta> guardar(@RequestBody Venta objVenta) {
        Venta nuevaVenta = varVentaService.save(objVenta);
        return new ResponseEntity<>(nuevaVenta, HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id) {
        varVentaService.delete(id);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Venta> editar(@RequestBody Venta objVenta, @PathVariable Long id) {
        Venta ventaActualizada = varVentaService.update(id, objVenta);
        return ResponseEntity.ok(ventaActualizada);
    }

    @PostMapping("/registrar")
    public ResponseEntity<VentaDTO> registrarVenta(@RequestBody VentaDTO ventaDTO) {
        System.out.println("Detalles de Venta: " + ventaDTO.getDetallesVenta());
        Venta venta = varVentaMapper.toEntity(ventaDTO);
        Venta ventaGuardada = varVentaService.save(venta); // Guardar venta y sus detalles
        return ResponseEntity.ok(varVentaMapper.toDTO(ventaGuardada));
    }

}
