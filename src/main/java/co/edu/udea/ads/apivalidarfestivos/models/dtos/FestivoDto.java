package co.edu.udea.ads.apivalidarfestivos.models.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data //Getters & Setter de la clase FestivoDto - Lombok
@NoArgsConstructor // Constructor vacío de la clase FestivoDto - Lombok
@AllArgsConstructor //Constructor con todos los argumentos de la clase FestivoDto - Lombok
public class FestivoDto {
    private String festivo;

    @JsonFormat(pattern="dd-MM-yyyy")
    private Date fecha;
}
