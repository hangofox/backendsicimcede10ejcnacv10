//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ApoyoAtencPrevEmergDesast;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 31/03/2026.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface ApoyoAtencPrevEmergDesastRepository extends JpaRepository<ApoyoAtencPrevEmergDesast, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (ID + KEYWORD + ID UNIDAD MILITAR + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_apoyos_atenc_prev_emerg_desast " +
          "WHERE (:idApoyoAtencPrevEmergDesast IS NULL OR tabla_apoyos_atenc_prev_emerg_desast.id_apoyo_atenc_prev_emerg_desast = :idApoyoAtencPrevEmergDesast) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_apoyos_atenc_prev_emerg_desast.codigo_radicado_apoyo_atenc_prev_emerg_desast) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_apoyos_atenc_prev_emerg_desast.nombre_entidad_institucional_solic_apoyo_atenc_prev_emerg_desast) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:idUnidadMilitar IS NULL OR tabla_apoyos_atenc_prev_emerg_desast.id_unidad_militar = :idUnidadMilitar) AND " +
          "(:idProcesoApoyoAtencionPrevencion IS NULL OR tabla_apoyos_atenc_prev_emerg_desast.id_proceso_apoyo_atencion_prevencion = :idProcesoApoyoAtencionPrevencion)", nativeQuery = true)
    Long findTotalRegistros(@Param("idApoyoAtencPrevEmergDesast") Long idApoyoAtencPrevEmergDesast, @Param("keyword") String keyword, @Param("idUnidadMilitar") Long idUnidadMilitar, @Param("idProcesoApoyoAtencionPrevencion") Long idProcesoApoyoAtencionPrevencion);
    
    @Query(value = "SELECT tabla_apoyos_atenc_prev_emerg_desast.* FROM tabla_apoyos_atenc_prev_emerg_desast " +
          "WHERE (:idApoyoAtencPrevEmergDesast IS NULL OR tabla_apoyos_atenc_prev_emerg_desast.id_apoyo_atenc_prev_emerg_desast = :idApoyoAtencPrevEmergDesast) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_apoyos_atenc_prev_emerg_desast.codigo_radicado_apoyo_atenc_prev_emerg_desast) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_apoyos_atenc_prev_emerg_desast.nombre_entidad_institucional_solic_apoyo_atenc_prev_emerg_desast) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:idUnidadMilitar IS NULL OR tabla_apoyos_atenc_prev_emerg_desast.id_unidad_militar = :idUnidadMilitar) AND " +
          "(:idProcesoApoyoAtencionPrevencion IS NULL OR tabla_apoyos_atenc_prev_emerg_desast.id_proceso_apoyo_atencion_prevencion = :idProcesoApoyoAtencionPrevencion) " +
          "ORDER BY CASE WHEN :orderBy = 'idApoyoAtencPrevEmergDesast' AND :orderMode = 'ASC' THEN tabla_apoyos_atenc_prev_emerg_desast.id_apoyo_atenc_prev_emerg_desast END ASC, " +
          "CASE WHEN :orderBy = 'idApoyoAtencPrevEmergDesast' AND :orderMode = 'DESC' THEN tabla_apoyos_atenc_prev_emerg_desast.id_apoyo_atenc_prev_emerg_desast END DESC, " +
          "CASE WHEN :orderBy = 'codigoRadicadoApoyoAtencPrevEmergDesast' AND :orderMode = 'ASC' THEN tabla_apoyos_atenc_prev_emerg_desast.codigo_radicado_apoyo_atenc_prev_emerg_desast END ASC, " +
          "CASE WHEN :orderBy = 'codigoRadicadoApoyoAtencPrevEmergDesast' AND :orderMode = 'DESC' THEN tabla_apoyos_atenc_prev_emerg_desast.codigo_radicado_apoyo_atenc_prev_emerg_desast END DESC, " +
          "CASE WHEN :orderBy = 'idUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_apoyos_atenc_prev_emerg_desast.id_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'idUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_apoyos_atenc_prev_emerg_desast.id_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'paisOrigenApoyoAtencPrevEmergDesast' AND :orderMode = 'ASC' THEN tabla_apoyos_atenc_prev_emerg_desast.pais_origen_apoyo_atenc_prev_emerg_desast END ASC, " +
          "CASE WHEN :orderBy = 'paisOrigenApoyoAtencPrevEmergDesast' AND :orderMode = 'DESC' THEN tabla_apoyos_atenc_prev_emerg_desast.pais_origen_apoyo_atenc_prev_emerg_desast END DESC, " +
          "CASE WHEN :orderBy = 'departamentoOEstadoOrigenApoyoAtencPrevEmergDesast' AND :orderMode = 'ASC' THEN tabla_apoyos_atenc_prev_emerg_desast.departamento_o_estado_origen_apoyo_atenc_prev_emerg_desast END ASC, " +
          "CASE WHEN :orderBy = 'departamentoOEstadoOrigenApoyoAtencPrevEmergDesast' AND :orderMode = 'DESC' THEN tabla_apoyos_atenc_prev_emerg_desast.departamento_o_estado_origen_apoyo_atenc_prev_emerg_desast END DESC, " +
          "CASE WHEN :orderBy = 'ciudadOrigenApoyoAtencPrevEmergDesast' AND :orderMode = 'ASC' THEN tabla_apoyos_atenc_prev_emerg_desast.ciudad_origen_apoyo_atenc_prev_emerg_desast END ASC, " +
          "CASE WHEN :orderBy = 'ciudadOrigenApoyoAtencPrevEmergDesast' AND :orderMode = 'DESC' THEN tabla_apoyos_atenc_prev_emerg_desast.ciudad_origen_apoyo_atenc_prev_emerg_desast END DESC, " +
          "CASE WHEN :orderBy = 'latitudApoyoAtencPrevEmergDesast' AND :orderMode = 'ASC' THEN tabla_apoyos_atenc_prev_emerg_desast.latitud_apoyo_atenc_prev_emerg_desast END ASC, " +
          "CASE WHEN :orderBy = 'latitudApoyoAtencPrevEmergDesast' AND :orderMode = 'DESC' THEN tabla_apoyos_atenc_prev_emerg_desast.latitud_apoyo_atenc_prev_emerg_desast END DESC, " +
          "CASE WHEN :orderBy = 'longitudApoyoAtencPrevEmergDesast' AND :orderMode = 'ASC' THEN tabla_apoyos_atenc_prev_emerg_desast.longitud_apoyo_atenc_prev_emerg_desast END ASC, " +
          "CASE WHEN :orderBy = 'longitudApoyoAtencPrevEmergDesast' AND :orderMode = 'DESC' THEN tabla_apoyos_atenc_prev_emerg_desast.longitud_apoyo_atenc_prev_emerg_desast END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSIniciacionApoyoAtencPrevEmergDesast' AND :orderMode = 'ASC' THEN tabla_apoyos_atenc_prev_emerg_desast.fecha_h_m_s_iniciacion_apoyo_atenc_prev_emerg_desast END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSIniciacionApoyoAtencPrevEmergDesast' AND :orderMode = 'DESC' THEN tabla_apoyos_atenc_prev_emerg_desast.fecha_h_m_s_iniciacion_apoyo_atenc_prev_emerg_desast END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSFinalizacionApoyoAtencPrevEmergDesast' AND :orderMode = 'ASC' THEN tabla_apoyos_atenc_prev_emerg_desast.fecha_h_m_s_finalizacion_apoyo_atenc_prev_emerg_desast END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSFinalizacionApoyoAtencPrevEmergDesast' AND :orderMode = 'DESC' THEN tabla_apoyos_atenc_prev_emerg_desast.fecha_h_m_s_finalizacion_apoyo_atenc_prev_emerg_desast END DESC, " +
          "CASE WHEN :orderBy = 'idTipoEntidadInstitucional' AND :orderMode = 'ASC' THEN tabla_apoyos_atenc_prev_emerg_desast.id_tipo_entidad_institucional END ASC, " +
          "CASE WHEN :orderBy = 'idTipoEntidadInstitucional' AND :orderMode = 'DESC' THEN tabla_apoyos_atenc_prev_emerg_desast.id_tipo_entidad_institucional END DESC, " +
          "CASE WHEN :orderBy = 'nombreEntidadInstitucionalSolicApoyoAtencPrevEmergDesast' AND :orderMode = 'ASC' THEN tabla_apoyos_atenc_prev_emerg_desast.nombre_entidad_institucional_solic_apoyo_atenc_prev_emerg_desast END ASC, " +
          "CASE WHEN :orderBy = 'nombreEntidadInstitucionalSolicApoyoAtencPrevEmergDesast' AND :orderMode = 'DESC' THEN tabla_apoyos_atenc_prev_emerg_desast.nombre_entidad_institucional_solic_apoyo_atenc_prev_emerg_desast END DESC, " +
          "CASE WHEN :orderBy = 'idTipoRequerimientoApoyoAtencionPrevencion' AND :orderMode = 'ASC' THEN tabla_apoyos_atenc_prev_emerg_desast.id_tipo_requerimiento_apoyo_atencion_prevencion END ASC, " +
          "CASE WHEN :orderBy = 'idTipoRequerimientoApoyoAtencionPrevencion' AND :orderMode = 'DESC' THEN tabla_apoyos_atenc_prev_emerg_desast.id_tipo_requerimiento_apoyo_atencion_prevencion END DESC, " +
          "CASE WHEN :orderBy = 'idProcesoApoyoAtencionPrevencion' AND :orderMode = 'ASC' THEN tabla_apoyos_atenc_prev_emerg_desast.id_proceso_apoyo_atencion_prevencion END ASC, " +
          "CASE WHEN :orderBy = 'idProcesoApoyoAtencionPrevencion' AND :orderMode = 'DESC' THEN tabla_apoyos_atenc_prev_emerg_desast.id_proceso_apoyo_atencion_prevencion END DESC, " +
          "CASE WHEN :orderBy = 'codigoRadicadoTipoRequerimientoApoyoAtencionPrevencion' AND :orderMode = 'ASC' THEN tabla_apoyos_atenc_prev_emerg_desast.codigo_radicado_tipo_requerimiento_apoyo_atencion_prevencion END ASC, " +
          "CASE WHEN :orderBy = 'codigoRadicadoTipoRequerimientoApoyoAtencionPrevencion' AND :orderMode = 'DESC' THEN tabla_apoyos_atenc_prev_emerg_desast.codigo_radicado_tipo_requerimiento_apoyo_atencion_prevencion END DESC, " +
          "CASE WHEN :orderBy = 'idTipoEventoApoyoRealizado' AND :orderMode = 'ASC' THEN tabla_apoyos_atenc_prev_emerg_desast.id_tipo_evento_apoyo_realizado END ASC, " +
          "CASE WHEN :orderBy = 'idTipoEventoApoyoRealizado' AND :orderMode = 'DESC' THEN tabla_apoyos_atenc_prev_emerg_desast.id_tipo_evento_apoyo_realizado END DESC, " +
          "CASE WHEN :orderBy = 'numeroHeridosRequerimientoApoyoAtencionPrevencion' AND :orderMode = 'ASC' THEN tabla_apoyos_atenc_prev_emerg_desast.numero_heridos_requerimiento_apoyo_atencion_prevencion END ASC, " +
          "CASE WHEN :orderBy = 'numeroHeridosRequerimientoApoyoAtencionPrevencion' AND :orderMode = 'DESC' THEN tabla_apoyos_atenc_prev_emerg_desast.numero_heridos_requerimiento_apoyo_atencion_prevencion END DESC, " +
          "CASE WHEN :orderBy = 'numeroMuertosRequerimientoApoyoAtencionPrevencion' AND :orderMode = 'ASC' THEN tabla_apoyos_atenc_prev_emerg_desast.numero_muertos_requerimiento_apoyo_atencion_prevencion END ASC, " +
          "CASE WHEN :orderBy = 'numeroMuertosRequerimientoApoyoAtencionPrevencion' AND :orderMode = 'DESC' THEN tabla_apoyos_atenc_prev_emerg_desast.numero_muertos_requerimiento_apoyo_atencion_prevencion END DESC, " +
          "CASE WHEN :orderBy = 'numeroDesaparecidosRequerimientoApoyoAtencionPrevencion' AND :orderMode = 'ASC' THEN tabla_apoyos_atenc_prev_emerg_desast.numero_desaparecidos_requerimiento_apoyo_atencion_prevencion END ASC, " +
          "CASE WHEN :orderBy = 'numeroDesaparecidosRequerimientoApoyoAtencionPrevencion' AND :orderMode = 'DESC' THEN tabla_apoyos_atenc_prev_emerg_desast.numero_desaparecidos_requerimiento_apoyo_atencion_prevencion END DESC, " +
          "CASE WHEN :orderBy = 'numeroViviendasAfectadasRequerimientoApoyoAtencionPrevencion' AND :orderMode = 'ASC' THEN tabla_apoyos_atenc_prev_emerg_desast.numero_viviendas_afectadas_requerimiento_apoyo_atencion_prevencion END ASC, " +
          "CASE WHEN :orderBy = 'numeroViviendasAfectadasRequerimientoApoyoAtencionPrevencion' AND :orderMode = 'DESC' THEN tabla_apoyos_atenc_prev_emerg_desast.numero_viviendas_afectadas_requerimiento_apoyo_atencion_prevencion END DESC, " +
          "CASE WHEN :orderBy = 'numeroPuentesAfectadosRequerimientoApoyoAtencionPrevencion' AND :orderMode = 'ASC' THEN tabla_apoyos_atenc_prev_emerg_desast.numero_puentes_afectados_requerimiento_apoyo_atencion_prevencion END ASC, " +
          "CASE WHEN :orderBy = 'numeroPuentesAfectadosRequerimientoApoyoAtencionPrevencion' AND :orderMode = 'DESC' THEN tabla_apoyos_atenc_prev_emerg_desast.numero_puentes_afectados_requerimiento_apoyo_atencion_prevencion END DESC, " +
          "CASE WHEN :orderBy = 'numeroViasAfectadasRequerimientoApoyoAtencionPrevencion' AND :orderMode = 'ASC' THEN tabla_apoyos_atenc_prev_emerg_desast.numero_vias_afectadas_requerimiento_apoyo_atencion_prevencion END ASC, " +
          "CASE WHEN :orderBy = 'numeroViasAfectadasRequerimientoApoyoAtencionPrevencion' AND :orderMode = 'DESC' THEN tabla_apoyos_atenc_prev_emerg_desast.numero_vias_afectadas_requerimiento_apoyo_atencion_prevencion END DESC, " +
          "CASE WHEN :orderBy = 'numeroHectareasAfectadasRequerimientoApoyoAtencionPrevencion' AND :orderMode = 'ASC' THEN tabla_apoyos_atenc_prev_emerg_desast.numero_hectareas_afectadas_requerimiento_apoyo_atencion_prevencion END ASC, " +
          "CASE WHEN :orderBy = 'numeroHectareasAfectadasRequerimientoApoyoAtencionPrevencion' AND :orderMode = 'DESC' THEN tabla_apoyos_atenc_prev_emerg_desast.numero_hectareas_afectadas_requerimiento_apoyo_atencion_prevencion END DESC", nativeQuery = true)
    List<ApoyoAtencPrevEmergDesast> findAllApoyosAtencPrevEmergDesast(@Param("idApoyoAtencPrevEmergDesast") Long idApoyoAtencPrevEmergDesast, @Param("keyword") String keyword, @Param("idUnidadMilitar") Long idUnidadMilitar, @Param("idProcesoApoyoAtencionPrevencion") Long idProcesoApoyoAtencionPrevencion, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_apoyos_atenc_prev_emerg_desast.* FROM tabla_apoyos_atenc_prev_emerg_desast " +
          "WHERE (:idApoyoAtencPrevEmergDesast IS NULL OR tabla_apoyos_atenc_prev_emerg_desast.id_apoyo_atenc_prev_emerg_desast = :idApoyoAtencPrevEmergDesast) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_apoyos_atenc_prev_emerg_desast.codigo_radicado_apoyo_atenc_prev_emerg_desast) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_apoyos_atenc_prev_emerg_desast.nombre_entidad_institucional_solic_apoyo_atenc_prev_emerg_desast) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:idUnidadMilitar IS NULL OR tabla_apoyos_atenc_prev_emerg_desast.id_unidad_militar = :idUnidadMilitar) AND " +
          "(:idProcesoApoyoAtencionPrevencion IS NULL OR tabla_apoyos_atenc_prev_emerg_desast.id_proceso_apoyo_atencion_prevencion = :idProcesoApoyoAtencionPrevencion) " +
          "ORDER BY CASE WHEN :orderBy = 'idApoyoAtencPrevEmergDesast' AND :orderMode = 'ASC' THEN tabla_apoyos_atenc_prev_emerg_desast.id_apoyo_atenc_prev_emerg_desast END ASC, " +
          "CASE WHEN :orderBy = 'idApoyoAtencPrevEmergDesast' AND :orderMode = 'DESC' THEN tabla_apoyos_atenc_prev_emerg_desast.id_apoyo_atenc_prev_emerg_desast END DESC, " +
          "CASE WHEN :orderBy = 'codigoRadicadoApoyoAtencPrevEmergDesast' AND :orderMode = 'ASC' THEN tabla_apoyos_atenc_prev_emerg_desast.codigo_radicado_apoyo_atenc_prev_emerg_desast END ASC, " +
          "CASE WHEN :orderBy = 'codigoRadicadoApoyoAtencPrevEmergDesast' AND :orderMode = 'DESC' THEN tabla_apoyos_atenc_prev_emerg_desast.codigo_radicado_apoyo_atenc_prev_emerg_desast END DESC, " +
          "CASE WHEN :orderBy = 'idUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_apoyos_atenc_prev_emerg_desast.id_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'idUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_apoyos_atenc_prev_emerg_desast.id_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'paisOrigenApoyoAtencPrevEmergDesast' AND :orderMode = 'ASC' THEN tabla_apoyos_atenc_prev_emerg_desast.pais_origen_apoyo_atenc_prev_emerg_desast END ASC, " +
          "CASE WHEN :orderBy = 'paisOrigenApoyoAtencPrevEmergDesast' AND :orderMode = 'DESC' THEN tabla_apoyos_atenc_prev_emerg_desast.pais_origen_apoyo_atenc_prev_emerg_desast END DESC, " +
          "CASE WHEN :orderBy = 'departamentoOEstadoOrigenApoyoAtencPrevEmergDesast' AND :orderMode = 'ASC' THEN tabla_apoyos_atenc_prev_emerg_desast.departamento_o_estado_origen_apoyo_atenc_prev_emerg_desast END ASC, " +
          "CASE WHEN :orderBy = 'departamentoOEstadoOrigenApoyoAtencPrevEmergDesast' AND :orderMode = 'DESC' THEN tabla_apoyos_atenc_prev_emerg_desast.departamento_o_estado_origen_apoyo_atenc_prev_emerg_desast END DESC, " +
          "CASE WHEN :orderBy = 'ciudadOrigenApoyoAtencPrevEmergDesast' AND :orderMode = 'ASC' THEN tabla_apoyos_atenc_prev_emerg_desast.ciudad_origen_apoyo_atenc_prev_emerg_desast END ASC, " +
          "CASE WHEN :orderBy = 'ciudadOrigenApoyoAtencPrevEmergDesast' AND :orderMode = 'DESC' THEN tabla_apoyos_atenc_prev_emerg_desast.ciudad_origen_apoyo_atenc_prev_emerg_desast END DESC, " +
          "CASE WHEN :orderBy = 'latitudApoyoAtencPrevEmergDesast' AND :orderMode = 'ASC' THEN tabla_apoyos_atenc_prev_emerg_desast.latitud_apoyo_atenc_prev_emerg_desast END ASC, " +
          "CASE WHEN :orderBy = 'latitudApoyoAtencPrevEmergDesast' AND :orderMode = 'DESC' THEN tabla_apoyos_atenc_prev_emerg_desast.latitud_apoyo_atenc_prev_emerg_desast END DESC, " +
          "CASE WHEN :orderBy = 'longitudApoyoAtencPrevEmergDesast' AND :orderMode = 'ASC' THEN tabla_apoyos_atenc_prev_emerg_desast.longitud_apoyo_atenc_prev_emerg_desast END ASC, " +
          "CASE WHEN :orderBy = 'longitudApoyoAtencPrevEmergDesast' AND :orderMode = 'DESC' THEN tabla_apoyos_atenc_prev_emerg_desast.longitud_apoyo_atenc_prev_emerg_desast END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSIniciacionApoyoAtencPrevEmergDesast' AND :orderMode = 'ASC' THEN tabla_apoyos_atenc_prev_emerg_desast.fecha_h_m_s_iniciacion_apoyo_atenc_prev_emerg_desast END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSIniciacionApoyoAtencPrevEmergDesast' AND :orderMode = 'DESC' THEN tabla_apoyos_atenc_prev_emerg_desast.fecha_h_m_s_iniciacion_apoyo_atenc_prev_emerg_desast END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSFinalizacionApoyoAtencPrevEmergDesast' AND :orderMode = 'ASC' THEN tabla_apoyos_atenc_prev_emerg_desast.fecha_h_m_s_finalizacion_apoyo_atenc_prev_emerg_desast END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSFinalizacionApoyoAtencPrevEmergDesast' AND :orderMode = 'DESC' THEN tabla_apoyos_atenc_prev_emerg_desast.fecha_h_m_s_finalizacion_apoyo_atenc_prev_emerg_desast END DESC, " +
          "CASE WHEN :orderBy = 'idTipoEntidadInstitucional' AND :orderMode = 'ASC' THEN tabla_apoyos_atenc_prev_emerg_desast.id_tipo_entidad_institucional END ASC, " +
          "CASE WHEN :orderBy = 'idTipoEntidadInstitucional' AND :orderMode = 'DESC' THEN tabla_apoyos_atenc_prev_emerg_desast.id_tipo_entidad_institucional END DESC, " +
          "CASE WHEN :orderBy = 'nombreEntidadInstitucionalSolicApoyoAtencPrevEmergDesast' AND :orderMode = 'ASC' THEN tabla_apoyos_atenc_prev_emerg_desast.nombre_entidad_institucional_solic_apoyo_atenc_prev_emerg_desast END ASC, " +
          "CASE WHEN :orderBy = 'nombreEntidadInstitucionalSolicApoyoAtencPrevEmergDesast' AND :orderMode = 'DESC' THEN tabla_apoyos_atenc_prev_emerg_desast.nombre_entidad_institucional_solic_apoyo_atenc_prev_emerg_desast END DESC, " +
          "CASE WHEN :orderBy = 'idTipoRequerimientoApoyoAtencionPrevencion' AND :orderMode = 'ASC' THEN tabla_apoyos_atenc_prev_emerg_desast.id_tipo_requerimiento_apoyo_atencion_prevencion END ASC, " +
          "CASE WHEN :orderBy = 'idTipoRequerimientoApoyoAtencionPrevencion' AND :orderMode = 'DESC' THEN tabla_apoyos_atenc_prev_emerg_desast.id_tipo_requerimiento_apoyo_atencion_prevencion END DESC, " +
          "CASE WHEN :orderBy = 'idProcesoApoyoAtencionPrevencion' AND :orderMode = 'ASC' THEN tabla_apoyos_atenc_prev_emerg_desast.id_proceso_apoyo_atencion_prevencion END ASC, " +
          "CASE WHEN :orderBy = 'idProcesoApoyoAtencionPrevencion' AND :orderMode = 'DESC' THEN tabla_apoyos_atenc_prev_emerg_desast.id_proceso_apoyo_atencion_prevencion END DESC, " +
          "CASE WHEN :orderBy = 'codigoRadicadoTipoRequerimientoApoyoAtencionPrevencion' AND :orderMode = 'ASC' THEN tabla_apoyos_atenc_prev_emerg_desast.codigo_radicado_tipo_requerimiento_apoyo_atencion_prevencion END ASC, " +
          "CASE WHEN :orderBy = 'codigoRadicadoTipoRequerimientoApoyoAtencionPrevencion' AND :orderMode = 'DESC' THEN tabla_apoyos_atenc_prev_emerg_desast.codigo_radicado_tipo_requerimiento_apoyo_atencion_prevencion END DESC, " +
          "CASE WHEN :orderBy = 'idTipoEventoApoyoRealizado' AND :orderMode = 'ASC' THEN tabla_apoyos_atenc_prev_emerg_desast.id_tipo_evento_apoyo_realizado END ASC, " +
          "CASE WHEN :orderBy = 'idTipoEventoApoyoRealizado' AND :orderMode = 'DESC' THEN tabla_apoyos_atenc_prev_emerg_desast.id_tipo_evento_apoyo_realizado END DESC, " +
          "CASE WHEN :orderBy = 'numeroHeridosRequerimientoApoyoAtencionPrevencion' AND :orderMode = 'ASC' THEN tabla_apoyos_atenc_prev_emerg_desast.numero_heridos_requerimiento_apoyo_atencion_prevencion END ASC, " +
          "CASE WHEN :orderBy = 'numeroHeridosRequerimientoApoyoAtencionPrevencion' AND :orderMode = 'DESC' THEN tabla_apoyos_atenc_prev_emerg_desast.numero_heridos_requerimiento_apoyo_atencion_prevencion END DESC, " +
          "CASE WHEN :orderBy = 'numeroMuertosRequerimientoApoyoAtencionPrevencion' AND :orderMode = 'ASC' THEN tabla_apoyos_atenc_prev_emerg_desast.numero_muertos_requerimiento_apoyo_atencion_prevencion END ASC, " +
          "CASE WHEN :orderBy = 'numeroMuertosRequerimientoApoyoAtencionPrevencion' AND :orderMode = 'DESC' THEN tabla_apoyos_atenc_prev_emerg_desast.numero_muertos_requerimiento_apoyo_atencion_prevencion END DESC, " +
          "CASE WHEN :orderBy = 'numeroDesaparecidosRequerimientoApoyoAtencionPrevencion' AND :orderMode = 'ASC' THEN tabla_apoyos_atenc_prev_emerg_desast.numero_desaparecidos_requerimiento_apoyo_atencion_prevencion END ASC, " +
          "CASE WHEN :orderBy = 'numeroDesaparecidosRequerimientoApoyoAtencionPrevencion' AND :orderMode = 'DESC' THEN tabla_apoyos_atenc_prev_emerg_desast.numero_desaparecidos_requerimiento_apoyo_atencion_prevencion END DESC, " +
          "CASE WHEN :orderBy = 'numeroViviendasAfectadasRequerimientoApoyoAtencionPrevencion' AND :orderMode = 'ASC' THEN tabla_apoyos_atenc_prev_emerg_desast.numero_viviendas_afectadas_requerimiento_apoyo_atencion_prevencion END ASC, " +
          "CASE WHEN :orderBy = 'numeroViviendasAfectadasRequerimientoApoyoAtencionPrevencion' AND :orderMode = 'DESC' THEN tabla_apoyos_atenc_prev_emerg_desast.numero_viviendas_afectadas_requerimiento_apoyo_atencion_prevencion END DESC, " +
          "CASE WHEN :orderBy = 'numeroPuentesAfectadosRequerimientoApoyoAtencionPrevencion' AND :orderMode = 'ASC' THEN tabla_apoyos_atenc_prev_emerg_desast.numero_puentes_afectados_requerimiento_apoyo_atencion_prevencion END ASC, " +
          "CASE WHEN :orderBy = 'numeroPuentesAfectadosRequerimientoApoyoAtencionPrevencion' AND :orderMode = 'DESC' THEN tabla_apoyos_atenc_prev_emerg_desast.numero_puentes_afectados_requerimiento_apoyo_atencion_prevencion END DESC, " +
          "CASE WHEN :orderBy = 'numeroViasAfectadasRequerimientoApoyoAtencionPrevencion' AND :orderMode = 'ASC' THEN tabla_apoyos_atenc_prev_emerg_desast.numero_vias_afectadas_requerimiento_apoyo_atencion_prevencion END ASC, " +
          "CASE WHEN :orderBy = 'numeroViasAfectadasRequerimientoApoyoAtencionPrevencion' AND :orderMode = 'DESC' THEN tabla_apoyos_atenc_prev_emerg_desast.numero_vias_afectadas_requerimiento_apoyo_atencion_prevencion END DESC, " +
          "CASE WHEN :orderBy = 'numeroHectareasAfectadasRequerimientoApoyoAtencionPrevencion' AND :orderMode = 'ASC' THEN tabla_apoyos_atenc_prev_emerg_desast.numero_hectareas_afectadas_requerimiento_apoyo_atencion_prevencion END ASC, " +
          "CASE WHEN :orderBy = 'numeroHectareasAfectadasRequerimientoApoyoAtencionPrevencion' AND :orderMode = 'DESC' THEN tabla_apoyos_atenc_prev_emerg_desast.numero_hectareas_afectadas_requerimiento_apoyo_atencion_prevencion END DESC", nativeQuery = true)
    Slice<ApoyoAtencPrevEmergDesast> findAllApoyosAtencPrevEmergDesastPag(Pageable pageable, @Param("idApoyoAtencPrevEmergDesast") Long idApoyoAtencPrevEmergDesast, @Param("keyword") String keyword, @Param("idUnidadMilitar") Long idUnidadMilitar, @Param("idProcesoApoyoAtencionPrevencion") Long idProcesoApoyoAtencionPrevencion, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<ApoyoAtencPrevEmergDesast> findByIdApoyoAtencPrevEmergDesast(Long idApoyoAtencPrevEmergDesast);
    
    //BUSQUEDA UNITARIA POR CAMPO ÚNICO (CODIGO RADICADO):
    ApoyoAtencPrevEmergDesast findByCodigoRadicadoApoyoAtencPrevEmergDesast(String codigoRadicadoApoyoAtencPrevEmergDesast);
    
    @Query(value = "SELECT MAX(id_apoyo_atenc_prev_emerg_desast) FROM tabla_apoyos_atenc_prev_emerg_desast", nativeQuery = true)
    Long findMaxIdApoyoAtencPrevEmergDesast();
}
