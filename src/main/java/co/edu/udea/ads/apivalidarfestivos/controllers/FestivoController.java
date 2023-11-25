package co.edu.udea.ads.apivalidarfestivos.controllers;

import co.edu.udea.ads.apivalidarfestivos.models.dtos.FestivoDto;
import co.edu.udea.ads.apivalidarfestivos.services.interfaces.IFestivoServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/festivos")
@CrossOrigin("*")
@Tag(name = "Festivos", description = "Api Festivos en Colombia")
public class FestivoController {

    @Autowired
    private IFestivoServicio festivoServicio;

    @Operation(summary = "- Endpoint para listar los festivos por año de consulta")
    @ApiResponse(responseCode = "200", description = "Operación Exitosa")
    @GetMapping("listar/{año}")
    public List<FestivoDto> listar(@Parameter(description = "Año de consulta")
                                       @PathVariable Integer año) {
        return festivoServicio.obtenerFestivos(año);
    }

    @Operation(summary = "- Endpoint para validar si una fecha es o no un festivo")
    @ApiResponse(responseCode = "200", description = "Ok",
            content = @Content(mediaType = "text/plain"))
    @ApiResponse(responseCode = "400", description = "¡Uuups! Algo salió mal",
            content = @Content(mediaType = "text/plain"))
    @GetMapping("validar-fecha/{fecha}")
    public String validarFestivo(@Parameter(description = "Fecha a consultar",
            example = "01-01-2023")
                                 @PathVariable String fecha) throws ParseException {
        if (festivoServicio.esFechaValida(fecha)) {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
            Date fechaVer = formatoFecha.parse(fecha);
            return festivoServicio.esFestivo(fechaVer) ? "Es festivo." : "No es festivo.";
        }
        return "No es una fecha o un formato válido. El formato correcto es: dd-MM-yyyy" +
                "\nPor favor, Verifique la fecha.";
    }
}



