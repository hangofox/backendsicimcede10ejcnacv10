//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.InclusionSeguroEquipoIngeniero;
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
public interface InclusionSeguroEquipoIngenieroRepository extends JpaRepository<InclusionSeguroEquipoIngeniero, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (ID INCLUSION + KEYWORD + ID ASEGURAMIENTO EQUIPO INGENIERO + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_inclusiones_seguros_equipos_ingenieros " +
            "WHERE (:idInclusionSeguroEquipoIngeniero IS NULL OR tabla_inclusiones_seguros_equipos_ingenieros.id_inclusion_seguro_equipo_ingeniero = :idInclusionSeguroEquipoIngeniero) AND " +
            "(:keyword IS NULL OR UPPER(DBMS_LOB.SUBSTR(tabla_inclusiones_seguros_equipos_ingenieros.descripcion_inclusion_seguro_equipo_ingeniero, 4000, 1)) LIKE UPPER('%'||:keyword||'%')) AND " +
            "(:idAseguramientoEquipoIngeniero IS NULL OR tabla_inclusiones_seguros_equipos_ingenieros.id_aseguramiento_equipo_ingeniero = :idAseguramientoEquipoIngeniero)", nativeQuery = true)
    Long findTotalRegistros(@Param("idInclusionSeguroEquipoIngeniero") Long idInclusionSeguroEquipoIngeniero, @Param("keyword") String keyword, @Param("idAseguramientoEquipoIngeniero") Long idAseguramientoEquipoIngeniero);
    
    @Query(value = "SELECT tabla_inclusiones_seguros_equipos_ingenieros.* FROM tabla_inclusiones_seguros_equipos_ingenieros " +
            "WHERE (:idInclusionSeguroEquipoIngeniero IS NULL OR tabla_inclusiones_seguros_equipos_ingenieros.id_inclusion_seguro_equipo_ingeniero = :idInclusionSeguroEquipoIngeniero) AND " +
            "(:keyword IS NULL OR UPPER(DBMS_LOB.SUBSTR(tabla_inclusiones_seguros_equipos_ingenieros.descripcion_inclusion_seguro_equipo_ingeniero, 4000, 1)) LIKE UPPER('%'||:keyword||'%')) AND " +
            "(:idAseguramientoEquipoIngeniero IS NULL OR tabla_inclusiones_seguros_equipos_ingenieros.id_aseguramiento_equipo_ingeniero = :idAseguramientoEquipoIngeniero) " +
            "ORDER BY CASE WHEN :orderBy = 'idInclusionSeguroEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_inclusiones_seguros_equipos_ingenieros.id_inclusion_seguro_equipo_ingeniero END ASC, " +
            "CASE WHEN :orderBy = 'idInclusionSeguroEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_inclusiones_seguros_equipos_ingenieros.id_inclusion_seguro_equipo_ingeniero END DESC, " +
            "CASE WHEN :orderBy = 'fechaHMSIniciacionInclusionSeguroEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_inclusiones_seguros_equipos_ingenieros.fecha_h_m_s_iniciacion_inclusion_seguro_equipo_ingeniero END ASC, " +
            "CASE WHEN :orderBy = 'fechaHMSIniciacionInclusionSeguroEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_inclusiones_seguros_equipos_ingenieros.fecha_h_m_s_iniciacion_inclusion_seguro_equipo_ingeniero END DESC, " +
            "CASE WHEN :orderBy = 'fechaHMSFinalizacionInclusionSeguroEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_inclusiones_seguros_equipos_ingenieros.fecha_h_m_s_finalizacion_inclusion_seguro_equipo_ingeniero END ASC, " +
            "CASE WHEN :orderBy = 'fechaHMSFinalizacionInclusionSeguroEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_inclusiones_seguros_equipos_ingenieros.fecha_h_m_s_finalizacion_inclusion_seguro_equipo_ingeniero END DESC, " +
            "CASE WHEN :orderBy = 'descripcionInclusionSeguroEquipoIngeniero' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_inclusiones_seguros_equipos_ingenieros.descripcion_inclusion_seguro_equipo_ingeniero, 4000, 1) END ASC, " +
            "CASE WHEN :orderBy = 'descripcionInclusionSeguroEquipoIngeniero' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_inclusiones_seguros_equipos_ingenieros.descripcion_inclusion_seguro_equipo_ingeniero, 4000, 1) END DESC", nativeQuery = true)
    List<InclusionSeguroEquipoIngeniero> findAllInclusionesSeguroEquipoIngeniero(@Param("idInclusionSeguroEquipoIngeniero") Long idInclusionSeguroEquipoIngeniero, @Param("keyword") String keyword, @Param("idAseguramientoEquipoIngeniero") Long idAseguramientoEquipoIngeniero, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_inclusiones_seguros_equipos_ingenieros.* FROM tabla_inclusiones_seguros_equipos_ingenieros " +
            "WHERE (:idInclusionSeguroEquipoIngeniero IS NULL OR tabla_inclusiones_seguros_equipos_ingenieros.id_inclusion_seguro_equipo_ingeniero = :idInclusionSeguroEquipoIngeniero) AND " +
            "(:keyword IS NULL OR UPPER(DBMS_LOB.SUBSTR(tabla_inclusiones_seguros_equipos_ingenieros.descripcion_inclusion_seguro_equipo_ingeniero, 4000, 1)) LIKE UPPER('%'||:keyword||'%')) AND " +
            "(:idAseguramientoEquipoIngeniero IS NULL OR tabla_inclusiones_seguros_equipos_ingenieros.id_aseguramiento_equipo_ingeniero = :idAseguramientoEquipoIngeniero) " +
            "ORDER BY CASE WHEN :orderBy = 'idInclusionSeguroEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_inclusiones_seguros_equipos_ingenieros.id_inclusion_seguro_equipo_ingeniero END ASC, " +
            "CASE WHEN :orderBy = 'idInclusionSeguroEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_inclusiones_seguros_equipos_ingenieros.id_inclusion_seguro_equipo_ingeniero END DESC, " +
            "CASE WHEN :orderBy = 'fechaHMSIniciacionInclusionSeguroEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_inclusiones_seguros_equipos_ingenieros.fecha_h_m_s_iniciacion_inclusion_seguro_equipo_ingeniero END ASC, " +
            "CASE WHEN :orderBy = 'fechaHMSIniciacionInclusionSeguroEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_inclusiones_seguros_equipos_ingenieros.fecha_h_m_s_iniciacion_inclusion_seguro_equipo_ingeniero END DESC, " +
            "CASE WHEN :orderBy = 'fechaHMSFinalizacionInclusionSeguroEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_inclusiones_seguros_equipos_ingenieros.fecha_h_m_s_finalizacion_inclusion_seguro_equipo_ingeniero END ASC, " +
            "CASE WHEN :orderBy = 'fechaHMSFinalizacionInclusionSeguroEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_inclusiones_seguros_equipos_ingenieros.fecha_h_m_s_finalizacion_inclusion_seguro_equipo_ingeniero END DESC, " +
            "CASE WHEN :orderBy = 'descripcionInclusionSeguroEquipoIngeniero' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_inclusiones_seguros_equipos_ingenieros.descripcion_inclusion_seguro_equipo_ingeniero, 4000, 1) END ASC, " +
            "CASE WHEN :orderBy = 'descripcionInclusionSeguroEquipoIngeniero' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_inclusiones_seguros_equipos_ingenieros.descripcion_inclusion_seguro_equipo_ingeniero, 4000, 1) END DESC", nativeQuery = true)
    Slice<InclusionSeguroEquipoIngeniero> findAllInclusionesSeguroEquipoIngeneroPag(Pageable pageable, @Param("idInclusionSeguroEquipoIngeniero") Long idInclusionSeguroEquipoIngeniero, @Param("keyword") String keyword, @Param("idAseguramientoEquipoIngeniero") Long idAseguramientoEquipoIngeniero, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<InclusionSeguroEquipoIngeniero> findByIdInclusionSeguroEquipoIngeniero(Long idInclusionSeguroEquipoIngeniero);
    
    @Query(value = "SELECT MAX(id_inclusion_seguro_equipo_ingeniero) FROM tabla_inclusiones_seguros_equipos_ingenieros", nativeQuery = true)
    Long findMaxIdInclusionSeguroEquipoIngeniero();
}
