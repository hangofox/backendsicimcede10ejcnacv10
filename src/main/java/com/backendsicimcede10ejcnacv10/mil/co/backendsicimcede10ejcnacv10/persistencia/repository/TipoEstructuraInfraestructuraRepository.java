//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoEstructuraInfraestructura;
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
public interface TipoEstructuraInfraestructuraRepository extends JpaRepository<TipoEstructuraInfraestructura,Long> {
    
    @Query(value = "SELECT COUNT(*) FROM tabla_tipos_estructuras_infraestructuras WHERE (:idTipoEstructuraInfraestructura IS NULL OR id_tipo_estructura_infraestructura = :idTipoEstructuraInfraestructura) AND (:keyword IS NULL OR UPPER(nombre_tipo_estructura_infraestructura) LIKE UPPER('%'||:keyword||'%'))", nativeQuery = true)
    Long findTotalRegistros(@Param("idTipoEstructuraInfraestructura") Long idTipoEstructuraInfraestructura, @Param("keyword") String keyword);
    
    @Query(value = "SELECT * FROM tabla_tipos_estructuras_infraestructuras WHERE (:idTipoEstructuraInfraestructura IS NULL OR id_tipo_estructura_infraestructura = :idTipoEstructuraInfraestructura) AND (:keyword IS NULL OR UPPER(nombre_tipo_estructura_infraestructura) LIKE UPPER('%'||:keyword||'%')) ORDER BY CASE WHEN :orderBy = 'idTipoEstructuraInfraestructura' AND :orderMode = 'ASC' THEN id_tipo_estructura_infraestructura END ASC, CASE WHEN :orderBy = 'idTipoEstructuraInfraestructura' AND :orderMode = 'DESC' THEN id_tipo_estructura_infraestructura END DESC, CASE WHEN :orderBy = 'nombreTipoEstructuraInfraestructura' AND :orderMode = 'ASC' THEN nombre_tipo_estructura_infraestructura END ASC, CASE WHEN :orderBy = 'nombreTipoEstructuraInfraestructura' AND :orderMode = 'DESC' THEN nombre_tipo_estructura_infraestructura END DESC", nativeQuery = true)
    List<TipoEstructuraInfraestructura> findAllTiposEstructurasInfraestructuras(@Param("idTipoEstructuraInfraestructura") Long idTipoEstructuraInfraestructura, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT * FROM tabla_tipos_estructuras_infraestructuras WHERE (:idTipoEstructuraInfraestructura IS NULL OR id_tipo_estructura_infraestructura = :idTipoEstructuraInfraestructura) AND (:keyword IS NULL OR UPPER(nombre_tipo_estructura_infraestructura) LIKE UPPER('%'||:keyword||'%')) ORDER BY CASE WHEN :orderBy = 'idTipoEstructuraInfraestructura' AND :orderMode = 'ASC' THEN id_tipo_estructura_infraestructura END ASC, CASE WHEN :orderBy = 'idTipoEstructuraInfraestructura' AND :orderMode = 'DESC' THEN id_tipo_estructura_infraestructura END DESC, CASE WHEN :orderBy = 'nombreTipoEstructuraInfraestructura' AND :orderMode = 'ASC' THEN nombre_tipo_estructura_infraestructura END ASC, CASE WHEN :orderBy = 'nombreTipoEstructuraInfraestructura' AND :orderMode = 'DESC' THEN nombre_tipo_estructura_infraestructura END DESC", nativeQuery = true)
    Slice<TipoEstructuraInfraestructura> findAllTiposEstructurasInfraestructurasPag(Pageable pageable, @Param("idTipoEstructuraInfraestructura") Long idTipoEstructuraInfraestructura, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<TipoEstructuraInfraestructura> findByIdTipoEstructuraInfraestructura(Long idTipoEstructuraInfraestructura);
    
    TipoEstructuraInfraestructura findByNombreTipoEstructuraInfraestructura(String nombreTipoEstructuraInfraestructura);
    
    @Query(value = "SELECT MAX(id_tipo_estructura_infraestructura) FROM tabla_tipos_estructuras_infraestructuras", nativeQuery = true)
    Long findMaxIdTipoEstructuraInfraestructura();
}
