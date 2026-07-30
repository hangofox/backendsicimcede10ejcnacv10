//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.CentroCostoUnidadMilitar;
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
public interface CentroCostoUnidadMilitarRepository extends JpaRepository<CentroCostoUnidadMilitar,Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (ID + KEYWORD + SIGLA O ACRONIMO UNIDAD MILITAR + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_centros_costos_unidades_militares, tabla_unidades_militares " +
          "WHERE (tabla_centros_costos_unidades_militares.id_unidad_militar = tabla_unidades_militares.id_unidad_militar) AND " +
          "(:idCentroCostoUnidadMilitar IS NULL OR tabla_centros_costos_unidades_militares.id_centro_costo_unidad_militar = :idCentroCostoUnidadMilitar) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_centros_costos_unidades_militares.centro_costo_unidad_militar) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:siglaoAcronimoUnidadMilitar IS NULL OR UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) = UPPER(:siglaoAcronimoUnidadMilitar))", nativeQuery = true)
    Long findTotalRegistros(@Param("idCentroCostoUnidadMilitar") Long idCentroCostoUnidadMilitar, @Param("keyword") String keyword, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar);
    
    @Query(value = "SELECT tabla_centros_costos_unidades_militares.* FROM tabla_centros_costos_unidades_militares, tabla_unidades_militares " +
          "WHERE (tabla_centros_costos_unidades_militares.id_unidad_militar = tabla_unidades_militares.id_unidad_militar) AND " +
          "(:idCentroCostoUnidadMilitar IS NULL OR tabla_centros_costos_unidades_militares.id_centro_costo_unidad_militar = :idCentroCostoUnidadMilitar) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_centros_costos_unidades_militares.centro_costo_unidad_militar) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:siglaoAcronimoUnidadMilitar IS NULL OR UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) = UPPER(:siglaoAcronimoUnidadMilitar)) " +
          "ORDER BY CASE WHEN :orderBy = 'idCentroCostoUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_centros_costos_unidades_militares.id_centro_costo_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'idCentroCostoUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_centros_costos_unidades_militares.id_centro_costo_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'centroCostoUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_centros_costos_unidades_militares.centro_costo_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'centroCostoUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_centros_costos_unidades_militares.centro_costo_unidad_militar END DESC", nativeQuery = true)
    List<CentroCostoUnidadMilitar> findAllCentrosCostosUnidadesMilitares(@Param("idCentroCostoUnidadMilitar") Long idCentroCostoUnidadMilitar, @Param("keyword") String keyword, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_centros_costos_unidades_militares.* FROM tabla_centros_costos_unidades_militares, tabla_unidades_militares " +
          "WHERE (tabla_centros_costos_unidades_militares.id_unidad_militar = tabla_unidades_militares.id_unidad_militar) AND " +
          "(:idCentroCostoUnidadMilitar IS NULL OR tabla_centros_costos_unidades_militares.id_centro_costo_unidad_militar = :idCentroCostoUnidadMilitar) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_centros_costos_unidades_militares.centro_costo_unidad_militar) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:siglaoAcronimoUnidadMilitar IS NULL OR UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) = UPPER(:siglaoAcronimoUnidadMilitar)) " +
          "ORDER BY CASE WHEN :orderBy = 'idCentroCostoUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_centros_costos_unidades_militares.id_centro_costo_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'idCentroCostoUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_centros_costos_unidades_militares.id_centro_costo_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'centroCostoUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_centros_costos_unidades_militares.centro_costo_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'centroCostoUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_centros_costos_unidades_militares.centro_costo_unidad_militar END DESC", nativeQuery = true)
    Slice<CentroCostoUnidadMilitar> findAllCentrosCostosUnidadesMilitaresPag(Pageable pageable, @Param("idCentroCostoUnidadMilitar") Long idCentroCostoUnidadMilitar, @Param("keyword") String keyword, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<CentroCostoUnidadMilitar> findByIdCentroCostoUnidadMilitar(Long idCentroCostoUnidadMilitar);
    
    @Query(value = "SELECT * FROM tabla_centros_costos_unidades_militares, tabla_unidades_militares WHERE tabla_centros_costos_unidades_militares.id_unidad_militar = tabla_unidades_militares.id_unidad_militar AND UPPER(tabla_centros_costos_unidades_militares.centro_costo_unidad_militar) = UPPER(:centroCostoUnidadMilitar) AND UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) = UPPER(:siglaoAcronimoUnidadMilitar)", nativeQuery = true)
    CentroCostoUnidadMilitar findByCentroCostoUnidadMilitarAndSiglaoAcronimoUnidadMilitar(@Param("centroCostoUnidadMilitar") String centroCostoUnidadMilitar, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar);
    
    @Query(value = "SELECT MAX(tabla_centros_costos_unidades_militares.id_centro_costo_unidad_militar) FROM tabla_centros_costos_unidades_militares", nativeQuery = true)
    Long findMaxIdCentroCostoUnidadMilitar();
}
