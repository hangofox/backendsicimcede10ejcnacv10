//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ClaseActivoEquipoIngeniero;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 24/03/2026.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface ClaseActivoEquipoIngenieroRepository extends JpaRepository<ClaseActivoEquipoIngeniero, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (ID + KEYWORD + NOMBRE CLASE ACTIVO EQUIPO INGENIERO + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_clases_activos_equipos_ingenieros " +
          "WHERE (:idClaseActivoEquipoIngeniero IS NULL OR tabla_clases_activos_equipos_ingenieros.id_clase_activo_equipo_ingeniero = :idClaseActivoEquipoIngeniero) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_clases_activos_equipos_ingenieros.nombre_clase_activo_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_clases_activos_equipos_ingenieros.numero_clase_activo_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:nombreClaseActivoEquipoIngeniero IS NULL OR UPPER(tabla_clases_activos_equipos_ingenieros.nombre_clase_activo_equipo_ingeniero) = UPPER(:nombreClaseActivoEquipoIngeniero))", nativeQuery = true)
    Long findTotalRegistros(@Param("idClaseActivoEquipoIngeniero") Long idClaseActivoEquipoIngeniero, @Param("keyword") String keyword, @Param("nombreClaseActivoEquipoIngeniero") String nombreClaseActivoEquipoIngeniero);
    
    @Query(value = "SELECT * FROM tabla_clases_activos_equipos_ingenieros " +
          "WHERE (:idClaseActivoEquipoIngeniero IS NULL OR tabla_clases_activos_equipos_ingenieros.id_clase_activo_equipo_ingeniero = :idClaseActivoEquipoIngeniero) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_clases_activos_equipos_ingenieros.nombre_clase_activo_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_clases_activos_equipos_ingenieros.numero_clase_activo_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:nombreClaseActivoEquipoIngeniero IS NULL OR UPPER(tabla_clases_activos_equipos_ingenieros.nombre_clase_activo_equipo_ingeniero) = UPPER(:nombreClaseActivoEquipoIngeniero)) " +
          "ORDER BY CASE WHEN :orderBy = 'idClaseActivoEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_clases_activos_equipos_ingenieros.id_clase_activo_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'idClaseActivoEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_clases_activos_equipos_ingenieros.id_clase_activo_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'nombreClaseActivoEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_clases_activos_equipos_ingenieros.nombre_clase_activo_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'nombreClaseActivoEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_clases_activos_equipos_ingenieros.nombre_clase_activo_equipo_ingeniero END DESC", nativeQuery = true)
    List<ClaseActivoEquipoIngeniero> findAllClasesActivosEquiposIngenieros(@Param("idClaseActivoEquipoIngeniero") Long idClaseActivoEquipoIngeniero, @Param("keyword") String keyword, @Param("nombreClaseActivoEquipoIngeniero") String nombreClaseActivoEquipoIngeniero, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT * FROM tabla_clases_activos_equipos_ingenieros " +
          "WHERE (:idClaseActivoEquipoIngeniero IS NULL OR tabla_clases_activos_equipos_ingenieros.id_clase_activo_equipo_ingeniero = :idClaseActivoEquipoIngeniero) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_clases_activos_equipos_ingenieros.nombre_clase_activo_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_clases_activos_equipos_ingenieros.numero_clase_activo_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:nombreClaseActivoEquipoIngeniero IS NULL OR UPPER(tabla_clases_activos_equipos_ingenieros.nombre_clase_activo_equipo_ingeniero) = UPPER(:nombreClaseActivoEquipoIngeniero)) " +
          "ORDER BY CASE WHEN :orderBy = 'idClaseActivoEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_clases_activos_equipos_ingenieros.id_clase_activo_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'idClaseActivoEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_clases_activos_equipos_ingenieros.id_clase_activo_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'nombreClaseActivoEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_clases_activos_equipos_ingenieros.nombre_clase_activo_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'nombreClaseActivoEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_clases_activos_equipos_ingenieros.nombre_clase_activo_equipo_ingeniero END DESC", nativeQuery = true)
    Slice<ClaseActivoEquipoIngeniero> findAllClasesActivosEquiposIngenierosProPag(Pageable pageable, @Param("idClaseActivoEquipoIngeniero") Long idClaseActivoEquipoIngeniero, @Param("keyword") String keyword, @Param("nombreClaseActivoEquipoIngeniero") String nombreClaseActivoEquipoIngeniero, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<ClaseActivoEquipoIngeniero> findByIdClaseActivoEquipoIngeniero(Long idClaseActivoEquipoIngeniero);
    
    @Query(value = "SELECT * FROM tabla_clases_activos_equipos_ingenieros " +
          "WHERE UPPER(nombre_clase_activo_equipo_ingeniero) = UPPER(:nombreClaseActivoEquipoIngeniero)", nativeQuery = true)
    ClaseActivoEquipoIngeniero findByNombreClaseActivoEquipoIngeniero(@Param("nombreClaseActivoEquipoIngeniero") String nombreClaseActivoEquipoIngeniero);

    @Query(value = "SELECT * FROM tabla_clases_activos_equipos_ingenieros " +
          "WHERE UPPER(numero_clase_activo_equipo_ingeniero) = UPPER(:numeroClaseActivoEquipoIngeniero)", nativeQuery = true)
    ClaseActivoEquipoIngeniero findByNumeroClaseActivoEquipoIngeniero(@Param("numeroClaseActivoEquipoIngeniero") String numeroClaseActivoEquipoIngeniero);

    @Query(value = "SELECT MAX(id_clase_activo_equipo_ingeniero) FROM tabla_clases_activos_equipos_ingenieros", nativeQuery = true)
    Long findMaxIdClaseActivoEquipoIngeniero();
}
