//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.PelotonUnidadMilitar;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 21/03/2026.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface PelotonUnidadMilitarRepository extends JpaRepository<PelotonUnidadMilitar, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (ID + KEYWORD + NOMBRE COMPAÑIA UNIDAD MILITAR + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_pelotones_unidades_militares, tabla_companias_unidades_militares " +
          "WHERE (:idPelotonUnidadMilitar IS NULL OR tabla_pelotones_unidades_militares.id_peloton_unidad_militar = :idPelotonUnidadMilitar) AND " +
          "(tabla_pelotones_unidades_militares.id_compania_unidad_militar = tabla_companias_unidades_militares.id_compania_unidad_militar) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_pelotones_unidades_militares.nombre_peloton_unidad_militar) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_companias_unidades_militares.nombre_compania_unidad_militar) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:nombreCompaniaUnidadMilitar IS NULL OR tabla_companias_unidades_militares.nombre_compania_unidad_militar = :nombreCompaniaUnidadMilitar)", nativeQuery = true)
    Long findTotalRegistros(@Param("idPelotonUnidadMilitar") Long idPelotonUnidadMilitar, @Param("keyword") String keyword, @Param("nombreCompaniaUnidadMilitar") String nombreCompaniaUnidadMilitar);
    
    @Query(value = "SELECT tabla_pelotones_unidades_militares.* FROM tabla_pelotones_unidades_militares, tabla_companias_unidades_militares " +
          "WHERE (:idPelotonUnidadMilitar IS NULL OR tabla_pelotones_unidades_militares.id_peloton_unidad_militar = :idPelotonUnidadMilitar) AND " +
          "(tabla_pelotones_unidades_militares.id_compania_unidad_militar = tabla_companias_unidades_militares.id_compania_unidad_militar) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_pelotones_unidades_militares.nombre_peloton_unidad_militar) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_companias_unidades_militares.nombre_compania_unidad_militar) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:nombreCompaniaUnidadMilitar IS NULL OR tabla_companias_unidades_militares.nombre_compania_unidad_militar = :nombreCompaniaUnidadMilitar) " +
          "ORDER BY CASE WHEN :orderBy = 'idPelotonUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_pelotones_unidades_militares.id_peloton_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'idPelotonUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_pelotones_unidades_militares.id_peloton_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'nombreCompaniaUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_companias_unidades_militares.nombre_compania_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'nombreCompaniaUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_companias_unidades_militares.nombre_compania_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'nombrePelotonUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_pelotones_unidades_militares.nombre_peloton_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'nombrePelotonUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_pelotones_unidades_militares.nombre_peloton_unidad_militar END DESC", nativeQuery = true)
    List<PelotonUnidadMilitar> findAllPelotonesUnidadesMilitares(@Param("idPelotonUnidadMilitar") Long idPelotonUnidadMilitar, @Param("keyword") String keyword, @Param("nombreCompaniaUnidadMilitar") String nombreCompaniaUnidadMilitar, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_pelotones_unidades_militares.* FROM tabla_pelotones_unidades_militares, tabla_companias_unidades_militares " +
          "WHERE (:idPelotonUnidadMilitar IS NULL OR tabla_pelotones_unidades_militares.id_peloton_unidad_militar = :idPelotonUnidadMilitar) AND " +
          "(tabla_pelotones_unidades_militares.id_compania_unidad_militar = tabla_companias_unidades_militares.id_compania_unidad_militar) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_pelotones_unidades_militares.nombre_peloton_unidad_militar) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_companias_unidades_militares.nombre_compania_unidad_militar) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:nombreCompaniaUnidadMilitar IS NULL OR tabla_companias_unidades_militares.nombre_compania_unidad_militar = :nombreCompaniaUnidadMilitar) " +
          "ORDER BY CASE WHEN :orderBy = 'idPelotonUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_pelotones_unidades_militares.id_peloton_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'idPelotonUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_pelotones_unidades_militares.id_peloton_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'nombreCompaniaUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_companias_unidades_militares.nombre_compania_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'nombreCompaniaUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_companias_unidades_militares.nombre_compania_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'nombrePelotonUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_pelotones_unidades_militares.nombre_peloton_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'nombrePelotonUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_pelotones_unidades_militares.nombre_peloton_unidad_militar END DESC", nativeQuery = true)
    Slice<PelotonUnidadMilitar> findAllPelotonesUnidadesMilitaresPag(Pageable pageable, @Param("idPelotonUnidadMilitar") Long idPelotonUnidadMilitar, @Param("keyword") String keyword, @Param("nombreCompaniaUnidadMilitar") String nombreCompaniaUnidadMilitar, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<PelotonUnidadMilitar> findByIdPelotonUnidadMilitar(Long idPelotonUnidadMilitar);
    
    @Query(value = "SELECT tabla_pelotones_unidades_militares.* FROM tabla_pelotones_unidades_militares, tabla_companias_unidades_militares " +
          "WHERE (tabla_pelotones_unidades_militares.id_compania_unidad_militar = tabla_companias_unidades_militares.id_compania_unidad_militar) AND " +
          "(tabla_pelotones_unidades_militares.nombre_peloton_unidad_militar = :nombrePelotonUnidadMilitar) AND " +
          "(tabla_companias_unidades_militares.nombre_compania_unidad_militar = :nombreCompaniaUnidadMilitar)", nativeQuery = true)
    PelotonUnidadMilitar findByNombrePelotonUnidadMilitarAndNombreCompaniaUnidadMilitar(@Param("nombrePelotonUnidadMilitar") String nombrePelotonUnidadMilitar, @Param("nombreCompaniaUnidadMilitar") String nombreCompaniaUnidadMilitar);
    
    @Query(value = "SELECT tabla_pelotones_unidades_militares.* FROM tabla_pelotones_unidades_militares, tabla_companias_unidades_militares, tabla_unidades_militares " +
          "WHERE (tabla_pelotones_unidades_militares.id_compania_unidad_militar = tabla_companias_unidades_militares.id_compania_unidad_militar) AND " +
          "(tabla_companias_unidades_militares.id_unidad_militar = tabla_unidades_militares.id_unidad_militar) AND " +
          "(tabla_pelotones_unidades_militares.nombre_peloton_unidad_militar = :nombrePelotonUnidadMilitar) AND " +
          "(tabla_companias_unidades_militares.nombre_compania_unidad_militar = :nombreCompaniaUnidadMilitar) AND " +
          "(tabla_unidades_militares.sigla_o_acronimo_unidad_militar = :siglaoAcronimoUnidadMilitar)", nativeQuery = true)
    PelotonUnidadMilitar findByNombrePelotonUnidadMilitarAndNombreCompaniaUnidadMilitarAndSiglaoAcronimoUnidadMilitar(@Param("nombrePelotonUnidadMilitar") String nombrePelotonUnidadMilitar, @Param("nombreCompaniaUnidadMilitar") String nombreCompaniaUnidadMilitar, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar);
    
    @Query(value = "SELECT MAX(id_peloton_unidad_militar) FROM tabla_pelotones_unidades_militares", nativeQuery = true)
    Long findMaxIdPelotonUnidadMilitar();
}
