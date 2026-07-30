//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.DocumentacionAnexaContratInfraestArrend;
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
public interface DocumentacionAnexaContratInfraestArrendRepository extends JpaRepository<DocumentacionAnexaContratInfraestArrend, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (ID DOC + KEYWORD + ID PROYECCION PLAN ANUAL ARRENDAMIENTO + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_documentacion_anexas_contrat_infraest_arrend, tabla_proyecciones_planes_anuales_arrendamientos " +
          "WHERE (:idDocumentacionAnexaContratInfraestArrend IS NULL OR tabla_documentacion_anexas_contrat_infraest_arrend.id_documentacion_anexa_contrat_infraest_arrend = :idDocumentacionAnexaContratInfraestArrend) AND " +
          "(tabla_documentacion_anexas_contrat_infraest_arrend.id_proyeccion_plan_anual_arrendamiento = tabla_proyecciones_planes_anuales_arrendamientos.id_proyeccion_plan_anual_arrendamiento) AND " +
          "(:keyword IS NULL OR UPPER(tabla_documentacion_anexas_contrat_infraest_arrend.nombre_documento_anexo_contrat_infraest_arrend) LIKE UPPER('%'||:keyword||'%')) AND " +
          "(:idProyeccionPlanAnualArrendamiento IS NULL OR tabla_proyecciones_planes_anuales_arrendamientos.id_proyeccion_plan_anual_arrendamiento = :idProyeccionPlanAnualArrendamiento)", nativeQuery = true)
    Long findTotalRegistros(@Param("idDocumentacionAnexaContratInfraestArrend") Long idDocumentacionAnexaContratInfraestArrend, @Param("keyword") String keyword, @Param("idProyeccionPlanAnualArrendamiento") Long idProyeccionPlanAnualArrendamiento);
    
    @Query(value = "SELECT tabla_documentacion_anexas_contrat_infraest_arrend.* FROM tabla_documentacion_anexas_contrat_infraest_arrend, tabla_proyecciones_planes_anuales_arrendamientos " +
          "WHERE (:idDocumentacionAnexaContratInfraestArrend IS NULL OR tabla_documentacion_anexas_contrat_infraest_arrend.id_documentacion_anexa_contrat_infraest_arrend = :idDocumentacionAnexaContratInfraestArrend) AND " +
          "(tabla_documentacion_anexas_contrat_infraest_arrend.id_proyeccion_plan_anual_arrendamiento = tabla_proyecciones_planes_anuales_arrendamientos.id_proyeccion_plan_anual_arrendamiento) AND " +
          "(:keyword IS NULL OR UPPER(tabla_documentacion_anexas_contrat_infraest_arrend.nombre_documento_anexo_contrat_infraest_arrend) LIKE UPPER('%'||:keyword||'%')) AND " +
          "(:idProyeccionPlanAnualArrendamiento IS NULL OR tabla_proyecciones_planes_anuales_arrendamientos.id_proyeccion_plan_anual_arrendamiento = :idProyeccionPlanAnualArrendamiento) " +
          "ORDER BY CASE WHEN :orderBy = 'idDocumentacionAnexaContratInfraestArrend' AND :orderMode = 'ASC' THEN tabla_documentacion_anexas_contrat_infraest_arrend.id_documentacion_anexa_contrat_infraest_arrend END ASC, " +
          "CASE WHEN :orderBy = 'idDocumentacionAnexaContratInfraestArrend' AND :orderMode = 'DESC' THEN tabla_documentacion_anexas_contrat_infraest_arrend.id_documentacion_anexa_contrat_infraest_arrend END DESC, " +
          "CASE WHEN :orderBy = 'nombreDocumentoAnexoContratInfraestArrend' AND :orderMode = 'ASC' THEN tabla_documentacion_anexas_contrat_infraest_arrend.nombre_documento_anexo_contrat_infraest_arrend END ASC, " +
          "CASE WHEN :orderBy = 'nombreDocumentoAnexoContratInfraestArrend' AND :orderMode = 'DESC' THEN tabla_documentacion_anexas_contrat_infraest_arrend.nombre_documento_anexo_contrat_infraest_arrend END DESC, " +
          "CASE WHEN :orderBy = 'valorAlquilerContratInfraestArrend' AND :orderMode = 'ASC' THEN tabla_documentacion_anexas_contrat_infraest_arrend.valor_alquiler_contrat_infraest_arrend END ASC, " +
          "CASE WHEN :orderBy = 'valorAlquilerContratInfraestArrend' AND :orderMode = 'DESC' THEN tabla_documentacion_anexas_contrat_infraest_arrend.valor_alquiler_contrat_infraest_arrend END DESC, " +
          "CASE WHEN :orderBy = 'nombreUnidadMedidaAlquilerContratInfraestArrend' AND :orderMode = 'ASC' THEN tabla_documentacion_anexas_contrat_infraest_arrend.nombre_unidad_medida_alquiler_contrat_infraest_arrend END ASC, " +
          "CASE WHEN :orderBy = 'nombreUnidadMedidaAlquilerContratInfraestArrend' AND :orderMode = 'DESC' THEN tabla_documentacion_anexas_contrat_infraest_arrend.nombre_unidad_medida_alquiler_contrat_infraest_arrend END DESC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoContratInfraestArrend' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_documentacion_anexas_contrat_infraest_arrend.nombre_archivo_documento_anexo_contrat_infraest_arrend, 4000, 1) END ASC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoContratInfraestArrend' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_documentacion_anexas_contrat_infraest_arrend.nombre_archivo_documento_anexo_contrat_infraest_arrend, 4000, 1) END DESC", nativeQuery = true)
    List<DocumentacionAnexaContratInfraestArrend> findAllDocumentacionesAnexasContratInfraestArrend(@Param("idDocumentacionAnexaContratInfraestArrend") Long idDocumentacionAnexaContratInfraestArrend, @Param("keyword") String keyword, @Param("idProyeccionPlanAnualArrendamiento") Long idProyeccionPlanAnualArrendamiento, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_documentacion_anexas_contrat_infraest_arrend.* FROM tabla_documentacion_anexas_contrat_infraest_arrend, tabla_proyecciones_planes_anuales_arrendamientos " +
          "WHERE (:idDocumentacionAnexaContratInfraestArrend IS NULL OR tabla_documentacion_anexas_contrat_infraest_arrend.id_documentacion_anexa_contrat_infraest_arrend = :idDocumentacionAnexaContratInfraestArrend) AND " +
          "(tabla_documentacion_anexas_contrat_infraest_arrend.id_proyeccion_plan_anual_arrendamiento = tabla_proyecciones_planes_anuales_arrendamientos.id_proyeccion_plan_anual_arrendamiento) AND " +
          "(:keyword IS NULL OR UPPER(tabla_documentacion_anexas_contrat_infraest_arrend.nombre_documento_anexo_contrat_infraest_arrend) LIKE UPPER('%'||:keyword||'%')) AND " +
          "(:idProyeccionPlanAnualArrendamiento IS NULL OR tabla_proyecciones_planes_anuales_arrendamientos.id_proyeccion_plan_anual_arrendamiento = :idProyeccionPlanAnualArrendamiento) " +
          "ORDER BY CASE WHEN :orderBy = 'idDocumentacionAnexaContratInfraestArrend' AND :orderMode = 'ASC' THEN tabla_documentacion_anexas_contrat_infraest_arrend.id_documentacion_anexa_contrat_infraest_arrend END ASC, " +
          "CASE WHEN :orderBy = 'idDocumentacionAnexaContratInfraestArrend' AND :orderMode = 'DESC' THEN tabla_documentacion_anexas_contrat_infraest_arrend.id_documentacion_anexa_contrat_infraest_arrend END DESC, " +
          "CASE WHEN :orderBy = 'nombreDocumentoAnexoContratInfraestArrend' AND :orderMode = 'ASC' THEN tabla_documentacion_anexas_contrat_infraest_arrend.nombre_documento_anexo_contrat_infraest_arrend END ASC, " +
          "CASE WHEN :orderBy = 'nombreDocumentoAnexoContratInfraestArrend' AND :orderMode = 'DESC' THEN tabla_documentacion_anexas_contrat_infraest_arrend.nombre_documento_anexo_contrat_infraest_arrend END DESC, " +
          "CASE WHEN :orderBy = 'valorAlquilerContratInfraestArrend' AND :orderMode = 'ASC' THEN tabla_documentacion_anexas_contrat_infraest_arrend.valor_alquiler_contrat_infraest_arrend END ASC, " +
          "CASE WHEN :orderBy = 'valorAlquilerContratInfraestArrend' AND :orderMode = 'DESC' THEN tabla_documentacion_anexas_contrat_infraest_arrend.valor_alquiler_contrat_infraest_arrend END DESC, " +
          "CASE WHEN :orderBy = 'nombreUnidadMedidaAlquilerContratInfraestArrend' AND :orderMode = 'ASC' THEN tabla_documentacion_anexas_contrat_infraest_arrend.nombre_unidad_medida_alquiler_contrat_infraest_arrend END ASC, " +
          "CASE WHEN :orderBy = 'nombreUnidadMedidaAlquilerContratInfraestArrend' AND :orderMode = 'DESC' THEN tabla_documentacion_anexas_contrat_infraest_arrend.nombre_unidad_medida_alquiler_contrat_infraest_arrend END DESC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoContratInfraestArrend' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_documentacion_anexas_contrat_infraest_arrend.nombre_archivo_documento_anexo_contrat_infraest_arrend, 4000, 1) END ASC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoContratInfraestArrend' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_documentacion_anexas_contrat_infraest_arrend.nombre_archivo_documento_anexo_contrat_infraest_arrend, 4000, 1) END DESC", nativeQuery = true)
    Slice<DocumentacionAnexaContratInfraestArrend> findAllDocumentacionesAnexasContratInfraestArrendPag(Pageable pageable, @Param("idDocumentacionAnexaContratInfraestArrend") Long idDocumentacionAnexaContratInfraestArrend, @Param("keyword") String keyword, @Param("idProyeccionPlanAnualArrendamiento") Long idProyeccionPlanAnualArrendamiento, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<DocumentacionAnexaContratInfraestArrend> findByIdDocumentacionAnexaContratInfraestArrend(Long idDocumentacionAnexaContratInfraestArrend);
    
    @Query(value = "SELECT MAX(id_documentacion_anexa_contrat_infraest_arrend) FROM tabla_documentacion_anexas_contrat_infraest_arrend", nativeQuery = true)
    Long findMaxIdDocumentacionAnexaContratInfraestArrend();
}
