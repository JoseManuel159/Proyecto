package bookcenter.modelo;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "compras")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JsonManagedReference
    private List<DetalleCompra> detallesCompra;

    @Column(nullable = false)
    private Double total;



}
