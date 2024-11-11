package bookcenter.servicio;

import bookcenter.modelo.Categoria;

public interface CategoriaService extends CrudGenericoService<Categoria, Long>{
public void editarCategoria(Categoria categoria,Long id);
}
