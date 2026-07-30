//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ElementoSubclasificacionEquipoIngeniero;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 19/06/2026.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface ElementoSubclasificacionEquipoIngenieroRepository extends JpaRepository<ElementoSubclasificacionEquipoIngeniero, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (ID + KEYWORD + NOMBRE ELEMENTO SUBCLASIFICACION EQUIPO INGENIERO + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_elementos_subclasificaciones_equipos_ingenieros " +
          "WHERE (:idElementoSubclasificacionEquipoIngeniero IS NULL OR tabla_elementos_subclasificaciones_equipos_ingenieros.id_elemento_subclasificacion_equipo_ingeniero = :idElementoSubclasificacionEquipoIngeniero) AND " +
          "(:keyword IS NULL OR UPPER(tabla_elementos_subclasificaciones_equipos_ingenieros.nombre_elemento_subclasificacion_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%')) AND " +
          "(:nombreElementoSubclasificacionEquipoIngeniero IS NULL OR UPPER(tabla_elementos_subclasificaciones_equipos_ingenieros.nombre_elemento_subclasificacion_equipo_ingeniero) = UPPER(:nombreElementoSubclasificacionEquipoIngeniero))", nativeQuery = true)
    Long findTotalRegistros(@Param("idElementoSubclasificacionEquipoIngeniero") Long idElementoSubclasificacionEquipoIngeniero, @Param("keyword") String keyword, @Param("nombreElementoSubclasificacionEquipoIngeniero") String nombreElementoSubclasificacionEquipoIngeniero);
    
    @Query(value = "SELECT * FROM tabla_elementos_subclasificaciones_equipos_ingenieros " +
          "WHERE (:idElementoSubclasificacionEquipoIngeniero IS NULL OR tabla_elementos_subclasificaciones_equipos_ingenieros.id_elemento_subclasificacion_equipo_ingeniero = :idElementoSubclasificacionEquipoIngeniero) AND " +
          "(:keyword IS NULL OR UPPER(tabla_elementos_subclasificaciones_equipos_ingenieros.nombre_elemento_subclasificacion_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%')) AND " +
          "(:nombreElementoSubclasificacionEquipoIngeniero IS NULL OR UPPER(tabla_elementos_subclasificaciones_equipos_ingenieros.nombre_elemento_subclasificacion_equipo_ingeniero) = UPPER(:nombreElementoSubclasificacionEquipoIngeniero)) " +
          "ORDER BY CASE WHEN :orderBy = 'idElementoSubclasificacionEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_elementos_subclasificaciones_equipos_ingenieros.id_elemento_subclasificacion_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'idElementoSubclasificacionEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_elementos_subclasificaciones_equipos_ingenieros.id_elemento_subclasificacion_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'nombreElementoSubclasificacionEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_elementos_subclasificaciones_equipos_ingenieros.nombre_elemento_subclasificacion_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'nombreElementoSubclasificacionEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_elementos_subclasificaciones_equipos_ingenieros.nombre_elemento_subclasificacion_equipo_ingeniero END DESC", nativeQuery = true)
    List<ElementoSubclasificacionEquipoIngeniero> findAllElementosSubclasificacionesEquiposIngenieros(@Param("idElementoSubclasificacionEquipoIngeniero") Long idElementoSubclasificacionEquipoIngeniero, @Param("keyword") String keyword, @Param("nombreElementoSubclasificacionEquipoIngeniero") String nombreElementoSubclasificacionEquipoIngeniero, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT * FROM tabla_elementos_subclasificaciones_equipos_ingenieros " +
          "WHERE (:idElementoSubclasificacionEquipoIngeniero IS NULL OR tabla_elementos_subclasificaciones_equipos_ingenieros.id_elemento_subclasificacion_equipo_ingeniero = :idElementoSubclasificacionEquipoIngeniero) AND " +
          "(:keyword IS NULL OR UPPER(tabla_elementos_subclasificaciones_equipos_ingenieros.nombre_elemento_subclasificacion_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%')) AND " +
          "(:nombreElementoSubclasificacionEquipoIngeniero IS NULL OR UPPER(tabla_elementos_subclasificaciones_equipos_ingenieros.nombre_elemento_subclasificacion_equipo_ingeniero) = UPPER(:nombreElementoSubclasificacionEquipoIngeniero)) " +
          "ORDER BY CASE WHEN :orderBy = 'idElementoSubclasificacionEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_elementos_subclasificaciones_equipos_ingenieros.id_elemento_subclasificacion_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'idElementoSubclasificacionEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_elementos_subclasificaciones_equipos_ingenieros.id_elemento_subclasificacion_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'nombreElementoSubclasificacionEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_elementos_subclasificaciones_equipos_ingenieros.nombre_elemento_subclasificacion_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'nombreElementoSubclasificacionEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_elementos_subclasificaciones_equipos_ingenieros.nombre_elemento_subclasificacion_equipo_ingeniero END DESC", nativeQuery = true)
    Slice<ElementoSubclasificacionEquipoIngeniero> findAllElementosSubclasificacionesEquiposIngenierosPag(Pageable pageable, @Param("idElementoSubclasificacionEquipoIngeniero") Long idElementoSubclasificacionEquipoIngeniero, @Param("keyword") String keyword, @Param("nombreElementoSubclasificacionEquipoIngeniero") String nombreElementoSubclasificacionEquipoIngeniero, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<ElementoSubclasificacionEquipoIngeniero> findByIdElementoSubclasificacionEquipoIngeniero(Long idElementoSubclasificacionEquipoIngeniero);
    
    @Query(value = "SELECT * FROM tabla_elementos_subclasificaciones_equipos_ingenieros " +
          "WHERE UPPER(nombre_elemento_subclasificacion_equipo_ingeniero) = UPPER(:nombreElementoSubclasificacionEquipoIngeniero) AND " +
          "id_subclasificacion_equipo_ingeniero = :idSubclasificacionEquipoIngeniero", nativeQuery = true)
    ElementoSubclasificacionEquipoIngeniero findByNombreElementoSubclasificacionEquipoIngenieroAndIdSubclasificacionEquipoIngeniero(@Param("nombreElementoSubclasificacionEquipoIngeniero") String nombreElementoSubclasificacionEquipoIngeniero, @Param("idSubclasificacionEquipoIngeniero") Long idSubclasificacionEquipoIngeniero);
    
    @Query(value = "SELECT elem.* FROM tabla_elementos_subclasificaciones_equipos_ingenieros elem " +
          "INNER JOIN tabla_clasificaciones_equipos_ingenieros clasif ON elem.id_clasificacion_equipo_ingeniero = clasif.id_clasificacion_equipo_ingeniero " +
          "INNER JOIN tabla_subclasificaciones_equipos_ingenieros sub ON elem.id_subclasificacion_equipo_ingeniero = sub.id_subclasificacion_equipo_ingeniero " +
          "INNER JOIN tabla_cuentas_equipos_ingenieros cuenta ON elem.id_cuenta_equipo_ingeniero = cuenta.id_cuenta_equipo_ingeniero " +
          "INNER JOIN tabla_clases_activos_equipos_ingenieros clase ON elem.id_clase_activo_equipo_ingeniero = clase.id_clase_activo_equipo_ingeniero " +
          "WHERE UPPER(elem.nombre_elemento_subclasificacion_equipo_ingeniero) = UPPER(:nombreElementoSubclasificacionEquipoIngeniero) AND " +
          "UPPER(clasif.nombre_clasificacion_equipo_ingeniero) = UPPER(:nombreClasificacionEquipoIngeniero) AND " +
          "UPPER(sub.nombre_subclasificacion_equipo_ingeniero) = UPPER(:nombreSubclasificacionEquipoIngeniero) AND " +
          "UPPER(cuenta.nombre_cuenta_equipo_ingeniero) = UPPER(:nombreCuentaEquipoIngeniero) AND " +
          "UPPER(clase.nombre_clase_activo_equipo_ingeniero) = UPPER(:nombreClaseActivoEquipoIngeniero)", nativeQuery = true)
    ElementoSubclasificacionEquipoIngeniero findByNombreElementoSubclasificacionEquipoIngenieroAndNombreClasificacionEquipoIngenieroAndNombreSubclasificacionEquipoIngenieroAndNombreCuentaEquipoIngenieroAndNombreClaseActivoEquipoIngeniero(@Param("nombreElementoSubclasificacionEquipoIngeniero") String nombreElementoSubclasificacionEquipoIngeniero, @Param("nombreClasificacionEquipoIngeniero") String nombreClasificacionEquipoIngeniero, @Param("nombreSubclasificacionEquipoIngeniero") String nombreSubclasificacionEquipoIngeniero, @Param("nombreCuentaEquipoIngeniero") String nombreCuentaEquipoIngeniero, @Param("nombreClaseActivoEquipoIngeniero") String nombreClaseActivoEquipoIngeniero);
    
    @Query(value = "SELECT MAX(id_elemento_subclasificacion_equipo_ingeniero) FROM tabla_elementos_subclasificaciones_equipos_ingenieros", nativeQuery = true)
    Long findMaxIdElementoSubclasificacionEquipoIngeniero();
}
