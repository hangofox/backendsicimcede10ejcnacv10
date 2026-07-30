//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.EquipoIngeniero;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 30/03/2026.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface EquipoIngenieroRepository extends JpaRepository<EquipoIngeniero, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (ID + KEYWORD + SIGLA O ACRONIMO UNIDAD MILITAR + NOMBRE ELEMENTO SUBCLASIFICACION EQUIPO INGENIERO + ESTADO + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_equipos_ingenieros, tabla_unidades_militares, tabla_clasificaciones_equipos_ingenieros, tabla_subclasificaciones_equipos_ingenieros, tabla_elementos_subclasificaciones_equipos_ingenieros " +
          "WHERE (tabla_equipos_ingenieros.id_unidad_militar = tabla_unidades_militares.id_unidad_militar) AND " +
          "(tabla_equipos_ingenieros.id_clasificacion_equipo_ingeniero = tabla_clasificaciones_equipos_ingenieros.id_clasificacion_equipo_ingeniero) AND " +
          "(tabla_equipos_ingenieros.id_subclasificacion_equipo_ingeniero = tabla_subclasificaciones_equipos_ingenieros.id_subclasificacion_equipo_ingeniero) AND " +
          "(tabla_equipos_ingenieros.id_elemento_subclasificacion_equipo_ingeniero = tabla_elementos_subclasificaciones_equipos_ingenieros.id_elemento_subclasificacion_equipo_ingeniero) AND " +
          "(:idEquipoIngeniero IS NULL OR tabla_equipos_ingenieros.id_equipo_ingeniero = :idEquipoIngeniero) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_equipos_ingenieros.denominacion_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_equipos_ingenieros.numero_inventario_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_equipos_ingenieros.numero_activo_fijo_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_elementos_subclasificaciones_equipos_ingenieros.nombre_elemento_subclasificacion_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:siglaoAcronimoUnidadMilitar IS NULL OR UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) = UPPER(:siglaoAcronimoUnidadMilitar)) AND " +
          "(:nombreClasificacionEquipoIngeniero IS NULL OR UPPER(tabla_clasificaciones_equipos_ingenieros.nombre_clasificacion_equipo_ingeniero) = UPPER(:nombreClasificacionEquipoIngeniero)) AND " +
          "(:nombreSubclasificacionEquipoIngeniero IS NULL OR UPPER(tabla_subclasificaciones_equipos_ingenieros.nombre_subclasificacion_equipo_ingeniero) = UPPER(:nombreSubclasificacionEquipoIngeniero)) AND " +
          "(:nombreElementoSubclasificacionEquipoIngeniero IS NULL OR UPPER(tabla_elementos_subclasificaciones_equipos_ingenieros.nombre_elemento_subclasificacion_equipo_ingeniero) = UPPER(:nombreElementoSubclasificacionEquipoIngeniero)) AND " +
          "(:estado IS NULL OR UPPER(tabla_equipos_ingenieros.estado_uso_equipo_ingeniero) = UPPER(:estado))", nativeQuery = true)
    Long findTotalRegistros(@Param("idEquipoIngeniero") Long idEquipoIngeniero, @Param("keyword") String keyword, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar, @Param("nombreClasificacionEquipoIngeniero") String nombreClasificacionEquipoIngeniero, @Param("nombreSubclasificacionEquipoIngeniero") String nombreSubclasificacionEquipoIngeniero, @Param("nombreElementoSubclasificacionEquipoIngeniero") String nombreElementoSubclasificacionEquipoIngeniero, @Param("estado") String estado);
    
    @Query(value = "SELECT tabla_equipos_ingenieros.* FROM tabla_equipos_ingenieros, tabla_unidades_militares, tabla_clasificaciones_equipos_ingenieros, tabla_subclasificaciones_equipos_ingenieros, tabla_elementos_subclasificaciones_equipos_ingenieros " +
          "WHERE (tabla_equipos_ingenieros.id_unidad_militar = tabla_unidades_militares.id_unidad_militar) AND " +
          "(tabla_equipos_ingenieros.id_clasificacion_equipo_ingeniero = tabla_clasificaciones_equipos_ingenieros.id_clasificacion_equipo_ingeniero) AND " +
          "(tabla_equipos_ingenieros.id_subclasificacion_equipo_ingeniero = tabla_subclasificaciones_equipos_ingenieros.id_subclasificacion_equipo_ingeniero) AND " +
          "(tabla_equipos_ingenieros.id_elemento_subclasificacion_equipo_ingeniero = tabla_elementos_subclasificaciones_equipos_ingenieros.id_elemento_subclasificacion_equipo_ingeniero) AND " +
          "(:idEquipoIngeniero IS NULL OR tabla_equipos_ingenieros.id_equipo_ingeniero = :idEquipoIngeniero) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_equipos_ingenieros.denominacion_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_equipos_ingenieros.numero_inventario_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_equipos_ingenieros.numero_activo_fijo_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_elementos_subclasificaciones_equipos_ingenieros.nombre_elemento_subclasificacion_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:siglaoAcronimoUnidadMilitar IS NULL OR UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) = UPPER(:siglaoAcronimoUnidadMilitar)) AND " +
          "(:nombreClasificacionEquipoIngeniero IS NULL OR UPPER(tabla_clasificaciones_equipos_ingenieros.nombre_clasificacion_equipo_ingeniero) = UPPER(:nombreClasificacionEquipoIngeniero)) AND " +
          "(:nombreSubclasificacionEquipoIngeniero IS NULL OR UPPER(tabla_subclasificaciones_equipos_ingenieros.nombre_subclasificacion_equipo_ingeniero) = UPPER(:nombreSubclasificacionEquipoIngeniero)) AND " +
          "(:nombreElementoSubclasificacionEquipoIngeniero IS NULL OR UPPER(tabla_elementos_subclasificaciones_equipos_ingenieros.nombre_elemento_subclasificacion_equipo_ingeniero) = UPPER(:nombreElementoSubclasificacionEquipoIngeniero)) AND " +
          "(:estado IS NULL OR UPPER(tabla_equipos_ingenieros.estado_uso_equipo_ingeniero) = UPPER(:estado)) " +
          "ORDER BY CASE WHEN :orderBy = 'idEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_equipos_ingenieros.id_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'idEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_equipos_ingenieros.id_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'denominacionEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_equipos_ingenieros.denominacion_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'denominacionEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_equipos_ingenieros.denominacion_equipo_ingeniero END DESC", nativeQuery = true)
    List<EquipoIngeniero> findAllEquiposIngenieros(@Param("idEquipoIngeniero") Long idEquipoIngeniero, @Param("keyword") String keyword, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar, @Param("nombreClasificacionEquipoIngeniero") String nombreClasificacionEquipoIngeniero, @Param("nombreSubclasificacionEquipoIngeniero") String nombreSubclasificacionEquipoIngeniero, @Param("nombreElementoSubclasificacionEquipoIngeniero") String nombreElementoSubclasificacionEquipoIngeniero, @Param("estado") String estado, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_equipos_ingenieros.* FROM tabla_equipos_ingenieros, tabla_unidades_militares, tabla_clasificaciones_equipos_ingenieros, tabla_subclasificaciones_equipos_ingenieros, tabla_elementos_subclasificaciones_equipos_ingenieros " +
          "WHERE (tabla_equipos_ingenieros.id_unidad_militar = tabla_unidades_militares.id_unidad_militar) AND " +
          "(tabla_equipos_ingenieros.id_clasificacion_equipo_ingeniero = tabla_clasificaciones_equipos_ingenieros.id_clasificacion_equipo_ingeniero) AND " +
          "(tabla_equipos_ingenieros.id_subclasificacion_equipo_ingeniero = tabla_subclasificaciones_equipos_ingenieros.id_subclasificacion_equipo_ingeniero) AND " +
          "(tabla_equipos_ingenieros.id_elemento_subclasificacion_equipo_ingeniero = tabla_elementos_subclasificaciones_equipos_ingenieros.id_elemento_subclasificacion_equipo_ingeniero) AND " +
          "(:idEquipoIngeniero IS NULL OR tabla_equipos_ingenieros.id_equipo_ingeniero = :idEquipoIngeniero) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_equipos_ingenieros.denominacion_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_equipos_ingenieros.numero_inventario_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_equipos_ingenieros.numero_activo_fijo_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_elementos_subclasificaciones_equipos_ingenieros.nombre_elemento_subclasificacion_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:siglaoAcronimoUnidadMilitar IS NULL OR UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) = UPPER(:siglaoAcronimoUnidadMilitar)) AND " +
          "(:nombreClasificacionEquipoIngeniero IS NULL OR UPPER(tabla_clasificaciones_equipos_ingenieros.nombre_clasificacion_equipo_ingeniero) = UPPER(:nombreClasificacionEquipoIngeniero)) AND " +
          "(:nombreSubclasificacionEquipoIngeniero IS NULL OR UPPER(tabla_subclasificaciones_equipos_ingenieros.nombre_subclasificacion_equipo_ingeniero) = UPPER(:nombreSubclasificacionEquipoIngeniero)) AND " +
          "(:nombreElementoSubclasificacionEquipoIngeniero IS NULL OR UPPER(tabla_elementos_subclasificaciones_equipos_ingenieros.nombre_elemento_subclasificacion_equipo_ingeniero) = UPPER(:nombreElementoSubclasificacionEquipoIngeniero)) AND " +
          "(:estado IS NULL OR UPPER(tabla_equipos_ingenieros.estado_uso_equipo_ingeniero) = UPPER(:estado)) " +
          "ORDER BY CASE WHEN :orderBy = 'idEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_equipos_ingenieros.id_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'idEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_equipos_ingenieros.id_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'denominacionEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_equipos_ingenieros.denominacion_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'denominacionEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_equipos_ingenieros.denominacion_equipo_ingeniero END DESC", nativeQuery = true)
    Slice<EquipoIngeniero> findAllEquiposIngenierosPag(Pageable pageable, @Param("idEquipoIngeniero") Long idEquipoIngeniero, @Param("keyword") String keyword, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar, @Param("nombreClasificacionEquipoIngeniero") String nombreClasificacionEquipoIngeniero, @Param("nombreSubclasificacionEquipoIngeniero") String nombreSubclasificacionEquipoIngeniero, @Param("nombreElementoSubclasificacionEquipoIngeniero") String nombreElementoSubclasificacionEquipoIngeniero, @Param("estado") String estado, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<EquipoIngeniero> findByIdEquipoIngeniero(Long idEquipoIngeniero);
    
    //BUSQUEDA UNITARIA POR CAMPOS ÚNICOS COMBINADOS (NUMERO INVENTARIO, NUMERO ACTIVO FIJO):
    @Query(value = "SELECT tabla_equipos_ingenieros.* FROM tabla_equipos_ingenieros " +
          "WHERE ((:numeroInventarioEquipoIngeniero IS NOT NULL AND tabla_equipos_ingenieros.numero_inventario_equipo_ingeniero = :numeroInventarioEquipoIngeniero) OR " +
          "(:numeroActivoFijoEquipoIngeniero IS NOT NULL AND tabla_equipos_ingenieros.numero_activo_fijo_equipo_ingeniero = :numeroActivoFijoEquipoIngeniero))", nativeQuery = true)
    EquipoIngeniero findByNumeroInventarioEquipoIngenieroOrNumeroActivoFijoEquipoIngeniero(@Param("numeroInventarioEquipoIngeniero") String numeroInventarioEquipoIngeniero, @Param("numeroActivoFijoEquipoIngeniero") String numeroActivoFijoEquipoIngeniero);
    
    @Query(value = "SELECT MAX(id_equipo_ingeniero) FROM tabla_equipos_ingenieros", nativeQuery = true)
    Long findMaxIdEquipoIngeniero();
}
