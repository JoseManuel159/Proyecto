package bookcenter.modelo;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "formas_pago")
public class FormaPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private Forma forma;

    public enum Forma {
        YAPE("yape"),
        EFECTIVO("efectivo");

        private final String value;

        Forma(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }
    }
}