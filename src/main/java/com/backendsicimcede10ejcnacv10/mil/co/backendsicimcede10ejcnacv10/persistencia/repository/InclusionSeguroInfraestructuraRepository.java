//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.InclusionSeguroInfraestructura;
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
public interface InclusionSeguroInfraestructuraRepository extends JpaRepository<InclusionSeguroInfraestructura, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (ID INCLUSION + KEYWORD + ID PROYECCION SEGURO INFRAESTRUCTURA + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_inclusiones_seguros_infraestructuras " +
            "WHERE (:idInclusionSeguroInfraestructura IS NULL OR tabla_inclusiones_seguros_infraestructuras.id_inclusion_seguro_infraestructura = :idInclusionSeguroInfraestructura) AND " +
            "(:keyword IS NULL OR UPPER(DBMS_LOB.SUBSTR(tabla_inclusiones_seguros_infraestructuras.descripcion_inclusion_seguro_infraestructura, 4000, 1)) LIKE UPPER('%'||:keyword||'%')) AND " +
            "(:idProyeccionSeguroInfraestructura IS NULL OR tabla_inclusiones_seguros_infraestructuras.id_proyeccion_seguro_infraestructura = :idProyeccionSeguroInfraestructura)", nativeQuery = true)
    Long findTotalRegistros(@Param("idInclusionSeguroInfraestructura") Long idInclusionSeguroInfraestructura, @Param("keyword") String keyword, @Param("idProyeccionSeguroInfraestructura") Long idProyeccionSeguroInfraestructura);
    
    @Query(value = "SELECT tabla_inclusiones_seguros_infraestructuras.* FROM tabla_inclusiones_seguros_infraestructuras " +
            "WHERE (:idInclusionSeguroInfraestructura IS NULL OR tabla_inclusiones_seguros_infraestructuras.id_inclusion_seguro_infraestructura = :idInclusionSeguroInfraestructura) AND " +
            "(:keyword IS NULL OR UPPER(DBMS_LOB.SUBSTR(tabla_inclusiones_seguros_infraestructuras.descripcion_inclusion_seguro_infraestructura, 4000, 1)) LIKE UPPER('%'||:keyword||'%')) AND " +
            "(:idProyeccionSeguroInfraestructura IS NULL OR tabla_inclusiones_seguros_infraestructuras.id_proyeccion_seguro_infraestructura = :idProyeccionSeguroInfraestructura) " +
            "ORDER BY CASE WHEN :orderBy = 'idInclusionSeguroInfraestructura' AND :orderMode = 'ASC' THEN tabla_inclusiones_seguros_infraestructuras.id_inclusion_seguro_infraestructura END ASC, " +
            "CASE WHEN :orderBy = 'idInclusionSeguroInfraestructura' AND :orderMode = 'DESC' THEN tabla_inclusiones_seguros_infraestructuras.id_inclusion_seguro_infraestructura END DESC, " +
            "CASE WHEN :orderBy = 'fechaHMSIniciacionInclusionSeguroInfraestructura' AND :orderMode = 'ASC' THEN tabla_inclusiones_seguros_infraestructuras.fecha_h_m_s_iniciacion_inclusion_seguro_infraestructura END ASC, " +
            "CASE WHEN :orderBy = 'fechaHMSIniciacionInclusionSeguroInfraestructura' AND :orderMode = 'DESC' THEN tabla_inclusiones_seguros_infraestructuras.fecha_h_m_s_iniciacion_inclusion_seguro_infraestructura END DESC, " +
            "CASE WHEN :orderBy = 'fechaHMSFinalizacionInclusionSeguroInfraestructura' AND :orderMode = 'ASC' THEN tabla_inclusiones_seguros_infraestructuras.fecha_h_m_s_finalizacion_inclusion_seguro_infraestructura END ASC, " +
            "CASE WHEN :orderBy = 'fechaHMSFinalizacionInclusionSeguroInfraestructura' AND :orderMode = 'DESC' THEN tabla_inclusiones_seguros_infraestructuras.fecha_h_m_s_finalizacion_inclusion_seguro_infraestructura END DESC, " +
            "CASE WHEN :orderBy = 'descripcionInclusionSeguroInfraestructura' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_inclusiones_seguros_infraestructuras.descripcion_inclusion_seguro_infraestructura, 4000, 1) END ASC, " +
            "CASE WHEN :orderBy = 'descripcionInclusionSeguroInfraestructura' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_inclusiones_seguros_infraestructuras.descripcion_inclusion_seguro_infraestructura, 4000, 1) END DESC", nativeQuery = true)
    List<InclusionSeguroInfraestructura> findAllInclusionesSeguroInfraestructura(@Param("idInclusionSeguroInfraestructura") Long idInclusionSeguroInfraestructura, @Param("keyword") String keyword, @Param("idProyeccionSeguroInfraestructura") Long idProyeccionSeguroInfraestructura, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_inclusiones_seguros_infraestructuras.* FROM tabla_inclusiones_seguros_infraestructuras " +
            "WHERE (:idInclusionSeguroInfraestructura IS NULL OR tabla_inclusiones_seguros_infraestructuras.id_inclusion_seguro_infraestructura = :idInclusionSeguroInfraestructura) AND " +
            "(:keyword IS NULL OR UPPER(DBMS_LOB.SUBSTR(tabla_inclusiones_seguros_infraestructuras.descripcion_inclusion_seguro_infraestructura, 4000, 1)) LIKE UPPER('%'||:keyword||'%')) AND " +
            "(:idProyeccionSeguroInfraestructura IS NULL OR tabla_inclusiones_seguros_infraestructuras.id_proyeccion_seguro_infraestructura = :idProyeccionSeguroInfraestructura) " +
            "ORDER BY CASE WHEN :orderBy = 'idInclusionSeguroInfraestructura' AND :orderMode = 'ASC' THEN tabla_inclusiones_seguros_infraestructuras.id_inclusion_seguro_infraestructura END ASC, " +
            "CASE WHEN :orderBy = 'idInclusionSeguroInfraestructura' AND :orderMode = 'DESC' THEN tabla_inclusiones_seguros_infraestructuras.id_inclusion_seguro_infraestructura END DESC, " +
            "CASE WHEN :orderBy = 'fechaHMSIniciacionInclusionSeguroInfraestructura' AND :orderMode = 'ASC' THEN tabla_inclusiones_seguros_infraestructuras.fecha_h_m_s_iniciacion_inclusion_seguro_infraestructura END ASC, " +
            "CASE WHEN :orderBy = 'fechaHMSIniciacionInclusionSeguroInfraestructura' AND :orderMode = 'DESC' THEN tabla_inclusiones_seguros_infraestructuras.fecha_h_m_s_iniciacion_inclusion_seguro_infraestructura END DESC, " +
            "CASE WHEN :orderBy = 'fechaHMSFinalizacionInclusionSeguroInfraestructura' AND :orderMode = 'ASC' THEN tabla_inclusiones_seguros_infraestructuras.fecha_h_m_s_finalizacion_inclusion_seguro_infraestructura END ASC, " +
            "CASE WHEN :orderBy = 'fechaHMSFinalizacionInclusionSeguroInfraestructura' AND :orderMode = 'DESC' THEN tabla_inclusiones_seguros_infraestructuras.fecha_h_m_s_finalizacion_inclusion_seguro_infraestructura END DESC, " +
            "CASE WHEN :orderBy = 'descripcionInclusionSeguroInfraestructura' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_inclusiones_seguros_infraestructuras.descripcion_inclusion_seguro_infraestructura, 4000, 1) END ASC, " +
            "CASE WHEN :orderBy = 'descripcionInclusionSeguroInfraestructura' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_inclusiones_seguros_infraestructuras.descripcion_inclusion_seguro_infraestructura, 4000, 1) END DESC", nativeQuery = true)
    Slice<InclusionSeguroInfraestructura> findAllInclusionesSeguroInfraestructuraPag(Pageable pageable, @Param("idInclusionSeguroInfraestructura") Long idInclusionSeguroInfraestructura, @Param("keyword") String keyword, @Param("idProyeccionSeguroInfraestructura") Long idProyeccionSeguroInfraestructura, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<InclusionSeguroInfraestructura> findByIdInclusionSeguroInfraestructura(Long idInclusionSeguroInfraestructura);
    
    @Query(value = "SELECT MAX(id_inclusion_seguro_infraestructura) FROM tabla_inclusiones_seguros_infraestructuras", nativeQuery = true)
    Long findMaxIdInclusionSeguroInfraestructura();
}
