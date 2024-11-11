package bookcenter.modelo;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente",referencedColumnName = "dniCliente", nullable = false)
    private Cliente dni_Cliente;

    @Column(nullable = false)
    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    private String descripcion;

    @Column(name = "fecha_pedido", updatable = true)
    private LocalDateTime fechaPedido;

    @PrePersist
    public void prePersist() {
        this.fechaPedido = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.fechaPedido = LocalDateTime.now();
    }

}