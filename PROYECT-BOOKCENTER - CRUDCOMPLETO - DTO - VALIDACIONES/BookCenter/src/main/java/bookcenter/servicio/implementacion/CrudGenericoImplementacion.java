package bookcenter.servicio.implementacion;

import bookcenter.excepcion.ModelNotFoundException;
import bookcenter.repositorio.CrudGenericoRepository;
import bookcenter.servicio.CrudGenericoService;
import org.springframework.beans.BeanUtils;

import java.util.List;

public abstract class CrudGenericoImplementacion<T,ID> implements CrudGenericoService<T,ID> {
    protected abstract CrudGenericoRepository<T, ID> getRepo();

    @Override
    public T save(T t) {
        return getRepo().save(t);
    }

    /*@Override
    public T update(ID id, T t) {
        getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("ID NOT FOUND: " + id));
        return getRepo().save(t);
    }*/

    @Override
    public T update(ID id, T t) {
        T existingEntity = getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("ID NOT FOUND: " + id));
        BeanUtils.copyProperties(t, existingEntity, "id");
        return getRepo().save(existingEntity);
    }

    @Override
    public List<T> findAll() {
        return getRepo().findAll();
    }
    @Override
    public T findById(ID id) {
        return getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("ID NOT FOUND: " + id));
    }
    @Override
    public void delete(ID id) {
        getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("ID NOT FOUND: " + id));
        getRepo().deleteById(id);
    }

}
