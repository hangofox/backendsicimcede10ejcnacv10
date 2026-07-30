//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ClasificacionEquipoIngeniero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/12/2025.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface ClasificacionEquipoIngenieroRepository extends JpaRepository<ClasificacionEquipoIngeniero,Long> {
    
    @Query(value = "SELECT COUNT(*) FROM tabla_clasificaciones_equipos_ingenieros WHERE (:idClasificacionEquipoIngeniero IS NULL OR id_clasificacion_equipo_ingeniero = :idClasificacionEquipoIngeniero) AND (:keyword IS NULL OR UPPER(nombre_clasificacion_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%'))", nativeQuery = true)
    Long findTotalRegistros(@Param("idClasificacionEquipoIngeniero") Long idClasificacionEquipoIngeniero, @Param("keyword") String keyword);
    
    @Query(value = "SELECT * FROM tabla_clasificaciones_equipos_ingenieros WHERE (:idClasificacionEquipoIngeniero IS NULL OR id_clasificacion_equipo_ingeniero = :idClasificacionEquipoIngeniero) AND (:keyword IS NULL OR UPPER(nombre_clasificacion_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%')) ORDER BY CASE WHEN :orderBy = 'idClasificacionEquipoIngeniero' AND :orderMode = 'ASC' THEN id_clasificacion_equipo_ingeniero END ASC, CASE WHEN :orderBy = 'idClasificacionEquipoIngeniero' AND :orderMode = 'DESC' THEN id_clasificacion_equipo_ingeniero END DESC, CASE WHEN :orderBy = 'nombreClasificacionEquipoIngeniero' AND :orderMode = 'ASC' THEN nombre_clasificacion_equipo_ingeniero END ASC, CASE WHEN :orderBy = 'nombreClasificacionEquipoIngeniero' AND :orderMode = 'DESC' THEN nombre_clasificacion_equipo_ingeniero END DESC", nativeQuery = true)
    List<ClasificacionEquipoIngeniero> findAllClasificacionesEquiposIngenieros(@Param("idClasificacionEquipoIngeniero") Long idClasificacionEquipoIngeniero, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT * FROM tabla_clasificaciones_equipos_ingenieros WHERE (:idClasificacionEquipoIngeniero IS NULL OR id_clasificacion_equipo_ingeniero = :idClasificacionEquipoIngeniero) AND (:keyword IS NULL OR UPPER(nombre_clasificacion_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%')) ORDER BY CASE WHEN :orderBy = 'idClasificacionEquipoIngeniero' AND :orderMode = 'ASC' THEN id_clasificacion_equipo_ingeniero END ASC, CASE WHEN :orderBy = 'idClasificacionEquipoIngeniero' AND :orderMode = 'DESC' THEN id_clasificacion_equipo_ingeniero END DESC, CASE WHEN :orderBy = 'nombreClasificacionEquipoIngeniero' AND :orderMode = 'ASC' THEN nombre_clasificacion_equipo_ingeniero END ASC, CASE WHEN :orderBy = 'nombreClasificacionEquipoIngeniero' AND :orderMode = 'DESC' THEN nombre_clasificacion_equipo_ingeniero END DESC", nativeQuery = true)
    Slice<ClasificacionEquipoIngeniero> findAllClasificacionesEquiposIngenierosPag(Pageable pageable, @Param("idClasificacionEquipoIngeniero") Long idClasificacionEquipoIngeniero, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<ClasificacionEquipoIngeniero> findByIdClasificacionEquipoIngeniero(Long idClasificacionEquipoIngeniero);
    
    ClasificacionEquipoIngeniero findByNombreClasificacionEquipoIngeniero(String nombreClasificacionEquipoIngeniero);
    
    @Query(value = "SELECT MAX(id_clasificacion_equipo_ingeniero) FROM tabla_clasificaciones_equipos_ingenieros", nativeQuery = true)
    Long findMaxIdClasificacionEquipoIngeniero();
}
