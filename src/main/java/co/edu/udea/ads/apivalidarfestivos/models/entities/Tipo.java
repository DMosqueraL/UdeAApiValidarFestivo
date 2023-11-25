package co.edu.udea.ads.apivalidarfestivos.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Getters & Setter de la clase Tipo - Lombok
@NoArgsConstructor // Constructor vacío de la clase Tipo- Lombok
@AllArgsConstructor //Constructor con todos los argumentos de la clase Tipo- Lombok
@Entity
@Table(name = "tipo")
public class Tipo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "tipo", unique = true, length = 100)
    private String tipo;
}
