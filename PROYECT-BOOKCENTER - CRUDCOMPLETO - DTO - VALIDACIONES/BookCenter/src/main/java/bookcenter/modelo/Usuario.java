package bookcenter.modelo;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "user", nullable = false, unique = true, length = 20)
    private String user;

    @Column(name = "clave", nullable = false, length = 100)
    private String clave;

    @Column(name = "estado", nullable = false, length = 10)
    private String estado;
}