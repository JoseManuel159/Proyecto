package bookcenter.modelo;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    private String dniCliente;

    @Column(nullable = false)
    private String nombre;

    private String telefono;
}
