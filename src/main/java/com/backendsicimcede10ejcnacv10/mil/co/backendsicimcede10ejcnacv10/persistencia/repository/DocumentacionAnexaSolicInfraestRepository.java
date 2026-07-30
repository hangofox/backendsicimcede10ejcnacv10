//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.DocumentacionAnexaSolicInfraest;
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
public interface DocumentacionAnexaSolicInfraestRepository extends JpaRepository<DocumentacionAnexaSolicInfraest,Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (ID DOC + KEYWORD + ID SOLICITUD INFRAESTRUCTURA + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_documentacion_anexas_solic_infraest " +
          "WHERE (:idDocumentacionAnexaSolicInfraest IS NULL OR tabla_documentacion_anexas_solic_infraest.id_documentacion_anexa_solic_infraest = :idDocumentacionAnexaSolicInfraest) AND " +
          "(:keyword IS NULL OR UPPER(tabla_documentacion_anexas_solic_infraest.nombre_documento_anexo_solic_infraest) LIKE UPPER('%'||:keyword||'%')) AND " +
          "(:idSolicitudInfraestructura IS NULL OR tabla_documentacion_anexas_solic_infraest.id_solicitud_infraestructura = :idSolicitudInfraestructura)", nativeQuery = true)
    Long findTotalRegistros(@Param("idDocumentacionAnexaSolicInfraest") Long idDocumentacionAnexaSolicInfraest, @Param("keyword") String keyword, @Param("idSolicitudInfraestructura") Long idSolicitudInfraestructura);
    
    @Query(value = "SELECT tabla_documentacion_anexas_solic_infraest.* FROM tabla_documentacion_anexas_solic_infraest " +
          "WHERE (:idDocumentacionAnexaSolicInfraest IS NULL OR tabla_documentacion_anexas_solic_infraest.id_documentacion_anexa_solic_infraest = :idDocumentacionAnexaSolicInfraest) AND " +
          "(:keyword IS NULL OR UPPER(tabla_documentacion_anexas_solic_infraest.nombre_documento_anexo_solic_infraest) LIKE UPPER('%'||:keyword||'%')) AND " +
          "(:idSolicitudInfraestructura IS NULL OR tabla_documentacion_anexas_solic_infraest.id_solicitud_infraestructura = :idSolicitudInfraestructura) " +
          "ORDER BY CASE WHEN :orderBy = 'idDocumentacionAnexaSolicInfraest' AND :orderMode = 'ASC' THEN tabla_documentacion_anexas_solic_infraest.id_documentacion_anexa_solic_infraest END ASC, " +
          "CASE WHEN :orderBy = 'idDocumentacionAnexaSolicInfraest' AND :orderMode = 'DESC' THEN tabla_documentacion_anexas_solic_infraest.id_documentacion_anexa_solic_infraest END DESC, " +
          "CASE WHEN :orderBy = 'nombreDocumentoAnexoSolicInfraest' AND :orderMode = 'ASC' THEN tabla_documentacion_anexas_solic_infraest.nombre_documento_anexo_solic_infraest END ASC, " +
          "CASE WHEN :orderBy = 'nombreDocumentoAnexoSolicInfraest' AND :orderMode = 'DESC' THEN tabla_documentacion_anexas_solic_infraest.nombre_documento_anexo_solic_infraest END DESC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoSolicInfraest' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_documentacion_anexas_solic_infraest.nombre_archivo_documento_anexo_solic_infraest, 4000, 1) END ASC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoSolicInfraest' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_documentacion_anexas_solic_infraest.nombre_archivo_documento_anexo_solic_infraest, 4000, 1) END DESC", nativeQuery = true)
    List<DocumentacionAnexaSolicInfraest> findAllDocumentacionAnexasSolicInfraest(@Param("idDocumentacionAnexaSolicInfraest") Long idDocumentacionAnexaSolicInfraest, @Param("keyword") String keyword, @Param("idSolicitudInfraestructura") Long idSolicitudInfraestructura, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_documentacion_anexas_solic_infraest.* FROM tabla_documentacion_anexas_solic_infraest " +
          "WHERE (:idDocumentacionAnexaSolicInfraest IS NULL OR tabla_documentacion_anexas_solic_infraest.id_documentacion_anexa_solic_infraest = :idDocumentacionAnexaSolicInfraest) AND " +
          "(:keyword IS NULL OR UPPER(tabla_documentacion_anexas_solic_infraest.nombre_documento_anexo_solic_infraest) LIKE UPPER('%'||:keyword||'%')) AND " +
          "(:idSolicitudInfraestructura IS NULL OR tabla_documentacion_anexas_solic_infraest.id_solicitud_infraestructura = :idSolicitudInfraestructura) " +
          "ORDER BY CASE WHEN :orderBy = 'idDocumentacionAnexaSolicInfraest' AND :orderMode = 'ASC' THEN tabla_documentacion_anexas_solic_infraest.id_documentacion_anexa_solic_infraest END ASC, " +
          "CASE WHEN :orderBy = 'idDocumentacionAnexaSolicInfraest' AND :orderMode = 'DESC' THEN tabla_documentacion_anexas_solic_infraest.id_documentacion_anexa_solic_infraest END DESC, " +
          "CASE WHEN :orderBy = 'nombreDocumentoAnexoSolicInfraest' AND :orderMode = 'ASC' THEN tabla_documentacion_anexas_solic_infraest.nombre_documento_anexo_solic_infraest END ASC, " +
          "CASE WHEN :orderBy = 'nombreDocumentoAnexoSolicInfraest' AND :orderMode = 'DESC' THEN tabla_documentacion_anexas_solic_infraest.nombre_documento_anexo_solic_infraest END DESC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoSolicInfraest' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_documentacion_anexas_solic_infraest.nombre_archivo_documento_anexo_solic_infraest, 4000, 1) END ASC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoSolicInfraest' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_documentacion_anexas_solic_infraest.nombre_archivo_documento_anexo_solic_infraest, 4000, 1) END DESC", nativeQuery = true)
    Slice<DocumentacionAnexaSolicInfraest> findAllDocumentacionAnexasSolicInfraestPag(Pageable pageable, @Param("idDocumentacionAnexaSolicInfraest") Long idDocumentacionAnexaSolicInfraest, @Param("keyword") String keyword, @Param("idSolicitudInfraestructura") Long idSolicitudInfraestructura, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<DocumentacionAnexaSolicInfraest> findByIdDocumentacionAnexaSolicInfraest(Long idDocumentacionAnexaSolicInfraest);
    
    @Query(value = "SELECT MAX(id_documentacion_anexa_solic_infraest) FROM tabla_documentacion_anexas_solic_infraest", nativeQuery = true)
    Long findMaxIdDocumentacionAnexaSolicInfraest();
}
