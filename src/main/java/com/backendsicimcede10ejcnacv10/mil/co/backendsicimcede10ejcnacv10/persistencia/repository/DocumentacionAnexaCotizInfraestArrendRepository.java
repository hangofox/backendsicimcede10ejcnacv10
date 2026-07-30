//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.DocumentacionAnexaCotizInfraestArrend;
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
public interface DocumentacionAnexaCotizInfraestArrendRepository extends JpaRepository<DocumentacionAnexaCotizInfraestArrend, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (ID DOC + KEYWORD + ID PROYECCION PLAN ANUAL ARRENDAMIENTO + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_documentacion_anexas_cotiz_infraest_arrend, tabla_proyecciones_planes_anuales_arrendamientos " +
          "WHERE (:idDocumentacionAnexaCotizInfraestArrend IS NULL OR tabla_documentacion_anexas_cotiz_infraest_arrend.id_documentacion_anexa_cotiz_infraest_arrend = :idDocumentacionAnexaCotizInfraestArrend) AND " +
          "(tabla_documentacion_anexas_cotiz_infraest_arrend.id_proyeccion_plan_anual_arrendamiento = tabla_proyecciones_planes_anuales_arrendamientos.id_proyeccion_plan_anual_arrendamiento) AND " +
          "(:keyword IS NULL OR UPPER(tabla_documentacion_anexas_cotiz_infraest_arrend.nombre_documento_anexo_cotiz_infraest_arrend) LIKE UPPER('%'||:keyword||'%')) AND " +
          "(:idProyeccionPlanAnualArrendamiento IS NULL OR tabla_proyecciones_planes_anuales_arrendamientos.id_proyeccion_plan_anual_arrendamiento = :idProyeccionPlanAnualArrendamiento)", nativeQuery = true)
    Long findTotalRegistros(@Param("idDocumentacionAnexaCotizInfraestArrend") Long idDocumentacionAnexaCotizInfraestArrend, @Param("keyword") String keyword, @Param("idProyeccionPlanAnualArrendamiento") Long idProyeccionPlanAnualArrendamiento);
    
    @Query(value = "SELECT tabla_documentacion_anexas_cotiz_infraest_arrend.* FROM tabla_documentacion_anexas_cotiz_infraest_arrend, tabla_proyecciones_planes_anuales_arrendamientos " +
          "WHERE (:idDocumentacionAnexaCotizInfraestArrend IS NULL OR tabla_documentacion_anexas_cotiz_infraest_arrend.id_documentacion_anexa_cotiz_infraest_arrend = :idDocumentacionAnexaCotizInfraestArrend) AND " +
          "(tabla_documentacion_anexas_cotiz_infraest_arrend.id_proyeccion_plan_anual_arrendamiento = tabla_proyecciones_planes_anuales_arrendamientos.id_proyeccion_plan_anual_arrendamiento) AND " +
          "(:keyword IS NULL OR UPPER(tabla_documentacion_anexas_cotiz_infraest_arrend.nombre_documento_anexo_cotiz_infraest_arrend) LIKE UPPER('%'||:keyword||'%')) AND " +
          "(:idProyeccionPlanAnualArrendamiento IS NULL OR tabla_proyecciones_planes_anuales_arrendamientos.id_proyeccion_plan_anual_arrendamiento = :idProyeccionPlanAnualArrendamiento) " +
          "ORDER BY CASE WHEN :orderBy = 'idDocumentacionAnexaCotizInfraestArrend' AND :orderMode = 'ASC' THEN tabla_documentacion_anexas_cotiz_infraest_arrend.id_documentacion_anexa_cotiz_infraest_arrend END ASC, " +
          "CASE WHEN :orderBy = 'idDocumentacionAnexaCotizInfraestArrend' AND :orderMode = 'DESC' THEN tabla_documentacion_anexas_cotiz_infraest_arrend.id_documentacion_anexa_cotiz_infraest_arrend END DESC, " +
          "CASE WHEN :orderBy = 'nombreDocumentoAnexoCotizInfraestArrend' AND :orderMode = 'ASC' THEN tabla_documentacion_anexas_cotiz_infraest_arrend.nombre_documento_anexo_cotiz_infraest_arrend END ASC, " +
          "CASE WHEN :orderBy = 'nombreDocumentoAnexoCotizInfraestArrend' AND :orderMode = 'DESC' THEN tabla_documentacion_anexas_cotiz_infraest_arrend.nombre_documento_anexo_cotiz_infraest_arrend END DESC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoCotizInfraestArrend' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_documentacion_anexas_cotiz_infraest_arrend.nombre_archivo_documento_anexo_cotiz_infraest_arrend, 4000, 1) END ASC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoCotizInfraestArrend' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_documentacion_anexas_cotiz_infraest_arrend.nombre_archivo_documento_anexo_cotiz_infraest_arrend, 4000, 1) END DESC", nativeQuery = true)
    List<DocumentacionAnexaCotizInfraestArrend> findAllDocumentacionesAnexasCotizInfraestArrend(@Param("idDocumentacionAnexaCotizInfraestArrend") Long idDocumentacionAnexaCotizInfraestArrend, @Param("keyword") String keyword, @Param("idProyeccionPlanAnualArrendamiento") Long idProyeccionPlanAnualArrendamiento, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_documentacion_anexas_cotiz_infraest_arrend.* FROM tabla_documentacion_anexas_cotiz_infraest_arrend, tabla_proyecciones_planes_anuales_arrendamientos " +
          "WHERE (:idDocumentacionAnexaCotizInfraestArrend IS NULL OR tabla_documentacion_anexas_cotiz_infraest_arrend.id_documentacion_anexa_cotiz_infraest_arrend = :idDocumentacionAnexaCotizInfraestArrend) AND " +
          "(tabla_documentacion_anexas_cotiz_infraest_arrend.id_proyeccion_plan_anual_arrendamiento = tabla_proyecciones_planes_anuales_arrendamientos.id_proyeccion_plan_anual_arrendamiento) AND " +
          "(:keyword IS NULL OR UPPER(tabla_documentacion_anexas_cotiz_infraest_arrend.nombre_documento_anexo_cotiz_infraest_arrend) LIKE UPPER('%'||:keyword||'%')) AND " +
          "(:idProyeccionPlanAnualArrendamiento IS NULL OR tabla_proyecciones_planes_anuales_arrendamientos.id_proyeccion_plan_anual_arrendamiento = :idProyeccionPlanAnualArrendamiento) " +
          "ORDER BY CASE WHEN :orderBy = 'idDocumentacionAnexaCotizInfraestArrend' AND :orderMode = 'ASC' THEN tabla_documentacion_anexas_cotiz_infraest_arrend.id_documentacion_anexa_cotiz_infraest_arrend END ASC, " +
          "CASE WHEN :orderBy = 'idDocumentacionAnexaCotizInfraestArrend' AND :orderMode = 'DESC' THEN tabla_documentacion_anexas_cotiz_infraest_arrend.id_documentacion_anexa_cotiz_infraest_arrend END DESC, " +
          "CASE WHEN :orderBy = 'nombreDocumentoAnexoCotizInfraestArrend' AND :orderMode = 'ASC' THEN tabla_documentacion_anexas_cotiz_infraest_arrend.nombre_documento_anexo_cotiz_infraest_arrend END ASC, " +
          "CASE WHEN :orderBy = 'nombreDocumentoAnexoCotizInfraestArrend' AND :orderMode = 'DESC' THEN tabla_documentacion_anexas_cotiz_infraest_arrend.nombre_documento_anexo_cotiz_infraest_arrend END DESC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoCotizInfraestArrend' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_documentacion_anexas_cotiz_infraest_arrend.nombre_archivo_documento_anexo_cotiz_infraest_arrend, 4000, 1) END ASC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoCotizInfraestArrend' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_documentacion_anexas_cotiz_infraest_arrend.nombre_archivo_documento_anexo_cotiz_infraest_arrend, 4000, 1) END DESC", nativeQuery = true)
    Slice<DocumentacionAnexaCotizInfraestArrend> findAllDocumentacionesAnexasCotizInfraestArrendPag(Pageable pageable, @Param("idDocumentacionAnexaCotizInfraestArrend") Long idDocumentacionAnexaCotizInfraestArrend, @Param("keyword") String keyword, @Param("idProyeccionPlanAnualArrendamiento") Long idProyeccionPlanAnualArrendamiento, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<DocumentacionAnexaCotizInfraestArrend> findByIdDocumentacionAnexaCotizInfraestArrend(Long idDocumentacionAnexaCotizInfraestArrend);
    
    @Query(value = "SELECT MAX(id_documentacion_anexa_cotiz_infraest_arrend) FROM tabla_documentacion_anexas_cotiz_infraest_arrend", nativeQuery = true)
    Long findMaxIdDocumentacionAnexaCotizInfraestArrend();
}
