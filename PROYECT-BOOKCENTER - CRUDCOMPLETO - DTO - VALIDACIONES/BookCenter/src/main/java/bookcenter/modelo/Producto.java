package bookcenter.modelo;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Notnull") //Rechaza valores Nulos.
    @NotBlank //Caracter Valido(Vacio)
    private String imagen;

    @Column(nullable = false)
    private Integer cantidadEnStock;

    @Column(nullable = false)
    private String nombre;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    @Column(nullable = false)
    private BigDecimal costoCompra;

    @DecimalMin(value = "0.1", message ="Coloque un valor mayor") // Valor Minimo
    @Column(nullable = false)
    private Double precioVenta;

    public void setCategoriaId(Long categoriaId) {
        this.categoria = new Categoria();
        this.categoria.setId(categoriaId);
    }

    public void actualizarStock(int cantidad) {
        if (cantidad >= 0) {
            this.cantidadEnStock += cantidad;  // Aumenta el stock.
        } else {
            if (this.cantidadEnStock + cantidad >= 0) {
                this.cantidadEnStock += cantidad;  // Disminuye el stock.
            } else {
                throw new IllegalArgumentException("No hay suficiente stock para esta operación");
            }
        }
    }
}