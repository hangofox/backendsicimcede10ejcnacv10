//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.Oficina;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/08/2023.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface OficinaRepository extends JpaRepository<Oficina, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (KEYWORD + SIGLAOACRÓNIMO UNIDAD MILITAR + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_oficinas, tabla_unidades_militares " +
          "WHERE (:idOficina IS NULL OR id_oficina = :idOficina) AND " +
          "(tabla_oficinas.id_unidad_militar = tabla_unidades_militares.id_unidad_militar) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_oficinas.nombre_oficina) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_unidades_militares.nombre_unidad_militar) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:siglaoAcronimoUnidadMilitar IS NULL OR tabla_unidades_militares.sigla_o_acronimo_unidad_militar = :siglaoAcronimoUnidadMilitar)", nativeQuery = true)
    Long findTotalRegistros(@Param("idOficina") Long idOficina, @Param("keyword") String keyword, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar);
    
    @Query(value = "SELECT * FROM tabla_oficinas, tabla_unidades_militares " +
          "WHERE (:idOficina IS NULL OR id_oficina = :idOficina) AND " +
          "(tabla_oficinas.id_unidad_militar = tabla_unidades_militares.id_unidad_militar) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_oficinas.nombre_oficina) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_unidades_militares.nombre_unidad_militar) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:siglaoAcronimoUnidadMilitar IS NULL OR tabla_unidades_militares.sigla_o_acronimo_unidad_militar = :siglaoAcronimoUnidadMilitar) " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idOficina' AND :orderMode = 'ASC' THEN tabla_oficinas.id_oficina END ASC, " +
          "CASE WHEN :orderBy = 'idOficina' AND :orderMode = 'DESC' THEN tabla_oficinas.id_oficina END DESC, " +
          "CASE WHEN :orderBy = 'nombreOficina' AND :orderMode = 'ASC' THEN tabla_oficinas.nombre_oficina END ASC, " +
          "CASE WHEN :orderBy = 'nombreOficina' AND :orderMode = 'DESC' THEN tabla_oficinas.nombre_oficina END DESC", nativeQuery = true)
    List<Oficina> findAllOficinas(@Param("idOficina") Long idOficina, @Param("keyword") String keyword, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT * FROM tabla_oficinas, tabla_unidades_militares " +
          "WHERE (:idOficina IS NULL OR id_oficina = :idOficina) AND " +
          "(tabla_oficinas.id_unidad_militar = tabla_unidades_militares.id_unidad_militar) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_oficinas.nombre_oficina) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_unidades_militares.nombre_unidad_militar) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:siglaoAcronimoUnidadMilitar IS NULL OR tabla_unidades_militares.sigla_o_acronimo_unidad_militar = :siglaoAcronimoUnidadMilitar) " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idOficina' AND :orderMode = 'ASC' THEN tabla_oficinas.id_oficina END ASC, " +
          "CASE WHEN :orderBy = 'idOficina' AND :orderMode = 'DESC' THEN tabla_oficinas.id_oficina END DESC, " +
          "CASE WHEN :orderBy = 'nombreOficina' AND :orderMode = 'ASC' THEN tabla_oficinas.nombre_oficina END ASC, " +
          "CASE WHEN :orderBy = 'nombreOficina' AND :orderMode = 'DESC' THEN tabla_oficinas.nombre_oficina END DESC", nativeQuery = true)
    Slice<Oficina> findAllOficinasPag(Pageable pageable, @Param("idOficina") Long idOficina, @Param("keyword") String keyword, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<Oficina> findByIdOficina(Long idOficina);
    
    @Query(value = "SELECT * FROM tabla_oficinas, tabla_unidades_militares " +
          "WHERE (tabla_oficinas.id_unidad_militar = tabla_unidades_militares.id_unidad_militar) " +
          "AND (tabla_oficinas.nombre_oficina = :nombreOficina) " +
          "AND (tabla_unidades_militares.sigla_o_acronimo_unidad_militar = :siglaoAcronimoUnidadMilitar)", nativeQuery = true)
    Oficina findByNombreOficinaAndSAUnidadMilitar(@Param("nombreOficina") String nombreOficina, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar);
    
    @Query(value = "SELECT MAX(id_oficina) FROM tabla_oficinas", nativeQuery = true)
    Long findMaxIdOficina();
}
