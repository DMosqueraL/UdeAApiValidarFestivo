package co.edu.udea.ads.apivalidarfestivos.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Data //Getters & Setter de la clase Tipo - Lombok
@NoArgsConstructor // Constructor vacío de la clase Tipo- Lombok
@AllArgsConstructor //Constructor con todos los argumentos de la clase Tipo- Lombok
@Entity
public class Tipo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_tipoFestivo")
    @GenericGenerator(name = "seq_tipoFestivo", strategy = "increment")
    @Column(name = "id")
    private Integer id;

    @Column(name = "idTipo", unique = true, length = 100)
    private String tipo;
}
