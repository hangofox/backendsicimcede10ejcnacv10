//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoContratoSeguroInfraestructura;
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
public interface TipoContratoSeguroInfraestructuraRepository extends JpaRepository<TipoContratoSeguroInfraestructura,Long> {
    
    //1. CONTADORES DE REGISTROS FILTRADOS.
    @Query(value = "" +
          "SELECT COUNT(*) " +
          "FROM tabla_tipos_contratos_seguros_infraestructuras " +
          "WHERE " +
          "(:idTipoContratoSeguroInfraestructura IS NULL OR id_tipo_contrato_seguro_infraestructura = :idTipoContratoSeguroInfraestructura) AND " +
          "(:keyword IS NULL OR nombre_tipo_contrato_seguro_infraestructura LIKE '%' || :keyword || '%')", nativeQuery = true)
    Long findTotalRegistros(@Param("idTipoContratoSeguroInfraestructura") Long idTipoContratoSeguroInfraestructura, @Param("keyword") String keyword);
    
    //1. LISTADO DE REGISTROS FILTRADOS.
    @Query(value = "" +
          "SELECT * " +
          "FROM tabla_tipos_contratos_seguros_infraestructuras " +
          "WHERE " +
          "(:idTipoContratoSeguroInfraestructura IS NULL OR id_tipo_contrato_seguro_infraestructura = :idTipoContratoSeguroInfraestructura) AND " +
          "(:keyword IS NULL OR nombre_tipo_contrato_seguro_infraestructura LIKE '%' || :keyword || '%') " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idTipoContratoSeguroInfraestructura' AND :orderMode = 'ASC' THEN id_tipo_contrato_seguro_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'idTipoContratoSeguroInfraestructura' AND :orderMode = 'DESC' THEN id_tipo_contrato_seguro_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'nombreTipoContratoSeguroInfraestructura' AND :orderMode = 'ASC' THEN nombre_tipo_contrato_seguro_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'nombreTipoContratoSeguroInfraestructura' AND :orderMode = 'DESC' THEN nombre_tipo_contrato_seguro_infraestructura END DESC", nativeQuery = true)
    List<TipoContratoSeguroInfraestructura> findAllTiposContratosSegurosInfraestructuras(@Param("idTipoContratoSeguroInfraestructura") Long idTipoContratoSeguroInfraestructura, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);

    @Query(value = "" +
          "SELECT * " +
          "FROM tabla_tipos_contratos_seguros_infraestructuras " +
          "WHERE " +
          "(:idTipoContratoSeguroInfraestructura IS NULL OR id_tipo_contrato_seguro_infraestructura = :idTipoContratoSeguroInfraestructura) AND " +
          "(:keyword IS NULL OR nombre_tipo_contrato_seguro_infraestructura LIKE '%' || :keyword || '%') " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idTipoContratoSeguroInfraestructura' AND :orderMode = 'ASC' THEN id_tipo_contrato_seguro_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'idTipoContratoSeguroInfraestructura' AND :orderMode = 'DESC' THEN id_tipo_contrato_seguro_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'nombreTipoContratoSeguroInfraestructura' AND :orderMode = 'ASC' THEN nombre_tipo_contrato_seguro_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'nombreTipoContratoSeguroInfraestructura' AND :orderMode = 'DESC' THEN nombre_tipo_contrato_seguro_infraestructura END DESC", nativeQuery = true)
    Slice<TipoContratoSeguroInfraestructura> findAllTiposContratosSegurosInfraestructurasPag(Pageable pageable, @Param("idTipoContratoSeguroInfraestructura") Long idTipoContratoSeguroInfraestructura, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<TipoContratoSeguroInfraestructura> findByIdTipoContratoSeguroInfraestructura(Long idTipoContratoSeguroInfraestructura);
    
    TipoContratoSeguroInfraestructura findByNombreTipoContratoSeguroInfraestructura(String nombreTipoContratoSeguroInfraestructura);
    
    @Query(value = "SELECT MAX(id_tipo_contrato_seguro_infraestructura) FROM tabla_tipos_contratos_seguros_infraestructuras", nativeQuery = true)
    Long findMaxIdTipoContratoSeguroInfraestructura();
}
