package bookcenter.servicio.implementacion;

import bookcenter.modelo.Compra;
import bookcenter.modelo.DetalleCompra;
import bookcenter.modelo.Producto;
import bookcenter.repositorio.CompraRepository;
import bookcenter.repositorio.CrudGenericoRepository;
import bookcenter.repositorio.ProductoRepository;
import bookcenter.servicio.CompraService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CompraImplementacion extends CrudGenericoImplementacion<Compra, Long> implements CompraService {

    private final CompraRepository varcompraRepository;

    private final ProductoRepository productoRepository; // Repositorio de Producto para actualizar el stock.


    @Override
    protected CrudGenericoRepository<Compra, Long> getRepo() {
        return varcompraRepository;
    }

    @Override
    public Compra save(Compra compra) {
        if (compra.getDetallesCompra() != null) {
            for (DetalleCompra detalleCompra : compra.getDetallesCompra()) {
                detalleCompra.setCompra(compra);

                // Actualizar el stock del producto
                Producto producto = detalleCompra.getProducto();
                producto = productoRepository.findById(producto.getId())
                        .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

                producto.setCantidadEnStock(producto.getCantidadEnStock() + detalleCompra.getCantidad());
                productoRepository.save(producto);


            }
        }
        return varcompraRepository.save(compra);
    }
}
