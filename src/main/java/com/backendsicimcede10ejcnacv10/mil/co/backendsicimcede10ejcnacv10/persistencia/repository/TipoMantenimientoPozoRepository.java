//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoMantenimientoPozo;
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
public interface TipoMantenimientoPozoRepository extends JpaRepository<TipoMantenimientoPozo,Long> {
    
    @Query(value = "SELECT COUNT(*) FROM tabla_tipos_mantenimientos_pozos WHERE (:idTipoMantenimientoPozo IS NULL OR id_tipo_mantenimiento_pozo = :idTipoMantenimientoPozo) AND (:keyword IS NULL OR UPPER(nombre_tipo_mantenimiento_pozo) LIKE UPPER('%'||:keyword||'%'))", nativeQuery = true)
    Long findTotalRegistros(@Param("idTipoMantenimientoPozo") Long idTipoMantenimientoPozo, @Param("keyword") String keyword);
    
    @Query(value = "SELECT * FROM tabla_tipos_mantenimientos_pozos WHERE (:idTipoMantenimientoPozo IS NULL OR id_tipo_mantenimiento_pozo = :idTipoMantenimientoPozo) AND (:keyword IS NULL OR UPPER(nombre_tipo_mantenimiento_pozo) LIKE UPPER('%'||:keyword||'%')) ORDER BY CASE WHEN :orderBy = 'idTipoMantenimientoPozo' AND :orderMode = 'ASC' THEN id_tipo_mantenimiento_pozo END ASC, CASE WHEN :orderBy = 'idTipoMantenimientoPozo' AND :orderMode = 'DESC' THEN id_tipo_mantenimiento_pozo END DESC, CASE WHEN :orderBy = 'nombreTipoMantenimientoPozo' AND :orderMode = 'ASC' THEN nombre_tipo_mantenimiento_pozo END ASC, CASE WHEN :orderBy = 'nombreTipoMantenimientoPozo' AND :orderMode = 'DESC' THEN nombre_tipo_mantenimiento_pozo END DESC", nativeQuery = true)
    List<TipoMantenimientoPozo> findAllTiposMantenimientosPozos(@Param("idTipoMantenimientoPozo") Long idTipoMantenimientoPozo, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);

    @Query(value = "SELECT * FROM tabla_tipos_mantenimientos_pozos WHERE (:idTipoMantenimientoPozo IS NULL OR id_tipo_mantenimiento_pozo = :idTipoMantenimientoPozo) AND (:keyword IS NULL OR UPPER(nombre_tipo_mantenimiento_pozo) LIKE UPPER('%'||:keyword||'%')) ORDER BY CASE WHEN :orderBy = 'idTipoMantenimientoPozo' AND :orderMode = 'ASC' THEN id_tipo_mantenimiento_pozo END ASC, CASE WHEN :orderBy = 'idTipoMantenimientoPozo' AND :orderMode = 'DESC' THEN id_tipo_mantenimiento_pozo END DESC, CASE WHEN :orderBy = 'nombreTipoMantenimientoPozo' AND :orderMode = 'ASC' THEN nombre_tipo_mantenimiento_pozo END ASC, CASE WHEN :orderBy = 'nombreTipoMantenimientoPozo' AND :orderMode = 'DESC' THEN nombre_tipo_mantenimiento_pozo END DESC", nativeQuery = true)
    Slice<TipoMantenimientoPozo> findAllTiposMantenimientosPozosPag(Pageable pageable, @Param("idTipoMantenimientoPozo") Long idTipoMantenimientoPozo, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<TipoMantenimientoPozo> findByIdTipoMantenimientoPozo(Long idTipoMantenimientoPozo);
    
    TipoMantenimientoPozo findByNombreTipoMantenimientoPozo(String nombreTipoMantenimientoPozo);
    
    @Query(value = "SELECT MAX(id_tipo_mantenimiento_pozo) FROM tabla_tipos_mantenimientos_pozos", nativeQuery = true)
    Long findMaxIdTipoMantenimientoPozo();
}
