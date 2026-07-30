//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoMantenimientoInfraestructura;
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
public interface TipoMantenimientoInfraestructuraRepository extends JpaRepository<TipoMantenimientoInfraestructura,Long> {
    
    @Query(value = "SELECT COUNT(*) FROM tabla_tipos_mantenimientos_infraestructuras WHERE (:idTipoMantenimientoInfraestructura IS NULL OR id_tipo_mantenimiento_infraestructura = :idTipoMantenimientoInfraestructura) AND (:keyword IS NULL OR UPPER(nombre_tipo_mantenimiento_infraestructura) LIKE UPPER('%'||:keyword||'%'))", nativeQuery = true)
    Long findTotalRegistros(@Param("idTipoMantenimientoInfraestructura") Long idTipoMantenimientoInfraestructura, @Param("keyword") String keyword);
    
    @Query(value = "SELECT * FROM tabla_tipos_mantenimientos_infraestructuras WHERE (:idTipoMantenimientoInfraestructura IS NULL OR id_tipo_mantenimiento_infraestructura = :idTipoMantenimientoInfraestructura) AND (:keyword IS NULL OR UPPER(nombre_tipo_mantenimiento_infraestructura) LIKE UPPER('%'||:keyword||'%')) ORDER BY CASE WHEN :orderBy = 'idTipoMantenimientoInfraestructura' AND :orderMode = 'ASC' THEN id_tipo_mantenimiento_infraestructura END ASC, CASE WHEN :orderBy = 'idTipoMantenimientoInfraestructura' AND :orderMode = 'DESC' THEN id_tipo_mantenimiento_infraestructura END DESC, CASE WHEN :orderBy = 'nombreTipoMantenimientoInfraestructura' AND :orderMode = 'ASC' THEN nombre_tipo_mantenimiento_infraestructura END ASC, CASE WHEN :orderBy = 'nombreTipoMantenimientoInfraestructura' AND :orderMode = 'DESC' THEN nombre_tipo_mantenimiento_infraestructura END DESC", nativeQuery = true)
    List<TipoMantenimientoInfraestructura> findAllTiposMantenimientosInfraestructuras(@Param("idTipoMantenimientoInfraestructura") Long idTipoMantenimientoInfraestructura, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);

    @Query(value = "SELECT * FROM tabla_tipos_mantenimientos_infraestructuras WHERE (:idTipoMantenimientoInfraestructura IS NULL OR id_tipo_mantenimiento_infraestructura = :idTipoMantenimientoInfraestructura) AND (:keyword IS NULL OR UPPER(nombre_tipo_mantenimiento_infraestructura) LIKE UPPER('%'||:keyword||'%')) ORDER BY CASE WHEN :orderBy = 'idTipoMantenimientoInfraestructura' AND :orderMode = 'ASC' THEN id_tipo_mantenimiento_infraestructura END ASC, CASE WHEN :orderBy = 'idTipoMantenimientoInfraestructura' AND :orderMode = 'DESC' THEN id_tipo_mantenimiento_infraestructura END DESC, CASE WHEN :orderBy = 'nombreTipoMantenimientoInfraestructura' AND :orderMode = 'ASC' THEN nombre_tipo_mantenimiento_infraestructura END ASC, CASE WHEN :orderBy = 'nombreTipoMantenimientoInfraestructura' AND :orderMode = 'DESC' THEN nombre_tipo_mantenimiento_infraestructura END DESC", nativeQuery = true)
    Slice<TipoMantenimientoInfraestructura> findAllTiposMantenimientosInfraestructurasPag(Pageable pageable, @Param("idTipoMantenimientoInfraestructura") Long idTipoMantenimientoInfraestructura, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<TipoMantenimientoInfraestructura> findByIdTipoMantenimientoInfraestructura(Long idTipoMantenimientoInfraestructura);
    
    TipoMantenimientoInfraestructura findByNombreTipoMantenimientoInfraestructura(String nombreTipoMantenimientoInfraestructura);
    
    @Query(value = "SELECT MAX(id_tipo_mantenimiento_infraestructura) FROM tabla_tipos_mantenimientos_infraestructuras", nativeQuery = true)
    Long findMaxIdTipoMantenimientoInfraestructura();
}
