//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.InclusionSeguroLineaBlanca;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 15/04/2026.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface InclusionSeguroLineaBlancaRepository extends JpaRepository<InclusionSeguroLineaBlanca, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (ID INCLUSION + KEYWORD + ID ASEGURAMIENTO LINEA BLANCA + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_inclusiones_seguros_lineas_blancas " +
            "WHERE (:idInclusionSeguroLineaBlanca IS NULL OR tabla_inclusiones_seguros_lineas_blancas.id_inclusion_seguro_linea_blanca = :idInclusionSeguroLineaBlanca) AND " +
            "(:keyword IS NULL OR UPPER(DBMS_LOB.SUBSTR(tabla_inclusiones_seguros_lineas_blancas.descripcion_inclusion_seguro_linea_blanca, 4000, 1)) LIKE UPPER('%'||:keyword||'%')) AND " +
            "(:idAseguramientoLineaBlanca IS NULL OR tabla_inclusiones_seguros_lineas_blancas.id_aseguramiento_linea_blanca = :idAseguramientoLineaBlanca)", nativeQuery = true)
    Long findTotalRegistros(@Param("idInclusionSeguroLineaBlanca") Long idInclusionSeguroLineaBlanca, @Param("keyword") String keyword, @Param("idAseguramientoLineaBlanca") Long idAseguramientoLineaBlanca);
    
    @Query(value = "SELECT tabla_inclusiones_seguros_lineas_blancas.* FROM tabla_inclusiones_seguros_lineas_blancas " +
            "WHERE (:idInclusionSeguroLineaBlanca IS NULL OR tabla_inclusiones_seguros_lineas_blancas.id_inclusion_seguro_linea_blanca = :idInclusionSeguroLineaBlanca) AND " +
            "(:keyword IS NULL OR UPPER(DBMS_LOB.SUBSTR(tabla_inclusiones_seguros_lineas_blancas.descripcion_inclusion_seguro_linea_blanca, 4000, 1)) LIKE UPPER('%'||:keyword||'%')) AND " +
            "(:idAseguramientoLineaBlanca IS NULL OR tabla_inclusiones_seguros_lineas_blancas.id_aseguramiento_linea_blanca = :idAseguramientoLineaBlanca) " +
            "ORDER BY CASE WHEN :orderBy = 'idInclusionSeguroLineaBlanca' AND :orderMode = 'ASC' THEN tabla_inclusiones_seguros_lineas_blancas.id_inclusion_seguro_linea_blanca END ASC, " +
            "CASE WHEN :orderBy = 'idInclusionSeguroLineaBlanca' AND :orderMode = 'DESC' THEN tabla_inclusiones_seguros_lineas_blancas.id_inclusion_seguro_linea_blanca END DESC, " +
            "CASE WHEN :orderBy = 'fechaHMSIniciacionInclusionSeguroLineaBlanca' AND :orderMode = 'ASC' THEN tabla_inclusiones_seguros_lineas_blancas.fecha_h_m_s_iniciacion_inclusion_seguro_linea_blanca END ASC, " +
            "CASE WHEN :orderBy = 'fechaHMSIniciacionInclusionSeguroLineaBlanca' AND :orderMode = 'DESC' THEN tabla_inclusiones_seguros_lineas_blancas.fecha_h_m_s_iniciacion_inclusion_seguro_linea_blanca END DESC, " +
            "CASE WHEN :orderBy = 'fechaHMSFinalizacionInclusionSeguroLineaBlanca' AND :orderMode = 'ASC' THEN tabla_inclusiones_seguros_lineas_blancas.fecha_h_m_s_finalizacion_inclusion_seguro_linea_blanca END ASC, " +
            "CASE WHEN :orderBy = 'fechaHMSFinalizacionInclusionSeguroLineaBlanca' AND :orderMode = 'DESC' THEN tabla_inclusiones_seguros_lineas_blancas.fecha_h_m_s_finalizacion_inclusion_seguro_linea_blanca END DESC, " +
            "CASE WHEN :orderBy = 'descripcionInclusionSeguroLineaBlanca' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_inclusiones_seguros_lineas_blancas.descripcion_inclusion_seguro_linea_blanca, 4000, 1) END ASC, " +
            "CASE WHEN :orderBy = 'descripcionInclusionSeguroLineaBlanca' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_inclusiones_seguros_lineas_blancas.descripcion_inclusion_seguro_linea_blanca, 4000, 1) END DESC", nativeQuery = true)
    List<InclusionSeguroLineaBlanca> findAllInclusionesSeguroLineaBlanca(@Param("idInclusionSeguroLineaBlanca") Long idInclusionSeguroLineaBlanca, @Param("keyword") String keyword, @Param("idAseguramientoLineaBlanca") Long idAseguramientoLineaBlanca, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_inclusiones_seguros_lineas_blancas.* FROM tabla_inclusiones_seguros_lineas_blancas " +
            "WHERE (:idInclusionSeguroLineaBlanca IS NULL OR tabla_inclusiones_seguros_lineas_blancas.id_inclusion_seguro_linea_blanca = :idInclusionSeguroLineaBlanca) AND " +
            "(:keyword IS NULL OR UPPER(DBMS_LOB.SUBSTR(tabla_inclusiones_seguros_lineas_blancas.descripcion_inclusion_seguro_linea_blanca, 4000, 1)) LIKE UPPER('%'||:keyword||'%')) AND " +
            "(:idAseguramientoLineaBlanca IS NULL OR tabla_inclusiones_seguros_lineas_blancas.id_aseguramiento_linea_blanca = :idAseguramientoLineaBlanca) " +
            "ORDER BY CASE WHEN :orderBy = 'idInclusionSeguroLineaBlanca' AND :orderMode = 'ASC' THEN tabla_inclusiones_seguros_lineas_blancas.id_inclusion_seguro_linea_blanca END ASC, " +
            "CASE WHEN :orderBy = 'idInclusionSeguroLineaBlanca' AND :orderMode = 'DESC' THEN tabla_inclusiones_seguros_lineas_blancas.id_inclusion_seguro_linea_blanca END DESC, " +
            "CASE WHEN :orderBy = 'fechaHMSIniciacionInclusionSeguroLineaBlanca' AND :orderMode = 'ASC' THEN tabla_inclusiones_seguros_lineas_blancas.fecha_h_m_s_iniciacion_inclusion_seguro_linea_blanca END ASC, " +
            "CASE WHEN :orderBy = 'fechaHMSIniciacionInclusionSeguroLineaBlanca' AND :orderMode = 'DESC' THEN tabla_inclusiones_seguros_lineas_blancas.fecha_h_m_s_iniciacion_inclusion_seguro_linea_blanca END DESC, " +
            "CASE WHEN :orderBy = 'fechaHMSFinalizacionInclusionSeguroLineaBlanca' AND :orderMode = 'ASC' THEN tabla_inclusiones_seguros_lineas_blancas.fecha_h_m_s_finalizacion_inclusion_seguro_linea_blanca END ASC, " +
            "CASE WHEN :orderBy = 'fechaHMSFinalizacionInclusionSeguroLineaBlanca' AND :orderMode = 'DESC' THEN tabla_inclusiones_seguros_lineas_blancas.fecha_h_m_s_finalizacion_inclusion_seguro_linea_blanca END DESC, " +
            "CASE WHEN :orderBy = 'descripcionInclusionSeguroLineaBlanca' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_inclusiones_seguros_lineas_blancas.descripcion_inclusion_seguro_linea_blanca, 4000, 1) END ASC, " +
            "CASE WHEN :orderBy = 'descripcionInclusionSeguroLineaBlanca' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_inclusiones_seguros_lineas_blancas.descripcion_inclusion_seguro_linea_blanca, 4000, 1) END DESC", nativeQuery = true)
    Slice<InclusionSeguroLineaBlanca> findAllInclusionesSeguroLineaBlancaPag(Pageable pageable, @Param("idInclusionSeguroLineaBlanca") Long idInclusionSeguroLineaBlanca, @Param("keyword") String keyword, @Param("idAseguramientoLineaBlanca") Long idAseguramientoLineaBlanca, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<InclusionSeguroLineaBlanca> findByIdInclusionSeguroLineaBlanca(Long idInclusionSeguroLineaBlanca);
    
    @Query(value = "SELECT MAX(id_inclusion_seguro_linea_blanca) FROM tabla_inclusiones_seguros_lineas_blancas", nativeQuery = true)
    Long findMaxIdInclusionSeguroLineaBlanca();
}
