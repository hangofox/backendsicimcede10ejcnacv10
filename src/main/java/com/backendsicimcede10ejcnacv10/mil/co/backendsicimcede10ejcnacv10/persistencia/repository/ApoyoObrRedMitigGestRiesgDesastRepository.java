//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ApoyoObrRedMitigGestRiesgDesast;
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
public interface ApoyoObrRedMitigGestRiesgDesastRepository extends JpaRepository<ApoyoObrRedMitigGestRiesgDesast,Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (ID + KEYWORD + SIGLA O ACRONIMO UNIDAD MILITAR + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_apoyos_obr_red_mitig_gest_riesg_desast, tabla_unidades_militares " +
          "WHERE (:idApoyoObrRedMitigGestRiesgDesast IS NULL OR tabla_apoyos_obr_red_mitig_gest_riesg_desast.id_apoyo_obr_red_mitig_gest_riesg_desast = :idApoyoObrRedMitigGestRiesgDesast) AND " +
          "(tabla_apoyos_obr_red_mitig_gest_riesg_desast.id_unidad_militar = tabla_unidades_militares.id_unidad_militar) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_apoyos_obr_red_mitig_gest_riesg_desast.codigo_radicado_apoyo_obr_red_mitig_gest_riesg_desast) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_apoyos_obr_red_mitig_gest_riesg_desast.ciudad_origen_apoyo_obr_red_mitig_gest_riesg_desast) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:siglaoAcronimoUnidadMilitar IS NULL OR UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) = UPPER(:siglaoAcronimoUnidadMilitar))", nativeQuery = true)
    Long findTotalRegistros(@Param("idApoyoObrRedMitigGestRiesgDesast") Long idApoyoObrRedMitigGestRiesgDesast, @Param("keyword") String keyword, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar);
    
    @Query(value = "SELECT tabla_apoyos_obr_red_mitig_gest_riesg_desast.* FROM tabla_apoyos_obr_red_mitig_gest_riesg_desast, tabla_unidades_militares " +
          "WHERE (:idApoyoObrRedMitigGestRiesgDesast IS NULL OR tabla_apoyos_obr_red_mitig_gest_riesg_desast.id_apoyo_obr_red_mitig_gest_riesg_desast = :idApoyoObrRedMitigGestRiesgDesast) AND " +
          "(tabla_apoyos_obr_red_mitig_gest_riesg_desast.id_unidad_militar = tabla_unidades_militares.id_unidad_militar) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_apoyos_obr_red_mitig_gest_riesg_desast.codigo_radicado_apoyo_obr_red_mitig_gest_riesg_desast) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_apoyos_obr_red_mitig_gest_riesg_desast.ciudad_origen_apoyo_obr_red_mitig_gest_riesg_desast) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:siglaoAcronimoUnidadMilitar IS NULL OR UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) = UPPER(:siglaoAcronimoUnidadMilitar)) " +
          "ORDER BY CASE WHEN :orderBy = 'idApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.id_apoyo_obr_red_mitig_gest_riesg_desast END ASC, " +
          "CASE WHEN :orderBy = 'idApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.id_apoyo_obr_red_mitig_gest_riesg_desast END DESC, " +
          "CASE WHEN :orderBy = 'codigoRadicadoApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.codigo_radicado_apoyo_obr_red_mitig_gest_riesg_desast END ASC, " +
          "CASE WHEN :orderBy = 'codigoRadicadoApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.codigo_radicado_apoyo_obr_red_mitig_gest_riesg_desast END DESC, " +
          "CASE WHEN :orderBy = 'idUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.id_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'idUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.id_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'paisOrigenApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.pais_origen_apoyo_obr_red_mitig_gest_riesg_desast END ASC, " +
          "CASE WHEN :orderBy = 'paisOrigenApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.pais_origen_apoyo_obr_red_mitig_gest_riesg_desast END DESC, " +
          "CASE WHEN :orderBy = 'departamentoOEstadoOrigenApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.departamento_o_estado_origen_apoyo_obr_red_mitig_gest_riesg_desast END ASC, " +
          "CASE WHEN :orderBy = 'departamentoOEstadoOrigenApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.departamento_o_estado_origen_apoyo_obr_red_mitig_gest_riesg_desast END DESC, " +
          "CASE WHEN :orderBy = 'ciudadOrigenApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.ciudad_origen_apoyo_obr_red_mitig_gest_riesg_desast END ASC, " +
          "CASE WHEN :orderBy = 'ciudadOrigenApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.ciudad_origen_apoyo_obr_red_mitig_gest_riesg_desast END DESC, " +
          "CASE WHEN :orderBy = 'latitudApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.latitud_apoyo_obr_red_mitig_gest_riesg_desast END ASC, " +
          "CASE WHEN :orderBy = 'latitudApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.latitud_apoyo_obr_red_mitig_gest_riesg_desast END DESC, " +
          "CASE WHEN :orderBy = 'longitudApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.longitud_apoyo_obr_red_mitig_gest_riesg_desast END ASC, " +
          "CASE WHEN :orderBy = 'longitudApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.longitud_apoyo_obr_red_mitig_gest_riesg_desast END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSIniciacionApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.fecha_h_m_s_iniciacion_apoyo_obr_red_mitig_gest_riesg_desast END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSIniciacionApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.fecha_h_m_s_iniciacion_apoyo_obr_red_mitig_gest_riesg_desast END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSFinalizacionApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.fecha_h_m_s_finalizacion_apoyo_obr_red_mitig_gest_riesg_desast END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSFinalizacionApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.fecha_h_m_s_finalizacion_apoyo_obr_red_mitig_gest_riesg_desast END DESC, " +
          "CASE WHEN :orderBy = 'idTipoEntidadInstitucional' AND :orderMode = 'ASC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.id_tipo_entidad_institucional END ASC, " +
          "CASE WHEN :orderBy = 'idTipoEntidadInstitucional' AND :orderMode = 'DESC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.id_tipo_entidad_institucional END DESC, " +
          "CASE WHEN :orderBy = 'nombreEntidadInstitucionalSolicApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.nombre_entidad_institucional_solic_apoyo_obr_red_mitig_gest_riesg_desast END ASC, " +
          "CASE WHEN :orderBy = 'nombreEntidadInstitucionalSolicApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.nombre_entidad_institucional_solic_apoyo_obr_red_mitig_gest_riesg_desast END DESC, " +
          "CASE WHEN :orderBy = 'codigoRadicadoHrOficioAutorizacionCdoIngApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.codigo_radicado_hr_oficio_autorizacion_cdo_ing_apoyo_obr_red_mitig_gest_riesg_desast END ASC, " +
          "CASE WHEN :orderBy = 'codigoRadicadoHrOficioAutorizacionCdoIngApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.codigo_radicado_hr_oficio_autorizacion_cdo_ing_apoyo_obr_red_mitig_gest_riesg_desast END DESC, " +
          "CASE WHEN :orderBy = 'idTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.id_tipo_em_desast_gen_obr_apoyo_obr_red_mitig_gest_riesg_desast END ASC, " +
          "CASE WHEN :orderBy = 'idTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.id_tipo_em_desast_gen_obr_apoyo_obr_red_mitig_gest_riesg_desast END DESC, " +
          "CASE WHEN :orderBy = 'numeroPobBenefApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.numero_pob_benef_apoyo_obr_red_mitig_gest_riesg_desast END ASC, " +
          "CASE WHEN :orderBy = 'numeroPobBenefApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.numero_pob_benef_apoyo_obr_red_mitig_gest_riesg_desast END DESC", nativeQuery = true)
    List<ApoyoObrRedMitigGestRiesgDesast> findAllApoyosObrRedMitigGestRiesgDesast(@Param("idApoyoObrRedMitigGestRiesgDesast") Long idApoyoObrRedMitigGestRiesgDesast, @Param("keyword") String keyword, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_apoyos_obr_red_mitig_gest_riesg_desast.* FROM tabla_apoyos_obr_red_mitig_gest_riesg_desast, tabla_unidades_militares " +
          "WHERE (:idApoyoObrRedMitigGestRiesgDesast IS NULL OR tabla_apoyos_obr_red_mitig_gest_riesg_desast.id_apoyo_obr_red_mitig_gest_riesg_desast = :idApoyoObrRedMitigGestRiesgDesast) AND " +
          "(tabla_apoyos_obr_red_mitig_gest_riesg_desast.id_unidad_militar = tabla_unidades_militares.id_unidad_militar) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_apoyos_obr_red_mitig_gest_riesg_desast.codigo_radicado_apoyo_obr_red_mitig_gest_riesg_desast) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_apoyos_obr_red_mitig_gest_riesg_desast.ciudad_origen_apoyo_obr_red_mitig_gest_riesg_desast) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:siglaoAcronimoUnidadMilitar IS NULL OR UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) = UPPER(:siglaoAcronimoUnidadMilitar)) " +
          "ORDER BY CASE WHEN :orderBy = 'idApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.id_apoyo_obr_red_mitig_gest_riesg_desast END ASC, " +
          "CASE WHEN :orderBy = 'idApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.id_apoyo_obr_red_mitig_gest_riesg_desast END DESC, " +
          "CASE WHEN :orderBy = 'codigoRadicadoApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.codigo_radicado_apoyo_obr_red_mitig_gest_riesg_desast END ASC, " +
          "CASE WHEN :orderBy = 'codigoRadicadoApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.codigo_radicado_apoyo_obr_red_mitig_gest_riesg_desast END DESC, " +
          "CASE WHEN :orderBy = 'idUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.id_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'idUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.id_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'paisOrigenApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.pais_origen_apoyo_obr_red_mitig_gest_riesg_desast END ASC, " +
          "CASE WHEN :orderBy = 'paisOrigenApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.pais_origen_apoyo_obr_red_mitig_gest_riesg_desast END DESC, " +
          "CASE WHEN :orderBy = 'departamentoOEstadoOrigenApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.departamento_o_estado_origen_apoyo_obr_red_mitig_gest_riesg_desast END ASC, " +
          "CASE WHEN :orderBy = 'departamentoOEstadoOrigenApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.departamento_o_estado_origen_apoyo_obr_red_mitig_gest_riesg_desast END DESC, " +
          "CASE WHEN :orderBy = 'ciudadOrigenApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.ciudad_origen_apoyo_obr_red_mitig_gest_riesg_desast END ASC, " +
          "CASE WHEN :orderBy = 'ciudadOrigenApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.ciudad_origen_apoyo_obr_red_mitig_gest_riesg_desast END DESC, " +
          "CASE WHEN :orderBy = 'latitudApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.latitud_apoyo_obr_red_mitig_gest_riesg_desast END ASC, " +
          "CASE WHEN :orderBy = 'latitudApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.latitud_apoyo_obr_red_mitig_gest_riesg_desast END DESC, " +
          "CASE WHEN :orderBy = 'longitudApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.longitud_apoyo_obr_red_mitig_gest_riesg_desast END ASC, " +
          "CASE WHEN :orderBy = 'longitudApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.longitud_apoyo_obr_red_mitig_gest_riesg_desast END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSIniciacionApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.fecha_h_m_s_iniciacion_apoyo_obr_red_mitig_gest_riesg_desast END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSIniciacionApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.fecha_h_m_s_iniciacion_apoyo_obr_red_mitig_gest_riesg_desast END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSFinalizacionApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.fecha_h_m_s_finalizacion_apoyo_obr_red_mitig_gest_riesg_desast END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSFinalizacionApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.fecha_h_m_s_finalizacion_apoyo_obr_red_mitig_gest_riesg_desast END DESC, " +
          "CASE WHEN :orderBy = 'idTipoEntidadInstitucional' AND :orderMode = 'ASC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.id_tipo_entidad_institucional END ASC, " +
          "CASE WHEN :orderBy = 'idTipoEntidadInstitucional' AND :orderMode = 'DESC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.id_tipo_entidad_institucional END DESC, " +
          "CASE WHEN :orderBy = 'nombreEntidadInstitucionalSolicApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.nombre_entidad_institucional_solic_apoyo_obr_red_mitig_gest_riesg_desast END ASC, " +
          "CASE WHEN :orderBy = 'nombreEntidadInstitucionalSolicApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.nombre_entidad_institucional_solic_apoyo_obr_red_mitig_gest_riesg_desast END DESC, " +
          "CASE WHEN :orderBy = 'codigoRadicadoHrOficioAutorizacionCdoIngApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.codigo_radicado_hr_oficio_autorizacion_cdo_ing_apoyo_obr_red_mitig_gest_riesg_desast END ASC, " +
          "CASE WHEN :orderBy = 'codigoRadicadoHrOficioAutorizacionCdoIngApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.codigo_radicado_hr_oficio_autorizacion_cdo_ing_apoyo_obr_red_mitig_gest_riesg_desast END DESC, " +
          "CASE WHEN :orderBy = 'idTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.id_tipo_em_desast_gen_obr_apoyo_obr_red_mitig_gest_riesg_desast END ASC, " +
          "CASE WHEN :orderBy = 'idTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.id_tipo_em_desast_gen_obr_apoyo_obr_red_mitig_gest_riesg_desast END DESC, " +
          "CASE WHEN :orderBy = 'numeroPobBenefApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.numero_pob_benef_apoyo_obr_red_mitig_gest_riesg_desast END ASC, " +
          "CASE WHEN :orderBy = 'numeroPobBenefApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_apoyos_obr_red_mitig_gest_riesg_desast.numero_pob_benef_apoyo_obr_red_mitig_gest_riesg_desast END DESC", nativeQuery = true)
    Slice<ApoyoObrRedMitigGestRiesgDesast> findAllApoyosObrRedMitigGestRiesgDesastPag(Pageable pageable, @Param("idApoyoObrRedMitigGestRiesgDesast") Long idApoyoObrRedMitigGestRiesgDesast, @Param("keyword") String keyword, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<ApoyoObrRedMitigGestRiesgDesast> findByIdApoyoObrRedMitigGestRiesgDesast(Long idApoyoObrRedMitigGestRiesgDesast);
    
    //BUSQUEDA UNITARIA POR CAMPO ÚNICO (CODIGO RADICADO):
    @Query(value = "SELECT tabla_apoyos_obr_red_mitig_gest_riesg_desast.* FROM tabla_apoyos_obr_red_mitig_gest_riesg_desast " +
          "WHERE tabla_apoyos_obr_red_mitig_gest_riesg_desast.codigo_radicado_apoyo_obr_red_mitig_gest_riesg_desast = :codigoRadicadoApoyoObrRedMitigGestRiesgDesast", nativeQuery = true)
    ApoyoObrRedMitigGestRiesgDesast findByCodigoRadicadoApoyoObrRedMitigGestRiesgDesast(@Param("codigoRadicadoApoyoObrRedMitigGestRiesgDesast") String codigoRadicadoApoyoObrRedMitigGestRiesgDesast);
    
    @Query(value = "SELECT MAX(id_apoyo_obr_red_mitig_gest_riesg_desast) FROM tabla_apoyos_obr_red_mitig_gest_riesg_desast", nativeQuery = true)
    Long findMaxIdApoyoObrRedMitigGestRiesgDesast();
}
