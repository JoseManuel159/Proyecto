package bookcenter.servicio.implementacion;

import bookcenter.modelo.Categoria;
import bookcenter.repositorio.CategoriaRepository;
import bookcenter.repositorio.CrudGenericoRepository;
import bookcenter.servicio.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoriaImplementacion extends CrudGenericoImplementacion<Categoria,Long> implements CategoriaService {

    private final CategoriaRepository repo;
    private final CategoriaRepository categoriaRepository;

    @Override
    protected CrudGenericoRepository<Categoria, Long> getRepo() {
        return categoriaRepository;
    }


    @Override
    public void editarCategoria(Categoria paraCategoria, Long id) {
        Categoria objCategoria = categoriaRepository.findById(id).orElse(new Categoria());
        if(objCategoria != null) {
            objCategoria.setNombre(paraCategoria.getNombre());
            objCategoria.setDescripcion(paraCategoria.getDescripcion());
            categoriaRepository.save(objCategoria);
        }
    }
}
