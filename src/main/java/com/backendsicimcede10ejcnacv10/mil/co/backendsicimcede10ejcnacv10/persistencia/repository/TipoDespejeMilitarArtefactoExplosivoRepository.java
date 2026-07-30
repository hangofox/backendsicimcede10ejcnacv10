//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoDespejeMilitarArtefactoExplosivo;
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
public interface TipoDespejeMilitarArtefactoExplosivoRepository extends JpaRepository<TipoDespejeMilitarArtefactoExplosivo,Long> {
    
    //1. CONTADORES DE REGISTROS FILTRADOS.
    @Query(value = "" +
          "SELECT COUNT(*) " +
          "FROM tabla_tipos_despejes_militares_artefactos_explosivos " +
          "WHERE " +
          "(:idTipoDespejeMilitarArtefactoExplosivo IS NULL OR id_tipo_despeje_militar_artefacto_explosivo = :idTipoDespejeMilitarArtefactoExplosivo) AND " +
          "(:keyword IS NULL OR nombre_tipo_despeje_militar_artefacto_explosivo LIKE '%' || :keyword || '%')", nativeQuery = true)
    Long findTotalRegistros(@Param("idTipoDespejeMilitarArtefactoExplosivo") Long idTipoDespejeMilitarArtefactoExplosivo, @Param("keyword") String keyword);
    
    //1. LISTADO DE REGISTROS FILTRADOS.
    @Query(value = "" +
          "SELECT * " +
          "FROM tabla_tipos_despejes_militares_artefactos_explosivos " +
          "WHERE " +
          "(:idTipoDespejeMilitarArtefactoExplosivo IS NULL OR id_tipo_despeje_militar_artefacto_explosivo = :idTipoDespejeMilitarArtefactoExplosivo) AND " +
          "(:keyword IS NULL OR nombre_tipo_despeje_militar_artefacto_explosivo LIKE '%' || :keyword || '%') " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idTipoDespejeMilitarArtefactoExplosivo' AND :orderMode = 'ASC' THEN id_tipo_despeje_militar_artefacto_explosivo END ASC, " +
          "CASE WHEN :orderBy = 'idTipoDespejeMilitarArtefactoExplosivo' AND :orderMode = 'DESC' THEN id_tipo_despeje_militar_artefacto_explosivo END DESC, " +
          "CASE WHEN :orderBy = 'nombreTipoDespejeMilitarArtefactoExplosivo' AND :orderMode = 'ASC' THEN nombre_tipo_despeje_militar_artefacto_explosivo END ASC, " +
          "CASE WHEN :orderBy = 'nombreTipoDespejeMilitarArtefactoExplosivo' AND :orderMode = 'DESC' THEN nombre_tipo_despeje_militar_artefacto_explosivo END DESC", nativeQuery = true)
    List<TipoDespejeMilitarArtefactoExplosivo> findAllTiposDespejesMilitaresArtefactosExplosivos(@Param("idTipoDespejeMilitarArtefactoExplosivo") Long idTipoDespejeMilitarArtefactoExplosivo, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);

    @Query(value = "" +
          "SELECT * " +
          "FROM tabla_tipos_despejes_militares_artefactos_explosivos " +
          "WHERE " +
          "(:idTipoDespejeMilitarArtefactoExplosivo IS NULL OR id_tipo_despeje_militar_artefacto_explosivo = :idTipoDespejeMilitarArtefactoExplosivo) AND " +
          "(:keyword IS NULL OR nombre_tipo_despeje_militar_artefacto_explosivo LIKE '%' || :keyword || '%') " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idTipoDespejeMilitarArtefactoExplosivo' AND :orderMode = 'ASC' THEN id_tipo_despeje_militar_artefacto_explosivo END ASC, " +
          "CASE WHEN :orderBy = 'idTipoDespejeMilitarArtefactoExplosivo' AND :orderMode = 'DESC' THEN id_tipo_despeje_militar_artefacto_explosivo END DESC, " +
          "CASE WHEN :orderBy = 'nombreTipoDespejeMilitarArtefactoExplosivo' AND :orderMode = 'ASC' THEN nombre_tipo_despeje_militar_artefacto_explosivo END ASC, " +
          "CASE WHEN :orderBy = 'nombreTipoDespejeMilitarArtefactoExplosivo' AND :orderMode = 'DESC' THEN nombre_tipo_despeje_militar_artefacto_explosivo END DESC", nativeQuery = true)
    Slice<TipoDespejeMilitarArtefactoExplosivo> findAllTiposDespejesMilitaresArtefactosExplosivosPag(
          Pageable pageable, @Param("idTipoDespejeMilitarArtefactoExplosivo") Long idTipoDespejeMilitarArtefactoExplosivo, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<TipoDespejeMilitarArtefactoExplosivo> findByIdTipoDespejeMilitarArtefactoExplosivo(Long idTipoDespejeMilitarArtefactoExplosivo);
    
    TipoDespejeMilitarArtefactoExplosivo findByNombreTipoDespejeMilitarArtefactoExplosivo(String nombreTipoDespejeMilitarArtefactoExplosivo);
    
    @Query(value = "SELECT MAX(id_tipo_despeje_militar_artefacto_explosivo) FROM tabla_tipos_despejes_militares_artefactos_explosivos", nativeQuery = true)
    Long findMaxIdTipoDespejeMilitarArtefactoExplosivo();
}
