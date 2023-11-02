package co.edu.udea.ads.apivalidarfestivos.controllers;

import co.edu.udea.ads.apivalidarfestivos.models.dtos.FestivoDto;
import co.edu.udea.ads.apivalidarfestivos.models.entities.Festivo;
import co.edu.udea.ads.apivalidarfestivos.services.interfaces.IFestivoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/festivos")
@CrossOrigin("*")
public class FestivoController {

    @Autowired
    private IFestivoServicio festivoServicio;

    @GetMapping("listar/{año}")
    public List<FestivoDto> listar(@PathVariable Integer año) {
        return festivoServicio.obtenerFestivos(año);
    }

    @GetMapping("validar-fecha/{fecha}")
    public String validarFestivo(@PathVariable String fecha) throws ParseException {
        if (festivoServicio.esFechaValida(fecha)) {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
            Date fechaVer = formatoFecha.parse(fecha);
            return festivoServicio.esFestivo(fechaVer) ? "Es festivo." : "No es festivo.";
        }
        return "No es una fecha o un formato válido. El formato correcto es: dd-MM-yyyy" +
                "\nPor favor, Verifique la fecha.";
    }
}



