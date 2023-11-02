package co.edu.udea.ads.apivalidarfestivos.repository;

import co.edu.udea.ads.apivalidarfestivos.models.entities.Festivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFestivoRepositorio extends JpaRepository<Festivo, Integer> {
}
