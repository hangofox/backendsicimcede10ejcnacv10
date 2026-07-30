//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.CargoIntegranteDocumentos;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 17/12/2025.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface CargoIntegranteDocumentosRepository extends JpaRepository<CargoIntegranteDocumentos,Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (ID + KEYWORD + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_cargos_integrantes_documentos " +
          "WHERE (:idCargoIntegranteDocumentos IS NULL OR id_cargo_integrante_documentos = :idCargoIntegranteDocumentos) " +
          "AND (:keyword IS NULL OR UPPER(nombre_cargo_integrante_documentos) LIKE UPPER('%'||:keyword||'%'))", nativeQuery = true)
    Long findTotalRegistros(@Param("idCargoIntegranteDocumentos") Long idCargoIntegranteDocumentos, @Param("keyword") String keyword);
    
    @Query(value = "SELECT * FROM tabla_cargos_integrantes_documentos " +
          "WHERE (:idCargoIntegranteDocumentos IS NULL OR id_cargo_integrante_documentos = :idCargoIntegranteDocumentos) " +
          "AND (:keyword IS NULL OR UPPER(nombre_cargo_integrante_documentos) LIKE UPPER('%'||:keyword||'%')) " +
          "ORDER BY CASE WHEN :orderBy = 'idCargoIntegranteDocumentos' AND :orderMode = 'ASC' THEN id_cargo_integrante_documentos END ASC, " +
          "CASE WHEN :orderBy = 'idCargoIntegranteDocumentos' AND :orderMode = 'DESC' THEN id_cargo_integrante_documentos END DESC, " +
          "CASE WHEN :orderBy = 'nombreCargoIntegranteDocumentos' AND :orderMode = 'ASC' THEN nombre_cargo_integrante_documentos END ASC, " +
          "CASE WHEN :orderBy = 'nombreCargoIntegranteDocumentos' AND :orderMode = 'DESC' THEN nombre_cargo_integrante_documentos END DESC", nativeQuery = true)
    List<CargoIntegranteDocumentos> findAllCargosIntegrantesDocumentos(@Param("idCargoIntegranteDocumentos") Long idCargoIntegranteDocumentos, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT * FROM tabla_cargos_integrantes_documentos " +
          "WHERE (:idCargoIntegranteDocumentos IS NULL OR id_cargo_integrante_documentos = :idCargoIntegranteDocumentos) " +
          "AND (:keyword IS NULL OR UPPER(nombre_cargo_integrante_documentos) LIKE UPPER('%'||:keyword||'%')) " +
          "ORDER BY CASE WHEN :orderBy = 'idCargoIntegranteDocumentos' AND :orderMode = 'ASC' THEN id_cargo_integrante_documentos END ASC, " +
          "CASE WHEN :orderBy = 'idCargoIntegranteDocumentos' AND :orderMode = 'DESC' THEN id_cargo_integrante_documentos END DESC, " +
          "CASE WHEN :orderBy = 'nombreCargoIntegranteDocumentos' AND :orderMode = 'ASC' THEN nombre_cargo_integrante_documentos END ASC, " +
          "CASE WHEN :orderBy = 'nombreCargoIntegranteDocumentos' AND :orderMode = 'DESC' THEN nombre_cargo_integrante_documentos END DESC", nativeQuery = true)
    Slice<CargoIntegranteDocumentos> findAllCargosIntegrantesDocumentosPag(Pageable pageable, @Param("idCargoIntegranteDocumentos") Long idCargoIntegranteDocumentos, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<CargoIntegranteDocumentos> findByIdCargoIntegranteDocumentos(Long idCargoIntegranteDocumentos);
    
    CargoIntegranteDocumentos findByNombreCargoIntegranteDocumentos(String nombreCargoIntegranteDocumentos);
    
    @Query(value = "SELECT MAX(id_cargo_integrante_documentos) FROM tabla_cargos_integrantes_documentos", nativeQuery = true)
    Long findMaxIdCargoIntegranteDocumentos();
}
