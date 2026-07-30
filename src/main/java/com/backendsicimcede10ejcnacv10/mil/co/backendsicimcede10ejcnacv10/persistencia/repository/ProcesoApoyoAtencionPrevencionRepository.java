//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ProcesoApoyoAtencionPrevencion;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 25/03/2026.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface ProcesoApoyoAtencionPrevencionRepository extends JpaRepository<ProcesoApoyoAtencionPrevencion, Long> {
    
    @Query(value = "" +
          "SELECT COUNT(*) " +
          "FROM tabla_procesos_apoyos_atencion_prevencion, tabla_tipos_requerimientos_apoyos_atencion_prevencion " +
          "WHERE (:idProcesoApoyoAtencionPrevencion IS NULL OR tabla_procesos_apoyos_atencion_prevencion.id_proceso_apoyo_atencion_prevencion = :idProcesoApoyoAtencionPrevencion) AND " +
          "(tabla_procesos_apoyos_atencion_prevencion.id_tipo_requerimiento_apoyo_atencion_prevencion = tabla_tipos_requerimientos_apoyos_atencion_prevencion.id_tipo_requerimiento_apoyo_atencion_prevencion) AND " +
          "(:nombreTipoRequerimientoApoyoAtencionPrevencion IS NULL OR tabla_tipos_requerimientos_apoyos_atencion_prevencion.nombre_tipo_requerimiento_apoyo_atencion_prevencion = :nombreTipoRequerimientoApoyoAtencionPrevencion) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_procesos_apoyos_atencion_prevencion.nombre_proceso_apoyo_atencion_prevencion) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_tipos_requerimientos_apoyos_atencion_prevencion.nombre_tipo_requerimiento_apoyo_atencion_prevencion) LIKE UPPER('%'||:keyword||'%')))", nativeQuery = true)
    Long findTotalRegistros(@Param("idProcesoApoyoAtencionPrevencion") Long idProcesoApoyoAtencionPrevencion, @Param("keyword") String keyword, @Param("nombreTipoRequerimientoApoyoAtencionPrevencion") String nombreTipoRequerimientoApoyoAtencionPrevencion);
    
    @Query(value = "" +
          "SELECT tabla_procesos_apoyos_atencion_prevencion.* " +
          "FROM tabla_procesos_apoyos_atencion_prevencion, tabla_tipos_requerimientos_apoyos_atencion_prevencion " +
          "WHERE (:idProcesoApoyoAtencionPrevencion IS NULL OR tabla_procesos_apoyos_atencion_prevencion.id_proceso_apoyo_atencion_prevencion = :idProcesoApoyoAtencionPrevencion) AND " +
          "(tabla_procesos_apoyos_atencion_prevencion.id_tipo_requerimiento_apoyo_atencion_prevencion = tabla_tipos_requerimientos_apoyos_atencion_prevencion.id_tipo_requerimiento_apoyo_atencion_prevencion) AND " +
          "(:nombreTipoRequerimientoApoyoAtencionPrevencion IS NULL OR tabla_tipos_requerimientos_apoyos_atencion_prevencion.nombre_tipo_requerimiento_apoyo_atencion_prevencion = :nombreTipoRequerimientoApoyoAtencionPrevencion) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_procesos_apoyos_atencion_prevencion.nombre_proceso_apoyo_atencion_prevencion) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_tipos_requerimientos_apoyos_atencion_prevencion.nombre_tipo_requerimiento_apoyo_atencion_prevencion) LIKE UPPER('%'||:keyword||'%'))) " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idProcesoApoyoAtencionPrevencion' AND :orderMode = 'ASC' THEN tabla_procesos_apoyos_atencion_prevencion.id_proceso_apoyo_atencion_prevencion END ASC, " +
          "CASE WHEN :orderBy = 'idProcesoApoyoAtencionPrevencion' AND :orderMode = 'DESC' THEN tabla_procesos_apoyos_atencion_prevencion.id_proceso_apoyo_atencion_prevencion END DESC, " +
          "CASE WHEN :orderBy = 'nombreProcesoApoyoAtencionPrevencion' AND :orderMode = 'ASC' THEN tabla_procesos_apoyos_atencion_prevencion.nombre_proceso_apoyo_atencion_prevencion END ASC, " +
          "CASE WHEN :orderBy = 'nombreProcesoApoyoAtencionPrevencion' AND :orderMode = 'DESC' THEN tabla_procesos_apoyos_atencion_prevencion.nombre_proceso_apoyo_atencion_prevencion END DESC, " +
          "CASE WHEN :orderBy = 'idTipoRequerimientoApoyoAtencionPrevencion' AND :orderMode = 'ASC' THEN tabla_procesos_apoyos_atencion_prevencion.id_tipo_requerimiento_apoyo_atencion_prevencion END ASC, " +
          "CASE WHEN :orderBy = 'idTipoRequerimientoApoyoAtencionPrevencion' AND :orderMode = 'DESC' THEN tabla_procesos_apoyos_atencion_prevencion.id_tipo_requerimiento_apoyo_atencion_prevencion END DESC", nativeQuery = true)
    List<ProcesoApoyoAtencionPrevencion> findAllProcesosApoyosAtencionPrevencion(@Param("idProcesoApoyoAtencionPrevencion") Long idProcesoApoyoAtencionPrevencion, @Param("keyword") String keyword, @Param("nombreTipoRequerimientoApoyoAtencionPrevencion") String nombreTipoRequerimientoApoyoAtencionPrevencion, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "" +
          "SELECT tabla_procesos_apoyos_atencion_prevencion.* " +
          "FROM tabla_procesos_apoyos_atencion_prevencion, tabla_tipos_requerimientos_apoyos_atencion_prevencion " +
          "WHERE (:idProcesoApoyoAtencionPrevencion IS NULL OR tabla_procesos_apoyos_atencion_prevencion.id_proceso_apoyo_atencion_prevencion = :idProcesoApoyoAtencionPrevencion) AND " +
          "(tabla_procesos_apoyos_atencion_prevencion.id_tipo_requerimiento_apoyo_atencion_prevencion = tabla_tipos_requerimientos_apoyos_atencion_prevencion.id_tipo_requerimiento_apoyo_atencion_prevencion) AND " +
          "(:nombreTipoRequerimientoApoyoAtencionPrevencion IS NULL OR tabla_tipos_requerimientos_apoyos_atencion_prevencion.nombre_tipo_requerimiento_apoyo_atencion_prevencion = :nombreTipoRequerimientoApoyoAtencionPrevencion) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_procesos_apoyos_atencion_prevencion.nombre_proceso_apoyo_atencion_prevencion) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_tipos_requerimientos_apoyos_atencion_prevencion.nombre_tipo_requerimiento_apoyo_atencion_prevencion) LIKE UPPER('%'||:keyword||'%'))) " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idProcesoApoyoAtencionPrevencion' AND :orderMode = 'ASC' THEN tabla_procesos_apoyos_atencion_prevencion.id_proceso_apoyo_atencion_prevencion END ASC, " +
          "CASE WHEN :orderBy = 'idProcesoApoyoAtencionPrevencion' AND :orderMode = 'DESC' THEN tabla_procesos_apoyos_atencion_prevencion.id_proceso_apoyo_atencion_prevencion END DESC, " +
          "CASE WHEN :orderBy = 'nombreProcesoApoyoAtencionPrevencion' AND :orderMode = 'ASC' THEN tabla_procesos_apoyos_atencion_prevencion.nombre_proceso_apoyo_atencion_prevencion END ASC, " +
          "CASE WHEN :orderBy = 'nombreProcesoApoyoAtencionPrevencion' AND :orderMode = 'DESC' THEN tabla_procesos_apoyos_atencion_prevencion.nombre_proceso_apoyo_atencion_prevencion END DESC, " +
          "CASE WHEN :orderBy = 'idTipoRequerimientoApoyoAtencionPrevencion' AND :orderMode = 'ASC' THEN tabla_procesos_apoyos_atencion_prevencion.id_tipo_requerimiento_apoyo_atencion_prevencion END ASC, " +
          "CASE WHEN :orderBy = 'idTipoRequerimientoApoyoAtencionPrevencion' AND :orderMode = 'DESC' THEN tabla_procesos_apoyos_atencion_prevencion.id_tipo_requerimiento_apoyo_atencion_prevencion END DESC", nativeQuery = true)
    Slice<ProcesoApoyoAtencionPrevencion> findAllProcesosApoyosAtencionPrevencionPag(Pageable pageable, @Param("idProcesoApoyoAtencionPrevencion") Long idProcesoApoyoAtencionPrevencion, @Param("keyword") String keyword, @Param("nombreTipoRequerimientoApoyoAtencionPrevencion") String nombreTipoRequerimientoApoyoAtencionPrevencion, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<ProcesoApoyoAtencionPrevencion> findByIdProcesoApoyoAtencionPrevencion(Long idProcesoApoyoAtencionPrevencion);
    
    @Query(value = "" +
          "SELECT tabla_procesos_apoyos_atencion_prevencion.* " +
          "FROM tabla_procesos_apoyos_atencion_prevencion, tabla_tipos_requerimientos_apoyos_atencion_prevencion " +
          "WHERE (tabla_procesos_apoyos_atencion_prevencion.id_tipo_requerimiento_apoyo_atencion_prevencion = tabla_tipos_requerimientos_apoyos_atencion_prevencion.id_tipo_requerimiento_apoyo_atencion_prevencion) AND " +
          "(tabla_tipos_requerimientos_apoyos_atencion_prevencion.nombre_tipo_requerimiento_apoyo_atencion_prevencion = :nombreTipoRequerimientoApoyoAtencionPrevencion) AND " +
          "(tabla_procesos_apoyos_atencion_prevencion.nombre_proceso_apoyo_atencion_prevencion = :nombreProcesoApoyoAtencionPrevencion)", nativeQuery = true)
    ProcesoApoyoAtencionPrevencion findByNombreTipoRequerimientoApoyoAtencionPrevencionAndNombreProcesoApoyoAtencionPrevencion(@Param("nombreTipoRequerimientoApoyoAtencionPrevencion") String nombreTipoRequerimientoApoyoAtencionPrevencion, @Param("nombreProcesoApoyoAtencionPrevencion") String nombreProcesoApoyoAtencionPrevencion);
    
    @Query(value = "SELECT MAX(id_proceso_apoyo_atencion_prevencion) FROM tabla_procesos_apoyos_atencion_prevencion", nativeQuery = true)
    Long findMaxIdProcesoApoyoAtencionPrevencion();
}
