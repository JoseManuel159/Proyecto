package bookcenter.controlador;

import bookcenter.modelo.Cliente;
import bookcenter.modelo.Pedido;
import bookcenter.servicio.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    private PedidoService varPedidoService;

    @GetMapping("/ver")
    public ResponseEntity<List<Pedido>> findAll() {
        List<Pedido> objPedido = varPedidoService.findAll();
        return ResponseEntity.ok(objPedido);
    }

    @GetMapping("/ver/{id}")
    public ResponseEntity<Pedido> findByCategoria(@PathVariable Long id) {
        Pedido objPedido = varPedidoService.findById(id);
        return ResponseEntity.ok(objPedido);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Pedido> guardar(@RequestBody Pedido objPedido) {
        Pedido nuevoPedido = varPedidoService.save(objPedido);
        return new ResponseEntity<>(nuevoPedido, HttpStatus.CREATED);
    }
/*
    @PostMapping("/guardar")
    public void guardar(@RequestBody Pedido objPedido) {
        varPedidoService.save(objPedido);
    }*/

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id) {
        varPedidoService.delete(id);
    }

/*

    @PutMapping("/editar/{id}")
    public ResponseEntity<Pedido> editar(@RequestBody Pedido objPedido, @PathVariable Long id) {
        varPedidoService.editarPedido(objPedido, id);
        return ResponseEntity.ok(objPedido);
    }*/

    @PutMapping("/editar/{id}")
    public ResponseEntity<Pedido> editar(@RequestBody Pedido objPedido, @PathVariable Long id) {
        Pedido pedidoActualizado = varPedidoService.update(id, objPedido);
        return ResponseEntity.ok(pedidoActualizado);
    }

}
