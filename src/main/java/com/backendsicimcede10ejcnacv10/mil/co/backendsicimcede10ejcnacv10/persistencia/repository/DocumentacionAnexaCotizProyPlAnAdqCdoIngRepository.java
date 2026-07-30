//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.DocumentacionAnexaCotizProyPlAnAdqCdoIng;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 08/04/2026.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface DocumentacionAnexaCotizProyPlAnAdqCdoIngRepository extends JpaRepository<DocumentacionAnexaCotizProyPlAnAdqCdoIng, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (ID DOC + KEYWORD + ID PROYECCION PLAN ANUAL ADQ CDO ING + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_documentacion_anexas_cotiz_proy_pl_an_adq_cdos_ing, tabla_proyecciones_planes_anuales_adq_cdos_ing " +
          "WHERE (:idDocumentacionAnexaCotizProyPlAnAdqCdoIng IS NULL OR tabla_documentacion_anexas_cotiz_proy_pl_an_adq_cdos_ing.id_documentacion_anexa_cotiz_proy_pl_an_adq_cdo_ing = :idDocumentacionAnexaCotizProyPlAnAdqCdoIng) AND " +
          "(tabla_documentacion_anexas_cotiz_proy_pl_an_adq_cdos_ing.id_proyeccion_plan_anual_adq_cdo_ing = tabla_proyecciones_planes_anuales_adq_cdos_ing.id_proyeccion_plan_anual_adq_cdo_ing) AND " +
          "(:keyword IS NULL OR UPPER(tabla_documentacion_anexas_cotiz_proy_pl_an_adq_cdos_ing.nombre_documento_anexo_cotiz_proy_pl_an_adq_cdo_ing) LIKE UPPER('%'||:keyword||'%')) AND " +
          "(:idProyeccionPlanAnualAdqCdoIng IS NULL OR tabla_proyecciones_planes_anuales_adq_cdos_ing.id_proyeccion_plan_anual_adq_cdo_ing = :idProyeccionPlanAnualAdqCdoIng)", nativeQuery = true)
    Long findTotalRegistros(@Param("idDocumentacionAnexaCotizProyPlAnAdqCdoIng") Long idDocumentacionAnexaCotizProyPlAnAdqCdoIng, @Param("keyword") String keyword, @Param("idProyeccionPlanAnualAdqCdoIng") Long idProyeccionPlanAnualAdqCdoIng);
    
    @Query(value = "SELECT tabla_documentacion_anexas_cotiz_proy_pl_an_adq_cdos_ing.* FROM tabla_documentacion_anexas_cotiz_proy_pl_an_adq_cdos_ing, tabla_proyecciones_planes_anuales_adq_cdos_ing " +
          "WHERE (:idDocumentacionAnexaCotizProyPlAnAdqCdoIng IS NULL OR tabla_documentacion_anexas_cotiz_proy_pl_an_adq_cdos_ing.id_documentacion_anexa_cotiz_proy_pl_an_adq_cdo_ing = :idDocumentacionAnexaCotizProyPlAnAdqCdoIng) AND " +
          "(tabla_documentacion_anexas_cotiz_proy_pl_an_adq_cdos_ing.id_proyeccion_plan_anual_adq_cdo_ing = tabla_proyecciones_planes_anuales_adq_cdos_ing.id_proyeccion_plan_anual_adq_cdo_ing) AND " +
          "(:keyword IS NULL OR UPPER(tabla_documentacion_anexas_cotiz_proy_pl_an_adq_cdos_ing.nombre_documento_anexo_cotiz_proy_pl_an_adq_cdo_ing) LIKE UPPER('%'||:keyword||'%')) AND " +
          "(:idProyeccionPlanAnualAdqCdoIng IS NULL OR tabla_proyecciones_planes_anuales_adq_cdos_ing.id_proyeccion_plan_anual_adq_cdo_ing = :idProyeccionPlanAnualAdqCdoIng) " +
          "ORDER BY CASE WHEN :orderBy = 'idDocumentacionAnexaCotizProyPlAnAdqCdoIng' AND :orderMode = 'ASC' THEN tabla_documentacion_anexas_cotiz_proy_pl_an_adq_cdos_ing.id_documentacion_anexa_cotiz_proy_pl_an_adq_cdo_ing END ASC, " +
          "CASE WHEN :orderBy = 'idDocumentacionAnexaCotizProyPlAnAdqCdoIng' AND :orderMode = 'DESC' THEN tabla_documentacion_anexas_cotiz_proy_pl_an_adq_cdos_ing.id_documentacion_anexa_cotiz_proy_pl_an_adq_cdo_ing END DESC, " +
          "CASE WHEN :orderBy = 'nombreDocumentoAnexoCotizProyPlAnAdqCdoIng' AND :orderMode = 'ASC' THEN tabla_documentacion_anexas_cotiz_proy_pl_an_adq_cdos_ing.nombre_documento_anexo_cotiz_proy_pl_an_adq_cdo_ing END ASC, " +
          "CASE WHEN :orderBy = 'nombreDocumentoAnexoCotizProyPlAnAdqCdoIng' AND :orderMode = 'DESC' THEN tabla_documentacion_anexas_cotiz_proy_pl_an_adq_cdos_ing.nombre_documento_anexo_cotiz_proy_pl_an_adq_cdo_ing END DESC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoCotizProyPlAnAdqCdoIng' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_documentacion_anexas_cotiz_proy_pl_an_adq_cdos_ing.nombre_archivo_documento_anexo_cotiz_proy_pl_an_adq_cdo_ing, 4000, 1) END ASC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoCotizProyPlAnAdqCdoIng' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_documentacion_anexas_cotiz_proy_pl_an_adq_cdos_ing.nombre_archivo_documento_anexo_cotiz_proy_pl_an_adq_cdo_ing, 4000, 1) END DESC", nativeQuery = true)
    List<DocumentacionAnexaCotizProyPlAnAdqCdoIng> findAllDocumentacionesAnexasCotizProyPlAnAdqCdoIng(@Param("idDocumentacionAnexaCotizProyPlAnAdqCdoIng") Long idDocumentacionAnexaCotizProyPlAnAdqCdoIng, @Param("keyword") String keyword, @Param("idProyeccionPlanAnualAdqCdoIng") Long idProyeccionPlanAnualAdqCdoIng, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_documentacion_anexas_cotiz_proy_pl_an_adq_cdos_ing.* FROM tabla_documentacion_anexas_cotiz_proy_pl_an_adq_cdos_ing, tabla_proyecciones_planes_anuales_adq_cdos_ing " +
          "WHERE (:idDocumentacionAnexaCotizProyPlAnAdqCdoIng IS NULL OR tabla_documentacion_anexas_cotiz_proy_pl_an_adq_cdos_ing.id_documentacion_anexa_cotiz_proy_pl_an_adq_cdo_ing = :idDocumentacionAnexaCotizProyPlAnAdqCdoIng) AND " +
          "(tabla_documentacion_anexas_cotiz_proy_pl_an_adq_cdos_ing.id_proyeccion_plan_anual_adq_cdo_ing = tabla_proyecciones_planes_anuales_adq_cdos_ing.id_proyeccion_plan_anual_adq_cdo_ing) AND " +
          "(:keyword IS NULL OR UPPER(tabla_documentacion_anexas_cotiz_proy_pl_an_adq_cdos_ing.nombre_documento_anexo_cotiz_proy_pl_an_adq_cdo_ing) LIKE UPPER('%'||:keyword||'%')) AND " +
          "(:idProyeccionPlanAnualAdqCdoIng IS NULL OR tabla_proyecciones_planes_anuales_adq_cdos_ing.id_proyeccion_plan_anual_adq_cdo_ing = :idProyeccionPlanAnualAdqCdoIng) " +
          "ORDER BY CASE WHEN :orderBy = 'idDocumentacionAnexaCotizProyPlAnAdqCdoIng' AND :orderMode = 'ASC' THEN tabla_documentacion_anexas_cotiz_proy_pl_an_adq_cdos_ing.id_documentacion_anexa_cotiz_proy_pl_an_adq_cdo_ing END ASC, " +
          "CASE WHEN :orderBy = 'idDocumentacionAnexaCotizProyPlAnAdqCdoIng' AND :orderMode = 'DESC' THEN tabla_documentacion_anexas_cotiz_proy_pl_an_adq_cdos_ing.id_documentacion_anexa_cotiz_proy_pl_an_adq_cdo_ing END DESC, " +
          "CASE WHEN :orderBy = 'nombreDocumentoAnexoCotizProyPlAnAdqCdoIng' AND :orderMode = 'ASC' THEN tabla_documentacion_anexas_cotiz_proy_pl_an_adq_cdos_ing.nombre_documento_anexo_cotiz_proy_pl_an_adq_cdo_ing END ASC, " +
          "CASE WHEN :orderBy = 'nombreDocumentoAnexoCotizProyPlAnAdqCdoIng' AND :orderMode = 'DESC' THEN tabla_documentacion_anexas_cotiz_proy_pl_an_adq_cdos_ing.nombre_documento_anexo_cotiz_proy_pl_an_adq_cdo_ing END DESC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoCotizProyPlAnAdqCdoIng' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_documentacion_anexas_cotiz_proy_pl_an_adq_cdos_ing.nombre_archivo_documento_anexo_cotiz_proy_pl_an_adq_cdo_ing, 4000, 1) END ASC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoCotizProyPlAnAdqCdoIng' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_documentacion_anexas_cotiz_proy_pl_an_adq_cdos_ing.nombre_archivo_documento_anexo_cotiz_proy_pl_an_adq_cdo_ing, 4000, 1) END DESC", nativeQuery = true)
    Slice<DocumentacionAnexaCotizProyPlAnAdqCdoIng> findAllDocumentacionesAnexasCotizProyPlAnAdqCdoIngPag(Pageable pageable, @Param("idDocumentacionAnexaCotizProyPlAnAdqCdoIng") Long idDocumentacionAnexaCotizProyPlAnAdqCdoIng, @Param("keyword") String keyword, @Param("idProyeccionPlanAnualAdqCdoIng") Long idProyeccionPlanAnualAdqCdoIng, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<DocumentacionAnexaCotizProyPlAnAdqCdoIng> findByIdDocumentacionAnexaCotizProyPlAnAdqCdoIng(Long idDocumentacionAnexaCotizProyPlAnAdqCdoIng);
    
    //BUSQUEDA UNITARIA POR NOMBRE Y ID PROYECCION PLAN ANUAL ADQ CDO ING (PARA VALIDACIÓN DE DUPLICADOS):
    @Query(value = "SELECT * FROM tabla_documentacion_anexas_cotiz_proy_pl_an_adq_cdos_ing " +
          "WHERE (UPPER(nombre_documento_anexo_cotiz_proy_pl_an_adq_cdo_ing) = :nombreDocumentoAnexoCotizProyPlAnAdqCdoIng) AND " +
          "(id_proyeccion_plan_anual_adq_cdo_ing = :idProyeccionPlanAnualAdqCdoIng) AND ROWNUM = 1", nativeQuery = true)
    DocumentacionAnexaCotizProyPlAnAdqCdoIng findByNombreAndIdProyeccionPlanAnualAdqCdoIng(@Param("nombreDocumentoAnexoCotizProyPlAnAdqCdoIng") String nombreDocumentoAnexoCotizProyPlAnAdqCdoIng, @Param("idProyeccionPlanAnualAdqCdoIng") Long idProyeccionPlanAnualAdqCdoIng);
    
    @Query(value = "SELECT MAX(id_documentacion_anexa_cotiz_proy_pl_an_adq_cdo_ing) FROM tabla_documentacion_anexas_cotiz_proy_pl_an_adq_cdos_ing", nativeQuery = true)
    Long findMaxIdDocumentacionAnexaCotizProyPlAnAdqCdoIng();
}
