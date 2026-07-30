//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoDocumentoAnexoSolicInfraest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/12/2025.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface TipoDocumentoAnexoSolicInfraestRepository extends JpaRepository<TipoDocumentoAnexoSolicInfraest,Long> {
    
    //1. CONTADORES DE REGISTROS FILTRADOS.
    @Query(value = "" +
          "SELECT COUNT(*) " +
          "FROM tabla_tipos_documentos_anexos_solic_infraest " +
          "WHERE " +
          "(:idTipoDocumentoAnexoSolicInfraest IS NULL OR id_tipo_documento_anexo_solic_infraest = :idTipoDocumentoAnexoSolicInfraest) AND " +
          "(:keyword IS NULL OR nombre_tipo_documento_anexo_solic_infraest LIKE '%' || :keyword || '%')", nativeQuery = true)
    Long findTotalRegistros(@Param("idTipoDocumentoAnexoSolicInfraest") Long idTipoDocumentoAnexoSolicInfraest, @Param("keyword") String keyword);
    
    //1. LISTADO DE REGISTROS FILTRADOS.
    @Query(value = "" +
          "SELECT * " +
          "FROM tabla_tipos_documentos_anexos_solic_infraest " +
          "WHERE " +
          "(:idTipoDocumentoAnexoSolicInfraest IS NULL OR id_tipo_documento_anexo_solic_infraest = :idTipoDocumentoAnexoSolicInfraest) AND " +
          "(:keyword IS NULL OR nombre_tipo_documento_anexo_solic_infraest LIKE '%' || :keyword || '%') " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idTipoDocumentoAnexoSolicInfraest' AND :orderMode = 'ASC' THEN id_tipo_documento_anexo_solic_infraest END ASC, " +
          "CASE WHEN :orderBy = 'idTipoDocumentoAnexoSolicInfraest' AND :orderMode = 'DESC' THEN id_tipo_documento_anexo_solic_infraest END DESC, " +
          "CASE WHEN :orderBy = 'nombreTipoDocumentoAnexoSolicInfraest' AND :orderMode = 'ASC' THEN nombre_tipo_documento_anexo_solic_infraest END ASC, " +
          "CASE WHEN :orderBy = 'nombreTipoDocumentoAnexoSolicInfraest' AND :orderMode = 'DESC' THEN nombre_tipo_documento_anexo_solic_infraest END DESC", nativeQuery = true)
    List<TipoDocumentoAnexoSolicInfraest> findAllTiposDocumentosAnexosSolicInfraest(@Param("idTipoDocumentoAnexoSolicInfraest") Long idTipoDocumentoAnexoSolicInfraest, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);

    @Query(value = "" +
          "SELECT * " +
          "FROM tabla_tipos_documentos_anexos_solic_infraest " +
          "WHERE " +
          "(:idTipoDocumentoAnexoSolicInfraest IS NULL OR id_tipo_documento_anexo_solic_infraest = :idTipoDocumentoAnexoSolicInfraest) AND " +
          "(:keyword IS NULL OR nombre_tipo_documento_anexo_solic_infraest LIKE '%' || :keyword || '%') " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idTipoDocumentoAnexoSolicInfraest' AND :orderMode = 'ASC' THEN id_tipo_documento_anexo_solic_infraest END ASC, " +
          "CASE WHEN :orderBy = 'idTipoDocumentoAnexoSolicInfraest' AND :orderMode = 'DESC' THEN id_tipo_documento_anexo_solic_infraest END DESC, " +
          "CASE WHEN :orderBy = 'nombreTipoDocumentoAnexoSolicInfraest' AND :orderMode = 'ASC' THEN nombre_tipo_documento_anexo_solic_infraest END ASC, " +
          "CASE WHEN :orderBy = 'nombreTipoDocumentoAnexoSolicInfraest' AND :orderMode = 'DESC' THEN nombre_tipo_documento_anexo_solic_infraest END DESC", nativeQuery = true)
    Slice<TipoDocumentoAnexoSolicInfraest> findAllTiposDocumentosAnexosSolicInfraestPag(Pageable pageable, @Param("idTipoDocumentoAnexoSolicInfraest") Long idTipoDocumentoAnexoSolicInfraest, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<TipoDocumentoAnexoSolicInfraest> findByIdTipoDocumentoAnexoSolicInfraest(Long idTipoDocumentoAnexoSolicInfraest);
    
    TipoDocumentoAnexoSolicInfraest findByNombreTipoDocumentoAnexoSolicInfraest(String nombreTipoDocumentoAnexoSolicInfraest);
    
    @Query(value = "SELECT MAX(id_tipo_documento_anexo_solic_infraest) FROM tabla_tipos_documentos_anexos_solic_infraest", nativeQuery = true)
    Long findMaxIdTipoDocumentoAnexoSolicInfraest();
}
