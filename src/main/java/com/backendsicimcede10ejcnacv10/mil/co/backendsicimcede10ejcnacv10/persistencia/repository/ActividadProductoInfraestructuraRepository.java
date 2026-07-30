//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ActividadProductoInfraestructura;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 25/03/2026.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface ActividadProductoInfraestructuraRepository extends JpaRepository<ActividadProductoInfraestructura, Long> {
    
    @Query(value = "" +
          "SELECT COUNT(*) " +
          "FROM tabla_actividades_productos_infraestructuras, tabla_capitulos_infraestructuras " +
          "WHERE (:idActividadProductoInfraestructura IS NULL OR tabla_actividades_productos_infraestructuras.id_actividad_producto_infraestructura = :idActividadProductoInfraestructura) AND " +
          "(tabla_actividades_productos_infraestructuras.id_capitulo_infraestructura = tabla_capitulos_infraestructuras.id_capitulo_infraestructura) AND " +
          "(:nombreCapituloInfraestructura IS NULL OR tabla_capitulos_infraestructuras.nombre_capitulo_infraestructura = :nombreCapituloInfraestructura) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_actividades_productos_infraestructuras.nombre_actividad_producto_infraestructura) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_capitulos_infraestructuras.nombre_capitulo_infraestructura) LIKE UPPER('%'||:keyword||'%')))", nativeQuery = true)
    Long findTotalRegistros(@Param("idActividadProductoInfraestructura") Long idActividadProductoInfraestructura, @Param("keyword") String keyword, @Param("nombreCapituloInfraestructura") String nombreCapituloInfraestructura);
    
    @Query(value = "" +
          "SELECT tabla_actividades_productos_infraestructuras.* " +
          "FROM tabla_actividades_productos_infraestructuras, tabla_capitulos_infraestructuras " +
          "WHERE (:idActividadProductoInfraestructura IS NULL OR tabla_actividades_productos_infraestructuras.id_actividad_producto_infraestructura = :idActividadProductoInfraestructura) AND " +
          "(tabla_actividades_productos_infraestructuras.id_capitulo_infraestructura = tabla_capitulos_infraestructuras.id_capitulo_infraestructura) AND " +
          "(:nombreCapituloInfraestructura IS NULL OR tabla_capitulos_infraestructuras.nombre_capitulo_infraestructura = :nombreCapituloInfraestructura) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_actividades_productos_infraestructuras.nombre_actividad_producto_infraestructura) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_capitulos_infraestructuras.nombre_capitulo_infraestructura) LIKE UPPER('%'||:keyword||'%'))) " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idActividadProductoInfraestructura' AND :orderMode = 'ASC' THEN tabla_actividades_productos_infraestructuras.id_actividad_producto_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'idActividadProductoInfraestructura' AND :orderMode = 'DESC' THEN tabla_actividades_productos_infraestructuras.id_actividad_producto_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'nombreActividadProductoInfraestructura' AND :orderMode = 'ASC' THEN tabla_actividades_productos_infraestructuras.nombre_actividad_producto_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'nombreActividadProductoInfraestructura' AND :orderMode = 'DESC' THEN tabla_actividades_productos_infraestructuras.nombre_actividad_producto_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'idCapituloInfraestructura' AND :orderMode = 'ASC' THEN tabla_actividades_productos_infraestructuras.id_capitulo_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'idCapituloInfraestructura' AND :orderMode = 'DESC' THEN tabla_actividades_productos_infraestructuras.id_capitulo_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'siglaOAcronimoUnidadMedidaActividadProductoInfraestructura' AND :orderMode = 'ASC' THEN tabla_actividades_productos_infraestructuras.sigla_o_acronimo_unidad_medida_actividad_producto_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'siglaOAcronimoUnidadMedidaActividadProductoInfraestructura' AND :orderMode = 'DESC' THEN tabla_actividades_productos_infraestructuras.sigla_o_acronimo_unidad_medida_actividad_producto_infraestructura END DESC", nativeQuery = true)
    List<ActividadProductoInfraestructura> findAllActividadesProductosInfraestructuras(@Param("idActividadProductoInfraestructura") Long idActividadProductoInfraestructura, @Param("keyword") String keyword, @Param("nombreCapituloInfraestructura") String nombreCapituloInfraestructura, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "" +
          "SELECT tabla_actividades_productos_infraestructuras.* " +
          "FROM tabla_actividades_productos_infraestructuras, tabla_capitulos_infraestructuras " +
          "WHERE (:idActividadProductoInfraestructura IS NULL OR tabla_actividades_productos_infraestructuras.id_actividad_producto_infraestructura = :idActividadProductoInfraestructura) AND " +
          "(tabla_actividades_productos_infraestructuras.id_capitulo_infraestructura = tabla_capitulos_infraestructuras.id_capitulo_infraestructura) AND " +
          "(:nombreCapituloInfraestructura IS NULL OR tabla_capitulos_infraestructuras.nombre_capitulo_infraestructura = :nombreCapituloInfraestructura) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_actividades_productos_infraestructuras.nombre_actividad_producto_infraestructura) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_capitulos_infraestructuras.nombre_capitulo_infraestructura) LIKE UPPER('%'||:keyword||'%'))) " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idActividadProductoInfraestructura' AND :orderMode = 'ASC' THEN tabla_actividades_productos_infraestructuras.id_actividad_producto_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'idActividadProductoInfraestructura' AND :orderMode = 'DESC' THEN tabla_actividades_productos_infraestructuras.id_actividad_producto_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'nombreActividadProductoInfraestructura' AND :orderMode = 'ASC' THEN tabla_actividades_productos_infraestructuras.nombre_actividad_producto_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'nombreActividadProductoInfraestructura' AND :orderMode = 'DESC' THEN tabla_actividades_productos_infraestructuras.nombre_actividad_producto_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'idCapituloInfraestructura' AND :orderMode = 'ASC' THEN tabla_actividades_productos_infraestructuras.id_capitulo_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'idCapituloInfraestructura' AND :orderMode = 'DESC' THEN tabla_actividades_productos_infraestructuras.id_capitulo_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'siglaOAcronimoUnidadMedidaActividadProductoInfraestructura' AND :orderMode = 'ASC' THEN tabla_actividades_productos_infraestructuras.sigla_o_acronimo_unidad_medida_actividad_producto_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'siglaOAcronimoUnidadMedidaActividadProductoInfraestructura' AND :orderMode = 'DESC' THEN tabla_actividades_productos_infraestructuras.sigla_o_acronimo_unidad_medida_actividad_producto_infraestructura END DESC", nativeQuery = true)
    Slice<ActividadProductoInfraestructura> findAllActividadesProductosInfraestructurasPag(Pageable pageable, @Param("idActividadProductoInfraestructura") Long idActividadProductoInfraestructura, @Param("keyword") String keyword, @Param("nombreCapituloInfraestructura") String nombreCapituloInfraestructura, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<ActividadProductoInfraestructura> findByIdActividadProductoInfraestructura(Long idActividadProductoInfraestructura);
    
    @Query(value = "" +
          "SELECT tabla_actividades_productos_infraestructuras.* " +
          "FROM tabla_actividades_productos_infraestructuras, tabla_capitulos_infraestructuras " +
          "WHERE (tabla_actividades_productos_infraestructuras.id_capitulo_infraestructura = tabla_capitulos_infraestructuras.id_capitulo_infraestructura) AND " +
          "(tabla_capitulos_infraestructuras.nombre_capitulo_infraestructura = :nombreCapituloInfraestructura) AND " +
          "(tabla_actividades_productos_infraestructuras.nombre_actividad_producto_infraestructura = :nombreActividadProductoInfraestructura)", nativeQuery = true)
    ActividadProductoInfraestructura findByNombreCapituloInfraestructuraAndNombreActividadProductoInfraestructura(@Param("nombreCapituloInfraestructura") String nombreCapituloInfraestructura, @Param("nombreActividadProductoInfraestructura") String nombreActividadProductoInfraestructura);
    
    @Query(value = "SELECT MAX(id_actividad_producto_infraestructura) FROM tabla_actividades_productos_infraestructuras", nativeQuery = true)
    Long findMaxIdActividadProductoInfraestructura();
}
