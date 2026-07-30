//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.NivelMantenimientoEquipoIngeniero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 17/12/2025.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface NivelMantenimientoEquipoIngenieroRepository extends JpaRepository<NivelMantenimientoEquipoIngeniero,Long> {
    
    @Query(value = "SELECT COUNT(*) FROM tabla_niveles_mantenimientos_equipos_ingenieros " +
          "WHERE (:idNivelMantenimientoEquipoIngeniero IS NULL OR id_nivel_mantenimiento_equipo_ingeniero = :idNivelMantenimientoEquipoIngeniero) AND " +
          "(:keyword IS NULL OR UPPER(nombre_nivel_mantenimiento_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%'))", nativeQuery = true)
    Long findTotalRegistros(@Param("idNivelMantenimientoEquipoIngeniero") Long idNivelMantenimientoEquipoIngeniero, @Param("keyword") String keyword);
    
    @Query(value = "SELECT * FROM tabla_niveles_mantenimientos_equipos_ingenieros " +
          "WHERE (:idNivelMantenimientoEquipoIngeniero IS NULL OR id_nivel_mantenimiento_equipo_ingeniero = :idNivelMantenimientoEquipoIngeniero) AND " +
          "(:keyword IS NULL OR UPPER(nombre_nivel_mantenimiento_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%')) " +
          "ORDER BY CASE WHEN :orderBy = 'idNivelMantenimientoEquipoIngeniero' AND :orderMode = 'ASC' THEN id_nivel_mantenimiento_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'idNivelMantenimientoEquipoIngeniero' AND :orderMode = 'DESC' THEN id_nivel_mantenimiento_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'nombreNivelMantenimientoEquipoIngeniero' AND :orderMode = 'ASC' THEN nombre_nivel_mantenimiento_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'nombreNivelMantenimientoEquipoIngeniero' AND :orderMode = 'DESC' THEN nombre_nivel_mantenimiento_equipo_ingeniero END DESC", nativeQuery = true)
    List<NivelMantenimientoEquipoIngeniero> findAllNivelesMantenimientosEquiposIngenieros(@Param("idNivelMantenimientoEquipoIngeniero") Long idNivelMantenimientoEquipoIngeniero, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT * FROM tabla_niveles_mantenimientos_equipos_ingenieros " +
          "WHERE (:idNivelMantenimientoEquipoIngeniero IS NULL OR id_nivel_mantenimiento_equipo_ingeniero = :idNivelMantenimientoEquipoIngeniero) AND " +
          "(:keyword IS NULL OR UPPER(nombre_nivel_mantenimiento_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%')) " +
          "ORDER BY CASE WHEN :orderBy = 'idNivelMantenimientoEquipoIngeniero' AND :orderMode = 'ASC' THEN id_nivel_mantenimiento_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'idNivelMantenimientoEquipoIngeniero' AND :orderMode = 'DESC' THEN id_nivel_mantenimiento_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'nombreNivelMantenimientoEquipoIngeniero' AND :orderMode = 'ASC' THEN nombre_nivel_mantenimiento_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'nombreNivelMantenimientoEquipoIngeniero' AND :orderMode = 'DESC' THEN nombre_nivel_mantenimiento_equipo_ingeniero END DESC", nativeQuery = true)
    Slice<NivelMantenimientoEquipoIngeniero> findAllNivelesMantenimientosEquiposIngenierosOrdenadosporIdPag(Pageable pageable, @Param("idNivelMantenimientoEquipoIngeniero") Long idNivelMantenimientoEquipoIngeniero, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<NivelMantenimientoEquipoIngeniero> findByIdNivelMantenimientoEquipoIngeniero(Long idNivelMantenimientoEquipoIngeniero);
    
    NivelMantenimientoEquipoIngeniero findByNombreNivelMantenimientoEquipoIngeniero(String nombreNivelMantenimientoEquipoIngeniero);
    
    @Query(value = "SELECT MAX(id_nivel_mantenimiento_equipo_ingeniero) FROM tabla_niveles_mantenimientos_equipos_ingenieros", nativeQuery = true)
    Long findMaxIdNivelMantenimientoEquipoIngeniero();
}
