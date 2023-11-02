package co.edu.udea.ads.apivalidarfestivos.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@Data //Getters & Setter de la clase Festivo- Lombok
@NoArgsConstructor // Constructor vacío de la clase Festivo - Lombok
@AllArgsConstructor //Constructor con todos los argumentos de la clase Festivo - Lombok
@Entity
@Table(name = "festivo")
public class Festivo {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_festivo")
    @GenericGenerator(name = "seq_festivo", strategy = "increment")
    private Integer id;

    @Column(name = "dia")
    private Integer dia;

    @Column(name = "mes")
    private Integer mes;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "diasPascua")
    private Integer diasPascua;

    private Date fecha;

    @OneToOne
    @JoinColumn(name = "idTipo", referencedColumnName = "id")
    private Tipo idTipo;
}
