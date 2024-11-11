package bookcenter.servicio.implementacion;

import bookcenter.modelo.Categoria;
import bookcenter.modelo.Producto;
import bookcenter.repositorio.CrudGenericoRepository;
import bookcenter.repositorio.ProductoRepository;
import bookcenter.servicio.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductoImplementacion extends CrudGenericoImplementacion<Producto,Long> implements ProductoService {
    private final ProductoRepository productoRepo;

    @Override
    protected CrudGenericoRepository<Producto, Long> getRepo() {
        return productoRepo;
    }


    @Override
    public void editarProducto(Producto paraProducto, Long id) {

        Producto objProducto = productoRepo.findById(id).orElse(new Producto());
        if(objProducto != null) {
            objProducto.setImagen(paraProducto.getImagen());
            objProducto.setCantidadEnStock(paraProducto.getCantidadEnStock());
            objProducto.setNombre(paraProducto.getNombre());
            objProducto.setDescripcion(paraProducto.getDescripcion());
            // Asumir que paraProducto.getCategoria() es un objeto Categoria con un atributo id
            objProducto.setCategoriaId(paraProducto.getCategoria().getId()); // Asignar el ID de la categoría
            objProducto.setCostoCompra(paraProducto.getCostoCompra());
            objProducto.setPrecioVenta(paraProducto.getPrecioVenta());
            productoRepo.save(objProducto);
        }
    }
}
