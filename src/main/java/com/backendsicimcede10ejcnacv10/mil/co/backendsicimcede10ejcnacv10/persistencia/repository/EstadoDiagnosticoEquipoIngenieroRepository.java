//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.EstadoDiagnosticoEquipoIngeniero;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 20/03/2026.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface EstadoDiagnosticoEquipoIngenieroRepository extends JpaRepository<EstadoDiagnosticoEquipoIngeniero,Long> {
    
    @Query(value = "SELECT * FROM tabla_estados_diagnosticos_equipos_ingenieros " +
          "WHERE (:idEstadoDiagnosticoEquipoIngeniero IS NULL OR id_estado_diagnostico_equipo_ingeniero = :idEstadoDiagnosticoEquipoIngeniero) " +
          "ORDER BY CASE WHEN :orderBy = 'idEstadoDiagnosticoEquipoIngeniero' AND :orderMode = 'ASC' THEN id_estado_diagnostico_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'idEstadoDiagnosticoEquipoIngeniero' AND :orderMode = 'DESC' THEN id_estado_diagnostico_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'nombreEstadoDiagnosticoEquipoIngeniero' AND :orderMode = 'ASC' THEN nombre_estado_diagnostico_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'nombreEstadoDiagnosticoEquipoIngeniero' AND :orderMode = 'DESC' THEN nombre_estado_diagnostico_equipo_ingeniero END DESC", nativeQuery = true)
    List<EstadoDiagnosticoEquipoIngeniero> findAllEstadosDiagnosticosEquiposIngenieros(@Param("idEstadoDiagnosticoEquipoIngeniero") Long idEstadoDiagnosticoEquipoIngeniero, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT * FROM tabla_estados_diagnosticos_equipos_ingenieros " +
          "WHERE (:idEstadoDiagnosticoEquipoIngeniero IS NULL OR id_estado_diagnostico_equipo_ingeniero = :idEstadoDiagnosticoEquipoIngeniero) " +
          "ORDER BY CASE WHEN :orderBy = 'idEstadoDiagnosticoEquipoIngeniero' AND :orderMode = 'ASC' THEN id_estado_diagnostico_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'idEstadoDiagnosticoEquipoIngeniero' AND :orderMode = 'DESC' THEN id_estado_diagnostico_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'nombreEstadoDiagnosticoEquipoIngeniero' AND :orderMode = 'ASC' THEN nombre_estado_diagnostico_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'nombreEstadoDiagnosticoEquipoIngeniero' AND :orderMode = 'DESC' THEN nombre_estado_diagnostico_equipo_ingeniero END DESC", nativeQuery = true)
    Slice<EstadoDiagnosticoEquipoIngeniero> findAllEstadosDiagnosticosEquiposIngenierosPag(Pageable pageable, @Param("idEstadoDiagnosticoEquipoIngeniero") Long idEstadoDiagnosticoEquipoIngeniero, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<EstadoDiagnosticoEquipoIngeniero> findByIdEstadoDiagnosticoEquipoIngeniero(Long idEstadoDiagnosticoEquipoIngeniero);
    
    EstadoDiagnosticoEquipoIngeniero findByNombreEstadoDiagnosticoEquipoIngeniero(String nombreEstadoDiagnosticoEquipoIngeniero);
    
    @Query(value = "SELECT MAX(id_estado_diagnostico_equipo_ingeniero) FROM tabla_estados_diagnosticos_equipos_ingenieros", nativeQuery = true)
    Long findMaxIdEstadoDiagnosticoEquipoIngeniero();
}
