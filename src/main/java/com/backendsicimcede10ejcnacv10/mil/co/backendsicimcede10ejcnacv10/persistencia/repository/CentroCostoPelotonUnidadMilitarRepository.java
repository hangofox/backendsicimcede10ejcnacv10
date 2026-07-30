//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.CentroCostoPelotonUnidadMilitar;
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
public interface CentroCostoPelotonUnidadMilitarRepository extends JpaRepository<CentroCostoPelotonUnidadMilitar, Long> {
    
    @Query(value = "" +
          "SELECT COUNT(*) " +
          "FROM tabla_centros_costos_pelotones_unidades_militares, tabla_pelotones_unidades_militares " +
          "WHERE (tabla_centros_costos_pelotones_unidades_militares.id_peloton_unidad_militar = tabla_pelotones_unidades_militares.id_peloton_unidad_militar) AND " +
          "(:idCentroCostoPelotonUnidadMilitar IS NULL OR tabla_centros_costos_pelotones_unidades_militares.id_centro_costo_peloton_unidad_militar = :idCentroCostoPelotonUnidadMilitar) AND " +
          "(:nombrePelotonUnidadMilitar IS NULL OR tabla_pelotones_unidades_militares.nombre_peloton_unidad_militar = :nombrePelotonUnidadMilitar) AND " +
          "(:keyword IS NULL OR UPPER(tabla_centros_costos_pelotones_unidades_militares.centro_costo_peloton_unidad_militar) LIKE UPPER('%'||:keyword||'%') " +
          "OR UPPER(tabla_pelotones_unidades_militares.nombre_peloton_unidad_militar) LIKE UPPER('%'||:keyword||'%'))", nativeQuery = true)
    Long findTotalRegistros(@Param("idCentroCostoPelotonUnidadMilitar") Long idCentroCostoPelotonUnidadMilitar, @Param("keyword") String keyword, @Param("nombrePelotonUnidadMilitar") String nombrePelotonUnidadMilitar);
    
    @Query(value = "" +
          "SELECT tabla_centros_costos_pelotones_unidades_militares.* " +
          "FROM tabla_centros_costos_pelotones_unidades_militares, tabla_pelotones_unidades_militares " +
          "WHERE (tabla_centros_costos_pelotones_unidades_militares.id_peloton_unidad_militar = tabla_pelotones_unidades_militares.id_peloton_unidad_militar) AND " +
          "(:idCentroCostoPelotonUnidadMilitar IS NULL OR tabla_centros_costos_pelotones_unidades_militares.id_centro_costo_peloton_unidad_militar = :idCentroCostoPelotonUnidadMilitar) AND " +
          "(:nombrePelotonUnidadMilitar IS NULL OR tabla_pelotones_unidades_militares.nombre_peloton_unidad_militar = :nombrePelotonUnidadMilitar) AND " +
          "(:keyword IS NULL OR UPPER(tabla_centros_costos_pelotones_unidades_militares.centro_costo_peloton_unidad_militar) LIKE UPPER('%'||:keyword||'%') " +
          "OR UPPER(tabla_pelotones_unidades_militares.nombre_peloton_unidad_militar) LIKE UPPER('%'||:keyword||'%')) " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idCentroCostoPelotonUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_centros_costos_pelotones_unidades_militares.id_centro_costo_peloton_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'idCentroCostoPelotonUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_centros_costos_pelotones_unidades_militares.id_centro_costo_peloton_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'centroCostoPelotonUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_centros_costos_pelotones_unidades_militares.centro_costo_peloton_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'centroCostoPelotonUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_centros_costos_pelotones_unidades_militares.centro_costo_peloton_unidad_militar END DESC", nativeQuery = true)
    List<CentroCostoPelotonUnidadMilitar> findAllCentrosCostosPelotonesUnidadesMilitares(@Param("idCentroCostoPelotonUnidadMilitar") Long idCentroCostoPelotonUnidadMilitar, @Param("keyword") String keyword, @Param("nombrePelotonUnidadMilitar") String nombrePelotonUnidadMilitar, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "" +
          "SELECT tabla_centros_costos_pelotones_unidades_militares.* " +
          "FROM tabla_centros_costos_pelotones_unidades_militares, tabla_pelotones_unidades_militares " +
          "WHERE (tabla_centros_costos_pelotones_unidades_militares.id_peloton_unidad_militar = tabla_pelotones_unidades_militares.id_peloton_unidad_militar) AND " +
          "(:idCentroCostoPelotonUnidadMilitar IS NULL OR tabla_centros_costos_pelotones_unidades_militares.id_centro_costo_peloton_unidad_militar = :idCentroCostoPelotonUnidadMilitar) AND " +
          "(:nombrePelotonUnidadMilitar IS NULL OR tabla_pelotones_unidades_militares.nombre_peloton_unidad_militar = :nombrePelotonUnidadMilitar) AND " +
          "(:keyword IS NULL OR UPPER(tabla_centros_costos_pelotones_unidades_militares.centro_costo_peloton_unidad_militar) LIKE UPPER('%'||:keyword||'%') " +
          "OR UPPER(tabla_pelotones_unidades_militares.nombre_peloton_unidad_militar) LIKE UPPER('%'||:keyword||'%')) " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idCentroCostoPelotonUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_centros_costos_pelotones_unidades_militares.id_centro_costo_peloton_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'idCentroCostoPelotonUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_centros_costos_pelotones_unidades_militares.id_centro_costo_peloton_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'centroCostoPelotonUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_centros_costos_pelotones_unidades_militares.centro_costo_peloton_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'centroCostoPelotonUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_centros_costos_pelotones_unidades_militares.centro_costo_peloton_unidad_militar END DESC", nativeQuery = true)
    Slice<CentroCostoPelotonUnidadMilitar> findAllCentrosCostosPelotonesUnidadesMilitaresPag(Pageable pageable, @Param("idCentroCostoPelotonUnidadMilitar") Long idCentroCostoPelotonUnidadMilitar, @Param("keyword") String keyword, @Param("nombrePelotonUnidadMilitar") String nombrePelotonUnidadMilitar, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<CentroCostoPelotonUnidadMilitar> findByIdCentroCostoPelotonUnidadMilitar(Long idCentroCostoPelotonUnidadMilitar);
    
    @Query(value = "" +
          "SELECT tabla_centros_costos_pelotones_unidades_militares.* " +
          "FROM tabla_centros_costos_pelotones_unidades_militares, tabla_pelotones_unidades_militares " +
          "WHERE (tabla_centros_costos_pelotones_unidades_militares.id_peloton_unidad_militar = tabla_pelotones_unidades_militares.id_peloton_unidad_militar) AND " +
          "(tabla_pelotones_unidades_militares.nombre_peloton_unidad_militar = :nombrePelotonUnidadMilitar) AND " +
          "(tabla_centros_costos_pelotones_unidades_militares.centro_costo_peloton_unidad_militar = :centroCostoPelotonUnidadMilitar)", nativeQuery = true)
    CentroCostoPelotonUnidadMilitar findByNombrePelotonUnidadMilitarAndCentroCostoPelotonUnidadMilitar(@Param("nombrePelotonUnidadMilitar") String nombrePelotonUnidadMilitar, @Param("centroCostoPelotonUnidadMilitar") String centroCostoPelotonUnidadMilitar);
    
    @Query(value = "SELECT MAX(id_centro_costo_peloton_unidad_militar) FROM tabla_centros_costos_pelotones_unidades_militares", nativeQuery = true)
    Long findMaxIdCentroCostoPelotonUnidadMilitar();
}
