package co.edu.udea.ads.apivalidarfestivos.services.interfaces;

import co.edu.udea.ads.apivalidarfestivos.models.dtos.FestivoDto;

import java.util.Date;
import java.util.List;

public interface IFestivoServicio {

    public boolean esFestivo(Date Fecha);

    public List<FestivoDto> obtenerFestivos(Integer año);

    public boolean esFechaValida(String strFecha);
}
