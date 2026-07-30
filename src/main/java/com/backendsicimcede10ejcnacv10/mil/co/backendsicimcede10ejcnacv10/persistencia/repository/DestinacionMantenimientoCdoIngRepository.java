//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.DestinacionMantenimientoCdoIng;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 22/12/2025.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface DestinacionMantenimientoCdoIngRepository extends JpaRepository<DestinacionMantenimientoCdoIng,Long> {
   
    @Query(value = "SELECT COUNT(*) FROM tabla_destinaciones_mantenimientos_cdos_ing " +
          "WHERE (:idDestinacionMantenimientoCdoIng IS NULL OR id_destinacion_mantenimiento_cdo_ing = :idDestinacionMantenimientoCdoIng) AND " +
          "(:keyword IS NULL OR UPPER(nombre_destinacion_mantenimiento_cdo_ing) LIKE UPPER('%'||:keyword||'%'))", nativeQuery = true)
    Long findTotalRegistros(@Param("idDestinacionMantenimientoCdoIng") Long idDestinacionMantenimientoCdoIng, @Param("keyword") String keyword);
    
    @Query(value = "SELECT * FROM tabla_destinaciones_mantenimientos_cdos_ing " +
          "WHERE (:idDestinacionMantenimientoCdoIng IS NULL OR id_destinacion_mantenimiento_cdo_ing = :idDestinacionMantenimientoCdoIng) AND " +
          "(:keyword IS NULL OR UPPER(nombre_destinacion_mantenimiento_cdo_ing) LIKE UPPER('%'||:keyword||'%')) " +
          "ORDER BY CASE WHEN :orderBy = 'idDestinacionMantenimientoCdoIng' AND :orderMode = 'ASC' THEN id_destinacion_mantenimiento_cdo_ing END ASC, " +
          "CASE WHEN :orderBy = 'idDestinacionMantenimientoCdoIng' AND :orderMode = 'DESC' THEN id_destinacion_mantenimiento_cdo_ing END DESC, " +
          "CASE WHEN :orderBy = 'nombreDestinacionMantenimientoCdoIng' AND :orderMode = 'ASC' THEN nombre_destinacion_mantenimiento_cdo_ing END ASC, " +
          "CASE WHEN :orderBy = 'nombreDestinacionMantenimientoCdoIng' AND :orderMode = 'DESC' THEN nombre_destinacion_mantenimiento_cdo_ing END DESC", nativeQuery = true)
    List<DestinacionMantenimientoCdoIng> findAllDestinacionesMantenimientosCdosIng(@Param("idDestinacionMantenimientoCdoIng") Long idDestinacionMantenimientoCdoIng, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT * FROM tabla_destinaciones_mantenimientos_cdos_ing " +
          "WHERE (:idDestinacionMantenimientoCdoIng IS NULL OR id_destinacion_mantenimiento_cdo_ing = :idDestinacionMantenimientoCdoIng) AND " +
          "(:keyword IS NULL OR UPPER(nombre_destinacion_mantenimiento_cdo_ing) LIKE UPPER('%'||:keyword||'%')) " +
          "ORDER BY CASE WHEN :orderBy = 'idDestinacionMantenimientoCdoIng' AND :orderMode = 'ASC' THEN id_destinacion_mantenimiento_cdo_ing END ASC, " +
          "CASE WHEN :orderBy = 'idDestinacionMantenimientoCdoIng' AND :orderMode = 'DESC' THEN id_destinacion_mantenimiento_cdo_ing END DESC, " +
          "CASE WHEN :orderBy = 'nombreDestinacionMantenimientoCdoIng' AND :orderMode = 'ASC' THEN nombre_destinacion_mantenimiento_cdo_ing END ASC, " +
          "CASE WHEN :orderBy = 'nombreDestinacionMantenimientoCdoIng' AND :orderMode = 'DESC' THEN nombre_destinacion_mantenimiento_cdo_ing END DESC", nativeQuery = true)
    Slice<DestinacionMantenimientoCdoIng> findAllDestinacionesMantenimientosCdosIngOrdenadosporIdPag(Pageable pageable, @Param("idDestinacionMantenimientoCdoIng") Long idDestinacionMantenimientoCdoIng, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<DestinacionMantenimientoCdoIng> findByIdDestinacionMantenimientoCdoIng(Long idDestinacionMantenimientoCdoIng);
    
    DestinacionMantenimientoCdoIng findByNombreDestinacionMantenimientoCdoIng(String nombreDestinacionMantenimientoCdoIng);
    
    @Query(value = "SELECT MAX(id_destinacion_mantenimiento_cdo_ing) FROM tabla_destinaciones_mantenimientos_cdos_ing", nativeQuery = true)
    Long findMaxIdDestinacionMantenimientoCdoIng();
}
