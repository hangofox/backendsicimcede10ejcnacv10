//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.LineaEquipoIngeniero;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 17/12/2025.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface LineaEquipoIngenieroRepository extends JpaRepository<LineaEquipoIngeniero,Long> {
    
    @Query(value = "SELECT COUNT(*) FROM tabla_lineas_equipos_ingenieros WHERE (:idLineaEquipoIngeniero IS NULL OR id_linea_equipo_ingeniero = :idLineaEquipoIngeniero) AND (:keyword IS NULL OR UPPER(nombre_linea_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%'))", nativeQuery = true)
    Long findTotalRegistros(@Param("idLineaEquipoIngeniero") Long idLineaEquipoIngeniero, @Param("keyword") String keyword);

    @Query(value = "SELECT * FROM tabla_lineas_equipos_ingenieros WHERE (:idLineaEquipoIngeniero IS NULL OR id_linea_equipo_ingeniero = :idLineaEquipoIngeniero) AND (:keyword IS NULL OR UPPER(nombre_linea_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%')) ORDER BY CASE WHEN :orderBy = 'idLineaEquipoIngeniero' AND :orderMode = 'ASC' THEN id_linea_equipo_ingeniero END ASC, CASE WHEN :orderBy = 'idLineaEquipoIngeniero' AND :orderMode = 'DESC' THEN id_linea_equipo_ingeniero END DESC, CASE WHEN :orderBy = 'nombreLineaEquipoIngeniero' AND :orderMode = 'ASC' THEN nombre_linea_equipo_ingeniero END ASC, CASE WHEN :orderBy = 'nombreLineaEquipoIngeniero' AND :orderMode = 'DESC' THEN nombre_linea_equipo_ingeniero END DESC", nativeQuery = true)
    List<LineaEquipoIngeniero> findAllLineasEquiposIngenieros(@Param("idLineaEquipoIngeniero") Long idLineaEquipoIngeniero, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);

    @Query(value = "SELECT * FROM tabla_lineas_equipos_ingenieros WHERE (:idLineaEquipoIngeniero IS NULL OR id_linea_equipo_ingeniero = :idLineaEquipoIngeniero) AND (:keyword IS NULL OR UPPER(nombre_linea_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%')) ORDER BY CASE WHEN :orderBy = 'idLineaEquipoIngeniero' AND :orderMode = 'ASC' THEN id_linea_equipo_ingeniero END ASC, CASE WHEN :orderBy = 'idLineaEquipoIngeniero' AND :orderMode = 'DESC' THEN id_linea_equipo_ingeniero END DESC, CASE WHEN :orderBy = 'nombreLineaEquipoIngeniero' AND :orderMode = 'ASC' THEN nombre_linea_equipo_ingeniero END ASC, CASE WHEN :orderBy = 'nombreLineaEquipoIngeniero' AND :orderMode = 'DESC' THEN nombre_linea_equipo_ingeniero END DESC", nativeQuery = true)
    Slice<LineaEquipoIngeniero> findAllLineasEquiposIngenierosPage(Pageable pageable, @Param("idLineaEquipoIngeniero") Long idLineaEquipoIngeniero, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<LineaEquipoIngeniero> findByIdLineaEquipoIngeniero(Long idLineaEquipoIngeniero);
    
    LineaEquipoIngeniero findByNombreLineaEquipoIngeniero(String nombreLineaEquipoIngeniero);
    
    @Query(value = "SELECT MAX(id_linea_equipo_ingeniero) FROM tabla_lineas_equipos_ingenieros", nativeQuery = true)
    Long findMaxIdLineaEquipoIngeniero();
}
