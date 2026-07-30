//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoFuenteFinanciacion;
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
public interface TipoFuenteFinanciacionRepository extends JpaRepository<TipoFuenteFinanciacion,Long> {
    
    @Query(value = "SELECT COUNT(*) FROM tabla_tipos_fuentes_financiacion WHERE (:idTipoFuenteFinanciacion IS NULL OR id_tipo_fuente_financiacion = :idTipoFuenteFinanciacion) AND (:keyword IS NULL OR UPPER(nombre_tipo_fuente_financiacion) LIKE UPPER('%'||:keyword||'%'))", nativeQuery = true)
    Long findTotalRegistros(@Param("idTipoFuenteFinanciacion") Long idTipoFuenteFinanciacion, @Param("keyword") String keyword);
    
    @Query(value = "SELECT * FROM tabla_tipos_fuentes_financiacion WHERE (:idTipoFuenteFinanciacion IS NULL OR id_tipo_fuente_financiacion = :idTipoFuenteFinanciacion) AND (:keyword IS NULL OR UPPER(nombre_tipo_fuente_financiacion) LIKE UPPER('%'||:keyword||'%')) ORDER BY CASE WHEN :orderBy = 'idTipoFuenteFinanciacion' AND :orderMode = 'ASC' THEN id_tipo_fuente_financiacion END ASC, CASE WHEN :orderBy = 'idTipoFuenteFinanciacion' AND :orderMode = 'DESC' THEN id_tipo_fuente_financiacion END DESC, CASE WHEN :orderBy = 'nombreTipoFuenteFinanciacion' AND :orderMode = 'ASC' THEN nombre_tipo_fuente_financiacion END ASC, CASE WHEN :orderBy = 'nombreTipoFuenteFinanciacion' AND :orderMode = 'DESC' THEN nombre_tipo_fuente_financiacion END DESC", nativeQuery = true)
    List<TipoFuenteFinanciacion> findAllTiposFuentesFinanciaciones(@Param("idTipoFuenteFinanciacion") Long idTipoFuenteFinanciacion, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);

    @Query(value = "SELECT * FROM tabla_tipos_fuentes_financiacion WHERE (:idTipoFuenteFinanciacion IS NULL OR id_tipo_fuente_financiacion = :idTipoFuenteFinanciacion) AND (:keyword IS NULL OR UPPER(nombre_tipo_fuente_financiacion) LIKE UPPER('%'||:keyword||'%')) ORDER BY CASE WHEN :orderBy = 'idTipoFuenteFinanciacion' AND :orderMode = 'ASC' THEN id_tipo_fuente_financiacion END ASC, CASE WHEN :orderBy = 'idTipoFuenteFinanciacion' AND :orderMode = 'DESC' THEN id_tipo_fuente_financiacion END DESC, CASE WHEN :orderBy = 'nombreTipoFuenteFinanciacion' AND :orderMode = 'ASC' THEN nombre_tipo_fuente_financiacion END ASC, CASE WHEN :orderBy = 'nombreTipoFuenteFinanciacion' AND :orderMode = 'DESC' THEN nombre_tipo_fuente_financiacion END DESC", nativeQuery = true)
    Slice<TipoFuenteFinanciacion> findAllTiposFuentesFinanciacionesPag(Pageable pageable, @Param("idTipoFuenteFinanciacion") Long idTipoFuenteFinanciacion, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<TipoFuenteFinanciacion> findByIdTipoFuenteFinanciacion(Long idTipoFuenteFinanciacion);
    
    TipoFuenteFinanciacion findByNombreTipoFuenteFinanciacion(String nombreTipoFuenteFinanciacion);
    
    @Query(value = "SELECT MAX(id_tipo_fuente_financiacion) FROM tabla_tipos_fuentes_financiacion", nativeQuery = true)
    Long findMaxIdTipoFuenteFinanciacion();
}
