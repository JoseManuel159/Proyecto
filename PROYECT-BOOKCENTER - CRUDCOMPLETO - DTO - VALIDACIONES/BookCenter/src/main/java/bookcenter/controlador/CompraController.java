package bookcenter.controlador;

import bookcenter.dtos.CompraDTO;
import bookcenter.mappers.CompraMapper;
import bookcenter.modelo.Compra;
import bookcenter.servicio.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/compra")
public class CompraController {

    @Autowired
    private CompraService varCompraService;

    @Autowired
    private CompraMapper varCompraMapper;


    @GetMapping("/ver")
    public ResponseEntity<List<Compra>> findAll() {
        List<Compra> objCompra = varCompraService.findAll();
        return ResponseEntity.ok(objCompra);
    }


    @GetMapping("/ver/{id}")
    public ResponseEntity<Compra> findByCategoria(@PathVariable Long id) {
        Compra objCompra = varCompraService.findById(id);
        return ResponseEntity.ok(objCompra);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Compra> guardar(@RequestBody Compra objVenta) {
        Compra nuevaCompra = varCompraService.save(objVenta);
        return new ResponseEntity<>(nuevaCompra, HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id) {
        varCompraService.delete(id);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Compra> editar(@RequestBody Compra objCompra, @PathVariable Long id) {
        Compra compraActualizada = varCompraService.update(id, objCompra);
        return ResponseEntity.ok(compraActualizada);
    }

    @PostMapping("/registrar")
    public ResponseEntity<CompraDTO> registrarCompra(@RequestBody CompraDTO compraDTO) {
        System.out.println("Detalles de Venta: " + compraDTO.getDetallesCompra());
        Compra compra = varCompraMapper.toEntity(compraDTO);
        Compra compraGuardada = varCompraService.save(compra); // Guardar venta y sus detalles
        return ResponseEntity.ok(varCompraMapper.toDTO(compraGuardada));
    }
}
