package bookcenter.servicio;

import bookcenter.modelo.Producto;

public interface ProductoService extends CrudGenericoService<Producto,Long> {
    public void editarProducto(Producto producto, Long id);
}
