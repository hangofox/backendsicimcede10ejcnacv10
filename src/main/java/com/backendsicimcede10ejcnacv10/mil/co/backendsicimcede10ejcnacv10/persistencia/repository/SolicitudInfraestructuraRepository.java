//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.SolicitudInfraestructura;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 27/03/2026.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface SolicitudInfraestructuraRepository extends JpaRepository<SolicitudInfraestructura,Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (ID + KEYWORD + SIGLA O ACRONIMO UNIDAD MILITAR + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_solicitudes_infraestructuras, tabla_unidades_militares " +
          "WHERE (:idSolicitudInfraestructura IS NULL OR tabla_solicitudes_infraestructuras.id_solicitud_infraestructura = :idSolicitudInfraestructura) AND " +
          "(tabla_solicitudes_infraestructuras.id_unidad_militar = tabla_unidades_militares.id_unidad_militar) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_solicitudes_infraestructuras.codigo_radicado_solicitud_infraestructura) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_solicitudes_infraestructuras.nombre_solicitud_infraestructura) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:siglaoAcronimoUnidadMilitar IS NULL OR UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) = UPPER(:siglaoAcronimoUnidadMilitar))", nativeQuery = true)
    Long findTotalRegistros(@Param("idSolicitudInfraestructura") Long idSolicitudInfraestructura, @Param("keyword") String keyword, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar);
    
    @Query(value = "SELECT tabla_solicitudes_infraestructuras.* FROM tabla_solicitudes_infraestructuras, tabla_unidades_militares " +
          "WHERE (:idSolicitudInfraestructura IS NULL OR tabla_solicitudes_infraestructuras.id_solicitud_infraestructura = :idSolicitudInfraestructura) AND " +
          "(tabla_solicitudes_infraestructuras.id_unidad_militar = tabla_unidades_militares.id_unidad_militar) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_solicitudes_infraestructuras.codigo_radicado_solicitud_infraestructura) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_solicitudes_infraestructuras.nombre_solicitud_infraestructura) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:siglaoAcronimoUnidadMilitar IS NULL OR UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) = UPPER(:siglaoAcronimoUnidadMilitar)) " +
          "ORDER BY CASE WHEN :orderBy = 'idSolicitudInfraestructura' AND :orderMode = 'ASC' THEN tabla_solicitudes_infraestructuras.id_solicitud_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'idSolicitudInfraestructura' AND :orderMode = 'DESC' THEN tabla_solicitudes_infraestructuras.id_solicitud_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'codigoRadicadoSolicitudInfraestructura' AND :orderMode = 'ASC' THEN tabla_solicitudes_infraestructuras.codigo_radicado_solicitud_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'codigoRadicadoSolicitudInfraestructura' AND :orderMode = 'DESC' THEN tabla_solicitudes_infraestructuras.codigo_radicado_solicitud_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'idUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_solicitudes_infraestructuras.id_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'idUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_solicitudes_infraestructuras.id_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSSolicitudInfraestructura' AND :orderMode = 'ASC' THEN tabla_solicitudes_infraestructuras.fecha_h_m_s_solicitud_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSSolicitudInfraestructura' AND :orderMode = 'DESC' THEN tabla_solicitudes_infraestructuras.fecha_h_m_s_solicitud_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'idTipoSolicitudInfraestructura' AND :orderMode = 'ASC' THEN tabla_solicitudes_infraestructuras.id_tipo_solicitud_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'idTipoSolicitudInfraestructura' AND :orderMode = 'DESC' THEN tabla_solicitudes_infraestructuras.id_tipo_solicitud_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'nombreSolicitudInfraestructura' AND :orderMode = 'ASC' THEN tabla_solicitudes_infraestructuras.nombre_solicitud_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'nombreSolicitudInfraestructura' AND :orderMode = 'DESC' THEN tabla_solicitudes_infraestructuras.nombre_solicitud_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'idInfraestructura' AND :orderMode = 'ASC' THEN tabla_solicitudes_infraestructuras.id_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'idInfraestructura' AND :orderMode = 'DESC' THEN tabla_solicitudes_infraestructuras.id_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'nombreDependenciaSolicitudInfraestructura' AND :orderMode = 'ASC' THEN tabla_solicitudes_infraestructuras.nombre_dependencia_solicitud_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'nombreDependenciaSolicitudInfraestructura' AND :orderMode = 'DESC' THEN tabla_solicitudes_infraestructuras.nombre_dependencia_solicitud_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'numeroFuncionariosSolicitudInfraestructura' AND :orderMode = 'ASC' THEN tabla_solicitudes_infraestructuras.numero_funcionarios_solicitud_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'numeroFuncionariosSolicitudInfraestructura' AND :orderMode = 'DESC' THEN tabla_solicitudes_infraestructuras.numero_funcionarios_solicitud_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'numeroUsuariosSolicitudInfraestructura' AND :orderMode = 'ASC' THEN tabla_solicitudes_infraestructuras.numero_usuarios_solicitud_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'numeroUsuariosSolicitudInfraestructura' AND :orderMode = 'DESC' THEN tabla_solicitudes_infraestructuras.numero_usuarios_solicitud_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSIngresoSolicitudInfraestructura' AND :orderMode = 'ASC' THEN tabla_solicitudes_infraestructuras.fecha_h_m_s_ingreso_solicitud_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSIngresoSolicitudInfraestructura' AND :orderMode = 'DESC' THEN tabla_solicitudes_infraestructuras.fecha_h_m_s_ingreso_solicitud_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSModificacionSolicitudInfraestructura' AND :orderMode = 'ASC' THEN tabla_solicitudes_infraestructuras.fecha_h_m_s_modificacion_solicitud_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSModificacionSolicitudInfraestructura' AND :orderMode = 'DESC' THEN tabla_solicitudes_infraestructuras.fecha_h_m_s_modificacion_solicitud_infraestructura END DESC", nativeQuery = true)
    List<SolicitudInfraestructura> findAllSolicitudesInfraestructuras(@Param("idSolicitudInfraestructura") Long idSolicitudInfraestructura, @Param("keyword") String keyword, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_solicitudes_infraestructuras.* FROM tabla_solicitudes_infraestructuras, tabla_unidades_militares " +
          "WHERE (:idSolicitudInfraestructura IS NULL OR tabla_solicitudes_infraestructuras.id_solicitud_infraestructura = :idSolicitudInfraestructura) AND " +
          "(tabla_solicitudes_infraestructuras.id_unidad_militar = tabla_unidades_militares.id_unidad_militar) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_solicitudes_infraestructuras.codigo_radicado_solicitud_infraestructura) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_solicitudes_infraestructuras.nombre_solicitud_infraestructura) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:siglaoAcronimoUnidadMilitar IS NULL OR UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) = UPPER(:siglaoAcronimoUnidadMilitar)) " +
          "ORDER BY CASE WHEN :orderBy = 'idSolicitudInfraestructura' AND :orderMode = 'ASC' THEN tabla_solicitudes_infraestructuras.id_solicitud_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'idSolicitudInfraestructura' AND :orderMode = 'DESC' THEN tabla_solicitudes_infraestructuras.id_solicitud_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'codigoRadicadoSolicitudInfraestructura' AND :orderMode = 'ASC' THEN tabla_solicitudes_infraestructuras.codigo_radicado_solicitud_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'codigoRadicadoSolicitudInfraestructura' AND :orderMode = 'DESC' THEN tabla_solicitudes_infraestructuras.codigo_radicado_solicitud_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'idUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_solicitudes_infraestructuras.id_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'idUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_solicitudes_infraestructuras.id_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSSolicitudInfraestructura' AND :orderMode = 'ASC' THEN tabla_solicitudes_infraestructuras.fecha_h_m_s_solicitud_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSSolicitudInfraestructura' AND :orderMode = 'DESC' THEN tabla_solicitudes_infraestructuras.fecha_h_m_s_solicitud_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'idTipoSolicitudInfraestructura' AND :orderMode = 'ASC' THEN tabla_solicitudes_infraestructuras.id_tipo_solicitud_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'idTipoSolicitudInfraestructura' AND :orderMode = 'DESC' THEN tabla_solicitudes_infraestructuras.id_tipo_solicitud_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'nombreSolicitudInfraestructura' AND :orderMode = 'ASC' THEN tabla_solicitudes_infraestructuras.nombre_solicitud_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'nombreSolicitudInfraestructura' AND :orderMode = 'DESC' THEN tabla_solicitudes_infraestructuras.nombre_solicitud_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'idInfraestructura' AND :orderMode = 'ASC' THEN tabla_solicitudes_infraestructuras.id_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'idInfraestructura' AND :orderMode = 'DESC' THEN tabla_solicitudes_infraestructuras.id_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'nombreDependenciaSolicitudInfraestructura' AND :orderMode = 'ASC' THEN tabla_solicitudes_infraestructuras.nombre_dependencia_solicitud_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'nombreDependenciaSolicitudInfraestructura' AND :orderMode = 'DESC' THEN tabla_solicitudes_infraestructuras.nombre_dependencia_solicitud_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'numeroFuncionariosSolicitudInfraestructura' AND :orderMode = 'ASC' THEN tabla_solicitudes_infraestructuras.numero_funcionarios_solicitud_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'numeroFuncionariosSolicitudInfraestructura' AND :orderMode = 'DESC' THEN tabla_solicitudes_infraestructuras.numero_funcionarios_solicitud_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'numeroUsuariosSolicitudInfraestructura' AND :orderMode = 'ASC' THEN tabla_solicitudes_infraestructuras.numero_usuarios_solicitud_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'numeroUsuariosSolicitudInfraestructura' AND :orderMode = 'DESC' THEN tabla_solicitudes_infraestructuras.numero_usuarios_solicitud_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSIngresoSolicitudInfraestructura' AND :orderMode = 'ASC' THEN tabla_solicitudes_infraestructuras.fecha_h_m_s_ingreso_solicitud_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSIngresoSolicitudInfraestructura' AND :orderMode = 'DESC' THEN tabla_solicitudes_infraestructuras.fecha_h_m_s_ingreso_solicitud_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSModificacionSolicitudInfraestructura' AND :orderMode = 'ASC' THEN tabla_solicitudes_infraestructuras.fecha_h_m_s_modificacion_solicitud_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSModificacionSolicitudInfraestructura' AND :orderMode = 'DESC' THEN tabla_solicitudes_infraestructuras.fecha_h_m_s_modificacion_solicitud_infraestructura END DESC", nativeQuery = true)
    Slice<SolicitudInfraestructura> findAllSolicitudesInfraestructurasPag(Pageable pageable, @Param("idSolicitudInfraestructura") Long idSolicitudInfraestructura, @Param("keyword") String keyword, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<SolicitudInfraestructura> findByIdSolicitudInfraestructura(Long idSolicitudInfraestructura);
    
    //BUSQUEDA UNITARIA POR CAMPO ÚNICO (CODIGO RADICADO):
    @Query(value = "SELECT tabla_solicitudes_infraestructuras.* FROM tabla_solicitudes_infraestructuras " +
          "WHERE tabla_solicitudes_infraestructuras.codigo_radicado_solicitud_infraestructura = :codigoRadicadoSolicitudInfraestructura", nativeQuery = true)
    SolicitudInfraestructura findByCodigoRadicadoSolicitudInfraestructura(@Param("codigoRadicadoSolicitudInfraestructura") String codigoRadicadoSolicitudInfraestructura);
    
    @Query(value = "SELECT MAX(id_solicitud_infraestructura) FROM tabla_solicitudes_infraestructuras", nativeQuery = true)
    Long findMaxIdSolicitudInfraestructura();
}
