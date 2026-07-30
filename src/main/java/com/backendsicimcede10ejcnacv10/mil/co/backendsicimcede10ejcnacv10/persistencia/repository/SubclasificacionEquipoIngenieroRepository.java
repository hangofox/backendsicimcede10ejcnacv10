//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.SubclasificacionEquipoIngeniero;
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
public interface SubclasificacionEquipoIngenieroRepository extends JpaRepository<SubclasificacionEquipoIngeniero,Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (ID + KEYWORD + NOMBRE DE CLASIFICACION DE EQUIPO DE INGENIERO + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_subclasificaciones_equipos_ingenieros, tabla_clasificaciones_equipos_ingenieros " +
          "WHERE (tabla_subclasificaciones_equipos_ingenieros.id_clasificacion_equipo_ingeniero = tabla_clasificaciones_equipos_ingenieros.id_clasificacion_equipo_ingeniero) AND " +
          "(:idSubclasificacionEquipoIngeniero IS NULL OR tabla_subclasificaciones_equipos_ingenieros.id_subclasificacion_equipo_ingeniero = :idSubclasificacionEquipoIngeniero) AND " +
          "(:keyword IS NULL OR (tabla_subclasificaciones_equipos_ingenieros.nombre_subclasificacion_equipo_ingeniero LIKE '%' || :keyword || '%' OR " +
          "tabla_clasificaciones_equipos_ingenieros.nombre_clasificacion_equipo_ingeniero LIKE '%' || :keyword || '%')) AND " +
          "(:nombreClasificacionEquipoIngeniero IS NULL OR tabla_clasificaciones_equipos_ingenieros.nombre_clasificacion_equipo_ingeniero = :nombreClasificacionEquipoIngeniero) AND " +
          "(:nombreSubclasificacionEquipoIngeniero IS NULL OR tabla_subclasificaciones_equipos_ingenieros.nombre_subclasificacion_equipo_ingeniero = :nombreSubclasificacionEquipoIngeniero)", nativeQuery = true)
    Long findTotalRegistros(@Param("idSubclasificacionEquipoIngeniero") Long idSubclasificacionEquipoIngeniero, @Param("keyword") String keyword, @Param("nombreSubclasificacionEquipoIngeniero") String nombreSubclasificacionEquipoIngeniero, @Param("nombreClasificacionEquipoIngeniero") String nombreClasificacionEquipoIngeniero);
    
    @Query(value = "SELECT tabla_subclasificaciones_equipos_ingenieros.* FROM tabla_subclasificaciones_equipos_ingenieros, tabla_clasificaciones_equipos_ingenieros " +
          "WHERE (tabla_subclasificaciones_equipos_ingenieros.id_clasificacion_equipo_ingeniero = tabla_clasificaciones_equipos_ingenieros.id_clasificacion_equipo_ingeniero) AND " +
          "(:idSubclasificacionEquipoIngeniero IS NULL OR tabla_subclasificaciones_equipos_ingenieros.id_subclasificacion_equipo_ingeniero = :idSubclasificacionEquipoIngeniero) AND " +
          "(:keyword IS NULL OR (tabla_subclasificaciones_equipos_ingenieros.nombre_subclasificacion_equipo_ingeniero LIKE '%' || :keyword || '%' OR " +
          "tabla_clasificaciones_equipos_ingenieros.nombre_clasificacion_equipo_ingeniero LIKE '%' || :keyword || '%')) AND " +
          "(:nombreSubclasificacionEquipoIngeniero IS NULL OR tabla_subclasificaciones_equipos_ingenieros.nombre_subclasificacion_equipo_ingeniero = :nombreSubclasificacionEquipoIngeniero) AND " +
          "(:nombreClasificacionEquipoIngeniero IS NULL OR tabla_clasificaciones_equipos_ingenieros.nombre_clasificacion_equipo_ingeniero = :nombreClasificacionEquipoIngeniero) " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idSubclasificacionEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_subclasificaciones_equipos_ingenieros.id_subclasificacion_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'idSubclasificacionEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_subclasificaciones_equipos_ingenieros.id_subclasificacion_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'nombreSubclasificacionEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_subclasificaciones_equipos_ingenieros.nombre_subclasificacion_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'nombreSubclasificacionEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_subclasificaciones_equipos_ingenieros.nombre_subclasificacion_equipo_ingeniero END DESC", nativeQuery = true)
    List<SubclasificacionEquipoIngeniero> findAllSubclasificacionesEquiposIngenieros(@Param("idSubclasificacionEquipoIngeniero") Long idSubclasificacionEquipoIngeniero, @Param("keyword") String keyword, @Param("nombreSubclasificacionEquipoIngeniero") String nombreSubclasificacionEquipoIngeniero, @Param("nombreClasificacionEquipoIngeniero") String nombreClasificacionEquipoIngeniero, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_subclasificaciones_equipos_ingenieros.* FROM tabla_subclasificaciones_equipos_ingenieros, tabla_clasificaciones_equipos_ingenieros " +
          "WHERE (tabla_subclasificaciones_equipos_ingenieros.id_clasificacion_equipo_ingeniero = tabla_clasificaciones_equipos_ingenieros.id_clasificacion_equipo_ingeniero) AND " +
          "(:idSubclasificacionEquipoIngeniero IS NULL OR tabla_subclasificaciones_equipos_ingenieros.id_subclasificacion_equipo_ingeniero = :idSubclasificacionEquipoIngeniero) AND " +
          "(:keyword IS NULL OR (tabla_subclasificaciones_equipos_ingenieros.nombre_subclasificacion_equipo_ingeniero LIKE '%' || :keyword || '%' OR " +
          "tabla_clasificaciones_equipos_ingenieros.nombre_clasificacion_equipo_ingeniero LIKE '%' || :keyword || '%')) AND " +
          "(:nombreSubclasificacionEquipoIngeniero IS NULL OR tabla_subclasificaciones_equipos_ingenieros.nombre_subclasificacion_equipo_ingeniero = :nombreSubclasificacionEquipoIngeniero) AND " +
          "(:nombreClasificacionEquipoIngeniero IS NULL OR tabla_clasificaciones_equipos_ingenieros.nombre_clasificacion_equipo_ingeniero = :nombreClasificacionEquipoIngeniero) " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idSubclasificacionEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_subclasificaciones_equipos_ingenieros.id_subclasificacion_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'idSubclasificacionEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_subclasificaciones_equipos_ingenieros.id_subclasificacion_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'nombreSubclasificacionEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_subclasificaciones_equipos_ingenieros.nombre_subclasificacion_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'nombreSubclasificacionEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_subclasificaciones_equipos_ingenieros.nombre_subclasificacion_equipo_ingeniero END DESC", nativeQuery = true)
    Slice<SubclasificacionEquipoIngeniero> findAllSubclasificacionesEquiposIngenierosPag(Pageable pageable, @Param("idSubclasificacionEquipoIngeniero") Long idSubclasificacionEquipoIngeniero, @Param("keyword") String keyword, @Param("nombreSubclasificacionEquipoIngeniero") String nombreSubclasificacionEquipoIngeniero, @Param("nombreClasificacionEquipoIngeniero") String nombreClasificacionEquipoIngeniero, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<SubclasificacionEquipoIngeniero> findByIdSubclasificacionEquipoIngeniero(Long idSubclasificacionEquipoIngeniero);
    
    @Query(value = "SELECT tabla_subclasificaciones_equipos_ingenieros.* FROM tabla_subclasificaciones_equipos_ingenieros, tabla_clasificaciones_equipos_ingenieros WHERE tabla_subclasificaciones_equipos_ingenieros.id_clasificacion_equipo_ingeniero = tabla_clasificaciones_equipos_ingenieros.id_clasificacion_equipo_ingeniero AND UPPER(tabla_subclasificaciones_equipos_ingenieros.nombre_subclasificacion_equipo_ingeniero) = UPPER(:nombreSubclasificacionEquipoIngeniero) AND UPPER(tabla_clasificaciones_equipos_ingenieros.nombre_clasificacion_equipo_ingeniero) = UPPER(:nombreClasificacionEquipoIngeniero)", nativeQuery = true)
    SubclasificacionEquipoIngeniero findByNombreSubclasificacionEquipoIngenieroAndNombreClasificacionEquipoIngeniero(@Param("nombreSubclasificacionEquipoIngeniero") String nombreSubclasificacionEquipoIngeniero, @Param("nombreClasificacionEquipoIngeniero") String nombreClasificacionEquipoIngeniero);
    
    @Query(value = "SELECT MAX(id_subclasificacion_equipo_ingeniero) FROM tabla_subclasificaciones_equipos_ingenieros", nativeQuery = true)
    Long findMaxIdSubclasificacionEquipoIngeniero();
}
