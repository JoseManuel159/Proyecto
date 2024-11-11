package bookcenter.servicio.implementacion;

import bookcenter.modelo.DetalleVenta;
import bookcenter.repositorio.CrudGenericoRepository;
import bookcenter.repositorio.DetalleVentaRepository;
import bookcenter.servicio.DetalleVentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class DetalleVentaImplementacion extends CrudGenericoImplementacion<DetalleVenta,Long> implements DetalleVentaService {
    private final DetalleVentaRepository varDetalleVentaRepository;

    @Override
    protected CrudGenericoRepository<DetalleVenta, Long> getRepo() {
        return varDetalleVentaRepository;
    }

}
