package bookcenter.modelo;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ventas")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tipo_venta_id", nullable = false)
    private TipoVenta tipoVenta;

    @Column(name = "fecha_emision")
    private LocalDateTime fechaEmision;

    @PrePersist
    public void prePersist() {
        this.fechaEmision = LocalDateTime.now();
    }
    @PreUpdate
    public void preUpdate() {
        this.fechaEmision = LocalDateTime.now();
    }
    
    @ManyToOne
    @JoinColumn(name = "cliente",referencedColumnName = "dniCliente", nullable = false)
    private Cliente dni_Cliente;

    @ManyToOne
    @JoinColumn(name = "forma_pago_id", nullable = false)
    private FormaPago formaPago;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JsonManagedReference
    private List<DetalleVenta> detallesVenta;
}