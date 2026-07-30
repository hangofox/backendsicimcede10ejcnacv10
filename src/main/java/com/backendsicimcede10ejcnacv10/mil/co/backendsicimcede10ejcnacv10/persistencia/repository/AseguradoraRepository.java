//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.Aseguradora;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 24/03/2026.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface AseguradoraRepository extends JpaRepository<Aseguradora,Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (ID + KEYWORD + NOMBRE TIPO DOCUMENTO IDENTIFICACION + NOMBRE ASEGURADORA + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_aseguradoras, tabla_tipos_documentos_identificacion " +
          "WHERE (tabla_aseguradoras.id_tipo_documento_identificacion = tabla_tipos_documentos_identificacion.id_tipo_documento_identificacion) AND " +
          "(:idAseguradora IS NULL OR tabla_aseguradoras.id_aseguradora = :idAseguradora) " +
          "(:keyword IS NULL OR (tabla_aseguradoras.nombre_aseguradora LIKE '%' || :keyword || '%' OR " +
          "tabla_aseguradoras.numero_documento_identificacion_aseguradora LIKE '%' || :keyword || '%' OR " +
          "tabla_tipos_documentos_identificacion.nombre_tipo_documento_identificacion LIKE '%' || :keyword || '%')) AND " +
          "(:nombreTipoDocumentoIdentificacion IS NULL OR tabla_tipos_documentos_identificacion.nombre_tipo_documento_identificacion = :nombreTipoDocumentoIdentificacion) AND " +
          "(:nombreAseguradora IS NULL OR tabla_aseguradoras.nombre_aseguradora = :nombreAseguradora)", nativeQuery = true)
    Long findTotalRegistros(@Param("idAseguradora") Long idAseguradora, @Param("keyword") String keyword, @Param("nombreTipoDocumentoIdentificacion") String nombreTipoDocumentoIdentificacion, @Param("nombreAseguradora") String nombreAseguradora);
    
    @Query(value = "SELECT tabla_aseguradoras.* FROM tabla_aseguradoras, tabla_tipos_documentos_identificacion " +
          "WHERE (tabla_aseguradoras.id_tipo_documento_identificacion = tabla_tipos_documentos_identificacion.id_tipo_documento_identificacion) AND " +
          "(:idAseguradora IS NULL OR tabla_aseguradoras.id_aseguradora = :idAseguradora) AND " +
          "(:keyword IS NULL OR (tabla_aseguradoras.nombre_aseguradora LIKE '%' || :keyword || '%' OR " +
          "tabla_aseguradoras.numero_documento_identificacion_aseguradora LIKE '%' || :keyword || '%' OR " +
          "tabla_tipos_documentos_identificacion.nombre_tipo_documento_identificacion LIKE '%' || :keyword || '%')) AND " +
          "(:nombreTipoDocumentoIdentificacion IS NULL OR tabla_tipos_documentos_identificacion.nombre_tipo_documento_identificacion = :nombreTipoDocumentoIdentificacion) AND " +
          "(:nombreAseguradora IS NULL OR tabla_aseguradoras.nombre_aseguradora = :nombreAseguradora) " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idAseguradora' AND :orderMode = 'ASC' THEN tabla_aseguradoras.id_aseguradora END ASC, " +
          "CASE WHEN :orderBy = 'idAseguradora' AND :orderMode = 'DESC' THEN tabla_aseguradoras.id_aseguradora END DESC, " +
          "CASE WHEN :orderBy = 'nombreAseguradora' AND :orderMode = 'ASC' THEN tabla_aseguradoras.nombre_aseguradora END ASC, " +
          "CASE WHEN :orderBy = 'nombreAseguradora' AND :orderMode = 'DESC' THEN tabla_aseguradoras.nombre_aseguradora END DESC, " +
          "CASE WHEN :orderBy = 'numeroDocumentoIdentificacionAseguradora' AND :orderMode = 'ASC' THEN tabla_aseguradoras.numero_documento_identificacion_aseguradora END ASC, " +
          "CASE WHEN :orderBy = 'numeroDocumentoIdentificacionAseguradora' AND :orderMode = 'DESC' THEN tabla_aseguradoras.numero_documento_identificacion_aseguradora END DESC, " +
          "CASE WHEN :orderBy = 'paisOrigenAseguradora' AND :orderMode = 'ASC' THEN tabla_aseguradoras.pais_origen_aseguradora END ASC, " +
          "CASE WHEN :orderBy = 'paisOrigenAseguradora' AND :orderMode = 'DESC' THEN tabla_aseguradoras.pais_origen_aseguradora END DESC, " +
          "CASE WHEN :orderBy = 'departamentoOEstadoOrigenAseguradora' AND :orderMode = 'ASC' THEN tabla_aseguradoras.departamento_o_estado_origen_aseguradora END ASC, " +
          "CASE WHEN :orderBy = 'departamentoOEstadoOrigenAseguradora' AND :orderMode = 'DESC' THEN tabla_aseguradoras.departamento_o_estado_origen_aseguradora END DESC, " +
          "CASE WHEN :orderBy = 'ciudadOrigenAseguradora' AND :orderMode = 'ASC' THEN tabla_aseguradoras.ciudad_origen_aseguradora END ASC, " +
          "CASE WHEN :orderBy = 'ciudadOrigenAseguradora' AND :orderMode = 'DESC' THEN tabla_aseguradoras.ciudad_origen_aseguradora END DESC, " +
          "CASE WHEN :orderBy = 'direccionAseguradora' AND :orderMode = 'ASC' THEN tabla_aseguradoras.direccion_aseguradora END ASC, " +
          "CASE WHEN :orderBy = 'direccionAseguradora' AND :orderMode = 'DESC' THEN tabla_aseguradoras.direccion_aseguradora END DESC, " +
          "CASE WHEN :orderBy = 'estadoAseguradora' AND :orderMode = 'ASC' THEN tabla_aseguradoras.estado_aseguradora END ASC, " +
          "CASE WHEN :orderBy = 'estadoAseguradora' AND :orderMode = 'DESC' THEN tabla_aseguradoras.estado_aseguradora END DESC", nativeQuery = true)
    List<Aseguradora> findAllAseguradoras(@Param("idAseguradora") Long idAseguradora, @Param("keyword") String keyword, @Param("nombreTipoDocumentoIdentificacion") String nombreTipoDocumentoIdentificacion, @Param("nombreAseguradora") String nombreAseguradora, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_aseguradoras.* FROM tabla_aseguradoras, tabla_tipos_documentos_identificacion " +
          "WHERE (tabla_aseguradoras.id_tipo_documento_identificacion = tabla_tipos_documentos_identificacion.id_tipo_documento_identificacion) AND " +
          "(:idAseguradora IS NULL OR tabla_aseguradoras.id_aseguradora = :idAseguradora) AND " +
          "(:keyword IS NULL OR (tabla_aseguradoras.nombre_aseguradora LIKE '%' || :keyword || '%' OR " +
          "tabla_aseguradoras.numero_documento_identificacion_aseguradora LIKE '%' || :keyword || '%' OR " +
          "tabla_tipos_documentos_identificacion.nombre_tipo_documento_identificacion LIKE '%' || :keyword || '%')) AND " +
          "(:nombreTipoDocumentoIdentificacion IS NULL OR tabla_tipos_documentos_identificacion.nombre_tipo_documento_identificacion = :nombreTipoDocumentoIdentificacion) AND " +
          "(:nombreAseguradora IS NULL OR tabla_aseguradoras.nombre_aseguradora = :nombreAseguradora) " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idAseguradora' AND :orderMode = 'ASC' THEN tabla_aseguradoras.id_aseguradora END ASC, " +
          "CASE WHEN :orderBy = 'idAseguradora' AND :orderMode = 'DESC' THEN tabla_aseguradoras.id_aseguradora END DESC, " +
          "CASE WHEN :orderBy = 'nombreAseguradora' AND :orderMode = 'ASC' THEN tabla_aseguradoras.nombre_aseguradora END ASC, " +
          "CASE WHEN :orderBy = 'nombreAseguradora' AND :orderMode = 'DESC' THEN tabla_aseguradoras.nombre_aseguradora END DESC, " +
          "CASE WHEN :orderBy = 'numeroDocumentoIdentificacionAseguradora' AND :orderMode = 'ASC' THEN tabla_aseguradoras.numero_documento_identificacion_aseguradora END ASC, " +
          "CASE WHEN :orderBy = 'numeroDocumentoIdentificacionAseguradora' AND :orderMode = 'DESC' THEN tabla_aseguradoras.numero_documento_identificacion_aseguradora END DESC, " +
          "CASE WHEN :orderBy = 'paisOrigenAseguradora' AND :orderMode = 'ASC' THEN tabla_aseguradoras.pais_origen_aseguradora END ASC, " +
          "CASE WHEN :orderBy = 'paisOrigenAseguradora' AND :orderMode = 'DESC' THEN tabla_aseguradoras.pais_origen_aseguradora END DESC, " +
          "CASE WHEN :orderBy = 'departamentoOEstadoOrigenAseguradora' AND :orderMode = 'ASC' THEN tabla_aseguradoras.departamento_o_estado_origen_aseguradora END ASC, " +
          "CASE WHEN :orderBy = 'departamentoOEstadoOrigenAseguradora' AND :orderMode = 'DESC' THEN tabla_aseguradoras.departamento_o_estado_origen_aseguradora END DESC, " +
          "CASE WHEN :orderBy = 'ciudadOrigenAseguradora' AND :orderMode = 'ASC' THEN tabla_aseguradoras.ciudad_origen_aseguradora END ASC, " +
          "CASE WHEN :orderBy = 'ciudadOrigenAseguradora' AND :orderMode = 'DESC' THEN tabla_aseguradoras.ciudad_origen_aseguradora END DESC, " +
          "CASE WHEN :orderBy = 'direccionAseguradora' AND :orderMode = 'ASC' THEN tabla_aseguradoras.direccion_aseguradora END ASC, " +
          "CASE WHEN :orderBy = 'direccionAseguradora' AND :orderMode = 'DESC' THEN tabla_aseguradoras.direccion_aseguradora END DESC, " +
          "CASE WHEN :orderBy = 'estadoAseguradora' AND :orderMode = 'ASC' THEN tabla_aseguradoras.estado_aseguradora END ASC, " +
          "CASE WHEN :orderBy = 'estadoAseguradora' AND :orderMode = 'DESC' THEN tabla_aseguradoras.estado_aseguradora END DESC", nativeQuery = true)
    Slice<Aseguradora> findAllAseguradorasPag(Pageable pageable, @Param("idAseguradora") Long idAseguradora, @Param("keyword") String keyword, @Param("nombreTipoDocumentoIdentificacion") String nombreTipoDocumentoIdentificacion, @Param("nombreAseguradora") String nombreAseguradora, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<Aseguradora> findByIdAseguradora(Long idAseguradora);
    
    Aseguradora findByNumeroDocumentoIdentificacionAseguradora(String numeroDocumentoIdentificacionAseguradora);
    
    @Query(value = "SELECT MAX(id_aseguradora) FROM tabla_aseguradoras", nativeQuery = true)
    Long findMaxIdAseguradora();
}
