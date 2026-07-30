//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.DocumentacionAnexaCotizProySoatLinBlanc;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 09/04/2026.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface DocumentacionAnexaCotizProySoatLinBlancRepository extends JpaRepository<DocumentacionAnexaCotizProySoatLinBlanc, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (ID DOC + KEYWORD + ID PROYECCION SOAT LINEA BLANCA + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_documentacion_anexas_cotiz_proy_soats_lin_blanc, tabla_proyecciones_soats_lineas_blancas " +
          "WHERE (:idDocumentacionAnexaCotizProySoatLinBlanc IS NULL OR tabla_documentacion_anexas_cotiz_proy_soats_lin_blanc.id_documentacion_anexa_cotiz_proy_soat_lin_blanc = :idDocumentacionAnexaCotizProySoatLinBlanc) AND " +
          "(tabla_documentacion_anexas_cotiz_proy_soats_lin_blanc.id_proyeccion_soat_linea_blanca = tabla_proyecciones_soats_lineas_blancas.id_proyeccion_soat_linea_blanca) AND " +
          "(:keyword IS NULL OR UPPER(tabla_documentacion_anexas_cotiz_proy_soats_lin_blanc.nombre_documento_anexo_cotiz_proy_soat_lin_blanc) LIKE UPPER('%'||:keyword||'%')) AND " +
          "(:idProyeccionSoatLineaBlanca IS NULL OR tabla_proyecciones_soats_lineas_blancas.id_proyeccion_soat_linea_blanca = :idProyeccionSoatLineaBlanca)", nativeQuery = true)
    Long findTotalRegistros(@Param("idDocumentacionAnexaCotizProySoatLinBlanc") Long idDocumentacionAnexaCotizProySoatLinBlanc, @Param("keyword") String keyword, @Param("idProyeccionSoatLineaBlanca") Long idProyeccionSoatLineaBlanca);
    
    @Query(value = "SELECT tabla_documentacion_anexas_cotiz_proy_soats_lin_blanc.* FROM tabla_documentacion_anexas_cotiz_proy_soats_lin_blanc, tabla_proyecciones_soats_lineas_blancas " +
          "WHERE (:idDocumentacionAnexaCotizProySoatLinBlanc IS NULL OR tabla_documentacion_anexas_cotiz_proy_soats_lin_blanc.id_documentacion_anexa_cotiz_proy_soat_lin_blanc = :idDocumentacionAnexaCotizProySoatLinBlanc) AND " +
          "(tabla_documentacion_anexas_cotiz_proy_soats_lin_blanc.id_proyeccion_soat_linea_blanca = tabla_proyecciones_soats_lineas_blancas.id_proyeccion_soat_linea_blanca) AND " +
          "(:keyword IS NULL OR UPPER(tabla_documentacion_anexas_cotiz_proy_soats_lin_blanc.nombre_documento_anexo_cotiz_proy_soat_lin_blanc) LIKE UPPER('%'||:keyword||'%')) AND " +
          "(:idProyeccionSoatLineaBlanca IS NULL OR tabla_proyecciones_soats_lineas_blancas.id_proyeccion_soat_linea_blanca = :idProyeccionSoatLineaBlanca) " +
          "ORDER BY CASE WHEN :orderBy = 'idDocumentacionAnexaCotizProySoatLinBlanc' AND :orderMode = 'ASC' THEN tabla_documentacion_anexas_cotiz_proy_soats_lin_blanc.id_documentacion_anexa_cotiz_proy_soat_lin_blanc END ASC, " +
          "CASE WHEN :orderBy = 'idDocumentacionAnexaCotizProySoatLinBlanc' AND :orderMode = 'DESC' THEN tabla_documentacion_anexas_cotiz_proy_soats_lin_blanc.id_documentacion_anexa_cotiz_proy_soat_lin_blanc END DESC, " +
          "CASE WHEN :orderBy = 'nombreDocumentoAnexoCotizProySoatLinBlanc' AND :orderMode = 'ASC' THEN tabla_documentacion_anexas_cotiz_proy_soats_lin_blanc.nombre_documento_anexo_cotiz_proy_soat_lin_blanc END ASC, " +
          "CASE WHEN :orderBy = 'nombreDocumentoAnexoCotizProySoatLinBlanc' AND :orderMode = 'DESC' THEN tabla_documentacion_anexas_cotiz_proy_soats_lin_blanc.nombre_documento_anexo_cotiz_proy_soat_lin_blanc END DESC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoCotizProySoatLinBlanc' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_documentacion_anexas_cotiz_proy_soats_lin_blanc.nombre_archivo_documento_anexo_cotiz_proy_soat_lin_blanc, 4000, 1) END ASC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoCotizProySoatLinBlanc' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_documentacion_anexas_cotiz_proy_soats_lin_blanc.nombre_archivo_documento_anexo_cotiz_proy_soat_lin_blanc, 4000, 1) END DESC", nativeQuery = true)
    List<DocumentacionAnexaCotizProySoatLinBlanc> findAllDocumentacionesAnexasCotizProySoatLinBlanc(@Param("idDocumentacionAnexaCotizProySoatLinBlanc") Long idDocumentacionAnexaCotizProySoatLinBlanc, @Param("keyword") String keyword, @Param("idProyeccionSoatLineaBlanca") Long idProyeccionSoatLineaBlanca, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_documentacion_anexas_cotiz_proy_soats_lin_blanc.* FROM tabla_documentacion_anexas_cotiz_proy_soats_lin_blanc, tabla_proyecciones_soats_lineas_blancas " +
          "WHERE (:idDocumentacionAnexaCotizProySoatLinBlanc IS NULL OR tabla_documentacion_anexas_cotiz_proy_soats_lin_blanc.id_documentacion_anexa_cotiz_proy_soat_lin_blanc = :idDocumentacionAnexaCotizProySoatLinBlanc) AND " +
          "(tabla_documentacion_anexas_cotiz_proy_soats_lin_blanc.id_proyeccion_soat_linea_blanca = tabla_proyecciones_soats_lineas_blancas.id_proyeccion_soat_linea_blanca) AND " +
          "(:keyword IS NULL OR UPPER(tabla_documentacion_anexas_cotiz_proy_soats_lin_blanc.nombre_documento_anexo_cotiz_proy_soat_lin_blanc) LIKE UPPER('%'||:keyword||'%')) AND " +
          "(:idProyeccionSoatLineaBlanca IS NULL OR tabla_proyecciones_soats_lineas_blancas.id_proyeccion_soat_linea_blanca = :idProyeccionSoatLineaBlanca) " +
          "ORDER BY CASE WHEN :orderBy = 'idDocumentacionAnexaCotizProySoatLinBlanc' AND :orderMode = 'ASC' THEN tabla_documentacion_anexas_cotiz_proy_soats_lin_blanc.id_documentacion_anexa_cotiz_proy_soat_lin_blanc END ASC, " +
          "CASE WHEN :orderBy = 'idDocumentacionAnexaCotizProySoatLinBlanc' AND :orderMode = 'DESC' THEN tabla_documentacion_anexas_cotiz_proy_soats_lin_blanc.id_documentacion_anexa_cotiz_proy_soat_lin_blanc END DESC, " +
          "CASE WHEN :orderBy = 'nombreDocumentoAnexoCotizProySoatLinBlanc' AND :orderMode = 'ASC' THEN tabla_documentacion_anexas_cotiz_proy_soats_lin_blanc.nombre_documento_anexo_cotiz_proy_soat_lin_blanc END ASC, " +
          "CASE WHEN :orderBy = 'nombreDocumentoAnexoCotizProySoatLinBlanc' AND :orderMode = 'DESC' THEN tabla_documentacion_anexas_cotiz_proy_soats_lin_blanc.nombre_documento_anexo_cotiz_proy_soat_lin_blanc END DESC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoCotizProySoatLinBlanc' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_documentacion_anexas_cotiz_proy_soats_lin_blanc.nombre_archivo_documento_anexo_cotiz_proy_soat_lin_blanc, 4000, 1) END ASC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoCotizProySoatLinBlanc' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_documentacion_anexas_cotiz_proy_soats_lin_blanc.nombre_archivo_documento_anexo_cotiz_proy_soat_lin_blanc, 4000, 1) END DESC", nativeQuery = true)
    Slice<DocumentacionAnexaCotizProySoatLinBlanc> findAllDocumentacionesAnexasCotizProySoatLinBlancPag(Pageable pageable, @Param("idDocumentacionAnexaCotizProySoatLinBlanc") Long idDocumentacionAnexaCotizProySoatLinBlanc, @Param("keyword") String keyword, @Param("idProyeccionSoatLineaBlanca") Long idProyeccionSoatLineaBlanca, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<DocumentacionAnexaCotizProySoatLinBlanc> findByIdDocumentacionAnexaCotizProySoatLinBlanc(Long idDocumentacionAnexaCotizProySoatLinBlanc);
    
    @Query(value = "SELECT MAX(id_documentacion_anexa_cotiz_proy_soat_lin_blanc) FROM tabla_documentacion_anexas_cotiz_proy_soats_lin_blanc", nativeQuery = true)
    Long findMaxIdDocumentacionAnexaCotizProySoatLinBlanc();
}
