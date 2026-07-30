//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoContribucionSaneamientoBasico;
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
public interface TipoContribucionSaneamientoBasicoRepository extends JpaRepository<TipoContribucionSaneamientoBasico,Long> {
    
    //1. CONTADORES DE REGISTROS FILTRADOS.
    @Query(value = "" +
          "SELECT COUNT(*) " +
          "FROM tabla_tipos_contribuciones_saneamientos_basicos " +
          "WHERE " +
          "(:idTipoContribucionSaneamientoBasico IS NULL OR id_tipo_contribucion_saneamiento_basico = :idTipoContribucionSaneamientoBasico) AND " +
          "(:keyword IS NULL OR nombre_tipo_contribucion_saneamiento_basico LIKE '%' || :keyword || '%')", nativeQuery = true)
    Long findTotalRegistros(@Param("idTipoContribucionSaneamientoBasico") Long idTipoContribucionSaneamientoBasico, @Param("keyword") String keyword);
    
    //1. LISTADO DE REGISTROS FILTRADOS.
    @Query(value = "" +
          "SELECT * " +
          "FROM tabla_tipos_contribuciones_saneamientos_basicos " +
          "WHERE " +
          "(:idTipoContribucionSaneamientoBasico IS NULL OR id_tipo_contribucion_saneamiento_basico = :idTipoContribucionSaneamientoBasico) AND " +
          "(:keyword IS NULL OR nombre_tipo_contribucion_saneamiento_basico LIKE '%' || :keyword || '%') " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idTipoContribucionSaneamientoBasico' AND :orderMode = 'ASC' THEN id_tipo_contribucion_saneamiento_basico END ASC, " +
          "CASE WHEN :orderBy = 'idTipoContribucionSaneamientoBasico' AND :orderMode = 'DESC' THEN id_tipo_contribucion_saneamiento_basico END DESC, " +
          "CASE WHEN :orderBy = 'nombreTipoContribucionSaneamientoBasico' AND :orderMode = 'ASC' THEN nombre_tipo_contribucion_saneamiento_basico END ASC, " +
          "CASE WHEN :orderBy = 'nombreTipoContribucionSaneamientoBasico' AND :orderMode = 'DESC' THEN nombre_tipo_contribucion_saneamiento_basico END DESC", nativeQuery = true)
    List<TipoContribucionSaneamientoBasico> findAllTiposContribucionesSaneamientosBasicos(
          @Param("idTipoContribucionSaneamientoBasico") Long idTipoContribucionSaneamientoBasico, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);

    @Query(value = "" +
          "SELECT * " +
          "FROM tabla_tipos_contribuciones_saneamientos_basicos " +
          "WHERE " +
          "(:idTipoContribucionSaneamientoBasico IS NULL OR id_tipo_contribucion_saneamiento_basico = :idTipoContribucionSaneamientoBasico) AND " +
          "(:keyword IS NULL OR nombre_tipo_contribucion_saneamiento_basico LIKE '%' || :keyword || '%') " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idTipoContribucionSaneamientoBasico' AND :orderMode = 'ASC' THEN id_tipo_contribucion_saneamiento_basico END ASC, " +
          "CASE WHEN :orderBy = 'idTipoContribucionSaneamientoBasico' AND :orderMode = 'DESC' THEN id_tipo_contribucion_saneamiento_basico END DESC, " +
          "CASE WHEN :orderBy = 'nombreTipoContribucionSaneamientoBasico' AND :orderMode = 'ASC' THEN nombre_tipo_contribucion_saneamiento_basico END ASC, " +
          "CASE WHEN :orderBy = 'nombreTipoContribucionSaneamientoBasico' AND :orderMode = 'DESC' THEN nombre_tipo_contribucion_saneamiento_basico END DESC", nativeQuery = true)
    Slice<TipoContribucionSaneamientoBasico> findAllTiposContribucionesSaneamientosBasicosPag(
          Pageable pageable, @Param("idTipoContribucionSaneamientoBasico") Long idTipoContribucionSaneamientoBasico, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);

    Optional<TipoContribucionSaneamientoBasico> findByIdTipoContribucionSaneamientoBasico(Long idTipoContribucionSaneamientoBasico);

    TipoContribucionSaneamientoBasico findByNombreTipoContribucionSaneamientoBasico(String nombreTipoContribucionSaneamientoBasico);

    @Query(value = "SELECT MAX(id_tipo_contribucion_saneamiento_basico) FROM tabla_tipos_contribuciones_saneamientos_basicos", nativeQuery = true)
    Long findMaxIdTipoContribucionSaneamientoBasico();
}
