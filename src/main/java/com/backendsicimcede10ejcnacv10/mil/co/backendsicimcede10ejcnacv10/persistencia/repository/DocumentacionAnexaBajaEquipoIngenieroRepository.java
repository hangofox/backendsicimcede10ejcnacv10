//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.DocumentacionAnexaBajaEquipoIngeniero;
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
public interface DocumentacionAnexaBajaEquipoIngenieroRepository extends JpaRepository<DocumentacionAnexaBajaEquipoIngeniero,Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (ID DOC + KEYWORD + ID EQUIPO INGENIERO + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_documentacion_anexas_bajas_equipos_ingenieros " +
          "WHERE (:idDocumentacionAnexaBajaEquipoIngeniero IS NULL OR tabla_documentacion_anexas_bajas_equipos_ingenieros.id_documentacion_anexa_baja_equipo_ingeniero = :idDocumentacionAnexaBajaEquipoIngeniero) AND " +
          "(:keyword IS NULL OR UPPER(tabla_documentacion_anexas_bajas_equipos_ingenieros.nombre_documento_anexo_baja_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%')) AND " +
          "(:idEquipoIngeniero IS NULL OR tabla_documentacion_anexas_bajas_equipos_ingenieros.id_equipo_ingeniero = :idEquipoIngeniero)", nativeQuery = true)
    Long findTotalRegistros(@Param("idDocumentacionAnexaBajaEquipoIngeniero") Long idDocumentacionAnexaBajaEquipoIngeniero, @Param("keyword") String keyword, @Param("idEquipoIngeniero") Long idEquipoIngeniero);
    
    @Query(value = "SELECT tabla_documentacion_anexas_bajas_equipos_ingenieros.* FROM tabla_documentacion_anexas_bajas_equipos_ingenieros " +
          "WHERE (:idDocumentacionAnexaBajaEquipoIngeniero IS NULL OR tabla_documentacion_anexas_bajas_equipos_ingenieros.id_documentacion_anexa_baja_equipo_ingeniero = :idDocumentacionAnexaBajaEquipoIngeniero) AND " +
          "(:keyword IS NULL OR UPPER(tabla_documentacion_anexas_bajas_equipos_ingenieros.nombre_documento_anexo_baja_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%')) AND " +
          "(:idEquipoIngeniero IS NULL OR tabla_documentacion_anexas_bajas_equipos_ingenieros.id_equipo_ingeniero = :idEquipoIngeniero) " +
          "ORDER BY CASE WHEN :orderBy = 'idDocumentacionAnexaBajaEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_documentacion_anexas_bajas_equipos_ingenieros.id_documentacion_anexa_baja_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'idDocumentacionAnexaBajaEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_documentacion_anexas_bajas_equipos_ingenieros.id_documentacion_anexa_baja_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'nombreDocumentoAnexoBajaEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_documentacion_anexas_bajas_equipos_ingenieros.nombre_documento_anexo_baja_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'nombreDocumentoAnexoBajaEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_documentacion_anexas_bajas_equipos_ingenieros.nombre_documento_anexo_baja_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoBajaEquipoIngeniero' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_documentacion_anexas_bajas_equipos_ingenieros.nombre_archivo_documento_anexo_baja_equipo_ingeniero, 4000, 1) END ASC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoBajaEquipoIngeniero' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_documentacion_anexas_bajas_equipos_ingenieros.nombre_archivo_documento_anexo_baja_equipo_ingeniero, 4000, 1) END DESC", nativeQuery = true)
    List<DocumentacionAnexaBajaEquipoIngeniero> findAllDocumentacionAnexasBajasEquiposIngenieros(@Param("idDocumentacionAnexaBajaEquipoIngeniero") Long idDocumentacionAnexaBajaEquipoIngeniero, @Param("keyword") String keyword, @Param("idEquipoIngeniero") Long idEquipoIngeniero, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_documentacion_anexas_bajas_equipos_ingenieros.* FROM tabla_documentacion_anexas_bajas_equipos_ingenieros " +
          "WHERE (:idDocumentacionAnexaBajaEquipoIngeniero IS NULL OR tabla_documentacion_anexas_bajas_equipos_ingenieros.id_documentacion_anexa_baja_equipo_ingeniero = :idDocumentacionAnexaBajaEquipoIngeniero) AND " +
          "(:keyword IS NULL OR UPPER(tabla_documentacion_anexas_bajas_equipos_ingenieros.nombre_documento_anexo_baja_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%')) AND " +
          "(:idEquipoIngeniero IS NULL OR tabla_documentacion_anexas_bajas_equipos_ingenieros.id_equipo_ingeniero = :idEquipoIngeniero) " +
          "ORDER BY CASE WHEN :orderBy = 'idDocumentacionAnexaBajaEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_documentacion_anexas_bajas_equipos_ingenieros.id_documentacion_anexa_baja_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'idDocumentacionAnexaBajaEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_documentacion_anexas_bajas_equipos_ingenieros.id_documentacion_anexa_baja_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'nombreDocumentoAnexoBajaEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_documentacion_anexas_bajas_equipos_ingenieros.nombre_documento_anexo_baja_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'nombreDocumentoAnexoBajaEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_documentacion_anexas_bajas_equipos_ingenieros.nombre_documento_anexo_baja_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoBajaEquipoIngeniero' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_documentacion_anexas_bajas_equipos_ingenieros.nombre_archivo_documento_anexo_baja_equipo_ingeniero, 4000, 1) END ASC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoBajaEquipoIngeniero' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_documentacion_anexas_bajas_equipos_ingenieros.nombre_archivo_documento_anexo_baja_equipo_ingeniero, 4000, 1) END DESC", nativeQuery = true)
    Slice<DocumentacionAnexaBajaEquipoIngeniero> findAllDocumentacionAnexasBajasEquiposIngenierosPag(Pageable pageable, @Param("idDocumentacionAnexaBajaEquipoIngeniero") Long idDocumentacionAnexaBajaEquipoIngeniero, @Param("keyword") String keyword, @Param("idEquipoIngeniero") Long idEquipoIngeniero, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<DocumentacionAnexaBajaEquipoIngeniero> findByIdDocumentacionAnexaBajaEquipoIngeniero(Long idDocumentacionAnexaBajaEquipoIngeniero);
    
    @Query(value = "SELECT MAX(id_documentacion_anexa_baja_equipo_ingeniero) FROM tabla_documentacion_anexas_bajas_equipos_ingenieros", nativeQuery = true)
    Long findMaxIdDocumentacionAnexaBajaEquipoIngeniero();
}
