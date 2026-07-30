//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoAltaEquipoIngeniero;
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
public interface TipoAltaEquipoIngenieroRepository extends JpaRepository<TipoAltaEquipoIngeniero,Long> {
    
    //1. CONTADORES DE REGISTROS FILTRADOS.
    @Query(value = "" +
          "SELECT COUNT(*) " +
          "FROM tabla_tipos_altas_equipos_ingenieros " +
          "WHERE " +
          "(:idTipoAltaEquipoIngeniero IS NULL OR id_tipo_alta_equipo_ingeniero = :idTipoAltaEquipoIngeniero) AND " +
          "(:keyword IS NULL OR nombre_tipo_alta_equipo_ingeniero LIKE '%' || :keyword || '%')", nativeQuery = true)
    Long findTotalRegistros(@Param("idTipoAltaEquipoIngeniero") Long idTipoAltaEquipoIngeniero, @Param("keyword") String keyword);
    
    //1. LISTADO DE REGISTROS FILTRADOS.
    @Query(value = "" +
          "SELECT * " +
          "FROM tabla_tipos_altas_equipos_ingenieros " +
          "WHERE " +
          "(:idTipoAltaEquipoIngeniero IS NULL OR id_tipo_alta_equipo_ingeniero = :idTipoAltaEquipoIngeniero) AND " +
          "(:keyword IS NULL OR nombre_tipo_alta_equipo_ingeniero LIKE '%' || :keyword || '%') " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idTipoAltaEquipoIngeniero' AND :orderMode = 'ASC' THEN id_tipo_alta_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'idTipoAltaEquipoIngeniero' AND :orderMode = 'DESC' THEN id_tipo_alta_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'nombreTipoAltaEquipoIngeniero' AND :orderMode = 'ASC' THEN nombre_tipo_alta_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'nombreTipoAltaEquipoIngeniero' AND :orderMode = 'DESC' THEN nombre_tipo_alta_equipo_ingeniero END DESC", nativeQuery = true)
    List<TipoAltaEquipoIngeniero> findAllTiposAltasEquiposIngenieros(@Param("idTipoAltaEquipoIngeniero") Long idTipoAltaEquipoIngeniero, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);

    @Query(value = "" +
          "SELECT * " +
          "FROM tabla_tipos_altas_equipos_ingenieros " +
          "WHERE " +
          "(:idTipoAltaEquipoIngeniero IS NULL OR id_tipo_alta_equipo_ingeniero = :idTipoAltaEquipoIngeniero) AND " +
          "(:keyword IS NULL OR nombre_tipo_alta_equipo_ingeniero LIKE '%' || :keyword || '%') " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idTipoAltaEquipoIngeniero' AND :orderMode = 'ASC' THEN id_tipo_alta_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'idTipoAltaEquipoIngeniero' AND :orderMode = 'DESC' THEN id_tipo_alta_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'nombreTipoAltaEquipoIngeniero' AND :orderMode = 'ASC' THEN nombre_tipo_alta_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'nombreTipoAltaEquipoIngeniero' AND :orderMode = 'DESC' THEN nombre_tipo_alta_equipo_ingeniero END DESC", nativeQuery = true)
    Slice<TipoAltaEquipoIngeniero> findAllTiposAltasEquiposIngenierosPag(Pageable pageable, @Param("idTipoAltaEquipoIngeniero") Long idTipoAltaEquipoIngeniero, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<TipoAltaEquipoIngeniero> findByIdTipoAltaEquipoIngeniero(Long idTipoAltaEquipoIngeniero);
    
    TipoAltaEquipoIngeniero findByNombreTipoAltaEquipoIngeniero(String nombreTipoAltaEquipoIngeniero);
    
    @Query(value = "SELECT MAX(id_tipo_alta_equipo_ingeniero) FROM tabla_tipos_altas_equipos_ingenieros", nativeQuery = true)
    Long findMaxIdTipoAltaEquipoIngeniero();
}
