//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoDespejeArtefactoExplosivo;
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
public interface TipoDespejeArtefactoExplosivoRepository extends JpaRepository<TipoDespejeArtefactoExplosivo,Long> {
    
    //1. CONTADORES DE REGISTROS FILTRADOS.
    @Query(value = "" +
          "SELECT COUNT(*) " +
          "FROM tabla_tipos_despejes_artefactos_explosivos " +
          "WHERE " +
          "(:idTipoDespejeArtefactoExplosivo IS NULL OR id_tipo_despeje_artefacto_explosivo = :idTipoDespejeArtefactoExplosivo) AND " +
          "(:keyword IS NULL OR nombre_tipo_despeje_artefacto_explosivo LIKE '%' || :keyword || '%')", nativeQuery = true)
    Long findTotalRegistros(@Param("idTipoDespejeArtefactoExplosivo") Long idTipoDespejeArtefactoExplosivo, @Param("keyword") String keyword);
    
    //1. LISTADO DE REGISTROS FILTRADOS.
    @Query(value = "" +
          "SELECT * " +
          "FROM tabla_tipos_despejes_artefactos_explosivos " +
          "WHERE " +
          "(:idTipoDespejeArtefactoExplosivo IS NULL OR id_tipo_despeje_artefacto_explosivo = :idTipoDespejeArtefactoExplosivo) AND " +
          "(:keyword IS NULL OR nombre_tipo_despeje_artefacto_explosivo LIKE '%' || :keyword || '%') " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idTipoDespejeArtefactoExplosivo' AND :orderMode = 'ASC' THEN id_tipo_despeje_artefacto_explosivo END ASC, " +
          "CASE WHEN :orderBy = 'idTipoDespejeArtefactoExplosivo' AND :orderMode = 'DESC' THEN id_tipo_despeje_artefacto_explosivo END DESC, " +
          "CASE WHEN :orderBy = 'nombreTipoDespejeArtefactoExplosivo' AND :orderMode = 'ASC' THEN nombre_tipo_despeje_artefacto_explosivo END ASC, " +
          "CASE WHEN :orderBy = 'nombreTipoDespejeArtefactoExplosivo' AND :orderMode = 'DESC' THEN nombre_tipo_despeje_artefacto_explosivo END DESC", nativeQuery = true)
    List<TipoDespejeArtefactoExplosivo> findAllTiposDespejesArtefactosExplosivos(@Param("idTipoDespejeArtefactoExplosivo") Long idTipoDespejeArtefactoExplosivo, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);

    @Query(value = "" +
          "SELECT * " +
          "FROM tabla_tipos_despejes_artefactos_explosivos " +
          "WHERE " +
          "(:idTipoDespejeArtefactoExplosivo IS NULL OR id_tipo_despeje_artefacto_explosivo = :idTipoDespejeArtefactoExplosivo) AND " +
          "(:keyword IS NULL OR nombre_tipo_despeje_artefacto_explosivo LIKE '%' || :keyword || '%') " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idTipoDespejeArtefactoExplosivo' AND :orderMode = 'ASC' THEN id_tipo_despeje_artefacto_explosivo END ASC, " +
          "CASE WHEN :orderBy = 'idTipoDespejeArtefactoExplosivo' AND :orderMode = 'DESC' THEN id_tipo_despeje_artefacto_explosivo END DESC, " +
          "CASE WHEN :orderBy = 'nombreTipoDespejeArtefactoExplosivo' AND :orderMode = 'ASC' THEN nombre_tipo_despeje_artefacto_explosivo END ASC, " +
          "CASE WHEN :orderBy = 'nombreTipoDespejeArtefactoExplosivo' AND :orderMode = 'DESC' THEN nombre_tipo_despeje_artefacto_explosivo END DESC", nativeQuery = true)
    Slice<TipoDespejeArtefactoExplosivo> findAllTiposDespejesArtefactosExplosivosPag(
          Pageable pageable, @Param("idTipoDespejeArtefactoExplosivo") Long idTipoDespejeArtefactoExplosivo, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<TipoDespejeArtefactoExplosivo> findByIdTipoDespejeArtefactoExplosivo(Long idTipoDespejeArtefactoExplosivo);
    
    TipoDespejeArtefactoExplosivo findByNombreTipoDespejeArtefactoExplosivo(String nombreTipoDespejeArtefactoExplosivo);
    
    @Query(value = "SELECT MAX(id_tipo_despeje_artefacto_explosivo) FROM tabla_tipos_despejes_artefactos_explosivos", nativeQuery = true)
    Long findMaxIdTipoDespejeArtefactoExplosivo();
}
