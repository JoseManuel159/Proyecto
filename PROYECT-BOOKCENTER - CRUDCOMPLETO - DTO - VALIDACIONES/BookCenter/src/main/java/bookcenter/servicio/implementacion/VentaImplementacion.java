package bookcenter.servicio.implementacion;

import bookcenter.modelo.DetalleVenta;
import bookcenter.modelo.Venta;
import bookcenter.repositorio.CrudGenericoRepository;
import bookcenter.repositorio.VentaRepository;
import bookcenter.servicio.VentaService;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class VentaImplementacion extends CrudGenericoImplementacion<Venta,Long> implements VentaService {
    private final VentaRepository varVentaRepository;

    @Override
    protected CrudGenericoRepository<Venta, Long> getRepo() {
        return varVentaRepository;
    }

    @Override
    public Venta save(Venta venta) {
        if (venta.getDetallesVenta() != null) {
            for (DetalleVenta detalleVenta : venta.getDetallesVenta()) {
                detalleVenta.setVenta(venta);
            }
        }
        return varVentaRepository.save(venta);
    }
}
