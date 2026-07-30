//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.CompaniaUnidadMilitar;
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
public interface CompaniaUnidadMilitarRepository extends JpaRepository<CompaniaUnidadMilitar, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (ID + KEYWORD + SIGLA O ACRÓNIMO UNIDAD MILITAR + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_companias_unidades_militares, tabla_unidades_militares " +
          "WHERE (:idCompaniaUnidadMilitar IS NULL OR tabla_companias_unidades_militares.id_compania_unidad_militar = :idCompaniaUnidadMilitar) AND " +
          "(tabla_companias_unidades_militares.id_unidad_militar = tabla_unidades_militares.id_unidad_militar) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_companias_unidades_militares.nombre_compania_unidad_militar) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_unidades_militares.nombre_unidad_militar) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:siglaoAcronimoUnidadMilitar IS NULL OR tabla_unidades_militares.sigla_o_acronimo_unidad_militar = :siglaoAcronimoUnidadMilitar)", nativeQuery = true)
    Long findTotalRegistros(@Param("idCompaniaUnidadMilitar") Long idCompaniaUnidadMilitar, @Param("keyword") String keyword, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar);
    
    @Query(value = "SELECT * FROM tabla_companias_unidades_militares, tabla_unidades_militares " +
          "WHERE (:idCompaniaUnidadMilitar IS NULL OR tabla_companias_unidades_militares.id_compania_unidad_militar = :idCompaniaUnidadMilitar) AND " +
          "(tabla_companias_unidades_militares.id_unidad_militar = tabla_unidades_militares.id_unidad_militar) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_companias_unidades_militares.nombre_compania_unidad_militar) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_unidades_militares.nombre_unidad_militar) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:siglaoAcronimoUnidadMilitar IS NULL OR tabla_unidades_militares.sigla_o_acronimo_unidad_militar = :siglaoAcronimoUnidadMilitar) " +
          "ORDER BY CASE WHEN :orderBy = 'idCompaniaUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_companias_unidades_militares.id_compania_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'idCompaniaUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_companias_unidades_militares.id_compania_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'siglaoAcronimoUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_unidades_militares.sigla_o_acronimo_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'siglaoAcronimoUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_unidades_militares.sigla_o_acronimo_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'nombreCompaniaUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_companias_unidades_militares.nombre_compania_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'nombreCompaniaUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_companias_unidades_militares.nombre_compania_unidad_militar END DESC", nativeQuery = true)
    List<CompaniaUnidadMilitar> findAllCompaniasUnidadesMilitares(@Param("idCompaniaUnidadMilitar") Long idCompaniaUnidadMilitar, @Param("keyword") String keyword, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT * FROM tabla_companias_unidades_militares, tabla_unidades_militares " +
          "WHERE (:idCompaniaUnidadMilitar IS NULL OR tabla_companias_unidades_militares.id_compania_unidad_militar = :idCompaniaUnidadMilitar) AND " +
          "(tabla_companias_unidades_militares.id_unidad_militar = tabla_unidades_militares.id_unidad_militar) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_companias_unidades_militares.nombre_compania_unidad_militar) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_unidades_militares.nombre_unidad_militar) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:siglaoAcronimoUnidadMilitar IS NULL OR tabla_unidades_militares.sigla_o_acronimo_unidad_militar = :siglaoAcronimoUnidadMilitar) " +
          "ORDER BY CASE WHEN :orderBy = 'idCompaniaUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_companias_unidades_militares.id_compania_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'idCompaniaUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_companias_unidades_militares.id_compania_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'siglaoAcronimoUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_unidades_militares.sigla_o_acronimo_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'siglaoAcronimoUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_unidades_militares.sigla_o_acronimo_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'nombreCompaniaUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_companias_unidades_militares.nombre_compania_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'nombreCompaniaUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_companias_unidades_militares.nombre_compania_unidad_militar END DESC", nativeQuery = true)
    Slice<CompaniaUnidadMilitar> findAllCompaniasUnidadesMilitaresPag(Pageable pageable, @Param("idCompaniaUnidadMilitar") Long idCompaniaUnidadMilitar, @Param("keyword") String keyword, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<CompaniaUnidadMilitar> findByIdCompaniaUnidadMilitar(Long idCompaniaUnidadMilitar);
    
    @Query(value = "SELECT * FROM tabla_companias_unidades_militares, tabla_unidades_militares " +
          "WHERE (tabla_companias_unidades_militares.id_unidad_militar = tabla_unidades_militares.id_unidad_militar) AND " +
          "(tabla_companias_unidades_militares.nombre_compania_unidad_militar = :nombreCompaniaUnidadMilitar) AND " +
          "(tabla_unidades_militares.sigla_o_acronimo_unidad_militar = :siglaoAcronimoUnidadMilitar)", nativeQuery = true)
    CompaniaUnidadMilitar findByNombreCompaniaUnidadMilitarAndSAUnidadMilitar(@Param("nombreCompaniaUnidadMilitar") String nombreCompaniaUnidadMilitar, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar);
    
    @Query(value = "SELECT MAX(id_compania_unidad_militar) FROM tabla_companias_unidades_militares", nativeQuery = true)
    Long findMaxIdCompaniaUnidadMilitar();
}
