//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.DocumentacionAnexaAltaEquipoIngeniero;
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
public interface DocumentacionAnexaAltaEquipoIngenieroRepository extends JpaRepository<DocumentacionAnexaAltaEquipoIngeniero,Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (ID DOC + KEYWORD + ID EQUIPO INGENIERO + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_documentacion_anexas_altas_equipos_ingenieros " +
          "WHERE (:idDocumentacionAnexaAltaEquipoIngeniero IS NULL OR tabla_documentacion_anexas_altas_equipos_ingenieros.id_documentacion_anexa_alta_equipo_ingeniero = :idDocumentacionAnexaAltaEquipoIngeniero) AND " +
          "(:keyword IS NULL OR UPPER(tabla_documentacion_anexas_altas_equipos_ingenieros.nombre_documento_anexo_alta_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%')) AND " +
          "(:idEquipoIngeniero IS NULL OR tabla_documentacion_anexas_altas_equipos_ingenieros.id_equipo_ingeniero = :idEquipoIngeniero)", nativeQuery = true)
    Long findTotalRegistros(@Param("idDocumentacionAnexaAltaEquipoIngeniero") Long idDocumentacionAnexaAltaEquipoIngeniero, @Param("keyword") String keyword, @Param("idEquipoIngeniero") Long idEquipoIngeniero);
    
    @Query(value = "SELECT tabla_documentacion_anexas_altas_equipos_ingenieros.* FROM tabla_documentacion_anexas_altas_equipos_ingenieros " +
          "WHERE (:idDocumentacionAnexaAltaEquipoIngeniero IS NULL OR tabla_documentacion_anexas_altas_equipos_ingenieros.id_documentacion_anexa_alta_equipo_ingeniero = :idDocumentacionAnexaAltaEquipoIngeniero) AND " +
          "(:keyword IS NULL OR UPPER(tabla_documentacion_anexas_altas_equipos_ingenieros.nombre_documento_anexo_alta_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%')) AND " +
          "(:idEquipoIngeniero IS NULL OR tabla_documentacion_anexas_altas_equipos_ingenieros.id_equipo_ingeniero = :idEquipoIngeniero) " +
          "ORDER BY CASE WHEN :orderBy = 'idDocumentacionAnexaAltaEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_documentacion_anexas_altas_equipos_ingenieros.id_documentacion_anexa_alta_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'idDocumentacionAnexaAltaEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_documentacion_anexas_altas_equipos_ingenieros.id_documentacion_anexa_alta_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'nombreDocumentoAnexoAltaEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_documentacion_anexas_altas_equipos_ingenieros.nombre_documento_anexo_alta_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'nombreDocumentoAnexoAltaEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_documentacion_anexas_altas_equipos_ingenieros.nombre_documento_anexo_alta_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoAltaEquipoIngeniero' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_documentacion_anexas_altas_equipos_ingenieros.nombre_archivo_documento_anexo_alta_equipo_ingeniero, 4000, 1) END ASC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoAltaEquipoIngeniero' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_documentacion_anexas_altas_equipos_ingenieros.nombre_archivo_documento_anexo_alta_equipo_ingeniero, 4000, 1) END DESC", nativeQuery = true)
    List<DocumentacionAnexaAltaEquipoIngeniero> findAllDocumentacionAnexasAltasEquiposIngenieros(@Param("idDocumentacionAnexaAltaEquipoIngeniero") Long idDocumentacionAnexaAltaEquipoIngeniero, @Param("keyword") String keyword, @Param("idEquipoIngeniero") Long idEquipoIngeniero, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_documentacion_anexas_altas_equipos_ingenieros.* FROM tabla_documentacion_anexas_altas_equipos_ingenieros " +
          "WHERE (:idDocumentacionAnexaAltaEquipoIngeniero IS NULL OR tabla_documentacion_anexas_altas_equipos_ingenieros.id_documentacion_anexa_alta_equipo_ingeniero = :idDocumentacionAnexaAltaEquipoIngeniero) AND " +
          "(:keyword IS NULL OR UPPER(tabla_documentacion_anexas_altas_equipos_ingenieros.nombre_documento_anexo_alta_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%')) AND " +
          "(:idEquipoIngeniero IS NULL OR tabla_documentacion_anexas_altas_equipos_ingenieros.id_equipo_ingeniero = :idEquipoIngeniero) " +
          "ORDER BY CASE WHEN :orderBy = 'idDocumentacionAnexaAltaEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_documentacion_anexas_altas_equipos_ingenieros.id_documentacion_anexa_alta_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'idDocumentacionAnexaAltaEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_documentacion_anexas_altas_equipos_ingenieros.id_documentacion_anexa_alta_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'nombreDocumentoAnexoAltaEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_documentacion_anexas_altas_equipos_ingenieros.nombre_documento_anexo_alta_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'nombreDocumentoAnexoAltaEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_documentacion_anexas_altas_equipos_ingenieros.nombre_documento_anexo_alta_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoAltaEquipoIngeniero' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_documentacion_anexas_altas_equipos_ingenieros.nombre_archivo_documento_anexo_alta_equipo_ingeniero, 4000, 1) END ASC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoAltaEquipoIngeniero' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_documentacion_anexas_altas_equipos_ingenieros.nombre_archivo_documento_anexo_alta_equipo_ingeniero, 4000, 1) END DESC", nativeQuery = true)
    Slice<DocumentacionAnexaAltaEquipoIngeniero> findAllDocumentacionAnexasAltasEquiposIngenierosPag(Pageable pageable, @Param("idDocumentacionAnexaAltaEquipoIngeniero") Long idDocumentacionAnexaAltaEquipoIngeniero, @Param("keyword") String keyword, @Param("idEquipoIngeniero") Long idEquipoIngeniero, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<DocumentacionAnexaAltaEquipoIngeniero> findByIdDocumentacionAnexaAltaEquipoIngeniero(Long idDocumentacionAnexaAltaEquipoIngeniero);
    
    @Query(value = "SELECT MAX(id_documentacion_anexa_alta_equipo_ingeniero) FROM tabla_documentacion_anexas_altas_equipos_ingenieros", nativeQuery = true)
    Long findMaxIdDocumentacionAnexaAltaEquipoIngeniero();
}
