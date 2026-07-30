//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.CentroCostoCompaniaUnidadMilitar;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 25/03/2026.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface CentroCostoCompaniaUnidadMilitarRepository extends JpaRepository<CentroCostoCompaniaUnidadMilitar, Long> {
    
    @Query(value = "" +
          "SELECT COUNT(*) " +
          "FROM tabla_centros_costos_companias_unidades_militares, tabla_companias_unidades_militares " +
          "WHERE (tabla_centros_costos_companias_unidades_militares.id_compania_unidad_militar = tabla_companias_unidades_militares.id_compania_unidad_militar) AND " +
          "(:idCentroCostoCompaniaUnidadMilitar IS NULL OR tabla_centros_costos_companias_unidades_militares.id_centro_costo_compania_unidad_militar = :idCentroCostoCompaniaUnidadMilitar) AND " +
          "(:nombreCompaniaUnidadMilitar IS NULL OR tabla_companias_unidades_militares.nombre_compania_unidad_militar = :nombreCompaniaUnidadMilitar) AND " +
          "(:keyword IS NULL OR UPPER(tabla_centros_costos_companias_unidades_militares.centro_costo_compania_unidad_militar) LIKE UPPER('%'||:keyword||'%') " +
          "OR UPPER(tabla_companias_unidades_militares.nombre_compania_unidad_militar) LIKE UPPER('%'||:keyword||'%'))", nativeQuery = true)
    Long findTotalRegistros(@Param("idCentroCostoCompaniaUnidadMilitar") Long idCentroCostoCompaniaUnidadMilitar, @Param("keyword") String keyword, @Param("nombreCompaniaUnidadMilitar") String nombreCompaniaUnidadMilitar);
    
    @Query(value = "" +
          "SELECT tabla_centros_costos_companias_unidades_militares.* " +
          "FROM tabla_centros_costos_companias_unidades_militares, tabla_companias_unidades_militares " +
          "WHERE (tabla_centros_costos_companias_unidades_militares.id_compania_unidad_militar = tabla_companias_unidades_militares.id_compania_unidad_militar) AND " +
          "(:idCentroCostoCompaniaUnidadMilitar IS NULL OR tabla_centros_costos_companias_unidades_militares.id_centro_costo_compania_unidad_militar = :idCentroCostoCompaniaUnidadMilitar) AND " +
          "(:nombreCompaniaUnidadMilitar IS NULL OR tabla_companias_unidades_militares.nombre_compania_unidad_militar = :nombreCompaniaUnidadMilitar) AND " +
          "(:keyword IS NULL OR UPPER(tabla_centros_costos_companias_unidades_militares.centro_costo_compania_unidad_militar) LIKE UPPER('%'||:keyword||'%') " +
          "OR UPPER(tabla_companias_unidades_militares.nombre_compania_unidad_militar) LIKE UPPER('%'||:keyword||'%')) " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idCentroCostoCompaniaUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_centros_costos_companias_unidades_militares.id_centro_costo_compania_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'idCentroCostoCompaniaUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_centros_costos_companias_unidades_militares.id_centro_costo_compania_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'centroCostoCompaniaUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_centros_costos_companias_unidades_militares.centro_costo_compania_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'centroCostoCompaniaUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_centros_costos_companias_unidades_militares.centro_costo_compania_unidad_militar END DESC", nativeQuery = true)
    List<CentroCostoCompaniaUnidadMilitar> findAllCentrosCostosCompaniasUnidadesMilitares(@Param("idCentroCostoCompaniaUnidadMilitar") Long idCentroCostoCompaniaUnidadMilitar, @Param("keyword") String keyword, @Param("nombreCompaniaUnidadMilitar") String nombreCompaniaUnidadMilitar, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "" +
          "SELECT tabla_centros_costos_companias_unidades_militares.* " +
          "FROM tabla_centros_costos_companias_unidades_militares, tabla_companias_unidades_militares " +
          "WHERE (tabla_centros_costos_companias_unidades_militares.id_compania_unidad_militar = tabla_companias_unidades_militares.id_compania_unidad_militar) AND " +
          "(:idCentroCostoCompaniaUnidadMilitar IS NULL OR tabla_centros_costos_companias_unidades_militares.id_centro_costo_compania_unidad_militar = :idCentroCostoCompaniaUnidadMilitar) AND " +
          "(:nombreCompaniaUnidadMilitar IS NULL OR tabla_companias_unidades_militares.nombre_compania_unidad_militar = :nombreCompaniaUnidadMilitar) AND " +
          "(:keyword IS NULL OR UPPER(tabla_centros_costos_companias_unidades_militares.centro_costo_compania_unidad_militar) LIKE UPPER('%'||:keyword||'%') " +
          "OR UPPER(tabla_companias_unidades_militares.nombre_compania_unidad_militar) LIKE UPPER('%'||:keyword||'%')) " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idCentroCostoCompaniaUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_centros_costos_companias_unidades_militares.id_centro_costo_compania_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'idCentroCostoCompaniaUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_centros_costos_companias_unidades_militares.id_centro_costo_compania_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'centroCostoCompaniaUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_centros_costos_companias_unidades_militares.centro_costo_compania_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'centroCostoCompaniaUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_centros_costos_companias_unidades_militares.centro_costo_compania_unidad_militar END DESC", nativeQuery = true)
    Slice<CentroCostoCompaniaUnidadMilitar> findAllCentrosCostosCompaniasUnidadesMilitaresPag(Pageable pageable, @Param("idCentroCostoCompaniaUnidadMilitar") Long idCentroCostoCompaniaUnidadMilitar, @Param("keyword") String keyword, @Param("nombreCompaniaUnidadMilitar") String nombreCompaniaUnidadMilitar, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<CentroCostoCompaniaUnidadMilitar> findByIdCentroCostoCompaniaUnidadMilitar(Long idCentroCostoCompaniaUnidadMilitar);
    
    @Query(value = "" +
          "SELECT tabla_centros_costos_companias_unidades_militares.* " +
          "FROM tabla_centros_costos_companias_unidades_militares, tabla_companias_unidades_militares " +
          "WHERE (tabla_centros_costos_companias_unidades_militares.id_compania_unidad_militar = tabla_companias_unidades_militares.id_compania_unidad_militar) AND " +
          "(tabla_companias_unidades_militares.nombre_compania_unidad_militar = :nombreCompaniaUnidadMilitar) AND " +
          "(tabla_centros_costos_companias_unidades_militares.centro_costo_compania_unidad_militar = :centroCostoCompaniaUnidadMilitar)", nativeQuery = true)
    CentroCostoCompaniaUnidadMilitar findByNombreCompaniaUnidadMilitarAndCentroCostoCompaniaUnidadMilitar(@Param("nombreCompaniaUnidadMilitar") String nombreCompaniaUnidadMilitar, @Param("centroCostoCompaniaUnidadMilitar") String centroCostoCompaniaUnidadMilitar);
    
    @Query(value = "SELECT MAX(id_centro_costo_compania_unidad_militar) FROM tabla_centros_costos_companias_unidades_militares", nativeQuery = true)
    Long findMaxIdCentroCostoCompaniaUnidadMilitar();
}
