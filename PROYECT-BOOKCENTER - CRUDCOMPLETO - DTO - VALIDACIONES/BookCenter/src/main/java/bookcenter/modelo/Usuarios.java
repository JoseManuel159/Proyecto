package bookcenter.modelo;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombres;

    @Column(name = "apellido_paterno", nullable = false)
    private String apellidoPaterno;

    @Column(name = "apellido_materno")
    private String apellidoMaterno;

    @Column(nullable = false, unique = true)
    private String dni;

    @Column(nullable = false)
    private String cargo;

    @Column(name = "foto_usuaria")
    private String fotoUsuaria;

    private String direccion;

    private String permisos;

    @OneToOne
    @JoinColumn(name = "credencial_id", unique = true)
    private Credenciales credencial;
}
