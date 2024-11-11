package bookcenter.servicio.implementacion;

import bookcenter.modelo.Pedido;
import bookcenter.repositorio.CrudGenericoRepository;
import bookcenter.repositorio.PedidoRepository;
import bookcenter.servicio.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PedidoImplementacion extends CrudGenericoImplementacion<Pedido, Long> implements PedidoService {
    private final PedidoRepository varPedidoRepository;

    @Override
    protected CrudGenericoRepository<Pedido, Long> getRepo() {
        return varPedidoRepository;
    }

/*
    @Override
    public void editarPedido(Pedido paraPedido, Long id) {
        Pedido objPedido = varPedidoRepository.findById(id).orElse(new Pedido());
        if(objPedido != null) {
            objPedido.setDni_Cliente(paraPedido.getDni_Cliente());
            objPedido.setDescripcion(paraPedido.getDescripcion());
            objPedido.setFechaPedido(paraPedido.getFechaPedido());
            objPedido.setProducto(paraPedido.getProducto());
            varPedidoRepository.save(objPedido);
        }
    }*/

}
