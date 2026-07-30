//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoMantenimientoEquipoIngeniero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/12/2025.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface TipoMantenimientoEquipoIngenieroRepository extends JpaRepository<TipoMantenimientoEquipoIngeniero,Long> {
    
    @Query(value = "SELECT COUNT(*) FROM tabla_tipos_mantenimientos_equipos_ingenieros WHERE (:idTipoMantenimientoEquipoIngeniero IS NULL OR id_tipo_mantenimiento_equipo_ingeniero = :idTipoMantenimientoEquipoIngeniero) AND (:keyword IS NULL OR UPPER(nombre_tipo_mantenimiento_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%'))", nativeQuery = true)
    Long findTotalRegistros(@Param("idTipoMantenimientoEquipoIngeniero") Long idTipoMantenimientoEquipoIngeniero, @Param("keyword") String keyword);
    
    @Query(value = "SELECT * FROM tabla_tipos_mantenimientos_equipos_ingenieros WHERE (:idTipoMantenimientoEquipoIngeniero IS NULL OR id_tipo_mantenimiento_equipo_ingeniero = :idTipoMantenimientoEquipoIngeniero) AND (:keyword IS NULL OR UPPER(nombre_tipo_mantenimiento_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%')) ORDER BY CASE WHEN :orderBy = 'idTipoMantenimientoEquipoIngeniero' AND :orderMode = 'ASC' THEN id_tipo_mantenimiento_equipo_ingeniero END ASC, CASE WHEN :orderBy = 'idTipoMantenimientoEquipoIngeniero' AND :orderMode = 'DESC' THEN id_tipo_mantenimiento_equipo_ingeniero END DESC, CASE WHEN :orderBy = 'nombreTipoMantenimientoEquipoIngeniero' AND :orderMode = 'ASC' THEN nombre_tipo_mantenimiento_equipo_ingeniero END ASC, CASE WHEN :orderBy = 'nombreTipoMantenimientoEquipoIngeniero' AND :orderMode = 'DESC' THEN nombre_tipo_mantenimiento_equipo_ingeniero END DESC", nativeQuery = true)
    List<TipoMantenimientoEquipoIngeniero> findAllTiposMantenimientosEquiposIngenieros(@Param("idTipoMantenimientoEquipoIngeniero") Long idTipoMantenimientoEquipoIngeniero, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT * FROM tabla_tipos_mantenimientos_equipos_ingenieros WHERE (:idTipoMantenimientoEquipoIngeniero IS NULL OR id_tipo_mantenimiento_equipo_ingeniero = :idTipoMantenimientoEquipoIngeniero) AND (:keyword IS NULL OR UPPER(nombre_tipo_mantenimiento_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%')) ORDER BY CASE WHEN :orderBy = 'idTipoMantenimientoEquipoIngeniero' AND :orderMode = 'ASC' THEN id_tipo_mantenimiento_equipo_ingeniero END ASC, CASE WHEN :orderBy = 'idTipoMantenimientoEquipoIngeniero' AND :orderMode = 'DESC' THEN id_tipo_mantenimiento_equipo_ingeniero END DESC, CASE WHEN :orderBy = 'nombreTipoMantenimientoEquipoIngeniero' AND :orderMode = 'ASC' THEN nombre_tipo_mantenimiento_equipo_ingeniero END ASC, CASE WHEN :orderBy = 'nombreTipoMantenimientoEquipoIngeniero' AND :orderMode = 'DESC' THEN nombre_tipo_mantenimiento_equipo_ingeniero END DESC", nativeQuery = true)
    Slice<TipoMantenimientoEquipoIngeniero> findAllTiposMantenimientosEquiposIngenierosPag(Pageable pageable, @Param("idTipoMantenimientoEquipoIngeniero") Long idTipoMantenimientoEquipoIngeniero, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<TipoMantenimientoEquipoIngeniero> findByIdTipoMantenimientoEquipoIngeniero(Long idTipoMantenimientoEquipoIngeniero);
    
    TipoMantenimientoEquipoIngeniero findByNombreTipoMantenimientoEquipoIngeniero(String nombreTipoMantenimientoEquipoIngeniero);
    
    @Query(value = "SELECT MAX(id_tipo_mantenimiento_equipo_ingeniero) FROM tabla_tipos_mantenimientos_equipos_ingenieros", nativeQuery = true)
    Long findMaxIdTipoMantenimientoEquipoIngeniero();
}
