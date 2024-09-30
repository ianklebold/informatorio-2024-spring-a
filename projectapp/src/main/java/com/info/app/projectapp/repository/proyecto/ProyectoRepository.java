package com.info.app.projectapp.repository.proyecto;

import com.info.app.projectapp.domain.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface ProyectoRepository extends JpaRepository<Proyecto, UUID> {

    List<Proyecto> findAllByNombreOrderByNombreAsc(String nombre);

    List<Proyecto> findByNombreLike(String nombre);

    List<Proyecto> findByFechaInicioGreaterThanEqualAndFechaFinNotNullAndFechaFinLessThan(LocalDate fehaInicio, LocalDate fechaFin);

}
