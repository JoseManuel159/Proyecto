package bookcenter.modelo;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

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
    private Double costoCompra;

    @DecimalMin(value = "0.1", message ="Coloque un valor mayor") // Valor Minimo
    @Column(nullable = false)
    private Double precioVenta;

    public void setCategoriaId(Long categoriaId) {
        this.categoria.setId(categoriaId);
    }
}