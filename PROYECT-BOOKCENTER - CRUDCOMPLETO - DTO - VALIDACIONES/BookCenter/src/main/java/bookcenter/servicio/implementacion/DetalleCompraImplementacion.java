package bookcenter.servicio.implementacion;

import bookcenter.modelo.DetalleCompra;
import bookcenter.repositorio.CrudGenericoRepository;
import bookcenter.repositorio.DetalleCompraRepository;
import bookcenter.servicio.DetalleCompraService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class DetalleCompraImplementacion extends CrudGenericoImplementacion<DetalleCompra, Long> implements DetalleCompraService {

    private final DetalleCompraRepository varDetalleCompraRepository;

    @Override
    protected CrudGenericoRepository<DetalleCompra, Long> getRepo() {
        return varDetalleCompraRepository;
    }
}
